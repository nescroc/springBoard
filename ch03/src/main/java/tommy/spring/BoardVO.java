package tommy.spring;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BoardVO {
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date createDate = new Date();
	private int cnt = 0;
}
