# 제어문
### 조건문
1) if
	- if (boolean형){}
	- if (boolean형){} else if(boolean형) ... else{}
2) switch
	- switch(정수형 or String){
		case 1:  로직; break;
		case 2: 로직; break;
		default: 로직;
		}

### 반복문
	초기식(밖), 조건식(안), 증감식(안) 유한루프

- while(boolean형){}
- do{} while(boolean형);
- for(초기식;조건식;증감식){}


# 제어 예약어
1) break
	1) switch or loop 안에서만 사용할 수 있음
	2) 블럭을 '**나간다**'
	3) labled( ' : '으로 지정) break문
	   
	   ex) day05/B.java
2) continue
	1) loop 안에서만 사용할 수 있음
	2) (조건에 맞으면) '**건너뛴다**'
	3) labled countinue문
	   
	   ex) day05/C.java
3) return
	1) 생성자나 메소드 안에서는 '**어디서나**' 사용할 수 있음
	2) '**호출한 곳**' or '**놈(JVM)**'으로 '**되돌린다**'
	
	   ex) day05/D.java


# 연산자(Operator)
1) 정의: (데이터들을) 연산하게 하는 '**기호**'
2) 종류: 
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
	
	ex) day05/G.java