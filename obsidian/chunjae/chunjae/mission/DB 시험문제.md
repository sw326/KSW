1. sqlplus 문법
	ex)
		@, start - 불러오기
		/, run - 직전에 했던 문장

2. DQL 순서 - SF (J)W GHO (SELECT → FROM → WHERE → GROUP BY → HAVING → ORDER BY)

3. DML ( insert, update, delete )

4. TCL ( commit, rollback, savepoint )

5. 함수( 초/밀리초 리턴) - SYSDATE, SYSTIMESTAMP, CURRENT_TIMESTAMP

6. 제약조건(Constraint) ( 5가지 )
	- PK(primary key)
	- FK(foreign key)
	- UK(unique key)
	- check
	- not null
	- ( default는 제약 조건이 아니다 ! ! ! )

7. Oracle 객체들 중에서 숫자 증감 기능을 가진 객체(2개의 함수를 가짐) 
	- sequence(nextval(), currval())
	
8. DDL (계정생성) create, alter, drop - '객체'를 생성, 변경, 삭제
   DCL (권한부여) grant, revoke, conn - 계정에 '권한' 부여 or 박탈

9. 모델링(개/논/물)의 단계별 특징
	1. 개념적 모델링 (Conceptual Modeling): 엔티티, 속성, 관계를 정의
	2. 논리적 모델링 (Logical Modeling): 데이터 타입, 제약조건, 관계의 세부사항을 포함 (DBMS에 독립적)
	3. 물리적 모델링 (Physical Modeling): 특정 DBMS에 맞춘 데이터 구조 DB의 물리적 저장 방식과 접근 방식을 결정

10. DB모델링 시 관계( 2가지 측면(관점)의 관계 ) 주관식
	- Cardinality 관점 (3가지)
		1. 1:1 - 한 사람은 하나의 여권만 가질 수 있습니다.
		2. 1:N - 한 고객은 여러 주문을 할 수 있습니다.
		3. N:N - 학생과 수업 간의 관계에서 한 학생이 여러 수업을 듣고, 한 수업에 여러 학생이 등록할 수 있습니다.
		   
	- Relationship Type 관점 (2가지)
		1. Identifying Relationship (식별 관계): FK가 PK ex) 프렌차이즈
		2. Non-Identifying Relationship (비식별 관계): FK가 일반 컬럼

11. 개념( DB / ? ) : 주관식
	: 지속적으로 유지 관리해야 할 '데이터의 집합'
	cf) BDMS : DB를 효율적으로 관리(저장/검색/수정/삭제)환경을 제공해주는 '시스템 SW'

12. ? : 주관식 ( ex 계좌이체 ) - transaction(?)
	트랜잭션(transaction):
	하나의 논리적 작업 단위
		- 원자성(Atomicity) : "모두 또는 아무것도"
		- 일관성(Consistency) : 트랜잭션이 시작되기 전과 후의 데이터베이스 상태가 일관성을 가져야 한다.
		- 고립성(Isolation) : 동시에 실행되는 트랜잭션은 서로에게 영향을 미치지 않아야 한다.
		- 지속성(Durability) : 트랜잭션이 성공적으로 완료되면 그 결과는 영구적으로 데이터베이스에 반영되어야 한다.

13. DDL(종류 N개)
	1. create
	2. alter
	3. drop
	4. rename
	5. comment
	6. truncate

14. (삭제 SQL) 2개의 차이점: 주관식 - delete / truncate ?
	1. DELETE
		- WHERE 사용 가능
		- 롤백이 가능, 트랜잭션 로그에 기록
		- 테이블의 구조는 유지
	2. TRUNCATE
		- WHERE 절을 사용 불가
		- 롤백불가, 로그에 최소한의 정보만 기록
		- 테이블의 구조는 유지되지만, 자동으로 IDENTITY 값을 초기화      
		- 속도가 빨라서 씀. (로그 데이터 등)

15. 오라클의 테이터 타입(2분류(카테고리))
	- 스칼라(Scalar)
		정의: 스칼라 데이터 타입은 단일 값을 저장하는 데이터 타입입니다. 각 스칼라 타입은 하나의 데이터 항목을 나타냅니다.
		예시:
		NUMBER: 숫자 값을 저장합니다.
		VARCHAR2: 가변 길이의 문자열을 저장합니다.
		CHAR: 고정 길이의 문자열을 저장합니다.
		DATE: 날짜와 시간을 저장합니다.
		TIMESTAMP: 날짜와 시간을 밀리초 단위로 저장합니다.
	- 모음(Collection)
		정의: 모음 데이터 타입은 여러 값을 저장할 수 있는 데이터 타입입니다. 배열과 유사한 구조로, 여러 개의 값을 하나의 변수에 저장할 수 있습니다.
		예시:
		VARRAY: 가변 길이의 배열로, 최대 크기를 지정할 수 있습니다.
		NESTED TABLE: 크기가 동적으로 변할 수 있는 테이블로, 다른 테이블의 행을 포함할 수 있습니다.
		INDEX BY TABLE: 인덱스를 사용하여 키-값 쌍을 저장하는 구조입니다.

16. 제약조건의 설명으로 맞는 것을 고르시오 ( 5가지 ) 특징 알기
    - PK(primary key) - PK는 not null 포함, 하나만 존재 가능
	- FK(foreign key) - 부모 테이블의 'PK 또는 U' 컬럼만, 여러개 가능 
	- UK(unique key) - 중복데이터를 허용하지 않는 컬럼, null 입력 가능, 여러개 가능 
	- check - 조건에 맞는 데이터만 입력되도록
	- not null - null이 입력되어서는 안되는 컬럼, '컬럼레벨'에서만 부여 가능
	- default는 제약조건이 아님

17. 제약조건 부여 방법 ( 테이블레벨, 컬럼레벨 등) 중 특이한 녀석이 하나 있음
    - 컬럼 레벨
	- 테이블 레벨
	- 생성 후 alter로 부여

18. 뷰(View)에 대해서
	정의
	뷰(View)는 데이터베이스에서 하나 이상의 테이블의 데이터를 가상적으로 표현하는 객체입니다. 뷰는 실제 데이터를 저장하지 않고, 기본 테이블의 데이터를 기반으로 쿼리를 실행하여 결과를 반환합니다. 뷰는 데이터베이스 사용자에게 특정 데이터에 대한 접근을 단순화하고, 보안을 강화하는 데 유용합니다.
	1. 가상 테이블
	2. 데이터 접근 제어
	3. 복잡한 쿼리 단순화

19. DB모델링(개/논/물)의 단계별 특징
	1. 개념적 모델링 (Conceptual Modeling): 엔티티, 속성, 관계를 정의
	2. 논리적 모델링 (Logical Modeling): 데이터 타입, 제약조건, 관계의 세부사항을 포함 (DBMS에 독립적)
	3. 물리적 모델링 (Physical Modeling): 특정 DBMS에 맞춘 데이터 구조 DB의 물리적 저장 방식과 접근 방식을 결정

20. PL-SQL
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