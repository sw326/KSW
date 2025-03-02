package addr.mvc.model;

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

import mvc.domain.Address;
import static addr.mvc.model.AddrSQL.*;

class AddrDAO {
	private DataSource ds;
	
	AddrDAO() {
		try{
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/TestDB");
			System.out.println("AddrDAO ds: " + ds);
		}catch(NamingException ne){
			System.out.println("DBCP객체(jdbc/TestDB)를 못찾음");
		}
	}
	
	ArrayList<Address> list() {
		ArrayList<Address> list = new ArrayList<>();
		String sql = LIST;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				long seq = rs.getLong(1);
				String name = rs.getString(2);
				String addr = rs.getString(3);
				Date rdate = rs.getDate(4);
				
				list.add(new Address(seq, name, addr, rdate));
			}
			return list;
		}catch(SQLException se){
			System.out.println("list se: "+ se);
			return null;
		}finally{
			try{
				rs.close();
				stmt.close();
				con.close();
			}catch(SQLException se){}
		}
	}
	
	boolean insert(Address address) {
		Connection con = null;
		String sql = INSERT;
		PreparedStatement pstmt = null;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, address.getName());
			pstmt.setString(2, address.getAddr());
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
	
	boolean delete(long seq) {
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
	
	//for Ajax
	Address selectBySeq(long seq) {
		Connection con = null;
		String sql = SELECT_BY_SEQ;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, seq);
			rs = pstmt.executeQuery();
			if(rs.next()){
				//long seq = rs.getLong(1);
				String name = rs.getString(2);
				String addr = rs.getString(3);
				Date rdate = rs.getDate(4);
				
				return new Address(seq, name, addr, rdate);
			}else {
				return null;
			}
		}catch(SQLException se){
			System.out.println("list se: "+ se);
			return null;
		}finally{
			try{
				rs.close();
				pstmt.close();
				con.close();
			}catch(SQLException se){}
		}
	}
	
	ArrayList<Address> selectByName(String na){
		ArrayList<Address> list = new ArrayList<>();
		String sql = SELECT_BY_NAME;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+na+"%");
			rs = pstmt.executeQuery();
			while(rs.next()){
				long seq = rs.getLong(1);
				String name = rs.getString(2);
				String addr = rs.getString(3);
				Date rdate = rs.getDate(4);
				
				list.add(new Address(seq, name, addr, rdate));
			}
			return list;
		}catch(SQLException se){
			System.out.println("list se: "+ se);
			return null;
		}finally{
			try{
				rs.close();
				pstmt.close();
				con.close();
			}catch(SQLException se){}
		}
	}
}
