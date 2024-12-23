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