class D {
	static int i; //1개
	int j; //2개
	void m(){
		i++;
		j++;
	}
	void show(){
		System.out.println("i: " + i);
		System.out.println("j: " + j);
	}
	public static void main(String[] args) {
		D d1 = new D();
		d1.m();
		D d2 = new D();
		d2.m();

		d2.show();
		//System.out.println("i: " + d2.i);
		//System.out.println("j: " + d1.j);
	}
}

class D1{
	static int i;
	int j;
	void m(){
		i++;
		j++;
	}
	void show(){
		System.out.println("i: "+i);
		System.out.println("j: "+j);
	}
	public static void main(String[] args){
		D1 d1 = new D1();
		d1.m();
		D1 d2 = new D1();
		d2.m();

		d2.show();
	}
}

class D2
{
	static int i;
	int j;
	void m() {i++; j++;}
	void show(){
		System.out.println("i: "+i);
		System.out.println("j: "+j);
	}
	public static void main(String[] args){
		D2 d1 = new D2();
		D2 d2 = new D2();
		d1.m();
		d2.m();
		d2.show();
	}
}

class D3
{
	static int i;
	int j;
	void m(){i++; j++;}
	void show(){
		System.out.println("i: "+i);
		System.out.println("j: "+j);
	}
	public static void main(String[] args){
		D3 d1 = new D3();
		D3 d2 = new D3();
		d1.m();
		d2.m();
		d2.show();
	}
}

class D4
{
	static int i;
	int j;
	void m(){i++; j++;}
	void m2(){
		System.out.println("i: "+i);
		System.out.println("j: "+j);
	}
	public static void main(String[] args){
		D4 d1 = new D4();
		D4 d2 = new D4();
		d1.m();
		d2.m();
		d1.m2();
	}
}

class D5
{
	static int i;
	int j;
	void m(){i++;j++;}
	void m2(){
		System.out.println("i: "+i);
		System.out.println("j: "+j);
	}
	public static void main(String args[]){
		D5 d1 = new D5();
		D5 d2 = new D5();
		d1.m();
		d2.m();
		d1.m2();
	}
}