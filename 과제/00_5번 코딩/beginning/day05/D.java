class D 
{
	int i;
	D(){
		System.out.println("D()의 시작");
		m1();
		System.out.println("D()의 끝");
	}
	void m1(){
		System.out.println("m1()의 시작");
		if(i==0) return;
		System.out.println("m1()의 끝");
	}
	public static void main(String[] args) 
	{
		D d = new D();
		//d.m1();
		if(d.i==0) return;
		System.out.println("main의 끝");
	}
}

class D1
{
	int i;
	D1(){
		System.out.println();
		m1();
		System.out.println();
	}
	void m1(){
		System.out.println();
		if(i==0) return;
		System.out.println();
	}
	public static void main(String[] args){
		D1 d = new D1();
		if(d.i==0) return;
		System.out.println();
	}
}

class D2
{
	int i;
	D2(){
		System.out.println();
		m();
		System.out.println();
	}
	void m(){
		System.out.println();
		if(i==0) return;
		System.out.println();
	}
	public static void main(String[] args){
		D2 d = new D2();
		if(d.i==0) return;
		System.out.println();
	}
}

class D3
{
	int i;
	D3(){
		System.out.println();
		m();
		System.out.println();
	}
	void m(){
		System.out.println();
		if(i==0) return;
		System.out.println();
	}
	public static void main(String[] args){
		D3 d = D3();
		if(d.i==0) return;
		System.out.println();
	}
}

class D4
{
	int i;
	D4(){
		System.out.println();
		m();
		System.out.println();
	}
	void m(){
		System.out.println();
		if(i==0) return;
		System.out.println();
	}
	public static void main(String[] args){
		D4 d = new D4();
		if(i==0) return;
		System.out.println();
	}
}

class D5
{
	int i;
	D5(){
		System.out.println();
		m();
		System.out.println();
	}
	void m(){
		System.out.println();
		if(i==0) return;
		System.out.println();
	}
	public static void main(String[] args){
		D5 d = new D5();
		if(i==0) return;
		System.out.println();
	}
}