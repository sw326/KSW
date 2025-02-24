package m2.mvc.model;

import java.util.ArrayList;

import mvc.domain.Reboard;

public class ReboardService {
	private ReboardDAO dao;

	private static final ReboardService instance = new ReboardService();

	private ReboardService() {
		dao = new ReboardDAO();
	}

	public static ReboardService getInstance() {
		return instance;
	}

	public ArrayList<Reboard> listS() {
		return dao.list();
	}

	public void insertS(Reboard reboard) {
		dao.insert(reboard);
	}

	public Reboard contentS(long idx) {
		return dao.content(idx);
	}

	public void updateHitS(long idx) {
		dao.updateHit(idx);
	}

	// public void updateReply(Reboard reboard) {
	// dao.updateReply(reboard);
	// }

	public void deleteS(long idx) {
		dao.delete(idx);
	}

	public Reboard editS(long idx) {
		Reboard reboard = dao.content(idx);
		return reboard;
	}

	public void updateS(Reboard reboard) {
		dao.update(reboard, reboard.getIdx());
	}

	public void rewriteInsertS(Reboard reboard, long parentIdx) {
		dao.rewriteInsert(reboard, parentIdx);
	}

	// public void updateOrderNo(long rootIdx, int orderNo) {
	// dao.updateOrderNo(rootIdx, orderNo);
	// }

}
