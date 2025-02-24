package login.mvc.model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import mvc.domain.Member;
import static login.mvc.model.LoginSQL.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class LoginDAO {
private DataSource ds;
	
	public LoginDAO() {
		try{
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/TestDB");
			System.out.println("AddrDAO ds: " + ds);
		}catch(NamingException ne){
			System.out.println("DBCP객체(jdbc/TestDB)를 못찾음");
		}
	}
	
	Member getMember(String email) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SEL);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				long seq = rs.getLong(1);
				String name = rs.getString(2);
				//String email = rs.getString(3);
				String pwd = rs.getString(4);
				String phone = rs.getString(5);
				Date rdate = rs.getDate(6);
				Date udate = rs.getDate(7);
				
				return new Member(seq, name, email, pwd, phone, rdate, udate);
			}else {
				return null;
			}
		}catch(SQLException se) {
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
}
