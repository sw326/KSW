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
