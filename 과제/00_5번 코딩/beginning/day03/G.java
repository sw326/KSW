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


class G2
{
	String str="100";
	String item;
	void m1(){
		int i = Integer.parseInt(str); // 메서드를 사용하고 싶을 때
		System.out.println(i+1);
	}
	void m2(){
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
	}
	void m3(){
		System.out.println(item);
	}
	public static void main(String[] args){
		G2 g = new G2();
		g.m1();
		g.m2();
		g.m3();
	}
}

class G3
{
	String str="100";
	String item;
	void m1(){
		System.out.println(str+1);
	}
	void m2(){
		System.out.println(Character.MAX_VALUE);
		System.out.println(Character.MIN_VALUE);
	}
	public static void main(String[] args){
		G3 g = new G3();
		g.m1();
		g.m2();
	}
}

class G4
{
	void m(){
	System.out.println(Double.MAX_VALUE);
	System.out.println(Double.MIN_VALUE);
	}
	public static void main(String[] args){
		G4 g = new G4();
		g.m();
	}
}

class G5
{
	void m(){
	System.out.println(Byte.MAX_VALUE);
	System.out.println(Byte.MIN_VALUE);
	System.out.println(Short.MAX_VALUE);
	System.out.println(Short.MIN_VALUE);
	System.out.println(Long.MAX_VALUE);
	System.out.println(Long.MIN_VALUE);
	System.out.println(Float.MAX_VALUE);
	System.out.println(Float.MIN_VALUE);
	System.out.println(Double.MAX_VALUE);
	System.out.println(Double.MIN_VALUE);
	}
	public static void main(String[] args){
		G5 g = new G5();
		g.m();
	}
}