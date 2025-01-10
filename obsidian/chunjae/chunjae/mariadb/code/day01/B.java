import java.sql.*;

public class B {
    String maria = "org.mariadb.jdbc.Driver";
    String mariaUrl = "jdbc:mariadb://127.0.01:3306/java_schema";
    Connection con;
    Statement stmt;

    B(){
        try{
            Class.forName(maria);
            con = DriverManager.getConnection(mariaUrl, "scott", "tiger");
            stmt = con.createStatement();
        }catch(ClassNotFoundException ce){
            pln("드라이버 로딩 실패: "+ ce);
        }catch(SQLException se){
            pln("연결 실패: "+ se);
        }
        //createT();
        dropT();
    }
    String tname = "JDBCT";
    void createT(){
        String sql = "create table if not exists "+tname
        +"(NO int primary key, NAME varchar(10), RDATE datetime)";
        try {
            stmt.execute(sql);
            pln(tname+" 테이블 생성 성공");
        } catch (SQLException se) {
            pln(tname+" 테이블 생성 실패: "+ se);
        }
    }
    void dropT(){
        String sql = "drop table if exists "+tname;
        try {
            stmt.execute(sql);
            pln(tname+" 테이블 삭제 성공");
        } catch (SQLException se) {
            pln(tname+" 테이블 삭제 실패: "+ se);
        }
    }
    void pln(String str){
        System.out.println(str);
    }
    public static void main(String[] args) {
        new B();
    }
}
