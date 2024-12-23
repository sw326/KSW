class A1
{
	A1() { // 생설자 정의
		System.out.println("2");
		m1(); // 호출
		System.out.println("6");
	}
	void m1() { // 메소드
		System.out.println("3");
		m2();
		System.out.println("5");
	}
	void m2() { // 메소드 
		System.out.println("4");
	}
	public static void main(String args[]){ // 메인 메소드 
		System.out.println("1");
		new A1();
		System.out.println("7");
	}
}

class A2
{
	A2(){
		System.out.println("2");
		m1();
		System.out.println("6");
	}
	void m1(){
		System.out.println("3");
		m2();
		System.out.println("5");
	}
	void m2(){
		System.out.println("4");
	}
	public static void main(String arg[]){
		System.out.println("1");
		new A2();
		System.out.println("7");
	}

}

class A3
{
	A3(){
		System.out.println("2");
		m1();
		System.out.println("6");
	}
	void m1(){
		System.out.println("3");
		m2();
		System.out.println("5");
	}
	void m2(){
		System.out.println("4");
	}
	public static void main(String args[]){
		System.out.println("1");
		new A3();
		System.out.println("7");
	}
}

class A4
{
	A4(){
		System.out.println("2");
		m1();
		System.out.println("6");
	}
	void m1(){
		System.out.println("3");
		m2();
		System.out.println("5");
	}
	void m2(){
		System.out.println("4");
	}
	public static void main(String args[]) {
		System.out.println("1");
		new A4();
		System.out.println("7");
	}
}

class A5
{
	A5(){
		System.out.println("도");
		m1();
		System.out.println("제");
	}
	void m1(){
		System.out.println("수");
		m2();
		System.out.println("통");
	}
	void m2(){
		System.out.println("군");
	}
	public static void main(String args[]){
		System.out.println("삼");
		new A5();
		System.out.println("사");
	}
}