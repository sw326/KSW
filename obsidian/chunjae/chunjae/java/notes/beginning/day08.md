### < 저장소 객체 >
1) 배열 ( 고정배열 ) : 기본형 저장이 가능함, 가볍다
  
2) 컬렉션 ( 가변배열 ) : 참조형 데이터만 저장 가능
	종류
	- Collection ( List, Set )
	- Map
	  
	특성
	- List (순서, 중복): ArrayList, Vector, ...
	- Set (순서X, 중복X ): TreeSet(정렬), ...
	- Map (순서X, 중복(key X, value O) ): HashMap, Hashtable, ...
	  
	확장
	- Generic
	- AutoBoxing
	- Enhanced Loop
	  
	N차원
	- ex) day07/N.java



# OOP의 특성
1) 상속성 ( Inheritance )
	부모는 '모든 것이 자식에게 '상속'되어지는 것(== '사용'할 수 있는 것)
	1) Why? 코드의 재사용성
	2) 자식 객체가 생성 되려면 먼저 부모 객체가 생성되어야 한다
		( 다른 생성자가 하나도 없을 때에만 JVM이 기본 생성자를 만들어 줌 )
	3) 모든 생성자의 첫 라인에는 super();가 생략되어 있음
	4) 클래스 간 상속은 '단일상속'만 가능함
	5) 모든 객체는 Object의 자식 ( 묵시적 상속 )
	6) 부모 메소드를 자식에서 '재정의(Overriding)'할 수 있음 == '다형성( Polymorphism )'
	7) 형변환(Type Casting)
		- 자동형변환 by JVM (자식 -> 부모)
		- 강제형변환 by 개발자 (부모 -> 자식)
	8) 강제형 변환은 '원래 자기 타입'을 되찾을 때만 가능하다
	9) 형제관계는 '남남'이다. - 형변환 불가
		
	ex) day08/Human.java
	
2) 다형성 ( Polymorphism )
	같은 타입 객체의 같은 메소드가 '다른 일'을 하는 것
	ex) day08/B.java
	
3) 은닉성 ( Information Hiding )
	외부 프로그램으로부터 '속성값'을 감추는 것
	ex) day08/C.java
4) 캡슐화 ( Encapsulation  )
	- 메소드의 캡슐화: 메소드의 구현 내용을 몰라도 그 형태(이름/파라미터/리턴타입)만 알면 호출해서 사용할 수 있는 것
	- 객체의 캡슐화: 객체가 속성값들을 감추고 선태적인 메소드로 속성값들의 일부를접근하게 하는 것
	  ex) day08/D.java