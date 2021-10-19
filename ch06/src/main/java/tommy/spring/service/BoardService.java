package tommy.spring.service;

import java.util.List;

import tommy.spring.domain.Board;

public interface BoardService {

	List<Board> getBoardList(Board board);

	void insertBoard(Board board);

	Board getBoard(Board board);

	void updateBoard(Board board);

	void deleteBoard(Board board);

}