interface BI {
	void m();
}

class B {
	private int i = 1; //멤버 
	void use1(int j){ //지역(파)
		int k = 3; //지역(선초)
		class BIChild implements BI {
			public void m(){
				int n = 4; //내부클래스 m()의 지역변수
				pln("BI의 m()구현 i:"+i+", j:"+j+", k:"+k + ", n:"+n);
			}
		}

		BI bi = new BIChild();
		bi.m();
	}
	void use2(int j){
		int k = 3;
		BI bi = () -> {
			int n = 4; 
			pln("i:"+i+", j:"+j+", k:"+k + ", n:"+n);
		};	

		bi.m();
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) {
		
		B b = new B();
		//b.use1(2);
		b.use2(2);
	}
}