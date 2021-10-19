package tommy.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tommy.spring.persistence.BoardRepository;

@SpringBootTest
public class BoardRepositoryTest {
	@Autowired
	private BoardRepository boardRepo;

	/*
	 * @Test public void testInsert() { Board board = new Board();
	 * board.setTitle("첫번째 게시글"); board.setWriter("ilsungna");
	 * board.setContent("testcontent"); board.setCreateDate(new Date());
	 * board.setCnt(0L); boardRepo.save(board); }
	 */

	/*
	 * @Test public void testGetBoard() { Board board =
	 * boardRepo.findById(1L).get(); System.out.println(board.toString()); }
	 */

	/*
	 * @Test public void testUpdateBoard() {
	 * System.out.println("========1번글조회========"); Board board =
	 * boardRepo.findById(1L).get(); System.out.println("========1번글제목수정========");
	 * board.setTitle("제목을 수정했습니다."); boardRepo.save(board); }
	 */
	
	@Test
	public void testDeleteBoard() {
		boardRepo.deleteById(1L);
	}
	
}
