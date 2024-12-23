class B 
{
	void m1(){
		int i = 0; // 초기식
		boolean flag = true;
		while (i<5) // 조건식
		{
			i++; // 증감식
			System.out.println(i);
		}
		System.out.println("Out the World!");
	}
	void m2(){
		int i = 0; // 초기식
		do{
			i++; // 증감식
			System.out.println(i);
		} while(i<5) // 조건식
		System.out.println("Out the World!");
	}
	void m3(){
		for(int i =0; i<5; i++){
			System.out.println(i);
		}
		System.out.ptintln("밖");
	}
	public static void main(String[] args) 
	{
		B b = new B();
		b.m1();
		b.m2();
		b.m3();
	}
}
