import java.sql.*;

// ResultSetMetaData (ResultSet 구조 정보)
public class G {
    String maria = "org.mariadb.jdbc.Driver";
    String mariaUrl = "jdbc:mariadb://127.0.01:3306/java_schema";
    Connection con;
    PreparedStatement pstmt1, pstmt2;
    String sql1 = "update JDBCT set NAME=? where NO=?"; // DML1
    String sql2 = "insert into JDBCT values(?,?,now())"; // DML2

    G() {
        try {
            Class.forName(maria);
            con = DriverManager.getConnection(mariaUrl, "scott", "tiger");
            con.setAutoCommit(false); // 중요!
            pstmt1 = con.prepareStatement(sql1);
            pstmt2 = con.prepareStatement(sql2);
        } catch (ClassNotFoundException ce) {
            pln("드라이버 로딩 실패: " + ce);
        } catch (SQLException se) {
            pln("연결 실패: " + se);
        }
        up();
    }

    Savepoint sp1; //commit, rollback, savepoint
    void up(){
        try{
            pstmt1.setString(1, "초밥");
            pstmt1.setInt(2, 20);
            int i = pstmt1.executeUpdate();
            if(i>0){
                pln("Update 성공");
                sp1 = con.setSavepoint("sa1name");
                in();
            }else{
                pln("Update 실패");
            }
        }catch(SQLException se){
            pln("Update 실패 se: "+se);
        }
    }

    void in(){
        try{
            pstmt2.setInt(1, 90);
            pstmt2.setString(2, "갑을");
            int i = pstmt2.executeUpdate();
            if(i>0){
                pln("insert 성공");
                con.commit();
            }else{
                pln("insert 실패");
                con.rollback();
                
            }
        }catch(SQLException se){
            pln("insert 실패 se: "+se);
            try{
                // con.rollback();
                con.rollback(sp1);
            }catch(SQLException se2){}
        }
    }
    void pln(String str) {
        System.out.println(str);
    }

    void p(String str) {
        System.out.print(str);
    }

    public static void main(String[] args) {
        new G();
    }
}
