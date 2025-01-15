import java.sql.*;
import java.util.Scanner;

class A {

	String sql;
	Statement stmt;

	String oracle = "oracle.jdbc.driver.OracleDriver";
	Connection con;
	String oracleUrl;
	
	Scanner scanner = new Scanner(System.in);

	A(){
		try{
			Class.forName(oracle);

			System.out.print("Oracle IP(default:127.0.0.1) : ");
			String ip = scanner.nextLine();
			if(ip.length() == 0) ip = "127.0.0.1";

			System.out.print("Oracle SID(default:JAVA) : ");
			String sid = scanner.nextLine();
			if(sid.length() == 0) sid = "JAVA";

			oracleUrl = "jdbc:oracle:thin:@"+ip+":1521:"+sid;

			System.out.print("ID(default:scott) : ");
			String id = scanner.nextLine();
			if(id.length() == 0) id = "scott";

			System.out.print("PWD(default:tiger) : ");
			String pwd = scanner.nextLine();
			if(pwd.length() == 0) pwd = "tiger";

			con = DriverManager.getConnection(oracleUrl, id, pwd);
			stmt = con.createStatement();

		}catch(ClassNotFoundException ce){
			System.out.println("드라이버로딩 실패: " + ce);
			System.out.println("set classpath=.;D:\\KNE\\Oracle\\ojdbc8.jar 설정했나요?");
		}catch(SQLException se){
			System.out.println("연결 실패: " + se);
		}
	}

	void sql(){
		while(true){
			System.out.print("SQL>");
			sql = scanner.nextLine();
			sql = sql.replaceAll(";", "").trim();
			
			if(sql.equalsIgnoreCase("exit") || sql.equalsIgnoreCase("quit")){
				System.out.println("종료");
				break;
			}
			
			if(sql.toUpperCase().startsWith("SELECT")){
				select(sql);
				//select * from emp
			}else if(sql.toUpperCase().startsWith("INSERT")){
				insert(sql);
				//insert into emp(empno, ename) values(9999, '김다예')
			}else if(sql.toUpperCase().startsWith("UPDATE")){
				update(sql);
				//update emp set ename = '김노은' where empno = 8888
			}else if(sql.toUpperCase().startsWith("DELETE")){
				delete(sql);
				//delete from emp where No=9999
			}else if(sql.toUpperCase().startsWith("CREATE")){
				create(sql);
				//CREATE TABLE 김노은(NO NUMBER PRIMARY KEY, Name VARCHAR2(10), RDATE DATE)
			}else if(sql.toUpperCase().startsWith("DROP")){
				drop(sql);
				//drop TABLE 김노은
			}
		}
	}

	void select(String sql){
		ResultSet rs = null;
		try{
			rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();

			int cc = rsmd.getColumnCount();

			for(int i=1; i<=cc; i++){
				String cn = rsmd.getColumnName(i);
				p(cn+"\t");
			}

			pln("");

			for(int i=1; i<=cc; i++){
				p("-----------");
			}

			pln("");

			while(rs.next()){
				for(int i=1; i<=cc; i++){
					String data = rs.getString(i);
					p(data+"\t");
				}
				pln("");
			}
		}catch(SQLException se){
			System.out.println("SQL 실행 오류: " + se);
		}finally{
			try{
				if(rs != null) rs.close(); //SQLException로 객체가 생성안되면 굳이 close할필요없음
			}catch(SQLException se){
				System.out.println("ResultSet 닫기 오류: " + se);
			}
		}
	}

	void insert(String sql){
		try{
			int i = stmt.executeUpdate(sql);
			if(i>0){
				pln(i+"개의 row 입력 성공");
			}else{
				pln("입력 실패"); //-1 리턴
			}
		}catch(SQLException se){
			pln("입력 실패: " + se);
		}
	}


	void update(String sql){
		try{
			int i = stmt.executeUpdate(sql);
			if(i>0){
				pln(i+"개의 row 수정 성공");
			}else{
				pln("수정 실패");
			}
		}catch(SQLException se){
			pln("수정 실패: " + se);
		}
	}


	void delete(String sql){
		try{
			int i = stmt.executeUpdate(sql); //int i == row 값 //항상 UPdate로!
			if(i>0){
				pln(i+"개의 row 삭제 성공");
			}else{
				pln("삭제 실패");
			}
		}catch(SQLException se){
			pln("삭제 실패: " + se);
		}
	}

	void create(String sql){
		try{
			stmt.execute(sql);
			pln("테이블 생성 성공");
		}catch(SQLException se){
			pln("테이블 생성 실패: " + se);
		}
	}

	void drop(String sql){
		try{
			stmt.execute(sql);
			pln("테이블 삭제 성공");
		}catch(SQLException se){
			pln("테이블 삭제 실패: " + se);
		}

	}

	void closeAll(){
		try{
			if (scanner != null) {
				scanner.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException se) {
			System.out.println("close 오류: " + se);
		}
	}

	void pln(String str){
		System.out.println(str);
	}

	void p(String str){
		System.out.print(str);
	}

	public static void main(String[] args) {
		A a = new A();
		a.sql();  // SQL 실행
		a.closeAll();  // 종료 후 자원 해제
	}
}