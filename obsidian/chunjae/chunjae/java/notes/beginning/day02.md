**2024-12-02**
# HW ( OS + JVM + App1, App2,.. )
	(1) CPU, GPU: 두뇌 
	(2) RAM(메모리): 책상 
	(3) HDD/SSD: 책꽂이
	(4) MainBoard: 방 
	(5) Card: Sound, Video, Lan, WLLan, .. 
	(6) 주변기기: 키보드, 마우스, 모니터, 프린터, 스피커, .. 

# 개발환경설정  
	(1) JDK(Java Development Kit) 다운/설치
	(2) 환경변수 
		- JAVA_HOME -> D:\SOO\Java\jdk-17.0.12
		- Path -> D:\SOO\Java\jdk-17.0.12\bin
		- classpath -> .
	(3) Editer
		- Editplus
		- Eclipse
		- IntelliJ
		- VSCode 
	(4) API(Application Programming Interface)
		- jdk-17.0.13_doc-all.zip 압축해제 후 즐겨찾기

#실행 
	(1) 작성(.java) -> 컴파일러(javac.exe) -> 클래스파일(.class)
		> javac Hello.java //컴파일
		> java Hello //실행

	(2) .java( for Human) -> .class( for JVM )

	    cf) JVM(Java Virtual Machine)

#실행되는 클래스(인입점)
	public static void main(String[] args){}
	'가 있으면 그 클래스는 실행이되는 클래스가 됨'

#주석( Comment )
	(1) 1라인 //
	(2) N라인 
		/*
		   1라인
		   2라인
		   .. 
		*/
	(3) 문서화 
		/**
		   1라인
		   2라인
		   .. 
		*/

#클래스구조 
	package aa.bb; //(1)
	import java.lang.*; //(2) 
	class A //(3)
	{
		String name = "홍길동"; //(4)멤버
		A(){ //(5) 생성자 
			System.out.println("A()");
		}
		void m(){ //(6) 메소드 
			System.out.println("m()");
		}
	}
	
# 패키지 컴파일 
	> javac -d . A.java //패키지 컴파일
	> java aa.bb.A //패키지 실행
	

# 제어
	 어떤 프로그램이 실행되고 있을 떄..
	 어느 한 지점의 연산(CPU/GPU)은 어떤 특정 코드 부분을 실행하고 있을 것이다
	 그 코드 부분을 '제어점'이라고 하고, 그 점들의 집합을 '제어'라 한다
	 즉, 프로그램의 '실행 흐름 라인(line)'
	JVM -> main() -> ... -> main() -> JVM

	#비유) 부메랑
	ex) day02/B.java


*아는 건데 대답을 못했어요



# 객체지향(OOP: Object-Oriented Programming) 키워드 5가지
	(1) 클래스(Class): 객체를 만드는 틀 
		ex) 붕어빵 틀
	(2) 객체(Object): 클래스를 통해 나온 '구현물' or '모든 것' 
		ex) 붕어빵
	(3) 생성자(Constructor): 객체가 생성될 때 하는 '행위(일)'
		ex) 붕어빵(String 앙꼬) {}
	(4) 메소드(Method): 객체가 할 수 있는 '행위(일)'
		ex) 배부르게하다() {}
	(5) 속성(Attribute==Property==Member==Field): 객체의 '특성'
		ex) 앙꼬, 가격, 


# 클래스 설계
	
```
	/*
	(붕어빵 예제를 참고하여..)
	일상의 어떤 상황 또는 스토리를 상상해서..
	클래스를 설계하고, 객체 생성해서 표현(메소드/속성)해 보고
	생성된 자바 소스를 제출해 주세요
	*/
```
	ex) day02/붕어빵.java, 주인.java, 신.java










참한 희진이가 공부한다
String 성격 = 참한;
void 공부한다(){}

희진.성격; // (속성, 형용사)
희진.공부한다(); // (동작, 동사)



