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

class B1{
	interface BInnerInter11{
		int I=10;
		void m1();
	}
	static interface BInnerInter21{
		int J=20;
		void m2();
	}
}
class BInnerInterChild11 implements B1.BInnerInter11{
	public void m1(){
		System.out.println("BInnerInterChild11");
	}
}
class BInnerInterChild21 implements B1.BInnerInter21{
	public void m2(){
		System.out.println("BInnerInterChild21");
	}
}
class BUser1{
	public static void main(String args[]){
		B1.BInnerInter11 inter1 = new BInnerInterChild11();
		System.out.println(B1.BInnerInter11.I);
		inter1.m1();

		B1.BInnerInter21 inter2 = new BInnerInterChild21();
		System.out.println(B1.BInnerInter21.J);
		inter2.m2();
	}
}

class B2{
	interface BInnerInter12{
		int I=10;
		void m1();
	}
	static interface BInnerInter22{
		int J=20;
		void m2();
	}
}
class BInnerInterChild12 implements B2.BInnerInter12{
	public void m1(){
		System.out.println("BInnerInterChild12");
	}
}
class BInnerInterChild22 implements B2.BInnerInter22{
	public void m2(){
		System.out.println("BInnerInterChild22");
	}
}
class BUser2{
	public static void main(String []args){
		B2.BInnerInter12 inter1 = new BInnerInterChild12();
		System.out.println(B2.BInnerInter12.I);
		inter1.m1();

		B2.BInnerInter22 inter2 = new BInnerInterChild22();
		System.out.println(B2.BInnerInter22.J);
		inter2.m2();
	}
}

class B3{
	interface BInnerInter13{
		int I=10;
		void m1();
	}
	static interface BInnerInter23{
		int J=20;
		void m2();
	}
}
class BInnerInterChild13 implements B3.BInnerInter13{
	public void m1(){
		System.out.println("BInnerInterChild13");
	}
}
class BInnerInterChild23 implements B3.BInnerInter23{
	public void m2(){
		System.out.println("23");
	}
}
class BUser3{
	public static void main(String []args){
		B3.BInnerInter13 inter1 = new BInnerInterChild13();
		System.out.println(B3.BInnerInter13.I);
		inter1.m1();

		B3.BInnerInter23 inter2 = new BInnerInterChild23();
		System.out.println(B3.BInnerInter23.J);
		inter2.m2();
	}
}
class B4{
	interface BInnerInter14{
		int I=10;
		void m1();
	}
	static interface BInnerInter24{
		int J=20;
		void m2();
	}
}
class BInnerInterChild14 implements B4.BInnerInter14{
	public void m1(){
		System.out.println("14");
	}
}
class BInnerInterChild24 implements B4.BInnerInter24{
	public void m2(){
		System.out.println("24");
	}
}
class BUser4{
	public static void main(String args[]){
		B4.BInnerInter14 inter1 = new BInnerInterChild14();
		System.out.println(B4.BInnerInter14.I);
		inter1.m1();

		B4.BInnerInter24 inter2 = new BInnerInterChild24();
		System.out.println(B4.BInnerInter24.J);
		inter2.m2();
	}
}

class B5{
	interface BInnerInter15{
		int I=10;
		void m1();
	}
	static interface BInnerInter25{
		int j=20;
		void m2();
	}
}
class BInnerInterChild15 implements B5.BInnerInter15{
	public void m1(){
		System.out.println("15");
	}
}
class BInnerInterChild25 implements B5.BInnerInter25{
	public void m2(){
		System.out.println("25);
	}
}
class BUser5{
	public static void main(String args[]){
		B5.BInnerInter15 inter1 = new BInnerInterChild15();
		System.out.println(B5.BInnerInter15.I);
		inter1.m1();

		B5.BInnerInter25 inter2 = new BInnerInterChild25();
		System.out.println(B5.BInnerInter25.J);
		inter2.m2();
	}
}