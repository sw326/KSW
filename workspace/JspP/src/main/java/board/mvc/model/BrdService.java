package board.mvc.model;

import java.util.ArrayList;

import mvc.domain.Board;

public class BrdService {
	private BrdDAO dao;
	
	// Singleton Object Model
	private static final BrdService instance = new BrdService();
	private BrdService() {
		dao = new BrdDAO();
	}
	
	public static BrdService getInstance() {
		return instance;
	}
	
	public ArrayList<Board> listS(){
		return dao.list();
	}
	
	public boolean insertS(Board board) {
		return dao.insert(board);
	}
	
	public Board getBoardS(long seq) {
		return dao.getBoard(seq);
	}
	
	public boolean deleteS(long seq) {
		return dao.delete(seq);
	}
	
	public boolean updateS(Board board) {
		return dao.update(board);
	}
}
