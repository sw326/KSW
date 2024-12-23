class  Hello
{ // class의 body 또는 block
	Hello(){ // 생성자
		System.out.println("Hello()");
	}
	void m1(){ // method
		System.out.println("m1()");
	}
	void m2(){ // method
		System.out.println("m1()");
	}
	public static void main(String[] args) // main method(방법) 인입점이 있는 메서드
	{ // method의 body
		System.out.println("하1");
		Hello o = new Hello(); // 호출
		System.out.println("하2");
		o.m1(); // 호풀
		System.out.println("하3");
	}
}
