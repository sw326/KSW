package m2.mvc.model;

import mvc.domain.Users;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class LoginDAO {
    private DataSource ds;

    public LoginDAO() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            ds = (DataSource) envContext.lookup("jdbc/TestDB");
        } catch (NamingException ne) {
            System.out.println("DBCP객체(jdbc/TestDB)를 못찾음");
        }
    }
    
    public Users getUsers(String id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String selectUsers = "SELECT * FROM users WHERE id = ?";
        try {
            con = ds.getConnection();
            System.out.println("DB Connection 성공");
            
            pstmt = con.prepareStatement(selectUsers);
            pstmt.setString(1, id);
            System.out.println("실행될 쿼리: " + selectUsers + " (id=" + id + ")");
            
            rs = pstmt.executeQuery();
            System.out.println("쿼리 실행 완료");
            
            if(rs.next()) {
                String pwd = rs.getString("pwd").trim();  // trim 추가
                String email = rs.getString("email");
                String homepage = rs.getString("homepage");
                Date created_at = rs.getDate("created_at");
                
                System.out.println("Found user - ID: " + id + ", PWD: '" + pwd + "'");  // 디버깅
                
                return new Users(id, pwd, email, homepage, created_at);
            } else {
                System.out.println("해당 ID의 사용자가 없음: " + id);
                return null;
            }
        } catch (SQLException se) {
            System.out.println("DB 오류 발생: " + se.getMessage());
            se.printStackTrace();
            return null;
        } finally {
            try {
                if(rs != null) rs.close();
                if(pstmt != null) pstmt.close();
                if(con != null) con.close();
            } catch(SQLException se) {}
        }
    }

}
