class C1
{
	byte b = 127;
	void m1(){
		b = (byte)(b + 1);
		System.out.println("B: "+b);
	}
	void m2(){
		float f1 = 100.1111111111f;
		float f2 = 200.2222222222f;
		float f = f1 + f2;
		System.out.println("f: " + f);

		double d2 = 200.2222222222;
		double d = f1 +d2;
		System.out.println("d: " + d);
	}
	void m3(){
		long lo = 1234567890123456789L;
		System.out.println("lo: " + lo);
	}
	public static void main(String[] args) 
	{
		C1 c = new C1();
		// c.m1();
		// c.m2();
		c.m3();
	}
}

class C2
{
	byte b = 127;
	void m1(){
		b = (byte)(b + 1);
		System.out.println("B: "+b);
	}
	void m2(){
		float f1 = 100.1111111111F;
		float f2 = 200.2222222222F;
		float f = f1 + f2;
		System.out.println("f: "+ f);

		double d2 = 200.2222222222;
		double d = f1 + d2;
		System.out.println("d: " + d);
	}
	void m3(){
		long lo = 1234567890123456789L;
		System.out.println("lo: "+lo);
		double d=lo;
		System.out.println("d: "+d);
	}
	public static void main(String[] args){
		C2 c = new C2();
		c.m1();
		c.m2();
		c.m3();
	}
}

class C3
{
	byte b = 127;
	void m1() {
		b = (byte)(b+1);
		System.out.println(b);
	}
	void m2(){
		float f1 = 100.1111111111f;
		float f2 = 200.2222222222f;
		float f = f1 + f2;
		System.out.println(f);

		double b2 = 200.2222222222;
		double d = f1 + b2;
		System.out.println(d);
	}
	void m3(){
		long lo = 1234567890123456789L;
		System.out.println(lo);
		double d = lo;
		System.out.println(d);
	}
	public static void main(String args[]){
		C3 c = new C3();
		c.m1();
		c.m2();
		c.m3();
	}
}

class C4
{
	void m1(){
		float f1 = 333.3333333333f;
		float f2 = 444.4444444444f;
		float f = f1 + f2;
		System.out.println(f);

		double d2 = 444.4444444444;
		double d = f1 + d2;
		System.out.println(d);
	}
	void m2(){
		long lo = 1234678901234567890L;
		System.out.println(lo);
		double d = lo;
		System.out.println(d);
	}
	public static void main(String args[]){
		C4 c = new C4();
		c.m1();
		c.m2();
	}
}


class C5 
{
	byte b = 127;
	void m1(){
		b = (byte)(b + 1);
		System.out.println("b: " + b);
	}
	void m2(){
		float f1 = 100.1111111111f;
		//float f2 = 200.2222222222f;
		//float f = f1 + f2;
		//System.out.println("f: " + f);

		double d2 = 200.2222222222;
		double d = f1 + d2;
		System.out.println("d: " + d);
	}
	void m3(){
		long lo = 1234678901234567890L;
		System.out.println("lo: " + lo);
		double d = lo;
		System.out.println("d: " + d);
	}
	public static void main(String[] args) 
	{
		C5 c = new C5();
		//c.m1();
		//c.m2();
		c.m3();
	}
}