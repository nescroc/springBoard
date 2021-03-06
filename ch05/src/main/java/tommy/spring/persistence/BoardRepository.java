package tommy.spring.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import tommy.spring.domain.Board;

public interface BoardRepository extends CrudRepository<tommy.spring.domain.Board, Long> {
	List<Board> findByTitle(String searchKeyword);
	List<Board> findByContentContaining(String searchKeyword);
	List<Board> findByTitleContainingOrContentContaining(String title, String content);
	List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
	List<Board> findByTitleContaining(String searchKeyword,Pageable paging);
	List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword,Pageable paging);
	/*
	 * @Query("SELECT * FROM MYBOARD b WHERE b.title like %?1% ORDER BY b.seq DESC")
	 * List<Board> queryAnnotationTest1(String searchKeyword);
	 */
	 
}
