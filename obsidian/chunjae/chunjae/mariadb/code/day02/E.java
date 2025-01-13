import java.sql.*;

// 동적 커서 (Dynamic Cursor)
public class E {
    String maria = "org.mariadb.jdbc.Driver";
    String mariaUrl = "jdbc:mariadb://127.0.01:3306/java_schema";
    Connection con;
    Statement stmt;
    String sql = "select * from JDBCT order by NO desc";

    E() {
        try {
            Class.forName(maria);
            con = DriverManager.getConnection(mariaUrl, "scott", "tiger");
            stmt = con.createStatement();
        } catch (ClassNotFoundException ce) {
            pln("드라이버 로딩 실패: " + ce);
        } catch (SQLException se) {
            pln("연결 실패: " + se);
        }

        createRs();
    }

    void createRs() {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
            forward(rs);
            backward(rs);
            rs.afterLast();
            backward(rs);
            forward(rs);
            rs.beforeFirst();
            forward(rs);

        } catch (SQLException se) {
        }
    }

    void forward(ResultSet rs) {
        pln("< 순방향 >");
        try {
            while (rs.next()) {
                int no = rs.getInt(1);
                String name = rs.getString(2);
                Date rdate = rs.getDate(3);
                Time rtime = rs.getTime(3);
                pln(no + "\t" + name + "\t" + rdate + " " + rtime);
            }
        } catch (SQLException se) {
        }
    }

    void backward(ResultSet rs) {
        try {
            pln("< 역방향 >");
            while (rs.previous()) {
                int no = rs.getInt(1);
                String name = rs.getString(2);
                Date rdate = rs.getDate(3);
                Time rtime = rs.getTime(3);
                pln(no + "\t" + name + "\t" + rdate + " " + rtime);
            }
        } catch (SQLException se) {
        }
    }

    void pln(String str) {
        System.out.println(str);
    }

    public static void main(String[] args) {
        new E();
    }
}
