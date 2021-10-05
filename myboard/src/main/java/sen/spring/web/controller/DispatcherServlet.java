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
		// 2. Ŭ���̾�Ʈ�� ��û path�� ���� ������ �۾��� �б� �����ش�.
		if (path.equals("/login.do")) {
			System.out.println("�α��� ó��");
			//1. ����� �Է� ���� ����
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			//2. �����ͺ��̽� ����ó��
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);
			
			UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);
			
			//3. ȭ�� �׺���̼�
			if(user!=null){
				response.sendRedirect("getBoardList.do");
			}else{
				response.sendRedirect("login.jsp");
			}
		} else if (path.equals("/logout.do")) {
			System.out.println("�α׾ƿ� ó��");
			//1. �������� ����� ���� ��ü�� ����
			HttpSession session = request.getSession(false);			
			session.invalidate();

			//2. ���� ���� �� ���� ȭ������ �̵�
			response.sendRedirect("login.jsp");
		} else if (path.equals("/insertBoard.do")) {
			System.out.println("�� ��� ó��");

			//1. ����� �Է� ���� ����
			request.setCharacterEncoding("utf-8");
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			//2 �����ͺ��̽� ����ó��
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(vo);
			
			response.sendRedirect("getBoardList.do");
				
		} else if (path.equals("/updateBoard.do")) {
			System.out.println("�� ���� ó��");
			//1. ����� �Է� ���� ����
			request.setCharacterEncoding("utf-8");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String seq = request.getParameter("seq");
			
			
			//2. �����ͺ��̽� ����ó��
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setContent(content);	
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.updateBoard(vo);
			
			//ȭ�� �׺���̼�
			response.sendRedirect("getBoardList.do");
			
		} else if (path.equals("/deleteBoard.do")) {
			System.out.println("�� ���� ó��");
			//1. ����� �Է� ���� ����
			String seq = request.getParameter("seq");

			//2. �����ͺ��̽� ����ó��
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.deleteBoard(vo);
			
			//3. ȭ�� �׺���̼�
			response.sendRedirect("getBoardList.do");
		} else if (path.equals("/getBoard.do")) {
			System.out.println("�� �� ���� ó��");

			//1.�˻��� �Խñ� ��ȣ ����
			String seq = request.getParameter("seq");
			
			//2.�����ͺ��̽� ���� ó��
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			BoardVO board = boardDAO.getBoard(vo);
			//3. ���� ȭ�� ����
			request.setAttribute("board", board);
			RequestDispatcher dispatcher = request.getRequestDispatcher("getBoard.jsp");
			dispatcher.forward(request, response);
		} else if (path.equals("/getBoardList.do")) {
			System.out.println("�� ��� �˻� ó��");
			//1. ����� �Է� ���� ���� : �˻� ����� ���߿� ����

			//2. �����ͺ��̽� ���� ó��
			BoardVO vo = new BoardVO();
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList(vo);
			//3. ���� ȭ�� ����
			request.setAttribute("boardList", boardList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("getBoardList.jsp");
			dispatcher.forward(request, response);
		}
	}
}
