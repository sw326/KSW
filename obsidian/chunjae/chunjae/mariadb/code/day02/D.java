import java.sql.*;

// CallableStatement
public class D {
    String maria = "org.mariadb.jdbc.Driver";
    String mariaUrl = "jdbc:mariadb://127.0.01:3306/java_schema";
    Connection con;
    CallableStatement cstmt;
    String sql = "call INCRE2(?, ?)";

    D() {
        try {
            Class.forName(maria);
            con = DriverManager.getConnection(mariaUrl, "scott", "tiger");
            cstmt = con.prepareCall(sql);
        } catch (ClassNotFoundException ce) {
            pln("드라이버 로딩 실패: " + ce);
        } catch (SQLException se) {
            pln("연결 실패: " + se);
        }
    }

    void call(int empno, int rate) {
        try {
            cstmt.setInt(1, empno);
            cstmt.setInt(2, rate);
            cstmt.execute();
            pln("호출성공(" + empno + "번 사원 급여 인상 완료");

        } catch (SQLException se) {
        } finally {
            try {
                cstmt.close();
                con.close();
            } catch (SQLException se) {
            }
        }
    }

    void pln(String str) {
        System.out.println(str);
    }

    public static void main(String[] args) {
        D d = new D();
        d.call(7369, 10);
    }
}
