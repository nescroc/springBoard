package tommy.spring;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tommy.spring.domain.Board;
import tommy.spring.persistence.BoardRepository;

@SpringBootTest
public class QueryAnnotationTest {
	@Autowired
	private BoardRepository boardRepo;

	/*
	 * @Test public void testQueryAnnotationTest1() { List<Board> boardList =
	 * boardRepo.queryAnnotationTest1("test title10"); System.out.println("검색결과");
	 * for (Board board : boardList) System.out.println(board.toString());
	 * 
	 * }
	 */
}
