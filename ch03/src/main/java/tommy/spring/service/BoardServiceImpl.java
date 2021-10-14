package tommy.spring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import tommy.spring.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Override
	public String hello(String name) {
		return "Hello : "+name;
	}

	@Override
	public BoardVO getBoard() {
		BoardVO board = new BoardVO();
		board.setSeq(1);
		board.setTitle("테스트 제목...");
		board.setWriter("테스트");
		board.setContent("테스트내용입니다");
		board.setCreateDate(new Date());
		board.setCnt(0);
		return board;
	}

	@Override
	public List<BoardVO> getBoardList() {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		for (int i = 1; i <= 10; i++) {
			BoardVO board = new BoardVO();
			board.setSeq(i);
			board.setTitle("제목"+i);
			board.setWriter("테스터"+i);
			board.setContent(i+"번 내용입니다");
			board.setCreateDate(new Date());
			board.setCnt(0);
		}
		return boardList;
	}

}
