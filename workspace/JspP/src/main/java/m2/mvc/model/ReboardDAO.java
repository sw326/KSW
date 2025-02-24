package m2.mvc.model;

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

import mvc.domain.Reboard;
import static m2.mvc.model.ReboardSQL.*;

import java.io.File;

import file.mvc.fileset.Path;

class ReboardDAO {
	private DataSource ds;

	public ReboardDAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/TestDB");
			System.out.println("ReboardDAO: " + ds);
		} catch (NamingException ne) {
			System.out.println("DBCP객체(jdbc/TestDB)를 못찾음");
		}
	}

	public ArrayList<Reboard> list() {
		ArrayList<Reboard> list = new ArrayList<>();
		String sql = LIST;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				long idx = rs.getLong(1);
				String subject = rs.getString(2);
				String content = rs.getString(3);
				String writer = rs.getString(4);
				String email = rs.getString(5);
				String homepage = rs.getString(6);
				String pwd = rs.getString(7);
				Long parentIdx = rs.getLong(8);
				Long rootIdx = rs.getLong(9);
				int dept = rs.getInt(10);
				int orderNo = rs.getInt(11);
				int hit = rs.getInt(12);
				String filename = rs.getString(13);
				Date createdAt = rs.getDate(14);

				Reboard rb = new Reboard(idx, subject, content, writer, email, homepage, pwd, parentIdx, rootIdx, dept,
						orderNo, hit, filename, createdAt);
				list.add(rb);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return list;
	}

	public void insert(Reboard reboard) {
		String sql = INSERT;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, reboard.getSubject());
			pstmt.setString(2, reboard.getContent());
			pstmt.setString(3, reboard.getWriter());
			pstmt.setString(4, reboard.getEmail());
			pstmt.setString(5, reboard.getHomepage());
			pstmt.setString(6, reboard.getPwd());
			pstmt.setString(7, reboard.getFileName());
			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	public Reboard content(long idx) {
		Reboard reboard = null;
		String sql = SELECT_BY_IDX;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, idx);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String subject = rs.getString(2);
				String content = rs.getString(3);
				String writer = rs.getString(4);
				String email = rs.getString(5);
				String homepage = rs.getString(6);
				String pwd = rs.getString(7);
				Long parentIdx = rs.getLong(8);
				Long rootIdx = rs.getLong(9);
				int dept = rs.getInt(10);
				int orderNo = rs.getInt(11);
				int hit = rs.getInt(12);
				String filename = rs.getString(13);
				Date createdAt = rs.getDate(14);

				reboard = new Reboard(idx, subject, content, writer, email, homepage, pwd, parentIdx, rootIdx, dept,
						orderNo, hit, filename, createdAt);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return reboard;
	}

	public void updateHit(long idx) {
		String sql = UPDATE_HIT;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, idx);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	public void delete(long idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			con.setAutoCommit(false);
			String sql = DELETE;
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, idx);
			pstmt.executeUpdate();
			Reboard reboard = content(idx);
			if (reboard.getFileName() != null) {
				File file = new File(Path.FILE_STORE, reboard.getFileName());
				if (file.exists())
					file.delete();
			}
			con.commit();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	public void update(Reboard reboard, long idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			con.setAutoCommit(false);
			String sql = UPDATE;
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, reboard.getSubject());
			pstmt.setString(2, reboard.getContent());
			pstmt.setString(3, reboard.getWriter());
			pstmt.setString(4, reboard.getEmail());
			pstmt.setString(5, reboard.getHomepage());
			pstmt.setString(6, reboard.getPwd());
			pstmt.setString(7, reboard.getFileName());
			pstmt.setLong(8, idx);
			pstmt.executeUpdate();

			reboard = content(idx);
			if (reboard.getFileName() != null) {
				File file = new File(Path.FILE_STORE, reboard.getFileName());
				if (file.exists())
					file.delete();
			}
			con.commit();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	public void rewriteInsert(Reboard reboard, long parentIdx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			con.setAutoCommit(false);

			// 1. order_no 업데이트
			String updateOrderNoSql = UPDATE_ORDER_NO;
			pstmt = con.prepareStatement(updateOrderNoSql);
			pstmt.setLong(1, reboard.getRootIdx());
			pstmt.setInt(2, reboard.getOrderNo());
			pstmt.executeUpdate();
			pstmt.close();
	
			// 2. 답글 삽입
			String insertSql = REWRITE_INSERT;
			pstmt = con.prepareStatement(insertSql);
			pstmt.setString(1, reboard.getSubject());
			pstmt.setString(2, reboard.getContent());
			pstmt.setString(3, reboard.getWriter());
			pstmt.setString(4, reboard.getEmail());
			pstmt.setString(5, reboard.getHomepage());
			pstmt.setString(6, reboard.getPwd());
			pstmt.setLong(7, reboard.getParentIdx());
			pstmt.setLong(8, reboard.getRootIdx());
			pstmt.setInt(9, reboard.getDepth());
			pstmt.setInt(10, reboard.getOrderNo());
			pstmt.setString(11, reboard.getFileName());
			pstmt.executeUpdate();

			con.commit();
		} catch (SQLException se) {
			if (con != null) {
				try {
					con.rollback();
				} catch (SQLException se2) {
					se2.printStackTrace();
				}
			}
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
}
