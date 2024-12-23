interface C {
	interface CInnerInter1{
		int I = 10;
		void m1();
	}
	static interface CInnerInter2{
		int J = 20;
		void m2();
	}
}
class CInnerInterChild1 implements C.CInnerInter1{
	public void m1(){
		System.out.println("CInnerInterChild1 m1()");
	}
}
class CInnerInterChild2 implements C.CInnerInter2{ 
	public void m2(){
		System.out.println("CInnerInterChild2 m2()");
	}
}
class CUser {
	public static void main(String args[]){
		C.CInnerInter1 inter1 = new CInnerInterChild1();
		System.out.println(C.CInnerInter1.I);
		inter1.m1();

		C.CInnerInter2 inter2 = new CInnerInterChild2();
		System.out.println(C.CInnerInter2.J);
		inter2.m2();
	}
}