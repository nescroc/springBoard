package tommy.spring.board.service;

import org.springframework.data.domain.Page;

import tommy.spring.board.domain.Board;
import tommy.spring.board.domain.Search;

public interface BoardService {

	void insertBoard(Board board);
	void updateBoard(Board board);
	void deleteBoard(Board board);
	Board getBoard(Board board);
	Page<Board> getBoardList(Search search);
}
