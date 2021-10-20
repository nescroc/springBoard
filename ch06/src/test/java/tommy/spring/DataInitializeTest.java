package tommy.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tommy.spring.domain.Board;
import tommy.spring.domain.Member;
import tommy.spring.persistence.BoardRepository;
import tommy.spring.persistence.MemberRepository;

@SpringBootTest
public class DataInitializeTest {
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	public void testDataInsert() {
		Member member1 = new Member();
		member1.setId("aaaa");
		member1.setName("손오공");
		member1.setPassword("1111");
		member1.setRole("role_user");
		
		memberRepo.save(member1);
		
		Member member2 = new Member();
		member2.setId("bbbb");
		member2.setName("사오정");
		member2.setPassword("2222");
		member2.setRole("role_admin");
		
		memberRepo.save(member2);
		
		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setWriter("손오공");
			board.setTitle("손오공이 등록한 게시글 " + i);
			board.setContent("손오공이 등록한 글내용 : "+i);
			boardRepo.save(board);
		}
		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setWriter("사오정");
			board.setTitle("사오정이 등록한 게시글 " + i);
			board.setContent("사오정이 등록한 글내용 : "+i);
			boardRepo.save(board);
		}
	}
}
