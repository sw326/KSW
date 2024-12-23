class B {
	interface BInnerInter1{
		int I = 10;
		void m1();
	}
	static interface BInnerInter2{
		int J = 20;
		void m2();
	}
}
class BInnerInterChild1 implements B.BInnerInter1{
	public void m1(){
		System.out.println("BInnerInterChild1 m1()");
	}
}
class BInnerInterChild2 implements B.BInnerInter2{
	public void m2(){
		System.out.println("BInnerInterChild1 m2()");
	}
}
class BUser{
	public static void main(String args[]){
		B.BInnerInter1 inter1 = new BInnerInterChild1();
		System.out.println(B.BInnerInter1.I);
		inter1.m1();

		B.BInnerInter2 inter2 = new BInnerInterChild2();
		System.out.println(B.BInnerInter2.J);
		inter2.m2();
	}
}