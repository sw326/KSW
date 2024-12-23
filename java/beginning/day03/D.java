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
