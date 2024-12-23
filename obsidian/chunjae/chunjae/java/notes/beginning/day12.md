# < 복습 > 
1) 오버라이딩
	1) 
2) 오버로딩 : 이름이 같은 생성자나 메소드를 여러개 정의 하는 것

3) 인터페이스: '상수', '추상 메소드', 'default 메소드', 'static 메소드' 구성
	implements를 통해 완벽한 자식을 만든다.
	다중상속 가능
	extends Object는 생략 돼 있음 ( 기본적으로 11개의 메소드가 있다 )
	'껍데기', '통로', '메뉴판'


# < 내부 클래스 ( inner class ) >
- 클래스 안의 클래스

1) 모양
	class A{
		class AInner{
		}
	}
2) 객체 생성하는 방법
	1) 외클.내클 변수 = new 외클().new 내클();
	2) 외클.내클 변수 = new 외클.내클();    ( <- static )
	   
	   ex) day12/A.java
	   
3) main() 위치
	1) 제2 클래스 || Outer 클래스에 있을 때
	   Outer class 실행 > java A
	   제3 class 실행 > java AUser
	2) Inner 클래스에 있을 경우
	   Inner class 실행 > java A$AInner1 // none static
	   Inner class 실행 > java A$AInner2 // static
	   
	   ex) day12/B.java
	   
4) 확장
	1) Depth는 무한대
	2) class 안에 '내부 interface', 'static 내부 interface' 가능
	   ex) day12/B.java
	3) interface 안에 '내부 interface', 'static 내부 interface' 가능
	   ex) day12/C.java
	   
	   cf) 
	   - class 구현클래스 implements 외클 || 외인.내인 {}
	   - 외클 || 외인.내인 변수 = new 구현클래스();
	
5) Why? 내부클래스는 왜 쓰는 걸까?
	   **외부클래스의 자원을 '자신의 것처럼 사용하고 싶을 때'**
	   GUI event 처리할 때? 자주 사용
	
	ex) day12/D.java


6) 참고 : 다양한 interface의 개념
	- HW와 OS간의 interface : HW '접근통로' ( ex) printer, keyboard 드라이버 )
	- Rest API ( Application Programming Interface ): URL을 통한 데이터 '접근통로'
	- Lib API Specification : 클래스라이브러리 '접근통로'
	- GUI ( Graphic User Interface ) : SW로직 '접근통로'
	- clss / interface : 구현객체 '접근통로'


## < @ 어노테이션 >  // 설명자
1) 모양: @
2) JDK 6 이상 지원
3) 기능
	1) 클래스나 생성자, 메소드에 붙어서 '정체성'을 부여
	2) 기능을 확장하는 '표식'
	3) xml을 대신하여 '설명'하는 역할
	   
	   ex) day12/E.java


# < 쓰레드 ( Thread ) >
1) 정의 
   Process를 구성하는 '제어의 흐름'
   
2) Process 와 Thread
	1) Process : 프로그램의 '실행 단위'
	2) Thread : Process를 구성하는 '작업 단위'
	   ex) day12/F.java
	   
3) 장점
	1) 1개의 프로세스로 여러개의 일을 동시에 수행할 수  있게 되었다.
	2) '경량 프로세스'라고 불린다.
	   ( 이유: '공통 Resource'를 공유하기 때문 )
	   
4) 생성하는 방법
	1) java.lang.Thread 상속
	2) java.lang.Runnable 상속
	   
5) 시작
   th.start();
   
6) 비유: '피고용인' ( Employee )
   
7) LifeCycle
   ![[Pasted image 20241216141248.png]]
	1) 5가지 상태
	2) 각 상태는 '메서드' || '스케줄러' || '시간' || '상황'등에 의해서 이동한다
	3) 한번 돌아가시면 살아나지 못함
	   
 8) Priority
	 1) Read 상태의 쓰레드 중에서 
	    우선적으로 CPU/GPU를 점유할 수 있는 쓰레드를 판별하기 위한 Level값
	2) 범위
	   1~10
	   
	3) 상수
	   Thread.MAX_PRIORITY // 10
	   Thread.MIN_PRIORITY // 1
	   Thread.NORM_PRIORITY // 5
	   	
	   	ex) day12/G.java
	   	
	4) th.setPriority(int newPriority); // 세팅
	   int priority = th.getPriority(); // 게팅
	   
	5) 우선순위를 높이면 스케쥴러에 의해 뽑힐 확률이 높아짐
	   
	6) 자식쓰레드에 join()을 걸어주면 부모가 먼저 죽을 수 없다.
	   
	    ex) day12/H.java
	    
9) 동기화 ( Synchronized)
	1) 비유: 화장실 문고리
	2) 무결성이 깨지는 '예'
	   int i = 0;
	   i++;
	   
	   - CPU 연산단계
	   1) 현재 i값을 읽는 단계
	   2) i값을 증가시키는 단계
	   3) 증가된 i값을 i에 대입 단계
	    
	3) 설명
	   하나 이상의 쓰레드가 어떤 연산 || 로직에 동시에 접근 했을 때,
	   그 연산에 대한 값의 무결성을 보장하기 위해서 수행영역에 대한 lock을 걸어주는 것
	   
	4) 방법
		1) synchronized void m(){
			   // 동기화가 필요한 로직들
		   }
		2) void m(){
			   //일반 로직들
			  synchronized(this){
				  // 동기화가 필요한 로직들
			  } 
		   }
		
		ex) day12/I.java