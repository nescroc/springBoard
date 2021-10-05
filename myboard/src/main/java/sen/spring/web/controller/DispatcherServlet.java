package sen.spring.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sen.spring.web.board.BoardVO;
import sen.spring.web.board.impl.BoardDAO;
import sen.spring.web.user.UserVO;
import sen.spring.web.user.impl.UserDAO;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet(name = "action", urlPatterns = { "*.do" })
public class DispatcherServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(uri);
		System.out.println(path);
		// 2. 클라이언트의 요청 path에 따라 적절히 작업을 분기 시켜준다.
		if (path.equals("/login.do")) {
			System.out.println("로그인 처리");
			//1. 사용자 입력 정보 추출
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			//2. 데이터베이스 연동처리
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);
			
			UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);
			
			//3. 화면 네비게이션
			if(user!=null){
				response.sendRedirect("getBoardList.do");
			}else{
				response.sendRedirect("login.jsp");
			}
		} else if (path.equals("/logout.do")) {
			System.out.println("로그아웃 처리");
			//1. 브라우저와 연결된 세션 객체를 종료
			HttpSession session = request.getSession(false);			
			session.invalidate();

			//2. 세션 종료 후 메인 화면으로 이동
			response.sendRedirect("login.jsp");
		} else if (path.equals("/insertBoard.do")) {
			System.out.println("글 등록 처리");

			//1. 사용자 입력 정보 추출
			request.setCharacterEncoding("utf-8");
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			//2 데이터베이스 연동처리
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(vo);
			
			response.sendRedirect("getBoardList.do");
				
		} else if (path.equals("/updateBoard.do")) {
			System.out.println("글 수정 처리");
			//1. 사용자 입력 정보 추출
			request.setCharacterEncoding("utf-8");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String seq = request.getParameter("seq");
			
			
			//2. 데이터베이스 연동처리
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setContent(content);	
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.updateBoard(vo);
			
			//화면 네비게이션
			response.sendRedirect("getBoardList.do");
			
		} else if (path.equals("/deleteBoard.do")) {
			System.out.println("글 삭제 처리");
			//1. 사용자 입력 정보 추출
			String seq = request.getParameter("seq");

			//2. 데이터베이스 연동처리
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.deleteBoard(vo);
			
			//3. 화면 네비게이션
			response.sendRedirect("getBoardList.do");
		} else if (path.equals("/getBoard.do")) {
			System.out.println("글 상세 보기 처리");

			//1.검색할 게시글 번호 추출
			String seq = request.getParameter("seq");
			
			//2.데이터베이스 연동 처리
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			BoardVO board = boardDAO.getBoard(vo);
			//3. 응답 화면 구현
			request.setAttribute("board", board);
			RequestDispatcher dispatcher = request.getRequestDispatcher("getBoard.jsp");
			dispatcher.forward(request, response);
		} else if (path.equals("/getBoardList.do")) {
			System.out.println("글 목록 검색 처리");
			//1. 사용자 입력 정보 추출 : 검색 기능은 나중에 구현

			//2. 데이터베이스 연동 처리
			BoardVO vo = new BoardVO();
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList(vo);
			//3. 응답 화면 구성
			request.setAttribute("boardList", boardList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("getBoardList.jsp");
			dispatcher.forward(request, response);
		}
	}
}
