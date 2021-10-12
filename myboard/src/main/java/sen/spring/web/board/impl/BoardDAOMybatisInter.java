package sen.spring.web.board.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import sen.spring.web.board.BoardVO;

@Repository
public interface BoardDAOMybatisInter {
	public void insertBoard(BoardVO vo);
	public void updateBoard(BoardVO vo);
	public void deleteBoard(BoardVO vo);
	public BoardVO getBoard(BoardVO vo);
	public List<BoardVO> getBoardList(BoardVO vo);
}
