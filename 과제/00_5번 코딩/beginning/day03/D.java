class D 
{
	byte b = 10;
	long lo = 20;
	void m1(){
		long result = b + lo; // 자동 형변환
		System.out.println("result: " +result);
	}
	void m2(){
		int i = 30;
		short s = (short)i; // 강제 형변환
		System.out.println("s: " +s);
	}
	public static void main(String[] args) 
	{
		D d = new D();
		d.m1();
	}
}

class D2
{
	byte b = 10;
	long lo = 20;
	void m1(){
		long result = b + lo;// 자동 형변환 
		System.out.println("result: " +result);
	}
	void m2(){
		int i = 30;
		short s = (short)i; // 강제 형변환
		System.out.println("s: "+s);
	}
	public static void main(String args[]){
		D2 d = new D2();
		d.m1();
		d.m2();
	}
}

class D3
{
	byte b = 10;
	long lo = 20;
	void m1(){
		long result = b+lo;
		System.out.println(result);
	}
	void m2(){
		int i = 30;
		short s=(short)i;
		System.out.println(s);
	}
	public static void main(String args[]){
		D3 d = new D3();
		d.m1();
		d.m2();
	}
}

class D4
{
	byte b=10;
	long lo=90;
	void m1(){
		long r =b+lo;
		System.out.println(r);
	}
	void m2(){
		int i = 70;
		short s=(short)i;
		System.out.println(s);
	}
	public static void main(String args[]){
		D4 d = new D4();
		d.m1();
		d.m2();
	}
}

class D5
{
	byte b=90;
	long lo = 120;
	void m1(){
		long r =b+lo;
		System.out.println(r);
	}
	void m2(){
		int i = 80;
		short s=(short)i;
		System.out.println(s);
	}
	public static void main(String[] args){
		D5 d = new D5();
		d.m1();
		d.m2();
	}
}