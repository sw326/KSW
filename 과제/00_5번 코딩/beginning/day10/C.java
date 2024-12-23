class C {
	static int i;
	int j;
	//static C(){} //불가!
	static void m(){
		//static int j = 1; //불가!
		System.out.println("m()");
	}
	void m2(){
		System.out.println("m2()");
	}
	public static void main(String[] args) 
	{
		System.out.println("i: " + i);
		m();

		C c = new C();
		System.out.println("j: " + c.j);
		c.m2();
	}
}

class CUser {
	public static void main(String[] args) 
	{
		System.out.println("C.i: " + C.i);
		C.m();
	}
}

class C1{
	static int i;
	int j;
	// static C(){} // 불가
	static void m(){
		// static int j = 1;
		System.out.println("m()");
	}
	void m2(){
		System.out.println("m2()");
	}
	public static void main(String[] args){
		System.out.println("i: " +i);
		m();

		C1 c = new C1();
		System.out.println("j: " + c.j);
	}
}

class CUser1{
	public static void main(String[] args){
		System.out.println("C.i: " + C1.i);
		C1.m();
	}
}

class C2 {
	static int i;
	int j;
	static void m(){
		System.out.println("m()");
	}
	void m2(){
		System.out.println("m2()");
	}
	public static void main(String args[]){
		System.out.println("i: " + i);
		m();

		C2 c = new C2();
		System.out.println("j: "+ c.j);
	}
}
class CUser2
{
	public static void main(String args[]){
		System.out.println("C2.i: "+C2.i );
		C2.m();
	}
}

class C3
{
	static int i;
	int j;
	static void m(){
		System.out.println("m()");
	}
	void m2(){
		System.out.println("m2()");
	}
	public static void main(String []args){
		System.out.println("i: "+i);
		m();

		C3 c = new C3();
		System.out.println("j: "+c.j);
	}
}

class CUser3
{
	public static void main(String args[]){
		System.out.println("C3.i : " +C3.i);
		C3.m();
	}
}

class C4{
	static int i;
	int j;
	static void m(){
		System.out.println("m()");
	}
	void m2(){
		System.out.println("m2()");
	}
	public static void main(String []args){
		System.out.println("i: "+i);
		m();

		C4 c = new C4();
		System.out.println("j: "+c.j);
	}
}

class CUser4{
	public static void main(String args[]){
		System.out.println("C4.i: "+C4.i);
		C4.m();
	}
}

class C5{
	static int i;
	int j;
	static void m(){
		System.out.println("m()");
	}
	void m2(){
		System.out.println("m2()");
	}
	public static void main(String[] args){
		System.out.println("i: "+i);
		m();

		C5 c = new C5();
		System.out.println("j: "+c.j);
	}
}
class CUser5{
	public static void main(String[] args){
		System.out.println("i: "+C5.i);
		C5.m();
	}
}