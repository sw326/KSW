class E 
{
	void m1(){
		for(int j=0;j<2;j++){
			for(int i=0;i<5;i++){
				//if(i==3) break;
				if(i==3) return;
				System.out.println("j: "+j+" i: "+i);
			}
			System.out.println("innter for outter");
		}
		System.out.println("outter for outter");
	}
	public static void main(String[] args) 
	{
		E e = new E();
		e.m1();
		System.out.println("main의 끝");
	}
}

class E1
{
	void m(){
		for(int j=0;j<2;j++){
			for(int i=0;i<5;i++){
				if(i==3) break;
				System.out.println(j+i);
			}
			System.out.println("in out");
		}
		System.out.println("out out");
	}
	public static void main(String []args){
		E1 e = new E1();
		e.m();
		System.out.println("main");
	}
}

class E2
{
	void m(){
		for(int j=0;j<2;j++){
			for(int i=0;i<5;i++){
				if(i==3) break;
				System.out.println(j+i);
			}
			System.out.println("in out");
		}
		System.out.println("out out");
	}
	public static void main(String args[]){
		E2 e = new E2();
		e.m();
		System.out.println("main");
	}
}