package tommy.spring.board.persistence;

import org.springframework.data.repository.CrudRepository;

import tommy.spring.board.domain.Member;

public interface MemberRepository extends CrudRepository<Member, String> {

}
