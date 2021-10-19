package tommy.spring;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import tommy.spring.domain.Board;
import tommy.spring.persistence.BoardRepository;

@SpringBootTest
public class QueryMethodTest {
	@Autowired
	private BoardRepository boardRepo;
	
	/*
	 * @Test public void dataPrepare() { for (int i = 1; i < 201; i++) { Board board
	 * = new Board(); board.setTitle("test title"+ i); board.setWriter("tester");
	 * board.setContent("test content "+i); board.setCreateDate(new Date());
	 * board.setCnt(0L); boardRepo.save(board); } }
	 */
	
	
	/*
	 * @Test public void testByTitleContainingOrderBySeqDesc() { List<Board>
	 * boardList = boardRepo.findByTitleContainingOrderBySeqDesc("17");
	 * System.out.println("검색결과"); for(Board board : boardList)
	 * System.out.println(board.toString()); }
	 */
	
	@Test
	public void testFindByTitleContaining() {		
		Pageable paging = PageRequest.of(0, 5,Sort.Direction.DESC,"seq");
		List<Board> boardList = boardRepo.findByTitleContaining("제목",paging);
		System.out.println("검색결과");
		for(Board board : boardList)
			System.out.println("--->"+board.toString());
	}	
}
