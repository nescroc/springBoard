package sen.spring.web.board;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

//@Entity
//@Table(name="MYBOARD")
@Data
public class BoardVO {
//	@Id
//	@GeneratedValue
	private int seq;
	private String title;
	private String writer;
	private String content;
//	@Temporal(TemporalType.DATE)
	private Date regDate;
	private int cnt;
//	@Transient
	@JsonIgnore
	private String searchCondition;
//	@Transient
	@JsonIgnore
	private String searchKeyword;
//	@Transient
	@JsonIgnore
	private MultipartFile uploadFile;
	
}
