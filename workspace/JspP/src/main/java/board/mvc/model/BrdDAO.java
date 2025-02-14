package board.mvc.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import mvc.domain.Board;

import static board.mvc.model.BrdSQL.*;

class BrdDAO {
	private DataSource ds;
	
	public BrdDAO() {
		try{
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/TestDB");
			System.out.println("AddrDAO ds: " + ds);
		}catch(NamingException ne){
			System.out.println("DBCP객체(jdbc/TestDB)를 못찾음");
		}
	}
	
	public ArrayList<Board> list(){
		ArrayList<Board> list = new ArrayList<>();
		String sql = LIST;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				long seq = rs.getLong(1);
				String writer = rs.getString(2);
				String email = rs.getString(3);
				String subject = rs.getString(4);
				String content = rs.getString(5);
				Date rdate = rs.getDate(6);
				
				list.add(new Board(seq, writer, email, subject, content, rdate));
			}
			return list;
		}catch(SQLException se) {
			return null;
		}finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			}catch(SQLException se) {}
		}
	}
	
	public boolean insert(Board board) {
		Connection con = null;
		String sql = INSERT;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  board.getWriter());
			pstmt.setString(2, board.getEmail());
			pstmt.setString(3, board.getSubject());
			pstmt.setString(4, board.getContent());
			int i = pstmt.executeUpdate();
			if(i>0) return true;
			else return false;
		}catch(SQLException se) {
			return false;
		}finally {
			try {
				pstmt.close();
				con.close();
			}catch(SQLException se) {}
		}
	}
	
	public Board getBoard(long seq) {
		Connection con = null;
	    String sql = GETBOARD;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    Board board = null;
	    
	    try{
	    	con = ds.getConnection();
	    	pstmt = con.prepareStatement(sql);
	        pstmt.setLong(1, seq);
	        rs = pstmt.executeQuery();
	        if(rs.next()){
	            String writer = rs.getString("WRITER");
	            String email = rs.getString("EMAIL");
	            String subject = rs.getString("SUBJECT");
	            String content = rs.getString("CONTENT");
	            Date rdate = rs.getDate("RDATE");
	            
	            board = new Board(seq, writer, email, subject, content, rdate);
	        }
	        return board;
	    }catch(SQLException se){
	    	return null;
	    }finally{
	        try{
	        	if(rs != null) rs.close();
	            if(pstmt != null) pstmt.close();
	            if(con != null) con.close();
	        }catch(SQLException se){}
	    }
	}
	
	public boolean delete(long seq) {
		Connection con = null;
		String sql = DELETE;
		PreparedStatement pstmt = null;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, seq);
			int i = pstmt.executeUpdate();
			if(i>0) return true;
			else return false;
		}catch(SQLException se){
			return false;
		}finally{
			try{
				pstmt.close();
				con.close();
			}catch(SQLException se){}
		}
	}
	
	public boolean update(Board board) {
		Connection con = null;
		PreparedStatement pstmt = null;
	    String sql = UPDATE;
	    
        try{
        	con = ds.getConnection();
        	pstmt = con.prepareStatement(sql);
            pstmt.setString(1, board.getEmail());
            pstmt.setString(2, board.getSubject());
            pstmt.setString(3, board.getContent());
            pstmt.setLong(4, board.getSeq());
            
            int i = pstmt.executeUpdate();
            return i>0;
        }catch(SQLException se){
        	return false;
        }finally{
            try{
            	if(pstmt != null) pstmt.close();
                if(con != null) con.close();    
        }catch(SQLException se){}
        }
	}
}
