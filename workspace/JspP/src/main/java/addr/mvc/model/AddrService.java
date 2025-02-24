package addr.mvc.model;

import java.util.ArrayList;

import mvc.domain.Address;

public class AddrService {
	private AddrDAO dao;
	
	// Singleton Object Model
	private static final AddrService instance = new AddrService();
	private AddrService() {
		dao = new AddrDAO();
	}
	
	public static AddrService getInstance() {
		return instance;
	}
	
	public ArrayList<Address> listS(){
		return dao.list();
	}
	
	public boolean insertS(Address address) {
		return dao.insert(address);
	}
	
	public boolean deleteS(long seq) {
		return dao.delete(seq);
	}
	
	// for Ajax
	public Address selectBySeqS(long seq) {
		return dao.selectBySeq(seq);
	}
	
	public ArrayList<Address> selectByNameS(String na){
		return dao.selectByName(na);
	}
}
