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
            //dropT();
            insertD(10, "홍길동");
            insertD(20, "이순신");
            insertD(30, "강감찬");
            insertD(40, "유관순");
            updateD(30, "낙성대");
            deleteD(20, "이순신");
            selectD();

            closeAll();
    }
    String tname = "JDBCT";
    void createT(){
        String sql = "create table if not exists "+tname
        +"(NO int primary key, NAME varchar(10), RDATE datetime)";
        try{
            stmt.execute(sql);
            pln("테이블 생성 성공");
        }catch(SQLException se){
            pln(tname+"테이블 생성 실패: "+ se);
        }
    }
    void dropT(){
        String sql = "drop table if exists " +tname;
        try{
            stmt.execute(sql);
            pln(tname+"테이블 삭제 성공");
        }catch(SQLException se){
            pln(tname+"테이블 삭제 실패: "+se);
        }
    }
    void insertD(int no, String name){
        String sql = "insert into "+tname+" values("+no+",'"+name+"', now())";
        try{
            int i = stmt.executeUpdate(sql);
            if(i>0){
                pln(i+"개의 row 입력 성공");
            }else{
                pln("입력 실패");
            }
        }catch(SQLException se){
            pln(tname+" 입력 실패: "+se);
        }
    }
    void updateD(int no, String name){
        String sql = "update "+tname+" set NAME='"+name+"' where NO="+no;
        try{
            int i = stmt.executeUpdate(sql);
            if(i>0){
                pln(i+"개의 row 수정 성공");
            }else{
                pln("수정 실패");
            }
        }catch(SQLException se){
            pln(tname+" 수정 실패: "+se);
        }
    }
    void deleteD(int no, String name){
        String sql = "delete from "+tname+" where NO="+no;
        try{
            int i = stmt.executeUpdate(sql);
            if(i>0){
                pln(i+"개의 row 삭제 성공");
            }else{
                pln("삭제 실패");
            }
        }catch(SQLException se){
            pln(tname+" 삭제 실패: "+se);
        }
    }
    void selectD(){
        String sql = "select * from "+tname+" order by NO desc";
        ResultSet rs = null;
        try{
            int i = 0;
            rs = stmt.executeQuery(sql);
            pln("--------------------------------------------------");
            pln("번호\t이름\t날짜");
            pln("--------------------------------------------------");
            while(rs.next()){
                int no = rs.getInt(1);
                String name = rs.getString(2);
                Date rdate = rs.getDate(3);
                pln(no+"\t"+tname+"\t"+rdate);
                i++;
            }
            pln("--------------------------------------------------");
            pln("총 "+i+"개의 row가 검색됨");
        }catch(SQLException se){
            pln("selectD()예외: "+ se);
        }finally{
            try{
                rs.close();
            }catch(SQLException se){}
        }
    }
    void closeAll(){
        try{
            stmt.close();
            con.close();
            pln("연결 객체들 닫기 성공");
        }catch(SQLException se){}
    }
    void pln(String str){
        System.out.println(str);
    }
    public static void main(String args[]){
        new B();
    }
}

class B2{
    String maria = "org.mariadb.jdbc.Driver";
    String mariaUrl = "jdbc:mariadb://127.0.01:3306/java_schema";
    Connection con;
    Statement stmt;
    B2(){
        try{
            Class.forName(maria);
            con = DriverManager.getConnection(mariaUrl, "scott", "tigger");
            stmt = con.createStatement();
        }catch(ClassNotFoundException ce){
            pln("Loading driver has failed: "+ ce);
        }catch(SQLException se){
            pln("Connection failed: "+ se);
        }
        //createT();
        dropT();
        // insertD(10, "홍길동");
        // insertD(20, "이순신");
        // insertD(30, "강감찬");
        // insertD(40, "유관순");
        // updateD(30, "낙성대");
        // deleteD(20, "이순신");
        selectD();

        closeAll();
    }
    String tname = "JDBCT";
    void createT(){
        String sql = "create table if not exists "+tname
        +"(NO int primary key, NAME varchar(10), RDATE datetime)";
        try{
            stmt.execute(sql);
            pln("succeeded to create the table "+tname);
        }catch(SQLException se){
            pln("Failed to create the table "+tname+" "+se);
        }
    }
    void dropT(){
        String sql = "drop table if exists " + tname;
        try{
            stmt.execute(sql);
            pln("succeeded to drop table "+tname);
        }catch(SQLException se){
            pln("failed to drop the table "+tname+" "+se);
        }
    }
    void insertD(int no, String name){
        String sql = "insert into "+tname+" values("+no+", '"+name+"', now())";
        try{
            int i = stmt.executeUpdate(sql);
            if(i>0){
                pln(i + " row(s) inserted successfully");
            }else{
                pln("insert failed");
            }
        }catch(SQLException se){
            pln(tname+" insert failed: "+ se);
        }
    }
    void updateD(int no, String name){
        String sql = "update "+tname+" set NAME='"+name+"' where NO="+no;
        try{
            int i = stmt.executeUpdate(sql);
            if(i>0){
                pln(i+" row(s) updated successfully");
            }else{
                pln("update failed");
            }
        }catch(SQLException se){
            pln(tname+"update failed: "+se);
        }
    }
    void deleteD(int no, String name){
        String sql = "delete from "+tname+" where NO="+no;
        try{
            int i = stmt.executeUpdate(sql);
            if(i>0){
                pln(i+"row(s) deleted successfully");
            }else{
                pln("delete failed");
            }
        }catch(SQLException se){
            pln(tname+" delete failed: "+se);
        }
    }
    void selectD(){
        String sql = "select * from "+tname+" order by NO desc";
        ResultSet rs = null;
        try{
            int i = 0;
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                int no = rs.getInt(1);
                String name = rs.getString(2);
                Date rdate = rs.getDate(3);
                pln(no+"\t"+name+"\t"+rdate);
                i++;
            }
            pln(i+"row(s) selected");
        }catch(SQLException se){
            pln("selectD() exception: "+se);
        }finally{
            try{
                rs.close();
            }catch(SQLException se){}
        }
    }
    void closeAll(){
        try{
            stmt.close();
            con.close();
            pln("success to close all connection");
        }catch(SQLException se){}
    }
    void pln(String str){
        System.out.println(str);
    }
    public static void main(String args[]){
        new B2();
    }
}

class B3{
    String maria = "org.mariadb.jdbc.Driver";
    String mariaUrl = "jdbc:mariadb://127.0.01:3306/java_schema";
    Connection con;
    Statement stmt;

    B3(){
        try{

            Class.forName(maria);
            con = DriverManager.getConnection(mariaUrl, "scott", "tiger");
            stmt = con.createStatement();
        }catch(ClassNotFoundException ce){
            pln(ce);
        }catch(SQLException se){
            pln(se);
        }
        createT();
        dropT();
        insertD(10, "John");
        insertD(20, "Tom");
        insertD(30, "Joe");
        insertD(40, "Taylor");
        updateD(30, "Donald");
        deleteD(20, "Tom");
        selectD();
        closeAll();
    }
    String tname="JDBCT";
    void createT(){
        String sql = "create table if not exists "+tname
        +"(NO int primary key, NAME varchar(10), RDATE datetime)";
        try{
            stmt.execute(sql);
            pln("create success");
        }catch(SQLException se){
            pln(se);
        }
    }
    void dropT(){
        String sql = "drop table if exists "+tname;
        try{
            stmt.execute(sql);
            pln("drop success");
        }catch(SQLException se){
            pln(se);
        }
    }
    void insertD(int no, String name){
        String sql = "insert into "+tname+" values("+no+", '"+name+"', now())";
        try{
            int i = stmt.executeUpdate(sql);
            if(i>0){
                pln(i+" rows inserted");
            }else{
                pln("insert failed");
            }
        }catch(SQLException se){
            pln(se);
        }
    }
    void updateD(int no, String name){
        String sql = "update "+tname+" set NAME='"+name+"' where NO="+no;
        try{
            int i = stmt.executeUpdate(sql);
            if(i<0){
                pln(i+" row updated");
            }else{
                pln("update failed");
            }
        }catch(SQLException se){
            pln(se);
        }
    }
    void deleteD(int no, String name){
        String sql = "delete from "+tname+" where NO="+no;
        try {
            int i = stmt.executeUpdate(sql);
            if(i>0){
                pln(i+"개의 row 삭제 성공");
            }else{
                pln("삭제 실패");
            }
        } catch (SQLException se) {
            pln(tname+ " 삭제 실패: "+ se);
        }
    }
    void selectD(){
        String sql = "select * from "+tname+ " order by NO desc";
        ResultSet rs = null;
        try{
            int i = 0;
            rs = stmt.executeQuery(sql);
            pln("--------------------------------------------------");
            pln("번호\t이름\t날짜");
            pln("--------------------------------------------------");
            while(rs.next()){
                int no = rs.getInt(1);
                String name = rs.getString(2);
                Date rdate = rs.getDate(3);
                Time rtime = rs.getTime(3);
                pln(no+"\t"+name+"\t"+rdate+"\t"+rtime);
                i++;
            }
            pln("--------------------------------------------------");
            pln("총 "+i+"개의 row가 검색됨");
        }catch(SQLException se){
            pln("selectD()예외: " + se);
        }finally{
            try{
                rs.close();
            }catch(SQLException se){}
        }
    }
    closeAll(){
        try{
            stmt.close();
            con.close();
            pln("연결 객체들 닫기 성공");
        }catch(SQLException se){}
    }
    void pln(String str){
        System.out.println(str);
    }
    public static void main(String args[]){
        new B3();
    }
}

class B4{
    String maria = "org.mariadb.jdbc.Driver";
    String mariaUrl = "jdbc:mariadb://127.0.01:3306/java_schema";
    Connection con;
    Statement stmt;

    B4(){
        try{
            Class.forName(maria);
            con = DriverManager.getConnection(mariaUrl, "scott", "tiger");
            stmt = con.createStatemenmt();
        }catch(ClassNotFoundException ce){
            pln(ce);
        }catch(SQLException se){
            pln(se);
        }
        createT();
        dropT();
        insertD(10, "A");
        insertD(20, "B");
        insertD(30, "C");
        insertD(40, "D");
        updateD(30, "a");
        deleteD(20, "B");
        selectD();
        closeAll();
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
    void insertD(int no, String name){
        String sql = "insert into "+tname+" values("+no+",'"+name+"', now())";
        try {
            int i = stmt.executeUpdate(sql);
            if(i>0){
                pln(i+"개의 row 입력 성공");
            }else{
                pln("입력 실패");
            }
        } catch (SQLException se) {
            pln(tname+ " 입력 실패: "+ se);
        }
    }
    void updateD(int no, String name){
        String sql = "update "+tname+" set NAME='"+name+"' where NO="+no;
        try {
            int i = stmt.executeUpdate(sql);
            if(i>0){
                pln(i+"개의 row 수정 성공");
            }else{
                pln("수정 실패");
            }
        } catch (SQLException se) {
            pln(tname+ " 수정 실패: "+ se);
        }
    }
    void deleteD(int no, String name){
        String sql = "delete from "+tname+" where NO="+no;
        try {
            int i = stmt.executeUpdate(sql);
            if(i>0){
                pln(i+"개의 row 삭제 성공");
            }else{
                pln("삭제 실패");
            }
        } catch (SQLException se) {
            pln(tname+ " 삭제 실패: "+ se);
        }
    }
    void selectD(){
        String sql = "select * from "+tname+ " order by NO desc";
        ResultSet rs = null;
        try{
            int i = 0;
            rs = stmt.executeQuery(sql);
            pln("--------------------------------------------------");
            pln("번호\t이름\t날짜");
            pln("--------------------------------------------------");
            while(rs.next()){
                int no = rs.getInt(1);
                String name = rs.getString(2);
                Date rdate = rs.getDate(3);
                Time rtime = rs.getTime(3);
                pln(no+"\t"+name+"\t"+rdate+"\t"+rtime);
                i++;
            }
            pln("--------------------------------------------------");
            pln("총 "+i+"개의 row가 검색됨");
        }catch(SQLException se){
            pln("selectD()예외: " + se);
        }finally{
            try{
                rs.close();
            }catch(SQLException se){}
        }
    }
    void closeAll(){
        try{
            stmt.close();
            con.close();
            pln("연결 객체들 닫기 성공");
        }catch(SQLException se){}
    }
    void pln(String str){
        System.out.println(str);
    }
    public static void main(String args[]){
        new B4();
    }
}