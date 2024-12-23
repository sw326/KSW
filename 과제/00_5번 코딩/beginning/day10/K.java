class K {
	String name;
	K(String name){
		this.name = name;
	}
	void m(){
		System.out.println("K의 m()");
	}
}
class KChild extends K{
	String name = "이순신";
	KChild(){
		super("홍길동"); //1
	}
	void showName(){
		System.out.println("this.name: " + name);
		System.out.println("super.name: " + super.name); //2
		m();
		super.m(); //3
	}
	void m(){ //오버라이딩
		System.out.println("KChild의 m()");
	}
}

class KUser {
	public static void main(String[] args) {
		KChild kc = new KChild();
		kc.showName();
	}
}

class K1{
	String name;
	K1(String name){
		this.name = name;
	}
	void m(){
		System.out.println("K's m()");
	}
}
class KChild1 extends K1{
	String name = "Lee";
	KChild1(){
		super("Hong");
	}
	void showName(){
		System.out.println("this.name: "+ name);
		System.out.println("super.name: "+super.name);
		m();
		super.m();
	}
	void m(){
		System.out.println("KChild's m()");
	}
}
class KUser1{
	public static void main(String []args){
		KChild1 kc = new KChild1();
		kc.showName();
	}
}

class K2{
	String name;
	K2(String name){
		this.name = name;
	}
	void m(){
		System.out.println("K's m()");
	}
}
class KChild2 extends K2{
	String name = "LEE";
	KChild2(){
		super("HONG");
	}
	void showName(){
		System.out.println();
		System.out.println();
		m();
		super.m();
	}
	void m(){
		System.out.println("KChild's m()");
	}
}
class KUser2{
	public static void main(String []args){
		KChild2 kc = new KChild2();
		kc.showName();
	}
}