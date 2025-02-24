package m2.mvc.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import mvc.domain.Reply;

class ReplyDAO {
    private DataSource ds;

    public ReplyDAO() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            ds = (DataSource) envContext.lookup("jdbc/TestDB");
            System.out.println("ReboardDAO: " + ds);
        } catch (NamingException ne) {
            System.out.println("DBCP객체(jdbc/TestDB)를 못찾음");
        }
    }

    public void insert(Reply reply) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = ds.getConnection();
            String sql = "INSERT INTO reply (board_idx, content, writer, pwd_reply, parent_idx, root_idx, depth, order_no, created_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, reply.getBoardIdx());
            pstmt.setString(2, reply.getContent());
            pstmt.setString(3, reply.getWriter());
            pstmt.setString(4, reply.getPwdReply());
            pstmt.setLong(5, reply.getParentIdx());
            pstmt.setLong(6, reply.getRootIdx());
            pstmt.setInt(7, reply.getDepth());
            pstmt.setInt(8, reply.getOrderNo());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Reply> selectAll(long boardIdx) {
        List<Reply> replyList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = ds.getConnection();
            String sql = "SELECT * FROM reply WHERE board_idx = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, boardIdx);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                long idxReply = rs.getLong("idx_reply");
                //long boardIdx = rs.getLong("board_idx");
                String content = rs.getString("content");
                String writer = rs.getString("writer");
                String pwdReply = rs.getString("pwd_reply");
                Long parentIdx = rs.getLong("parent_idx");  
                Long rootIdx = rs.getLong("root_idx");
                int depth = rs.getInt("depth");
                int orderNo = rs.getInt("order_no");
                Date createdAt = rs.getDate("created_at");

                Reply reply = new Reply(idxReply, boardIdx, content, writer, pwdReply, parentIdx, rootIdx, depth, orderNo, createdAt);
                replyList.add(reply);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return replyList;
    }
}
