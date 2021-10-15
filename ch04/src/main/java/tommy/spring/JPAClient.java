package tommy.spring;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import tommy.spring.domain.Board;

public class JPAClient {

	public static void main(String[] args) {
		//EntityManager 생성
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("ch04");
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			
			
			
			/*
			 * Board board = new Board(); board.setTitle("JPA 제목"); board.setWriter("관리자");
			 * board.setContent("JPA 그 등록 잘되네요"); board.setCreateDate(new Date());
			 * board.setCnt(0);
			 * 
			 * em.persist(board);
			 */
			 
			 
			
//			Board searchBoard = em.find(Board.class, 2L);
//			System.out.println("======>"+ searchBoard.toString());
			
			//트랜잭션
			
			
			  Board board = em.find(Board.class, 1L); 
			  board.setTitle("검색한 게시글의 제목 수정");
			 
			
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			em.close();
			factory.close();
		}
	}
}
