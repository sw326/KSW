import java.sql.*;

// PreparedStatement
public class C {
    String maria = "org.mariadb.jdbc.Driver";
    String mariaUrl = "jdbc:mariadb://127.0.01:3306/java_schema";
    Connection con;
    PreparedStatement pstmt, pstmt2, pstmt3;
    String tname = "JDBCT";
    String sql = "insert into " + tname + " values(?,?,now())";
    String sql2 = "select * from " + tname + " order by NO desc";
    String sql3 = "select * from " + tname + " where name like ?";

    C() {
        try {
            Class.forName(maria);
            con = DriverManager.getConnection(mariaUrl, "scott", "tiger");
            pstmt = con.prepareStatement(sql);
            pstmt2 = con.prepareStatement(sql2);
            pstmt3 = con.prepareStatement(sql3);
        } catch (ClassNotFoundException ce) {
            pln("드라이버 로딩 실패: " + ce);
        } catch (SQLException se) {
            pln("연결 실패: " + se);
        }

        // insertD(50, "엄태정");
        // insertD(60, "신혜서");
        // insertD(70, "김노은");
        // insertD(80, "김다예");
        // insertD(90, "민성빈");
        // selectD();
        selectD("노");
        closeAll();

    }

    void insertD(int no, String name) {
        try {
            pstmt.setInt(1, no);
            pstmt.setString(2, name);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                pln(i + "개의 row 입력 성공");
            } else {
                pln("입력 실패");
            }
        } catch (SQLException se) {
            pln(tname + " 입력 실패: " + se);
        }
    }

    void selectD() {

        ResultSet rs = null;
        try {
            int i = 0;
            rs = pstmt2.executeQuery();
            pln("--------------------------------------------------");
            pln("번호\t이름\t날짜");
            pln("--------------------------------------------------");
            while (rs.next()) {
                int no = rs.getInt(1);
                String name = rs.getString(2);
                Date rdate = rs.getDate(3);
                Time rtime = rs.getTime(3);
                pln(no + "\t" + name + "\t" + rdate + "\t" + rtime);
                i++;
            }
            pln("--------------------------------------------------");
            pln("총 " + i + "개의 row가 검색됨");
        } catch (SQLException se) {
            pln("selectD()예외: " + se);
        } finally {
            try {
                rs.close();
            } catch (SQLException se) {
            }
        }
    }

    void selectD(String na) {
        ResultSet rs = null;
        try {
            int i = 0;
            pstmt3.setString(1, "%" + na + "%");
            rs = pstmt3.executeQuery();
            pln("--------------------------------------------------");
            pln("번호\t이름\t날짜");
            pln("--------------------------------------------------");
            while (rs.next()) {
                int no = rs.getInt(1);
                String name = rs.getString(2);
                Date rdate = rs.getDate(3);
                Time rtime = rs.getTime(3);
                pln(no + "\t" + name + "\t" + rdate + "\t" + rtime);
                i++;
            }
            pln("--------------------------------------------------");
            pln("총 " + i + "개의 row가 검색됨");
        } catch (SQLException se) {
            pln("selectD()예외: " + se);
        } finally {
            try {
                rs.close();
            } catch (SQLException se) {
            }
        }
    }

    void closeAll() {
        try {
            pstmt.close();
            pstmt2.close();
            pstmt3.close();
            con.close();
            pln("연결 객체들 닫기 성공");
        } catch (SQLException se) {
        }
    }

    void pln(String str) {
        System.out.println(str);
    }

    public static void main(String[] args) {
        new C();
    }
}
