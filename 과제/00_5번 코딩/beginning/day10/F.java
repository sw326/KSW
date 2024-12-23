abstract class F 
{
	int j; // 
	// abstract int i; 불가
	// abstract F(){}; 불가
	abstract void m(); // 바디가 없는 경우 가능 // 추상 메소드
	void m2(){ // 일반 메소드
		System.out.println("m2()");
	}
}

class FChild extends F {
	void m(){
		System.out.println("m() in Child");
	}

}

class FUser {
	public static void main(String[] args){
		F f = new FChild();
		// 추상클래스 F의 객체를 만들어서.. 자원을 사용해보세요
		f.m();
		f.m2();
	}
}

abstract class F1
{
	int j;
	// abstact int i; not allowed
	// abstract F1(){}; not allowed
	abstract void m(); // no body <- abstract method
	void m2(){ // nomal method
		System.out.println("m2()");
	}
}

class FChild1 extends F1{
	void m(){
		System.out.println("m() in Child");
	}
}
class FUser1{
	public static void main(String[] args){
		F1 f = new FChild1();
		f.m();
		f.m2();
	}
}

abstract class F2
{
	int j;
	abstract void m();
	void m2(){
		System.out.println("m2()");
	}
}
class FChild2 extends F2
{
	void m(){
		System.out.println("m() in Child");
	}
}
class FUser2
{
	public static void main(String args[]){
		F2 f = new FChild2();
		f.m();
		f.m2();
	}
}

abstract class F3
{
	int i;
	abstract void m();
	void m2(){
		System.out.println("m()");
	}
}
class FChild3 extends F3
{
	void m(){
		System.out.println("m() int Child");
	}
}
class FUser3
{
	public static void main(String args[]){
		F3 f = new FChild3();
		f.m();
		f.m2();
	}
}

abstract class F4{
	int i;
	abstract void m();
	void m2() System.out.println("m()");
}
class FChild4{
	void m() System.out.println("m() in child");
}
class FUser4{
	public static void main(String args[]){
		F4 f = new F4();
		f.m();
		f.m2();
	}
}

abstract class F5{
	int i; abstract void m(); voidm2() System.out.println("m()");
}
class FChild5{
	void m() System.out.println("m() in child");
}
class FUser5{
	public static void main(String[] args){
		F5 f = new F5();
		f.m();
		f.m2();
	}
}