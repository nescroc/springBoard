package sen.spring.web.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {
	public static void main(String args[]) {
		//1. ������ �����̳� ����
		AbstractApplicationContext container= 
				new GenericXmlApplicationContext("applicationContext.xml");
		//2. ������ �����̳ʷ� ���� BoardServiceImpl ��ü�� lookup�Ѵ�.
		BoardService boardService = (BoardService)container.getBean("boardService");
		//3. �� ��� ��� �׽�Ʈ
		BoardVO vo = new BoardVO();
		//vo.setSeq(1003);
		vo.setTitle("123");
		vo.setWriter("1�ϼ�");
		vo.setContent("5����");
		boardService.insertBoard(vo);
		//4.�� �˻� ��� �׽�Ʈ
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for(BoardVO board: boardList) {
			System.out.println("--->"+board.toString());
		}
		//5.�����������̳� ����
		container.close();
	}
}
