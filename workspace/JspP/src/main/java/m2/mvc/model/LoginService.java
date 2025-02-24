package m2.mvc.model;

import mvc.domain.Users;

public class LoginService {
    private LoginDAO dao;
    private static final LoginService instance = new LoginService();
    
    private LoginService() {
        dao = new LoginDAO();
    }
    public static LoginService getInstance() {
        return instance;
    }
    
    public Users getUsers(String id) {
        Users user = dao.getUsers(id);
        user.setPwd("");
        return user;
    }
    public int check(String id, String pwd) {
        System.out.println("Check method - ID: " + id + ", PWD: " + pwd);  // 디버깅
        Users user = dao.getUsers(id);
        
        if(user == null) {
            System.out.println("User not found");  // 디버깅
            return LoginConst.ID_NOT_EXIST;
        } else {
            String dbPwd = user.getPwd();
            if(dbPwd != null) dbPwd = dbPwd.trim();
            pwd = pwd.trim();  // 입력받은 비밀번호도 trim
            
            System.out.println("DB Password: '" + dbPwd + "'");  // 디버깅
            System.out.println("Input Password: '" + pwd + "'");  // 디버깅
            
            if(!dbPwd.equals(pwd)) {
                System.out.println("Password mismatch");  // 디버깅
                return LoginConst.PWD_NOT_MATCH;
            } else {
                System.out.println("Login successful");  // 디버깅
                return LoginConst.LOGGED_IN;
            }
        }
    }
}
