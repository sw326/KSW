interface BI{
	void m();
}

class B{
	private int i=1; // member
	void use(int j){ // local(param)
		int k=3; // local(init)
		class BIChild implements BI{
			public void m(){
				int n = 4; // inner class m()'s local
				pln("BI의 m()구현 : " +i+n);
			}
		}
		BI bi = new BIChild();
		bi.m();
	}
	void use2(int j){
		int k=3;
		BI bi = ()->{
			int n=4;
			pln("i:"+i+", j:"+j+", k:"+k + ", n:"+n);
		};
		bi.m();
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args){
		System.out.println("Hello World!");
		B b = new B();
		//b.use1(2);
		b.use2(2);
	}
}

interface BI1{
	void m();
}
class B1{
	private int i=1;
	void use(int j){
		int k=3;
		class BIChild1 implements BI1{
			public void m(){
				int n=4;
				pln(""+i+n);
			}
		}
		BI1 bi = new BIChild1();
		bi.m();
	}
	void use2(int j){
		int k=3;
		BI1 bi=()->{
			int n=4;
			pln("i:"+i+", j:"+j+", k:"+k + ", n:"+n);
		};
		bi.m();
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) {
		
		B1 b = new B1();
		//b.use1(2);
		b.use2(2);
	}
}

