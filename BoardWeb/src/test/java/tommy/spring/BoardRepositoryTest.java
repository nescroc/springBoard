package tommy.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import tommy.spring.board.domain.Board;
import tommy.spring.board.domain.Member;
import tommy.spring.board.domain.Role;
import tommy.spring.board.persistence.BoardRepository;
import tommy.spring.board.persistence.MemberRepository;

@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	private MemberRepository memberRepo;

	@Autowired
	private BoardRepository boardRepo;

	@Autowired
	private PasswordEncoder encoder;
	
	@Test
	public void testInsert() {
		Member member1 = new Member();
		member1.setId("member");
		member1.setName("손오공");
		member1.setPassword(encoder.encode("1111"));
		member1.setEnabled(true);
		member1.setRole(Role.ROLE_MEMBER);

		memberRepo.save(member1);

		Member member2 = new Member();
		member2.setId("admin");
		member2.setName("사오정");
		member2.setPassword(encoder.encode("2222"));
		member1.setEnabled(true);
		member2.setRole(Role.ROLE_ADMIN);

		memberRepo.save(member2);

		for (int i = 1; i <= 13; i++) {
			Board board = new Board();
			board.setMember(member1);
			board.setTitle(member1.getName() + "이 등록한 게시글 " + i);
			board.setContent(member1.getName() + "이 등록한 글내용 : " + i);
			boardRepo.save(board);
		}
		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setMember(member2);
			board.setTitle(member2.getName() + "이 등록한 게시글 " + i);
			board.setContent(member2.getName() + "이 등록한 글내용 : " + i);
			boardRepo.save(board);
		}
	}

	/*
	 * @Test public void testGetBoard() { Board board =
	 * boardRepo.findById(1L).get();
	 * System.out.println("     [ "+board.getSeq()+"번 게시 글 상세 정보 ]");
	 * System.out.println("제목\t : "+board.getTitle());
	 * System.out.println("작성자\t : "+board.getMember().getName());
	 * System.out.println("내용\t : "+board.getContent());
	 * System.out.println("등록일\t : "+board.getCreateDate());
	 * System.out.println("조회수\t : "+board.getCnt()); }
	 */

//	@Test
//	public void testGetBoardList() {
//		Member member = memberRepo.findById("member").get();
//		
//		System.out.println(" [ "+member.getName()+"가 등록한 게시글 ] ");
//		for(Board board : member.getBoardList()) {
//			System.out.println("---> "+board.toString());
//		}
//	}
}
