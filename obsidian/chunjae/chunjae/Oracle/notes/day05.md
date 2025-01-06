# TCL ( Transactio Control Language )
-- commit, rollback

1) 설명
   DML(insert, update, delete)실행결과가 DBMS에 '영구저장'되거나, '되돌리기'위한 SQL
   
2) 트랜젝션(Transaction)
	1) 정의
	   분리되어서는 안될 (논리적인) '작업단위'
	   
	2) 시작
	   1. DBMS에 접속했을때
	   2. (하나 또는 여러개의 DBL문을 실행한 이후) commit 또는 rollback 한 직후
	   3. DDL이나 DCL이 실행된 직후
	      
	3) 끝
	   1. commit 또는 rollback 한 직후
	   2. DDL이나 DCL이 실행된 직후
	   3. 세션 종료
	        1. 비정상 종료: rollback 됨
	         - 종료 버튼 클릭
	         - 시스템(OS or Oracle)에서 종료
	         - 재부팅
	           
	      2. 정상 종료: commit 됨
	         - exit; 또는 quit;
	           
	   4. 해당 세션에서 계정 변경 ?
	      ex)  conn system/java1234; -- 자동 commit; 된 후 변경됨
	      
	   5. DB를 닫은 후
	      세션 1) 
		    - sqlplus scott/tiger
		    -  insert into dept3 values(50, 'sw', '경기');
		      
	      세선 2) 
		    - conn system/java1234 as sysdba;
		    - shutdown immediate -- DBMS 종료
		    - startup -- DBMS 시작
		      
	      세션 3)
		    - sqlplus scott/tiger
		    - select * from dept3;
	    
3) TCL의 종류
	1) commit
		DML문을 영구적으로 저장하는 SQL
		
	2) rollback
		DML문을 되돌리는 SQL
		
	3) savepoint
	   세션1> 
		   SQL> insert into DEPT2 values(91, 'a1', 'b1'); 
		   SQL> insert into DEPT2 values(92, 'a2', 'b2'); 
		   SQL> savepoint a; 
		   SQL> insert into DEPT2 values(93, 'a3', 'b3'); 
		   SQL> savepoint b; 
		   SQL> insert into DEPT2 values(94, 'a4', 'b4'); 
		   SQL> rollback to a; SQL> commit; 
	   세션2> 
		   SQL> select * from DEPT2; -- 세션1> rollback to a; 후 
		   SQL> select * from DEPT2; -- 세션1> commit; 후
		   
4) DB Deadlock
   일반적으로 DeadLock(교착상태)을 설명하자면, 둘 이상의 프로세스가 다른 프로세스가 점유하고 있는 
   자원을 서로 기다릴 때 '무한 대기'에 빠지는 상황을 말한다 
   DB에서의 데드락은 두 트랜잭션이 각각 Lock을 정하고 다음 서로의 Lock에 접근하여 값을 얻어오려고 
   할 때 이미 각각의 트랜잭션에 의해 Lock이 설정되어 있기 때문에 양쪽 트랜잭션 모두 영원히 처리가 되지않게 
   되는 상태를 말한다
   즉, DB Deadlock은 상대방이 소유하고 있는 Lock을 요청해서 작업의 처리를 진행하지 못하는 상태다

   예를 들어 수강신청 시스템에서 1명만이 정원으로 남게되었는데, 2사람이 거의 동시에 버튼을 누른 경우, 
   성공은 1명만 되야한다. 
   즉, 동시성 제어으로 인해 트랜잭션 명령들 간의 끼어들기가 가능한 상황에서 서로 간섭 없이 독립적으로 
   수행되어 하기 때문에, DBMS(DataBase Management System)가 사용하는 공통적인 방법이 Lock인 것이다.
   잠금(Locking)은 트랜잭션의 실행 순서를 강제로 제어하여 직렬 가능한 스케줄이 되도록 보장한다. 
   하지만 lock과 unlock을 잘못 사용하면 데드락 상태에 빠질 수 있는 것이다.
5) Lock
	1) Read Consistensy ( 읽기 일관성 ) : 해당 'row' - Row-level Lock
	   
	   ex) 
	   세선1 ) update DEPT3 set DNAME='가' where deptno=61; --첫번째 트랜젝션에 의해 Lock이 걸림
	   세선2 ) update DEPT3 set DNAME='나' where deptno=61; --두번째 트랜잰션은 데이터를 핸들링할 수 없음
	   세선1 ) commit 또는 rollback -- 트랜젝션의 마무리에 의해 Lock이 해제
	   세선2 ) 1 행이 업데이트되었습니다
	   
	2) Table-level Lock
	   어떤 사용자(세션)가 변경중(트랜젝션진행중)인 '전체행'을 다른 사용자(세션)가 변경할 수 없게하는 현상
      
      ex) 
      세션1> delete from DEPT2;
      세션2> update DEPT2 set DNAME='다' where DEPTNO=91;

      결론) Lock 해제 방법: '진행중인 Transaction을 종료'해야 함 

      -- 복사된 emp2, dept2, emp3, dept3를 이용해서 TCL을 연습추천! 


# < DDL( Data Definition Language ) > 

(1) 설명 
    DBMS내의 객체(Object)를 '생성', '변경', '삭제' 등을 하기 위한 SQL   

(2) 객체(Object)
    1) table 
    2) index
    3) view 
    4) sequence 
    5) synonym 
    6) session 
    7) user
    8) procedure 
    9) trigger 
        .... 

(3) 종류
    1) create 
       생성> create table DDLTEST(
                NO number(4) constraint DDLTEST_PK primary key,
                ID varchar2(12), 
		PWD varchar2(12)
            );
       제약조건확인> select CONSTRAINT_NAME, CONSTRAINT_TYPE 
       from user_constraints where TABLE_NAME='DDLTEST';
       입력> insert into DDLTEST values(1000, 'a1', 'b1');
            insert into DDLTEST values(2000, 'a2', 'b2');
            insert into DDLTEST values(3000, 'a3', 'b3');
       복사1> create table DDLTEST2(
	     NO NUMBER(4) constraint DDLTEST2_PK primary key,
	     ID VARCHAR2(12),
	     PWD VARCHAR2(12)
	     ); 
	     insert into DDLTEST2 select * from DDLTEST;
	     commit;
	     select * from DDLTEST2;
       복사2> create table DDLTEST3 as select * from DDLTEST;
             alter table DDLTEST3 add constraint DDLTEST3_PK primary key(NO);

    2) alter 
       ( 옵션: add, modify, rename column, drop column, add constraint, 
              drop constraint, rename constraint, disable constraint, enable constraint )

       <1> add
           alter table DDLTEST2 add(ADDR varchar2(20) unique);
	   desc DDLTEST2
	   insert into DDLTEST2 values(4000, 'a4', 'b4', 'seoul');
	   select * from DDLTEST2;

       <2> modify
           alter table DDLTEST2 modify(ID varchar2(15), PWD varchar2(15));
	   desc DDLTEST2

       <3> rename column  
           alter table DDLTEST2 rename column PWD to PASS;
	   desc DDLTEST2

       <4> drop constraint
           alter table DDLTEST2 drop constraint DDLTEST2_PK;
	   desc DDLTEST2
	   select CONSTRAINT_NAME, CONSTRAINT_TYPE 
	        from user_constraints where TABLE_NAME='DDLTEST2';--PK삭제 확인됨
    	  
    3) drop 
          drop table DDLTEST2;
	  select tname from tab;
	  drop table DDLTEST3; -- DDLTEST3 삭제 
	  flashback table DDLTEST3 to before drop;
	  select tname from tab; -- 다시 DDLTEST3 보임

	  --purge recyclebin; --휴지통비우기

    4) rename
         rename DDLTEST3 to DDLTEST33; 
	 select tname from tab; --DDLTEST33 로 변경확인됨

    5) comment 
       <1> 테이블 
           comment on table DDLTEST is '수쌤이 만든 DDL테스트용 테이블';
	   select TABLE_NAME, COMMENTS from user_tab_comments 
	   where TABLE_NAME='DDLTEST';

       <2> 컬럼 
           comment on column DDLTEST.NO is 'DDL테스트의 primary key 컬럼';
	   select TABLE_NAME, COLUMN_NAME, COMMENTS from user_col_comments 
	   where TABLE_NAME='DDLTEST';

    6) truncate 
        select * from DDLTEST33;
        truncate table DDLTEST33;
        select * from DDLTEST33;

	질문) delete 문의 차이점 
	 - 되돌릴 수 없음( rollback 불가! )
	 - where 절 불가! 
	 - when ? '조사해 볼것' 


# DCL ( Data Control Language )

1) 설명
	계정에 권한을 '부여'하거나 '빠앗'을 때 사용하는 SQL
	
2) 계정 생성
	1) 실행창
		- 방법 1 : sqlplus system/java1234 as sysdba 또는 sqlplus sys/java1234 as sysdba
		- 방법 2 : sqlplus /as sysdba
		  
	2) 생성
		create user TEST2 identified by  JAVA1; -- 1user : 1 project
		
	3) 접근 시도
		conn TEST1/JAVA1;
		
3) 권한 부여
	grant CONNECT, RESOURCE, CREATE VIEW, UNLIMITEDTABLESPACE to TEST1;
	conn TEST1JAVA1;
	show user
	select tname from tab; -- 테이블은 현재 없음
	
4) 권한 제거 
	revoke RESOURCE from TEST1;
	revoke CONNECT from TEST1;
	conn TEST1/JAVA1; -- 불가
	
5) 비번변경
	1) 접속
		conn system/java1234 as sysdba;
		
	2) 수정
		alter user TEST1 identified by JAVAC1;
		conn TEST1/JAVAC1
6) 계정삭제
	1) 해당 user에 테이블이 없는 경우
		conn system/java1234 as sysdba;
		drop user TEST1; -- 삭제 성공
		
	2) 해당 user에 테이블이 있는 경우
		conn system/java1234 as sysdba; --관리자
        create user TEST1 identified by JAVA1;
        grant CONNECT, RESOURCE to TEST1;
        conn TEST1/JAVA1 --일반사용자
        create table T1(NO number); --테이블생성
        conn system/java1234 as sysdba; --관리자
        drop user TEST1; --불가!
        drop user TEST1 CASCADE; --가능!




# <  SQL외.. > 

1. Data Dictionary  
    (1) 설명 
       Oracle 테이블은 2가지 종류가 있다 
       첫번째, DB가 생성될 때 기본적으로 만들어지는 '자료사전테이블'
       두번째, User가 데이터를 저장하고 관리하기 위한 '사용자정의테이블'
       전자가 Data Dictionary 이다  

    (2) 종류 
       1) DBA_XXX : DB전체의 관련정보를 저장한 테이블 
       2) ALL_XXX : 자신이 볼 수 있는 Object 정보 테이블 
       3) USER_XXX : 자신이 생성한 Object 정보 테이블 
       4) X$_XXX : DB의 성능 분석/통계 정보 테이블 ( 'DB튜닝'시 수정함 )
       5) V$_XXX : X$_XXX의 VIEW ( 성능 참조 ) 

       <예1>
          SQL> select * from dictionary;
	  SQL> select * from dict_columns;
	       cf) Ctl + C : 명령실행 정지

       <예2> user_ ( ***** )
          SQL> desc user_tables 
	  SQL> select * from user_tables;
          SQL> select TABLE_NAME from user_tables;
	  SQL> select tname from tab;

          SQL> desc user_indexes
	  SQL> select INDEX_NAME, INDEX_TYPE, TABLE_NAME from user_indexes;
	  SQL> select INDEX_NAME, INDEX_TYPE, TABLE_NAME from user_indexes 
	       where TABLE_NAME='EMP';

	  SQL> desc user_constraints 
	  SQL> select TABLE_NAME, CONSTRAINT_NAME, CONSTRAINT_TYPE from user_constraints;
	  SQL> select TABLE_NAME, CONSTRAINT_NAME, CONSTRAINT_TYPE from user_constraints
	       where TABLE_NAME='EMP';

	  SQL> desc user_views
	  SQL> select VIEW_NAME, TEXT from user_views;

	  cf) view 생성예 
	      SQL> create or replace view VIEW1 as 
	        select DEPTNO "부서번호", round(avg(SAL)) "평균급여" from EMP 
		where SAL<(select round(avg(SAL)) from EMP where DEPTNO=10) 
		group by DEPTNO 
		having DEPTNO!=10 
		order by DEPTNO desc;

              SQL> select VIEW_NAME, TEXT from user_views;
	      SQL> select * from VIEW1;

      <예3> all_
         SQL> desc all_tables
         SQL> select * from all_tables;
	 SQL> select OWNER, TABLE_NAME from all_tables where TABLE_NAME='DUAL';
  
      <예4> dba_
         SQL> select * from dba_tables;  -- 이런 테이블 없음 
	 SQL> conn system/java1234
	 SQL> select * from dba_tables; -- 많은 테이블 


2. Data Type 
   (1) 설명 
      Oracle에서 제공하는 데이터 타입
   
   (2) 종류 
      1) 스칼라(Scalar) 타입 
          cf) Scalar : 실수로 표시할 수 있는 '수량' 

	  <1> '하나의 데이터 타입컬럼'에 오직, '하나의 데이터'만 저장할 수 있는 타입 
          <2> '문자/숫자/날짜' 데이터를 저장 
	      1> number ( -38 ~ +38 자리수 )
	      2> binary_integer ( -2^31 ~ 2^31-1 )
	      3> char(0~255), nchar 
	       - char(10) -> 나머지 공간을 space 로 채움 
	       - nchar(10) -> 다양한 언어의 문자값을 저장 
              4> varchar, varchar2(4000), nvarchar2(4000)
	       - varchar2(10) -> 필요한 공간만 채움 
	       - nvarchar2(10) -> 다양한 언어의 문자값을 저장 
              5> blob, long row, clob, long 
	       - blob -> 바이어리 데이터를 4G
	       - long row -> 바이어리 데이터를 2G
	       - clob -> 문자 데이터를 4G
	       - long -> 문자 데이터를 2G
	      6> date ( 초단위 데이터 저장 )
	      7> timestamp ( 마이크로초 저장 )
	       - timestamp with time zone
	       - timestamp with local zone 
	       - interval year to month 

	       cf1) java.sql.Timestamp 를 이용 
	       cf2) '1/10^6'초까지 저장은 가능하나 
	            자바에서 생성할 수 있는 유효한 시간은 
		    '1/10^3'초이므로 실제저장시간은 '1/1000'초 임 
              8> boolean ( true / false 저장 ) 


      2) 모음(Collection) 타임
          <1> '하나의 데이터 타입컬럼'에 오직, '여러개의 데이터(배열/테이블)'만 저장할 수 있는 타입
	  <2> 배열/테이블 데이터를 저장 
	  <3> 종류 
	     1> varray 
	     2> nested table
 
  (3) 시간 관련 함수 
      1) current_date ( sysdate )
	 
	 cf1) 시간포멧수정 
	    SQL> alter session set NLS_DATE_FORMAT='YYYY-MM-DD AM HH:MI:SS DAY';
	    SQL> alter session set NLS_LANGUAGE='ENGLISH';

	 cf2) NLS( National Language Support ) 

      2) current_timestamp ( ***** )
         SQL> select current_timestamp from dual;
	 SQL> alter session set TIME_ZONE='-08:00';
	 SQL> select current_timestamp from dual;
	 SQL> alter session set TIME_ZONE='00:00';
	 SQL> select current_timestamp from dual;

      3) localtimestamp  
         SQL> select current_timestamp, localtimestamp from dual;

	 cf) TST 테이블 
	 SQL> create table TST(
	       NO number primary key, 
	       RDATE date, 
	       TS timestamp);
	 SQL> insert into TST values(10, sysdate, current_timestamp);
	 SQL> insert into TST values(20, sysdate, current_timestamp);
	 SQL> insert into TST values(30, sysdate, current_timestamp);
	 SQL> select * from TST;

  (4) ROWID 와 ROWNUM 컬럼 ( ***** )
      1) 설명 
         oracle 에서 테이블을 생성하면 기본적으로 제공되는 컬럼 
  
      2) 종류
         1) ROWID
	     -> ROW의 고유 ID ( 중간 row를 수정해도 불변 )

	 2) ROWNUM
	     -> 행의 index ( 중간 row를 수정하면 변함 )

	    SQL> select NO, ROWID, ROWNUM from TST;
	    SQL> select count(*) from TST;
	    SQL> select max(ROWNUM) from TST;


3. 일련번호 ( Sequence *** ) 
    (1) 설명 
       연속적인 숫자값을 자동으로 증감해주는 객체(Object)
       즉, 시퀀스는 생성한 후, 호출만하면 연속적으로 번호를 
       증가 or 감소시켜 제공해 줌

    (2) 문법 
       create sequence 시퀀스명 
        [ increment by N ]
		[ start with N ]
		[ maxvalue N | nomaxvalue ]
		[ minvalue N | nominvalue ]
		[ cycle | nocycle ]
		[ cache | nocache ]

    (3) 생성 
        create sequence DEPT2_SEQ increment by 1 start with 1 nocache;

        -- 생성 확인 --
	desc user_sequences --딕셔너리 
	select SEQUENCE_NAME, INCREMENT_BY, MIN_VALUE, MAX_VALUE from user_sequences;
	desc seq --뷰
	select SEQUENCE_NAME, INCREMENT_BY, MIN_VALUE, MAX_VALUE from seq;

    (4) 사용
        1) nextval 
           select DEPT2_SEQ.nextval from DUAL;

	2) currval 
	   select DEPT2_SEQ.currval from DUAL;

    (5) 삭제 
        drop sequence DEPT2_SEQ;
	select * from seq;

    (6) 응용 
	create table ST(seq number primary key, name varchar2(10));
	create sequence ST_SEQ increment by 1 start with 1 nocache;
	insert into ST values(ST_SEQ.nextval, '홍길동');
	insert into ST values(ST_SEQ.nextval, '이순신');
	insert into ST values(ST_SEQ.nextval, '강감찬');
	select * from ST;


4. 제약조건 ( Constraint ***** ) 
    (1) 설명 
       테이블 컬럼에 '원치않는 데이터가 입력/변경/삭제되는 것을 방지'
	하기위해 테이블 생성(create) or 변경(alter)시 설정하는 조건 

	cf) 제약조건명( constraint 변수명 )을 개발자가 직접 부여하면
	  추후 해당 constraint 관리 용이 

    (2) 종류 
        1) primary key ( 기본키 == 식별키 == 주키 )
	   하나의 ROW 데이터를 특정하는 키 

	   - 하나의 테이블에 오직 '하나'만 존재 가능( 0 or 1 ) 
	   - 제약조건 이름과 같은 이름의 인덱스 객체가 자동으로 생성되어 부여됨 

	2) foreign key ( 참조키 == 외래키 )
	   부모 테이블의 'PK 또는 U' 제약조건이 걸려있는 컬럼만 참조 가능 

	   - 여러개 가능 

	3) unique key ( 유일키 ) 
	   PK가 아니더라도 컬럼의 모든 값이 '유일'해야 하는 경우에 사용되는 키 
	    ( 즉, 중복데이터를 허용하지 않는 컬럼에 부여 )

	    cf) PK와 차이점
	    - null 입력 가능 
	    - 하나의 테이블에 '여러개' 가능 

        4) check
	   조건에 맞는 데이터만 입력되도록 부여한 제약조건 
	   
	   cf) 조건 ? 
	      - 데이터의 범위
	      - 특정 패턴 숫자 
	      - 문자값 설정 
	      .. 

	5) not null
            null이 입력되어서는 안되는 컬럼에 부여하는 제약조건  
	    ( '컬럼레벨'에서만 부여 가능 )

         cf) Tip 
	     - PK는 not null 포함 
	     - default 는 제약조건이 아님
	     - not null 조건도 constraint_type이 'C'로 표시 

    (3) 특징 
        1) 제약조건 수정하려면, 삭제하고 다시 만들어야 함
	2) disable constraint, enable constraint 는 왠만하면 사용 안하는 걸 추천! 

    (4) 제약 조건 부여 
	1) column level
	   <1> 이름을 부여 X
	      ex) ct1.sql
	      
	   <2> 이름을 부여 O
	      ex) ct2.sql

	2) table level
	   <1> 테이블 생성
	      1> 이름을 부여 X
                  ex) ct3.sql

	      2> 이름을 부여 O  
	          ex) ct4.sql

	   <2> 테이블 변경
	      ex) ct5.sql