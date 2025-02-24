package login.mvc.model;

import mvc.domain.Member;
import static login.mvc.model.LoginConst.*;

public class LoginService {
	private LoginDAO dao;
	private static final LoginService instance = new LoginService();
	
	private LoginService() {
		dao = new LoginDAO();
	}
	public static LoginService getInstance() {
		return instance;
	}
	
	public Member getMemberS(String email) {
		Member m = dao.getMember(email);
		m.setPwd("");
		
		return m;
	}
	public int check(String email, String pwd) {
		Member m = dao.getMember(email);
		if(m==null) {
			return NO_ID;
		}else {
			String dbPwd = m.getPwd();
			if(dbPwd!=null)dbPwd = dbPwd.trim();
			
			if(!dbPwd.equals(pwd)) {
				return NO_PWD; // email은 존재하지만 비번은 틀림
			}else {
				return YES_ID_PWD; // email과 pwd가 일치
			}
		}
	}
}
