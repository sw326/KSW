class C 
{
	String name = "홍길동"; // 변수
	C(){
		System.out.println("C()");
	}
	void m(){
		System.out.println("m()");
		name = "삼도수군통제사";
	}
	public static void main(String[] args) 
	{
		C c = new C();
		System.out.println("c.name: " + c.name);
		c.m();
	}
}
