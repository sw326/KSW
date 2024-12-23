## < 복습 >

# 제어문
1. 조건문
	- if(boolean형){}
	- switch(정수형 + String){}
2. 반복문
	- while(boolean형){}
	- do{} while(boolean형);
	- for(초기식;조건식;증감식){}

# 예약어
1. break
	- loop, switch
	- ( 첫번째 블럭을 )**'나간다'**
	- labled break;
1. continue
	- loop
	- 조건이 맞으면 **'건너뛴다'**
	- labled continue
1. return
	- 생성자 || 메소드 어디서나 나올 수 있다
	- 자기(생성자나 메소드)를 호출한 **곳** || JVM으로 **'되돌아간다'**
	- 메소드의 return type이 void 가 아니면 생략 불가

# 연산자 ( Operator )
1. ( 데이터 ) 연산하게 하는 **'기호'**
2. 종류
	1) 산술 ex) +, -, *, /, %
	2) 증감 ex) ++, --
	3) 대입 ex) =
	4) 산술대입 ex) +=, -=, *=, /=, %=
	5) 비트 ex) &, |, ~, 시프트( <<, >>, <<< )
	6) 비교 ex) `==`, !=, <, >, <=, >=
	7) 논리 ex) &, &&, |, ||
	8) 논리대입 ex) &=, |=
	9) 조건 ex) A? b : C
	10) instanceof ex) 객체 instanceof 클래스






# 배열 ( Array )
	 같은 타입의 데이터 **'저장소'**로서, 생성될 때 그 크기가 고정되는 **'객체'**

1) 선언
	type 배열변수[]
	(예 : int is[], String strs[], ...)
	
2) 생성
	배열변수 = new type[크기];
	( 예 : is = new int[2], strs = new String[0], ...)
	
3) 초기화
	배열변수[인덱스] = 데이터;
	( 예 : is[0] = 10, strs[0] = "spring", ...)
	
4) 선언 및 생성
	type 배열 변수[] = new type[크기];
	( 예 : int is[] = new int[2];, String strs[] = new String[4];, ...)
	
5) 선언 생성 및 초기화
	type 배열변수[] = {데이터1, 데이터2, ... };
	( 예 : int is[] = {10, 20};, String strs[] = {"Spring", "Summer"};, ... )
	
	 참고) 배열 크기 속성 : length
	 주의) **'선언'** 과 **생성&초기화**를 따로 분리 할 수 없다
	 
	 ex) day06/A.java
	 
6) 배열방의 default 초기값( by JVM )
	- 불리언 (false), 정수(0, 0L), 실수(0.0f, 0.0)
	- null
	  
7) 형변환
	자동형변환이 가능한 데이터라면 변환돼서 저장됨
	( 예 : int is[] = {b, s, c, i, (int)lo, (int)f, (int)d}; )
	ex) day06/B.java
	
8) 2차원 배열 
	1차원 배열을 데이터(element)로 갖는 배열
	
	ex) day06/D.java
9) N차원 배열
	(N-1)차원 배열을 데이터(element)로 갖는 배열
	
	ex) day06/E.java



