class C // continue 
{
	void m1(){
		aa:
		for(int j=0;j<2;j++){
			for(int i=0;i<5;i++){
				if(i==2) continue aa;
				System.out.println("j: "+j+", i: "+i);
			}
			System.out.println("inner for inner");
		}
		System.out.println("outer for outer");
	}
	public static void main(String[] args) 
	{
		C c = new C();
		c.m1();
	}
}

class C1
{
	void m1(){
		aa:
		for(int j=0;j<2;j++){
			for(int i=0;i<5;i++){
				if(i==2) continue aa;
				System.out.println(j+i);
			}
			System.out.println("안 밖");
		}
		System.out.println("밖 밖");
	}
	public static void main(String[] args){
		C1 c = new C1();
		c.m1();
	}
}

class C2
{
	void m(){
		aa:
		for (int j=0;j<2;j++){
			for(int i=0;i<5;i++){
				if(i==2) continue aa;
				System.out.println(j+i);
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String[] args){
		C2 c = new C2();
		c.m();
	}
}

class C3
{
	void m(){
		aa:
		for(int i=0;i<2;i++){
			for(int j=0;j<5;j++){
				if(j==2) continue aa;
				System.out.println(i+j);
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String[] args){
		C3 c = new C3();
		c.m();
	}
}

class C4
{
	void m(){
		aa:
		for(int j =0;j<2;j++){
			for(int i=0;i<5;i++){
				if(i==2) continue aa;
				System.out.println(j+i);
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String[] args){
		C4 c = new C4();
		c.m();
	}
}

class C5
{
	void m(){
		aa:
		for(int j=0;j<2;j++){
			for(int i=0;i<5;i++){
				if(i==2) continue aa;
				System.out.println(j+i);
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String[] args){
		C5 c = new C5();
		c.m();
	}
}