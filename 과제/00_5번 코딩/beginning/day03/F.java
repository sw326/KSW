class F 
{
	byte b;
	short s;
	char c;
	int i;
	long lo;
	float f;
	double d;
	boolean flag;

	void m(){
		pln("b: "+ b);
		pln("s: "+ s);
		pln("c: "+ c);
		pln("i: "+ i);
		pln("lo: "+ lo);
		pln("f: "+ f);
		pln("d: "+ d);
		pln("flag: "+ flag);
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) 
	{
		F f = new F();
		f.m();
	}
}

class F2
{
	byte b;
	short s;
	char c;
	int i;
	long lo;
	float f;
	double d;
	boolean flag;

	void m(){
		pln("b: "+ b);
		pln("s: "+ s);
		pln("c: "+ c);
		pln("i: "+ i);
		pln("lo: "+ lo);
		pln("f: "+ f);
		pln("d: "+ d);
		pln("flag: "+ flag);
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args){
		F2 f = new F2();
		f.m();
	}
}

class F3
{
	byte b;
	short s;
	char c;
	int i;
	long lo;
	float f;
	double d;
	boolean flag;
	void m(){
		pln(""+ b);
		pln(""+ s);
		pln("c: "+ c);
		pln("i: "+ i);
		pln("lo: "+ lo);
		pln("f: "+ f);
		pln("d: "+ d);
		pln("flag: "+ flag);
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String args[]){
		F3 f = new F3();
		f.m();
	}
}

class F4
{
	byte b;
	short s;
	char c;
	int i;
	long lo;
	float f;
	double d;
	boolean flag;
	void m(){
		System.out.print(b);
		System.out.print(s);
		System.out.print(c);
		System.out.print(i);
		System.out.print(lo);
		System.out.print(f);
		System.out.print(d);
		System.out.print(flag);
	}
	public static void main(String args[]){
		F4 f = new F4();
		f.m();
	}
}

class F5
{
	byte b;
	short s;
	char c;
	int i;
	long lo;
	float f;
	double d;
	boolean flag;
	void m(){
		System.out.println(b);
		System.out.println(s);
		System.out.println(c);
		System.out.println(i);
		System.out.println(lo);
		System.out.println(f);
		System.out.println(d);
		System.out.println(flag);
	}
	public static void main(String args[]){
		F5 f = new F5();
		f.m();
	}
}