package tommy.spring.board.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import tommy.spring.board.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>,QuerydslPredicateExecutor<Board> {
	//쿼리 안에 있는 board는 엔티티 
	@Query("select b from Board b")
	Page<Board> getBoardList(Pageable pageable);
	
}
