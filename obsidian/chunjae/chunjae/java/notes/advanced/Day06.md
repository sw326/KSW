1. 오라클 설치( 12c )
   (1) 디렉토리 이름이 '한글'이면 X
       1) Oracle 설치파일이 존재하는 경로에 한글X
       2) Oracle 설치경로에 한글X

   (2) 디렉토리에 '공백'이 있으면 X
       1) Oracle 설치 파일이 존재하는 경로에 공백X
       2) Oracle 설치 경로에 공백X

   (3) Windows 계정이 한글 이름이면 X
   
   (4) 설치시에 에러 해결 방법 
       1) OS부터 밀고 다시 설치 
       2) Oracle 를 다시 설치 
          <1> 제어판 -> 프로그램 추가제거 -> 관련 프로그램 제거
          <2> 관리도구 -> 서비스 -> 오라클 관련 서비스들을 정지
          <3> Oracle 설치 디렉토리를 삭제
	         (만약, 삭제 안되면 '안전모드'에서 삭제 )
          <4> 시작 -> 모든 프로그램에서 -> Oracle관련 메뉴 삭제 
          <5> 실행 -> regedit -> oracle관련 파일을 모두 제거 
          <6> 다시 설치

          cf) SID: JAVA 
              PWD: java1234

   (5) 오라클(12c) 설치시 셋팅
       1) 드라이브변경: D -> C 
       2) Enterprise Edition 선택 
       3) 전역데이터베이스이름(SID)변경: orcl -> JAVA
       4) 비번입력: java1234 
       5) 컨테이너 데이터베이스로 생성: 체크 해제
       6) 방화벽 허용

       참고1) 중간에 계정의 lock을 풀어주는 화면나올땐 함께 셋팅 
       참고2) 참고 블로그
              https://gunnm.tistory.com/232

2. 오라클 접근
   (1) 개발 계정(scott) 활성화 
	1) 실행창( Win + R )에서 관리자로 들어가는 방법
	    <방법1> sqlplus / as sysdba
	    <방법1> sqlplus sys/java1234 as sysdba

	2) scott/tiger 계정 생성
	    <방법1>
		create user scott identified by tiger;
	    <방법2:성우>
		alter session set "_oracle_script"=true; 
		create user scott identified by tiger;
	    <방법3:성우>
		create user scott2 identified by tiger;
		(이전버젼) create user c##scott identified by tiger;

	     cf) 계정제거
		drop user scott cascade;

	3) 권한부여(관리자계정에서) 
	    grant connect, resource, unlimited tablespace to scott;
	    conn scott/tiger
	    show user

	    cf) 권한뺏기
	    revoke connect, resource, unlimited tablespace from scott;

	4) scott 접속 
	    <방법1> 실행창에서
		sqlplus scott/tiger
	    <방법2> 다른 계정의 세션에서 계정 변경 
		conn scott/tiger

	5) 기본 테이블 생성 / 데이터 입력 
	    탐색기( C:\app\user\virtual\product\ 에서 ) -> 파일찾기 
	    -> scott.sql 의 복사(line 28~96) -> sqlplus창에 붙여넣기 
	    -> Enter!

	6) 테이블/ 데이터 확인 
	   select TNAME from tab;

	   set linesize 120;
	   select * from EMP;
	   select * from DEPT;
	   select * from SALGRADE;
	   select * from BONUS;

	7) 세션(session) 나오기 
	   exit;

	   
   (2) 오라클 접근법
	1) sqlplus 법 
	    실행창> sqlplus scott/tiger

	2) utility 법 
	    <1> sql developer ( by Oracle ) 공짜 
	    <2> toad 
	    <3> orange 
	        ... 


< scott계정 생성 >
sqlplus sys/java1234 as sysdba --관리자계정엑세스
show user --엑세스 유져 확인
create user scott identified by tiger; --scott/tiger 계정생성 
conn scott/tiger; --접근시도(에러발생)
conn sys/java1234 as sysdba; --관리자계정엑세스
grant connect, resource, unlimited tablespace to scott; --scott에게 권한부여
conn scott/tiger; --scott계정으로 엑세스 
show user --엑세스 유져 확인 

< 테이블명과 내용 확인 >
select tname from tab;
set linesize 120;
select * from dept;
select * from emp;

< 접근 방법 >
sqlplus scott/tiger
SQL Developer 

< Oracle 개요 >
1. DBMS의 개념
   (1) DB( DataBase )
	- 지속적으로 유지 관리해야 할 '데이터의 집합'
   (2) DBMS ( DataBase Management System ) 
	- DB를 효율적으로 관리(저장/검색/수정/삭제)환경을 제공해주는 '시스템 SW'

2.  DBMS 역사 
   (1) 1960 : File System
   (2) 1970 : Network-DBMS 
   (3) 1980 : 관계형-DBMS ( RDBMS )
   (4) 1990 : 관계형-DBMS, 객체관계형( ORDBMS )
   (5) 2000 : 관계형/객체관계형/객체지향  

       ex) oracle 6.X, 7.X -> 관계형 
           oracle 8.X, 11.X, 12c.X, ... -> 객체관계형 

3. 데이터베이스 설계
   실세계(업무분석) -> '개'념적 모델링 -> '논'리적 모델링 -> '물'리적 모델링 -> SQL작성
		(Entity/Attribute)  (논리ERD)    (물리ERD:DBMS결정)

4. SQL ( Structured Query Language )

5. 기본 계정 
   (1) SYS
       오라클 super 사용자 ID이며, 데이터베이스에서 발생하는 
        '모든 문제'를 처리할 수 있는 권한    

   (2) SYSTEM 
       SYS과 같은데, 차이는 데이터베이스를 생성할 수 있는 권한이 없음 

   (3) SCOTT 
       처음 오라클을 사용하는 user들을 위한 SAMPLE 계정이며, 
       일반적으로 프로젝트를 구현할 때 사용하는 권한( for Developer )을 가진 계정

6. 주요 용어 
   (1) TABLE 
       관계형 DBMS에서 기본 데이터 저장 구조로써 'Entity(실체)'의 
       저장소 ( ex: DEPT, EMP, SALGRADE, BONUS, ... ) 

   (2) ROW 
       테이블의 행 ( 하나의 유효한 데이터 ) 즉, Entity(실체)
       (ex : 10 ACCOUNTING     NEW YORK  )

   (3) COLUMN 명 
       테이블의 열명 ( Attibute 가 COLUMN이 됨 ) 
       (ex : DEPTNO,  DNAME, LOC )

   (4) FIELD 
       테이블에서 ROW와 COLUMN이 교차하는 데이터 

   (5) NULL
       데이터가 존재하지 않는 것 

   (6) PRIMARY-KEY
       테이블에서 각 ROW를 유일하게 구분하는 COLUMN 에 
       부여되는 '제약조건( Constraint )'

   (7) FOREIGN-KEY ( == 참조키, 외래키 )   
       부모테이블의 COLUMN값을 참조하는 테이블의 COLUMN에 
       부여되는 '제약조건( Constraint )' 

   (8) 무결성 : 데이터가 '논리적'으로 결함이 없는 성질

7. SQL(Structured Query Language)의 구분 
   (1) DQL( Data Query Language ): 조회/질의
	(ex: select ~ ) 
   (2) DML ( Data Manipulation Language ) : 조작 
	(ex: insert~, update~, delete~ ) 
   (3) TCL ( Transaction Control Language ) : 트랜젝션 
	(ex: commit, rollback, savepoint ) 
   (4) DDL ( Data Definition Language ) : 정의 
	(ex: create~, alter~, drop~, ... ) 
   (5) DCL ( Data Control Language ) : 권한 
	(ex: grant~, revoke~ ) 

8. PL-SQL
   '제어문(조건문, 반복문)'이 들어있는 SQL로써 오라클 DBMS에서 지원하는 '확장된 SQL' 
   (1) Stored Procedure
       -> 일련의 '작업처리순서를 정의'해 놓은 것으로 
         미리 DBMS에 컴파일되어져있어 프로그램 or 사용자로부터 
	 호출되면 실행되는 일종의 '작업처리순서' 
   (2) Anonymous Procedure 
       -> Stored Procedure 와의 차이점은 'DBMS에 자동으로 포함'되어 
         '내부적으로 호출'되는 프로시져 
   (3) Stored Function 
       -> 프로시져와 차이점은 'return값'이 존재해야 함  
   (4) Trigger 
       -> 어떤 조건에 만족되어지는 상황(DML)이 발생되면 
         자동으로 호출되어 작동되는 로직 
   (5) Package 
       -> 위의 것들을 기능별 묶어놓은 꾸러미