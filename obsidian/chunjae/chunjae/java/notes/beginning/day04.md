## 복습

# 변수(Variable)
1) 유효범위
	1) 멤버(전역)
		- 클래스
		- 객체
	1) 지역(로컬)
		- 파라미터(매개, 인수, 아규먼츠)
		- 선언 초기화
2) 소유
	1) 클래스(static == 정적)
	2) 객체(동적)
3) final 여부
	1) 변수(Variable)
	2) 상수(Constant) 
4) 메모리
	- 기본(primitive) : 8가지
	  byte(1) > short(2) > int(4) > long(8) > float(4) > double(8)
			 char(2) >
		boolean(1)
	- 참조(reference)

ex) final 사용 예
final static int NO_ID = 1;
final static int N)_PW = 2;
final static int YES_LOGIN =3;


**알파벳 A의 아스키 코드 ( 65 )**
# 제어문

1) 조건문
	1) if문
		1) if(boolean형){}
		2) if(boolean형){}else if{} ... else{}
		   
		   주의) if의 body( {} )가 없다면 첫번째 세미콜론( ; )까지가 body가 됨
		   
		   ex) day04/A.java
	2) switch문
		   switch(변수){ case:... default:...}
		   -> 정수형 + String, break, default
		   
		   ex) day04/A.java
2) 반복문
   초기식(밖), 조건식(안), 증감식(안) 을 갖추어야 '**유한루프**' 반복문이 됨
	   1) while(boolean형){}; // 신사
	   2) do{} while(boolean형); // 조폭
	   3) for(초기식;조건식;증감식){} // 신사
   
   ex) day04/B.java