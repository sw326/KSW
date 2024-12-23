class E 
{
	void m1(){
		byte b = 10;
		short s = 20;
		int r = b + s;
		System.out.println("r: " +r);
	}
	public static void main(String[] args) 
	{
		E e = new E();
		e.m1();
	}
}

class E2
{
	void m1(){
		byte b=10;
		short s=20;
		int r=b+s;
		System.out.println(r);
	}
	public static void main(String []args){
		E2 e = new E2();
		e.m1();
	}
}

class E3
{
	void m1(){
		byte b=10;
		byte s=20;
		int r=b+s;
		System.out.println(r);
	}
	public static void main(String []args){
		E3 e = new E3();
		e.m1();
	}
}

class E4
{
	void m1(){
		short s=50;
		short s1=90;
		int r=s+s1;
		System.out.println(r);
	}
	public static void main(String[] args){
		E4 e = new E4();
		e.m1();
	}
}

class E5
{
	void m1(){
		byte b=10;
		short s = 20;
		int r = b+s;
		System.out.println(r);
	}
	public static void main(String[] args){
		E5 e = new E5();
		e.m1();
	}
}