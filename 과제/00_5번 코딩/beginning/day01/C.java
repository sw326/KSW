package aa; // (1) 패키지 선언

import java.lang.*; // (2) import 구문
import java.util.Random;

class C1 // (3) 클래스
{
	String name = "홍길동"; // (4) 멤버변수 선언
	Random r;
	C1() { // (5) 생성자 정의
	}
	void m(){// (6) 메소드 정의
	}
	public static void main(String args[]){
		System.out.println("Hello World!");
	}
}


// 클래스 구조 예제

class C2 // 클래스 선언
{
	String name; // 맴버 변수 선언
	Random r;
	C2(){} // 생성자 정의
	void m(){} // 메소드 정의
	public static void main(String args[]){
		new C2();
	}
}