# < 복습 >
--- 

## < 예외 ( Exception ) 복습 > ( 돌발상황 )
정상적으로 진행되지 못하게 하는 돌발상황

try{
	// 예외 발생할 수 있는 구문
} catch ( Exception e ) {
	// 예외 발생했을 경우 취하는 조치
}

계층도 
				    Object
					     |
					  Throwable
					  |                |
				   Error                 Exception
						    |                         |
						CompileException      RuntimeException
						
		ex) IOException (CompileException)
			NumberFormatException (RuntimeException)


# < 제한자 ( Modifier ) >

클래스, 변수, 생성자, 메소드 앞에 붙어서 기능을 '제한'하는 예약어

1) 접근 제한자 ( Access Modifier )
	1) 종류 
		1) public : 접근 제한이 없음
		2) protected : 같은 패키지 || 다른 패키지라도 상속관계라면 접근 가능
		3) default : 같은 패키지 자원만 접근 가능
		4) private : 자신의 클래스 안
		   
		   ex) day10/A.java
		   
	2) 특징
		1) 클래스나 인터페이스 앞에 붙을 수 있는 접근 제한자는
		   public과 default만 가능하다.
		2) 맴버, 생성자, 메소드 앞에 4개의 접근 제한자가 모두 붙을 수 있다
		   ( 지역변수는 default만 가능하다 )
		3)  public 클래스나 인터페이스의 이름은 파일 이름과 같아야 한다.
		   두 개 이상의 public 클래스가 필요하다면 파일을 분리해야 한다.
		   
		   ex) day10/B.java
	3) 범위
		1)  넓은 순위: public > protected > default > private
		2)  강력 순위: private > default > protected > public
		   
		   
2) 소유제한자 ( static ) // 가운데 화투장
   붙으면 '클래스' 소유가 되는 예약어
   
   1) 멤버와 메서드 앞에만 붙을 수 있다
   2) static 자원은 클래스 이름으로 접근
   3) static 메소드에서는 자원 접근 시 자신의 클래스 이름을 생략할 수 있음
       ( 단, 다른 클래스에서 접근시에는 새약 불가 )
   4) 해당 클래스의 객체로도 static 자원을 접근할 수 있음
   5) static 메소드 내에서 객체 자원을 접근 할 때는 객체를 생성시켜서 그 객체로 접근함
   6) static 자원(멤버, 메소드)은 메모리에 '1개' 생성되어서, 그 클래스의 모든 객체에 '공유'된다
   7) 
      
      ex) day10/C.java
      
      
3) 수정 제한자 ( final )
   final이 붙으면 수정이 되지 않는다 ( 상수 )
	1) 클래스, 변수(지역변수 포함), 메소프 앞에 붙을 수 있음
	2) 클래스 앞에 붙으면 자식을 못 낳고, 
	   변수 앞에 붙으면 초기값을 못 바꾸고,
	   메소드 앞에 붙으면 오버라이딩을 못하게 함
	
	   ex) day10/E.java
	   
4) 추상 제한자 ( abstract )
	1) 클래스와 메소드 앞에만 붙을 수 있다.
	2) 구체화되지 않은 것
	3) 하나 이상의 '추상 메소드'를 가진 클래스는 반드시 추상 클래스가 되어야 한다
	4) 추상클래스 객체는 '완벽한 자식 클래스 객체'를 만들어서 '형변환'하여 생성함
	   참고) 추상 클래스 : abstract가 붙은 클래스
			추상 메서드 : abstract가 붙은 메서드
			
			
5) 기타 제한자
	1) Synchronized ( thread )
	2) transient ( 보안 )


# < 식별자 ( Identifier ) >
개발자가 임의로 설정하는 패키지, 클래스, 인터페이스, 변수, 생성자, 메서드, '이름'

1) 규칙
	1) 숫자가 맨 앞에 나올 수 없음
	2) 특수 문자는 ' _ '와 '$'만 가능하다. 
	3) 길이의 제약은 없음
	   
	   ex) day10/H.java
	   
2) 관례
	1) 클래스나 인터페이스 이름의 첫문자는 'upper case'
	2) 2개 이상의 단어의 조합은 다음 단어의 첫 문자를 'upper case'로 하거나, ' _ '로 연결
	3) 상수는 전체 문자를 'upper case'로 한다
	4) 패키지, 변수, 메소드 이름의 첫문자는 'lower case'로 한다
	5) _와 $ 사용은 자제 함
	6) 의미있는 단어를 사용
	   
	   ex) day10/I.java
	   
3) 팁
	1) Camel Case // 자바의 변수 || 메서드
	   ex) setFirstName, userAge
	2) Pascal Case // 자바의 클래스 || 인터페이스
	   ex) UserName, UserAge
	3) Snak Case // 자바의 상수에서 || 프론트
	   ex) user_name, user_age, USER_AGE
	4) Kebab Case // Restful
	   ex) user-name, USER-AGE
	5) Hungurian Notaion // 동적 타입 언어에 타입 명시 목적으로 사용
	   ex) strUserName, iUserAge



# < this > 
1) 정의
   자신의 '객체' || '생성자'를 가리키는 '대명사'
2) Case
	1) 지역변수와 이름이 같은 맴버변수를 해당 지역에서 접근할 때
	2) 자신의 생성자를 호출할 때 this를 사용한다
	3) 자신의 객체를 다른 클래스에게 넘길 때 사용한다.
	   
	   ex) day10/J.java

# < super >
1) 정의
   부모의 '객체' || '생성자'를 가리키는 '대명사'
2) Case
	1) 부모의 생성자를 호출할 때
	2) 이름이 동일한 부모의 맴버를 호출할 때
	3) 오버라이딩 되기 전 부모의 메서드를 호출할 때
	   
	   ex) day10/K.java