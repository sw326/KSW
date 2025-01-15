import java.io.*;
import java.sql.*;

class WooSqlplus {
    String oracle = "oracle.jdbc.driver.OracleDriver";
    String oracleUrl = "";
    String id = "";
    String pwd = "";
    Connection con;
    Statement stmt;
    String sql = "";
    BufferedReader br;

    void init() {
        try {
            String input = "";
            br = new BufferedReader(new InputStreamReader(System.in));

            // Oracle IP 입력
            p("Oracle IP(default:127.0.0.1) : ");
            input = br.readLine();
            defaultValues(input, "127.0.0.1", "ip");

            // Oracle SID 입력
            p("Oracle SID(default:JAVA) : ");
            input = br.readLine();
            defaultValues(input, "JAVA", "sid");

            // ID 입력
            p("ID(default:scott) : ");
            input = br.readLine();
            defaultValues(input, "scott", "id");

            // PWD 입력
            p("PWD(default:tiger) : ");
            input = br.readLine();
            defaultValues(input, "tiger", "pwd");

        } catch (IOException ie) {
        }
    }

    void defaultValues(String input, String defaultVal, String type) {
        String value = input.trim().length() == 0 ? defaultVal : input.trim();
        switch (type) {
            case "ip":
                oracleUrl = "jdbc:oracle:thin:@" + value + ":1521:";
                break;
            case "sid":
                oracleUrl += value;
                break;
            case "id":
                this.id = value;
                break;
            case "pwd":
                this.pwd = value;
                break;
        }
    }

    void connect() {
        try {
            pln(oracle + " " + oracleUrl + " " + id + " " + pwd);
            Class.forName(oracle);
            con = DriverManager.getConnection(oracleUrl, id, pwd);
            con.setAutoCommit(false);
            stmt = con.createStatement();
        } catch (ClassNotFoundException ce) {
            pln("드라이버 로딩 실패: " + ce);
        } catch (SQLException se) {
            pln("연결 실패: " + se);
        }
        sql();
    }

    void sql() {
        try {
            String query;
            br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                p("SQL> ");
                query = br.readLine();
                // 쿼리 끝의 세미콜론 제거
                query = query.trim();
                if (query.endsWith(";")) {
                    query = query.substring(0, query.length() - 1);
                }
                if ("exit".equalsIgnoreCase(query)) {
                    closeAll();
                    break;
                }
                processQuery(query);
            }

        } catch (IOException ie) {
            pln("입력 오류: " + ie);
            sql();
        }
    }

    void processQuery(String query) {

        String upperQuery = query.trim().toUpperCase();
        if (upperQuery.startsWith("INSERT")) {
            insertD(query);
        } else if (upperQuery.startsWith("SELECT")) {
            selectD(query);
        } else if (upperQuery.startsWith("UPDATE")) {
            updateD(query);
        } else if (upperQuery.startsWith("DELETE")) {
            deleteD(query);
        } else if(upperQuery.startsWith("CREATE")){
            create(query);
        } else if(upperQuery.startsWith("DROP")){
            drop(query);
        } else if (upperQuery.equals("COMMIT")) {
            commitD();
        } else if (upperQuery.equals("ROLLBACK")) {
            rollbackD();
        } else if (upperQuery.startsWith("DESC")) {
            descD(query);
        } else if(upperQuery.equals("")){
            p("");
        } else {
            pln("지원하지 않는 쿼리입니다.");
        }
    }

    void insertD(String query) {
        try {
            int i = stmt.executeUpdate(query);
            if (i > 0) {
                pln(i + "개의 row 입력 성공");
            } else {
                pln("입력 실패");
            }
        } catch (SQLException se) {
            pln("데이터 삽입 실패: " + se);
        }
    }

    void selectD(String query) {
        try {
            ResultSet rs = stmt.executeQuery(query);
            int columnCount = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                StringBuilder row = new StringBuilder();
                for (int i = 1; i <= columnCount; i++) {
                    row.append(rs.getString(i)).append("\t");
                }
                pln(row.toString());
            }
        } catch (SQLException se) {
            pln("데이터 조회 실패: " + se);
        }
    }

    void updateD(String query) {
        try {
            stmt.executeUpdate(query);
            pln("데이터 업데이트 완료");
        } catch (SQLException se) {
            pln("데이터 업데이트 실패: " + se);
        }
    }

    void deleteD(String query) {
        try {
            stmt.executeUpdate(query);
            pln("데이터 삭제 완료");
        } catch (SQLException se) {
            pln("데이터 삭제 실패: " + se);
        }
    }

    void create(String query){
		try{
			stmt.execute(query);
			pln("테이블 생성 성공");
		}catch(SQLException se){
			pln("테이블 생성 실패: " + se);
		}
	}

	void drop(String query){
		try{
			stmt.execute(query);
			pln("테이블 삭제 성공");
		}catch(SQLException se){
			pln("테이블 삭제 실패: " + se);
		}

	}

    void commitD() {
        try {
            con.commit();
            pln("커밋이 완료되었습니다.");
        } catch (SQLException se) {
            pln("커밋 실패: " + se);
        }
    }

    void rollbackD() {
        try {
            con.rollback();
            pln("롤백이 완료되었습니다.");
        } catch (SQLException se) {
            pln("롤백 실패: " + se);
        }
    }

    void descD(String query) {
        String tableName = query.trim().substring(5); // DESC 뒤의 테이블 이름 추출
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName + " WHERE ROWNUM = 1"); // 테이블의 첫 번째 행 조회
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            pln("테이블 " + tableName + "의 구조:");
            for (int i = 1; i <= columnCount; i++) {
                pln("컬럼 이름: " + metaData.getColumnName(i) + ", 타입: " + metaData.getColumnTypeName(i));
            }
        } catch (SQLException se) {
            pln("테이블 설명 실패: " + se);
        }
    }

    void closeAll() {
        try {
            if (stmt != null)
                stmt.close();
            if (con != null)
                con.close();
            pln("데이터베이스 연결을 종료합니다.");
        } catch (SQLException se) {
            pln("연결 종료 중 오류 발생: " + se);
        }
    }

    void pln(String str) {
        System.out.println(str);
    }

    void p(String str) {
        System.out.print(str);
    }

    public static void main(String args[]) {
        WooSqlplus wsql = new WooSqlplus();
        wsql.init();
        wsql.connect();
    }
}
