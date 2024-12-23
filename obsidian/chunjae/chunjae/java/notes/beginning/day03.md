**2024-12-03**

# 복습
```java
// 자바: '클래스'를 짠다는 얘기

// 자바의 6가지 구조
package aa.bb; // 1) 패키지
import java.lang.*; // 2) 임포트

class A { // 3) 클래스 선언
	int i; // 4) 맴버
	A(){ // 5) 생성자
	}
	void m(){ // 6) 메서드
	}
	public static void main(String args[]){
	}
}
```

- 패키지 디렉토리 생성 명령어
```
javac -d . A.java
```

## OOP(Object Oriented Programming) 5가지
- Class: 객체를 만들기 위한 '틀'
- Object: 클래스를 통해서 나온 '구현물' or '모든 것(지칭할 수 있는 모든 것)' 
- Constructor: 객체가 생성될 때 하는 '일(행위, 동사)'
- Method: 객체가 할 수 있는 '일(행위)'
- Member/Field/Property: 객체의 '특성' -> 다양한 객체를 만들고 표현할 수 있다





# 변수 ( Variable )

- 변수의 종류
	맴버, 지역, 전역, 매개, static, 참조, 상수, 배열, 인스턴스, 클래스, 기본형, 동적, 정적, 파라미터, 인수, 아규먼츠, 등등


## 변수
	(1) 유효범위
		1) 전역(맴버)
			1) 클래스(==static==정적)
			2) 객체(==인스턴스==동적)
		2) 지역(로컬)
			1) 파라미터(==매개==인수==아규먼츠)
			2) 선언초기화
		ex) day03/A.java
		
	(2) 소유
		1) 클래스 (==static==정적)
		2) 객체 (==instance==동적)
		
	(3) 변경가능유무
		1) 변수( Variable )
		2) 상수( Constant )

		ex) day03/B.java
	(4) 메모리
		1) 기본(==primitive==원시): 8가지
			1) call by value
			2) 형태: 소문자
			3) 종류: 8가지
				1) byte > short > int > long > float > double
				 char
				 boolean
			 4) 담을 수 있는 값의 범위
				 1) byte(1): -2^7 ~ 2^7-1 (경우의 수 2^8)
				 2) short(2): -2^15 ~ 2^15-1 (경우의 수 2^16)
				 3) char(2): 0 ~ 2^16-1 (경우의 수 2^16)
				 4) int(4): -2^31 ~ 2^31-1 (경우의 수 2^32)
				 5) long(8): -2^63 ~ 2^63-1 (경우의 수 2^64)
				 6) float(4): 무한대 (경우의 수 2^32)
				 7) double(8): 무한대 (경우의 수 2^64)
				 8) boolean(1): false / true
			 5) 형변환 ( Type casting )
				 1) 자동 형변환(암시적/Implicit) JVM
				 2) 강제 형변환(명시적/Explicit) 개발자
			 6) 예외 형변환
			    정수형(byte, short, char, int) 끼리 연산 결과는 int
			    
			    ex) day03/E.java
			 7) 디폴트 초기값 by JVM
				 정수(0, 0L), 실수(0.0f, 0.0), 불리언(false)
				 
				 ex)day03/F.java
			 8) 존재 이유
			    실행의 효율성
			    
			    cf) Wrapper class(기본형을 쌓아서 참조형으로 만드는 클래스)
			    Byte, Short, Character, Integer, Long, Float, Double, Boolean
				
		2) 참조(==reference): 8가지를 제외한 모든 것, 무한대
			1) call by reference
			2) 형태: (관례상) 첫문자를 대문자로 시작
			3) 티폴트 초기값: null
			4) 형변환 // 나중에(상속 배우고 나서)
