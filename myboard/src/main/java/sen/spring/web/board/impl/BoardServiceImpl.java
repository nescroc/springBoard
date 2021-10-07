package sen.spring.web.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sen.spring.web.board.BoardService;
import sen.spring.web.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAOSpring boardDAO;

	@Override 
	public void insertBoard(BoardVO vo) {  
	
	 //if (vo.getSeq() == 0) { throw new IllegalArgumentException("0번 글은 등록할 수 없습니다."); }
	System.out.println("BoardServiceImpl : InsertBoard Servcie");
	 boardDAO.insertBoard(vo); 
	 }

	@Override
	public void updateBoard(BoardVO vo) {
		System.out.println("BoardServiceImpl : UpdateBoard Servcie");
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		System.out.println("BoardServiceImpl : DeleteBoard Servcie");
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("BoardServiceImpl : GetBoard Servcie");
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("BoardServiceImpl : GetBoardList Servcie");
		return boardDAO.getBoardList(vo);
	}

}
