package sen.spring.web.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {
	public static void main(String args[]) {
		//1. 스프링 컨테이너 구동
		AbstractApplicationContext container= 
				new GenericXmlApplicationContext("applicationContext.xml");
		//2. 스프링 컨테이너로 부터 BoardServiceImpl 객체를 lookup한다.
		BoardService boardService = (BoardService)container.getBean("boardService");
		//3. 글 등록 기능 테스트
		BoardVO vo = new BoardVO();
		//vo.setSeq(1003);
		vo.setTitle("123");
		vo.setWriter("1일성");
		vo.setContent("5빠따");
		boardService.insertBoard(vo);
		//4.글 검색 기능 테스트
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for(BoardVO board: boardList) {
			System.out.println("--->"+board.toString());
		}
		//5.스프링컨테이너 종료
		container.close();
	}
}
