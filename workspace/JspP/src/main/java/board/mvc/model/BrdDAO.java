package board.mvc.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import file.mvc.model.FileService;
import jakarta.servlet.http.Part;
import mvc.domain.Board;

import static board.mvc.model.BrdSQL.*;

class BrdDAO {
	private DataSource ds;
	
	public BrdDAO() {
		try{
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/TestDB");
			System.out.println("BrdDAO ds: " + ds);
		}catch(NamingException ne){
			System.out.println("DBCP객체(jdbc/TestDB)를 못찾음");
		}
	}
	
	public ArrayList<Board> list(int page, int pageSize){
		ArrayList<Board> list = new ArrayList<>();
		String sql = LIST;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pageSize);
			pstmt.setInt(2, (page -1) * pageSize); // offset 계산
			rs = pstmt.executeQuery();
			while(rs.next()) {
				long seq = rs.getLong(1);
				String writer = rs.getString(2);
				String email = rs.getString(3);
				String subject = rs.getString(4);
				String content = rs.getString(5);
				String fname = rs.getString(6);
				String ofname = rs.getString(7);
				int fsize = rs.getInt(8);
				Date rdate = rs.getDate(9);
				
				list.add(new Board(seq, writer, email, subject, content, fname, ofname, fsize, rdate));
			}
		}catch(SQLException se) {
			return null;
		}finally {
			try {
				if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (con != null) con.close();
			}catch(SQLException se) {}
		}
		return list;
	}
	
	public int getTotalRecords() {
		int totalRecords = 0;
		String sql = RECORDS;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totalRecords = rs.getInt(1);
			}
		}catch(SQLException se) {
			
		}finally {
			try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (con != null) con.close();
	        } catch (SQLException se) {}
		}
		return totalRecords;
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
			pstmt.setString(5, board.getFname());
			pstmt.setString(6, board.getOfname());
			pstmt.setInt(7, board.getFsize());
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
	            String fname = rs.getString("FNAME");
	            String ofname = rs.getString("OFNAME");
	            int fsize = rs.getInt("FSIZE");
	            Date rdate = rs.getDate("RDATE");
	            
	            board = new Board(seq, writer, email, subject, content, fname, ofname, fsize, rdate);
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
		PreparedStatement pstmt = null;
		boolean result = false;
		try{
			con = ds.getConnection();
			con.setAutoCommit(false);  // 트랜젝션 시작
			
			// 게시물 삭제
			String sql = DELETE;
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, seq);
			int i = pstmt.executeUpdate();
			if(i>0) {
				// 파일 삭제
				Board board = getBoard(seq); // 삭제한 게시물 정보 가져오기
				if(board != null && board.getFname() != null) { // 파일 이름이 널이 아닐 경우에만 삭제
					FileService fileService = FileService.getInstance();
					fileService.deleteFile(board.getFname()); // 파일 삭제
				}
			}
			con.commit();
			result =  true;
		}catch(SQLException se){
			if(con!=null) {
				try {
					con.rollback();
				}catch(SQLException rse) {
					rse.printStackTrace();
				}
			}
		}finally{
			try{
				if (pstmt != null) pstmt.close();
	            if (con != null) con.close();
			}catch(SQLException se){}
		}
		return result;
	}
	
	public boolean update(Board board, Part filePart) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result = false;
	    
        try{
        	con = ds.getConnection();
        	con.setAutoCommit(false);
        	
        	// 파일 처리
        	if(filePart != null && filePart.getSize() > 0) {
        		FileService fileService = FileService.getInstance();
        		FileService.FileInfo fileInfo = fileService.saveFile(filePart);
        		
        		if(board.getFname() != null) {
        			fileService.deleteFile(board.getFname());
        		}
        		
        		board.setFname(fileInfo.savedFileName);
                board.setOfname(fileInfo.originalFileName);
                board.setFsize(fileInfo.fileSize);
        	}
        	
        	String sql = UPDATE;
        	pstmt = con.prepareStatement(sql);
            pstmt.setString(1, board.getEmail());
            pstmt.setString(2, board.getSubject());
            pstmt.setString(3, board.getContent());
            pstmt.setString(4, board.getFname());
            pstmt.setString(5, board.getOfname());
            pstmt.setInt(6, board.getFsize());
            pstmt.setLong(7, board.getSeq());
            
            int i = pstmt.executeUpdate();
            if(i>0) {
            	result = true;
            	con.commit();
            }
        }catch(SQLException se){
        	if(con != null) {
        		try {
        			con.rollback();
        		}catch(SQLException rse) {
        			rse.printStackTrace();
        		}
        	}
        }finally{
            try{
            	if(pstmt != null) pstmt.close();
                if(con != null) con.close();    
            }catch(SQLException se){}
        }
        return result;
	}
}
