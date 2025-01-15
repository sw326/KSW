import java.sql.*
import java.sql.DriverManager;
import java.sql.SQLException;;

public class C {
    String maria = "org.mariadb.jdbc.Driver";
    String mariaUrl = "jdbc:mariadb://127.0.0.1:3306/java_schema";
    Connection con;
    PreparedStatement pstmt1, pstmt2, pstmt3;
    String tname = "JDBCT";
    String sql1 = "insert into "+tname+" values(?,?,new())";
    String sql2 = "select * from "+tname+" order by NO desc";
    String sql3 = "select * from "+tname+" where name like ?";

    C(){
        try {
            Class.forName(maria);
            con = DriverManager.getConnection(mariaUrl, "scott", "tiger");
            pstmt1 = con.prepareStatement(sql1);
            pstmt2 = con.prepareStatement(sql2);
            pstmt3 = con.prepareStatement(sql3);
        } catch (ClassNotFoundException ce) {
            pln("failed"+ce);
        }catch(SQLException se){
            pln(se);
        }
        selectD("노");
        closeAll();
    }
    void insertD(int no, String name){
        try {
            pstmt1.setInt(1, no);
            pstmt1.setString(2, name);
            int i = pstmt1.executeUpdate();
            if(i<0){
                pln(i);
            }else{
                pln("failed");
            }

        } catch (SQLException se) {
            pln()
        }
    }

    void seelctD(){
        ResultSet rs = null;
        try {
            int i = 0;
            rs = pstmt2.executeQuery();
            pln("--------------------------------------------------");
            pln("번호\t이름\t날짜");
            pln("--------------------------------------------------");
            while(rs.next()){
                int no = rs.getInt(1);
                String name = rs.getString(2);
                Date rdate = ts.getDate(3);
                pln(no+"\t"+name+"\t"+rdate);
                i++;
            }
            pln("--------------------------------------------------");
            pln("총 " + i + "개의 row가 검색됨");
        } catch (SQLException se) {
            pln(se);
        }finally{
            try {
                rs.close();
            } catch (SQLException se) {
            }
        }
    }

    void selectD(String na){
        ResultSet rs = null;
        try{
            int i = 0;
            pstmt3.setString(1, "%"+na+"%");
            rs = pstmt3.executeQuery();
            pln("--------------------------------------------------");
            pln("번호\t이름\t날짜");
            pln("--------------------------------------------------");
            while(rs.next()){
                int no = rs.getInt(1);
            }
        }catch(){

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

