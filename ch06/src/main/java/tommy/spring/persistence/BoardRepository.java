package tommy.spring.persistence;

import org.springframework.data.repository.CrudRepository;

import tommy.spring.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {

}
