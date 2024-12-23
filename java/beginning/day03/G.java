class G 
{
	String str = "100";
	String item;
	void m1(){
		int i = Integer.parseInt(str); // 메서드를 사용하고 싶을 때
		System.out.println(i + 1);
	}
	void m2(){
		System.out.println("max: " + Integer.MAX_VALUE);
		System.out.println("max: " + Integer.MIN_VALUE);
	}
	void m3(){
		System.out.println("item: " + item);
	}
	public static void main(String[] args) 
	{
		G g = new G();
		g.m2();
		g.m3();
	}
}
