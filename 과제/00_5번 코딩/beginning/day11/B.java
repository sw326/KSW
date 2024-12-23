class B {
	String name;

	//생성자 오버로딩 
	B(){}
	B(String name){
		this.name = name;
	}

	//메소드 오버로딩
	void m(){
	}
	int m(int i){
		System.out.println("i: " + i);
		return i;
	}
	String m(String str, int i){
		return str;
	}
	void m(int i, String str){
	}
}
class BChild extends B {
	void m(byte b){ //오버로딩
		System.out.println("b: " + b);
	}
}
class BUser{
	public static void main(String args[]){
		BChild c = new BChild();
		byte b = 10;
		c.m(b);
	}
}
class B1{
	String name;
	B1(){}
	B1(String name){
		this.name = name;
	}
	void m(){}
	int m(int i){
		System.out.println("i: "+ i);
		return i;
	}
	String m(String str, int i){
		return str;
	}
	void m(int i, String str){}
}
class BChild1 extends B1{
	void m(byte b){
		System.out.println("b : "+b);
	}
}
class BUser1{
	public static void main(String args[]){
		BChild1 c = new BChild1();
		byte b = 10;
		c.m(b);
	}
}
class B2{
	String name;
	B2(){}
	B2(String name) this.name = name;
	void m(){}
	int m(int i) System.out.println("i : "+i) return i;
	String m(String str) return str;
	String m(String str, int i) return str;
	void m(int i, String str){}
}
class BChild2 extends B2{
	void m(byte b) System.out.println("b: "+b);
}
class BUser2{
	public static void main(String args[]){
		BChild2 c = new BChild2();
		byte b = 10;
		c.m(b);
	}
}
class B3{
	String name;
	B3(){}
	B3(String name) this.name = name;
	void m(){}
	int m(int i) System.out.println("i: "+i) return i;
	String m(String str) return str;
	String m(String str, int i) return str;
	void m(int i, String str){}

}
class BChild3 extends B3{
	void m(byte b) System.out.println("b: "+b);
}
class BUser3{
	public static void main(String args[]){
		BChild3 c = new BChild3();
		byte b = 10;
		c.m(b);
	}
}
class B4{
	String name;
	B4(){}
	B4(String name) this.name = name;
	void m(){}
	int m(int i) System.out.println("i: "+i) return i;
	String m(String str) return str;
	String m(String str, int i) return str;
	void m(int i, String str){}
}
class BChild4 extends B4{
	void m(byte b) System.out.println("b: " +b);
}
class BUser4{
	public static void main(String []args){
		BChild4 c = new BChild4();
		byte b = 10;
		c.m(b);
	}
}
class B5{
	String name;
	B5(){}
	B5(String name) this.name = name;
	void m(){}
	int m(int i) System.out.println("i: "+i) return i;
	String m(String str) return str;
	String m(String str, int i) return str;
	void m(int i, String str){}
}
class BChild5 extends B5{
	void m(byte b) System.out.println("b: "+b);
}
class BUser5{
	public static void main(String []args){
		BChild5 c = new BChild5();
		byte b = 10;
		c.m(b);
	}
}