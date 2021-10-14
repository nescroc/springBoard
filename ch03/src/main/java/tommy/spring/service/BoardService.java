package tommy.spring.service;

import java.util.List;

import tommy.spring.BoardVO;

public interface BoardService {
	String hello(String name);
	BoardVO getBoard();
	List<BoardVO> getBoardList();
}
