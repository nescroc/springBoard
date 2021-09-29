package tommy.spring.board.service;

import tommy.spring.board.dao.ArticleDAO;
import tommy.spring.board.vo.ArticleVO;

public class WriteArticleServiceImpl implements WriteArticleService {

	private ArticleDAO articleDAO;
	public WriteArticleServiceImpl() {}
	public WriteArticleServiceImpl(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}
	
	@Override
	public void write(ArticleVO article) {
		System.out.println("WriteArticleServiceimpl.write() 메서드 실행");
		articleDAO.insert(article);
	}
}
