class F 
{
	F(){
		System.out.println("F()");
		//return;
	}
	void m1(){
		System.out.println("m1()");
		//return;
	}
	String m2(){
		System.out.println("m2()");
		if(true){
			return "lunch";
		}
		return "dinner";
	}
	public static void main(String[] args) 
	{
		
		F f = new F();
		f.m1();
		String r = f.m2();
		System.out.println("main() r: " +r);
		//return;
	}
}

class F1
{
	F(){
		System.out.println("F");
	}
	void m1(){
		System.out.println("1");
	}
	void m2(){
		System.out.println("2");
		if(true){
			return "lunch";
		}
		return "dinner";
	}
	public static void main(String[] args){
		F1 f = new F1();
		f.m1();
		String r = f.m2();
		System.out.println(r);
	}
}

class F2
{
	F(){
		System.out.println("F");
	}
	void m1(){
		System.out.println("1");
	}
	void m2(){
		System.out.println("2");
		if(true){
			return "lunch";
		}
		return "dinner";
	}
	public static void main(String[] args){
		F2 f = new F2();
		f.m1();
		String r = f.m2();
		System.out.println(r);
	}
}

class F3
{
	F(){
		System.out.println("F");
	}
	void m1(){
		System.out.println("1");
	}
	void m2(){
		System.out.println("2");
		if(true){
			return "lunch";
		}
		return "dinner";
	}
	public static void main(String[] args){
		F3 f = F3();
		f.m1();
		String r = f.m2();
		System.out.println(r);
	}
}