package board.mvc.model;

import java.util.ArrayList;

import jakarta.servlet.http.Part;
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
	
	public ArrayList<Board> listS(int page, int pageSize){
		System.out.println(page+" "+pageSize);
		return dao.list(page, pageSize);
	}
	
	public int getTotalRecords() {
		return dao.getTotalRecords();
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
	
	public boolean updateS(Board board, Part filePart) {
		return dao.update(board, filePart);
	}
}
