package tommy.spring.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "MYUSER")
public class Member {
	@Id
	private String id;
	private String password;
	private String name;
	private String role;
}
