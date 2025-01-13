# MariaDB

1. 환경설정
   1. 다운로드 ( mariadb-10.11.8-winx64.msi )
      https://mariadb.org/download
   2. 설치
      password (1234) -> Modify~, Enable~, USe~ 모두 체크
2. 접근
   1. MySQL Client ()
      MariaDB [(none)]> select user(); --root@localhost
      MariaDB [(none)]> select database(); --NULL
      MariaDB [(none)]> show databases; --information_schema/mysql/performance_schema/sys
      --database는 schema와 같은 의미
      MariaDB [(none)]> use mysql --Database changed MariaDB [mysql]
      MariaDB [mysql]> select USER, Password, HOST, PLUGIN from USER;
      -- mariadb.sys와 root 5개
      MariaDB [mysql]> select database(); --mysql
      MariaDB [mysql]> quit;
   2. CMD
      1. Path등록
         1. 고급 시스템 설정 > 시스템변수 > Path > C:\Program Files\MariaDB 10.11\bin 없음 확인
         2. CMD관리자 권한 > SETX PATH "C:\Program Files\MariaDB 10.11\bin;%Path%" /M

            ==!!!!! Poweshell에 하면 안됨 !!!!!!==

            -> SUCCESS: Specified value was saved.
   3. HeidiSQL
      1. 신규 - > 세션이름: localhost -> 암호 :1234 -> 저장 -> 열기
      2. 왼쪽창: localhost/mysql 선택
      3. 오른쪽창: 쿼리 탭
         - select user() == root@localhost
         - show databases;
         - select database(); --mysql
         - desc user;
         - select USER, PASSWORD, HOST, PLUGIN from USER; --mariabd.sys와 root(5개)
3. user 생성/삭제
   1. 'CMD'에서
      mysql -u root -p
      Enter password: 1234
      MariaDB [mysql]> create user 'scott'@'localhost' identified by 'tiger';
      -- (옵션) create user 'scott'@'%' identified by 'tiger';
      MariaDB [mysql]> use mysql -- MariaDB [mysql]
      MariaDB [mysql]> select USER, PASSWORD, HOST, PLUGIN from USER;
   2. 삭제
      MariaDB [mysql]> select user();
      MariaDB [mysql]> drop user 'scott'@'localhost';
      -- (옵션) drop user 'scott'@'%';
      MariaDB [mysql]> select USER, PASSWORD, HOST, PLUGIN from USER; -- scott 삭제 확인
   3. 다시 생성
      MariaDB [mysql]> create user 'scott'@'localhost' identified by 'tiger';
      MariaDB [mysql]> select USER, PASSWORD, HOST, PLUGIN from USER; -- scott 생성 확인
4. database (schema) 생성
   1. 생성
      MariaDB [mysql]> create database java_schema;
      MariaDB [mysql]> show databases; --java_schema 생성 확인
   2. 권한부여 ( root 계정에서 해야 함 )
      MariaDB [mysql]> select user();
      MariaDB [mysql]> grant all privileges on java_schema.\* to 'scott'@'localhost';
      MariaDB [mysql]> flush privileges;
   3. 사용 관리 테이블 (USER)은 mysql database에만 존재
      MariaDB [mysql]> use java_schema
      MariaDB [java_schema]> select USER, PASSWORD, HOST, PLUGIN from USER;
      --(err) Table 'java_schema.user' doesn't exist
      MariaDB [java_schema]> use mysql
      MariaDB [mysql]> select USER, PASSWORD, HOST, PLUGIN from USER;
      -- scott 확인
5. scott/tiger 계정으로 접속
   1. 연결
      mysql -u scott -p -h localhost
      Enter password: tiger
      MariaDB [(none)]> use java_schema
      MariaDB [java_schema]> select user(); --
      MariaDB [java_schema]> show tables; --없음
   2. scott_maria.sql 생성
      1. scott_oracle.sql 생성
         탐색기 ( C:\app\user\virtual\product\ 에서 ) -> 'scott.sql' 찾기
         -> 'scott.sql' 파일찾기 -> line 28~96 복사
      2. scott_maria.sql
         GPT로 오라클 -> 마리아 컨버트 하기
      3. 인스톨
         MariaDB [java_schema]> source ~ 경로
         MariaDB [java_schema]> show tables; --dept/emp/salgrade/bonus 테이블 생성확인
         MariaDB [java_schema]> desc emp;
         MariaDB [java_schema]> desc dept;
   3. pro2_maria.sql 생성
      1. pro2.sql을 복사해서 pro2_oracle.sql로 변경
         GPT로 오라클 -> 마리아 컨버트 하기
      2. 인스톨
         MariaDB [java_schema]> source D:\KSW\obsidian\chunjae\chunjae\mariadb\note\code\day01\pro2_maria.sql
      3. 호출
         MariaDB [java_schema]> select _ from emp where empno=7839;--SAL: 5000
         MariaDB [java_schema]> call INCRE2(7839, 10);
         MariaDB [java_schema]> select _ from emp where empno=7839;--SAL: 5500
         
6. 연동 ( DB <-> JAVA )
   1. JDBC( Java Database Connectivity ) -- 인터페이스
      1. 드라이버
         1. 오라클: ojdbc8.jar
         2. 마리아: mariadb-java-client-3.4.0.jar
   2. 순서
      1. Driver 로딩
         Class.forName("org.mariadb.jdbc.Driver");
         
         set classpath=.;D:\KSW\자료실\ojdbc8.jar
         -- 클래스의 위치를 JVM에게 알려주기 위해
      2. Connection 생성
         Connection con = DriverManager.getConnection(url, id, pw)
         
         ex) mariadb/day01/B.java
         
      3. Statement 생성
         Statement stmt = con.createStatement();
         
      4. Statement 실행 ( DQL: ResultSet 생성)
         stmt.execute(sql); --DML이나 DQL이 아닌 경우
         int i = stmt.excuteUpdate(sql); --DML
         ResultSet rs = stmt.executeQuery(sql); -- DQL
         
      5. 데이터 추출 ( from ResultSet )
         rs.next();
         Date rdate = rs.getXXX(column idx or name);
         
      6. 연결 객체들 닫기
         rs.close();
         stmt.close();
         con.close();
         ex) mariadb/day01/B.java
         
7. Statement
	1) Statement
	   
	2) PreparedStatement
	   
	   ex) mariadb/day02/C.java
	3) CallableStatement
	   
	   ex) mariadb/day02/D.java
	   
8. 동적 커서 ( Dynamic Cursor )
	- rs.next();
	- rs.previous();
	- rs.beforeFirst();
	- rs.afterLast();
	
	ex) /mariadb/day02/E.java  
	
9. Transaction
	1. DML: 1 Transaction (JDBC는 DML이 기본적으로 auto commit되기 때문에)
	   
10. 