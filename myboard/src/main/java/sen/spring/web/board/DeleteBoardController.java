package sen.spring.web.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import sen.spring.web.board.impl.BoardDAO;

public class DeleteBoardController implements org.springframework.web.servlet.mvc.Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�� ���� ó��");
		//1. ����� �Է� ���� ����
		String seq = request.getParameter("seq");

		//2. �����ͺ��̽� ����ó��
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.deleteBoard(vo);
		
		//3. ȭ�� �׺���̼�
		return new ModelAndView("getBoardList.do");
		}
	

}
