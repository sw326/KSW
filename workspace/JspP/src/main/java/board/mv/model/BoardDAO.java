package board.mv.model;

import javax.naming.*;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class BoardDAO {
	private DataSource ds;
	public BoardDAO() {
		try{
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/TestDB");
			System.out.println("AddrDAO ds: " + ds);
		}catch(NamingException ne){
			System.out.println("DBCP객체(jdbc/TestDB)를 못찾음");
		}
	}
	public ArrayList<BoardDTO> list(){
		ArrayList<BoardDTO> list = new ArrayList<>();
		String sql = "select * from BOARD order by SEQ desc";
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
				
				list.add(new BoardDTO(seq, writer, email, subject, content, rdate));
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
	public boolean insert(BoardDTO dto) {
		Connection con = null;
		String sql = "insert into BOARD(WRITER, EMAIL, SUBJECT, CONTENT, RDATE) values(?,?,?,?,now())";
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  dto.getWriter());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getContent());
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
	
	public BoardDTO getBoard(long seq) {
		Connection con = null;
	    String sql = "select * from BOARD where SEQ = ?";
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    BoardDTO dto = null;
	    
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
	            
	            dto = new BoardDTO(seq, writer, email, subject, content, rdate);
	        }
	        return dto;
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
		String sql = "delete from BOARD where SEQ=?";
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
	
	public boolean update(BoardDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
	    String sql = "update BOARD set EMAIL=?, SUBJECT=?, CONTENT=? where SEQ=?";
	    
        try{
        	con = ds.getConnection();
        	pstmt = con.prepareStatement(sql);
            pstmt.setString(1, dto.getEmail());
            pstmt.setString(2, dto.getSubject());
            pstmt.setString(3, dto.getContent());
            pstmt.setLong(4, dto.getSeq());
            
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














