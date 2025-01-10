import java.sql.*;

class A{
    //String dbms = "오라클";
    String dbms = "마리아";
    //String oracle = "oracle.jdbc.driver.OracleDriver";
    String maria = "org.mariadb.jdbc.Driver";
    Connection con;
    String oracleUrl = "jdbc:oracle:thin:@127.0.0.1:1521:JAVA";
    String mariaUrl = "jdbc:mariadb://127.0.01:3306/java_schema";
    A(){
        // 1) 드라이버 로딩
        try{
            //Class.forName(oracle);
            Class.forName(maria);
            pln("(1)"+dbms+" 드라이버로딩 성공");
            //con = DriverManager.getConnection(oracleUrl, "scott", "tiger");
            con = DriverManager.getConnection(mariaUrl, "scott", "tiger");
            pln("(2)"+dbms+" 연결 성공 " + con);
        }catch(ClassNotFoundException ce){
            pln("(1)"+dbms+" 드라이버 로딩 실패: "+ ce);
        }catch(SQLException se){
            pln("(2)"+dbms+" 드라이버 로딩 실패: "+ se);
        }
    }
    void pln(String str){
        System.out.println(str);
    }
    public static void main(String[] args) {
        new A();
    }
}