# < 지난 주 리뷰 >

# 개발환경
JDK
환경변수: JAVA_HOME/Path/classpath=.
Efiter: Editplus/Eclipse/IntellJ/VSCode
API

# 실행
- Java -> 컴파일(javac.exe) -> class
- public static void main(String[] args){}

# 주석
- //
- /*   */
- /** */

# 클래스
package
import
class A{
	int i;
	A(){}
	void m(){}
}

# 제어 ( 프로그램의 실행점)
- 부메랑

# OOP 키워드
- 클래스: '틀'
- 객체: '구현물' or '모든것'
- 생성자: 생성될 때 하는 '행위(일)'
- 메서드: 객체가 가지고 있는 기능 '행위(일)'
- 속성: '특성'

# 변수 ( Variable )
- 범위: 전역/지역
- 소유: 클래스(static)/객체
- 변경: 변수/상수(final)
- 메모리: 기본형(8개)/참조형

# 제어문
1) 조건문: if(){} / switch(){}
2) 반복문: while(){} / do{}while() / for( ; ; ){}

# 제어 예약어
- break
- continue
- return

# 연산자 ( Operator )
- '기호'

# 배열
A is[];  // 선언
is = new int[]; // 생성

is[0] = 10; // 초기화
is[1] = 20;

int us[] = enw int[2]; // 선언 + 생성
is[0] = 10; // 초기화

int is[] = {10, 20} // 선언 + 생성 + 초기화

int iss[][] = {is, {1,2,3}, {400,500}}





---

# 컬렉션 ( Data Structure / 가변배열 )
: 같은 타입의 '참조형'데이터 '저장소'로서 그 크기가 변할 수 있는 '객체'
1) 종류
	1) java.util.Collection
		|				                     |
		List			                     Set
		|                                    |
		Vector, ArrayList, ...	     TreeSet, ...
		
		
	2) java.util.Map
			|
		HashMap, Hashtable, ...
		
2) 특성
	1) List ( 배열 )
		- 순서를 보전
		- 중복을 허용
		  
		ex) day07/A.java
		
	2) Set ( 수학의 집합 )
		- 순서를 보전X
		- 중복을 허용X 
		- 정렬은 됨
		  
		ex) day07/A.java
		
	1) Map ( 수학에서 1:1 대응 )
		- key 와 value값 한 쌍으로 저장
		- 순서 보전 X
		- 정렬 되지 X
		- key는 중복X, value는 중복 허용
			만약 key값이 중복되면 나중 값으로 대체된다
		  
		ex) day07/C.java

- 확장
	- Generic ( ex) A2, B2, C2.java )
	- AutoBoxing ( ex) C3.java )
		- Boxing ( ex) C3.java )
		- UnBoxing (ex) Boxing.java )
	- Enhanced Loop
		( ex) A4, B4, C4.java )
3) N차원 컬렉션
	(N-1)차원 컬렉션을 데이터(Elemnet)로 갖는 컬렉션

