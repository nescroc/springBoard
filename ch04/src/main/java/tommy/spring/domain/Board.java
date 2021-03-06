package tommy.spring.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "MYBOARD")
/*
 * @SequenceGenerator(name="BOARD_SEQ_GENERATOR", sequenceName =
 * "BOARD_SEQUENCE", initialValue = 1, allocationSize = 1)
 */public class Board {
	@Id
	@GeneratedValue /*
					 * (strategy=GenerationType.SEQUENCE, generator = "BOARD_SEQ_GENERATOR")
					 */
	private long seq;
	private String title;
	private String writer;
	private String content;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	private long cnt;
	public long getSeq() {
		return seq;
	}
	public void setSeq(long seq) {
		this.seq = seq;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public long getCnt() {
		return cnt;
	}
	
	public void setCnt(long cnt) {
		this.cnt = cnt;
	}
	
	@Override
	public String toString() {
		return "MyBoard [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", createDate=" + createDate + ", cnt=" + cnt + "]";
	}
	 
}
