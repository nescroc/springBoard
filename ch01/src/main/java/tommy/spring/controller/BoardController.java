package tommy.spring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tommy.spring.domain.BoardVO;

@RestController
public class BoardController {
	public BoardController() {
		System.out.println("==========> BoardController 생성");
	}
	@GetMapping("/hello")
	public String hello(String name) {	
		return "Hello :"+name;
	}
	@GetMapping("/getBoard")
	public BoardVO getBoard() {
		BoardVO board = new BoardVO();
		board.setSeq(1);
		board.setTitle("Tommy");
		board.setWriter("leesin");
		board.setContent("12345");
		board.setCreateDate(new Date());
		board.setCnt(0);
		
		return board;
	}
	@GetMapping("/getBoardList")
	public List<BoardVO> getBoardList(){
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		for (int i = 1; i <= 10; i++) {
			BoardVO board = new BoardVO();
			board.setSeq(i);
			board.setTitle("제목 : "+i);
			board.setWriter("작성자 : 홍길동("+i+")");
			board.setContent(i+"");
			board.setCreateDate(new Date());
			board.setCnt(0);
			boardList.add(board);
		}
		return boardList;
	}
}
