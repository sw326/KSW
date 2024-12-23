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

interface C1{
	interface CInnerInter11{
		int I=10;
		void m1();
	}
	static interface CInnerInter21{
		int J=20;
		void m2();
	}
}
class CInnerInterChild11 implements C1.CInnerInter11{
	public void m1(){
		System.out.println("11");
	}
}
class CInnerInterChild21 implements C1.CInnerInter21{
	public void m2(){
		System.out.println("21");
	}
}
class CUser1{
	public static void main(String args[]){
		C1.CInnerInter11 inter1 = new CInnerInterChild11();
		System.out.println(C1.CInnerInter11.I);
		inter1.m1();

		C1.CInnerInter21 inter2 = new CInnerInterChild21();
		System.out.println(C1.CInnerInter21.J);
		inter2.m2();
	}
}

class C2{
	interface CInner12{
		int I=10;
		void m1();
	}
	static interface CInner22{
		int J=20;
		void m2();
	}
}
class CInnerChild12 implements C2.CInner12{
	public void m1(){
		System.out.println("12");
	}
}
class CInnerChild22 implements C2.CInner22{
	public void m2(){
		System.out.println("22");
	}
}
class CUser2{
	public static void main(String args[]){
		C2.CInner12 in1 = new CInnerChild12();
		System.out.println(C2.CInner12.I);
		in1.m1();

		C2.CInner22 in2 = new CInnerChild22();
		System.out.println(C2.CInner22.J);
		in2.m2();
	}
}

class C3{
	interface CInner13{
		int I=10;
		void m1();
	}
	static interface CInner23{
		int J=20;
		void m2();
	}
}
class CInnerChild13 implements C3.CInner13{
	public void m1(){
		System.out.println("13");
	}
}
class CInnerChild23 implements C3.CInner23{
	public void m2(){
		System.out.println("23");
	}
}
class CUser3{
	public static void main(String args[]){
		C3.CInner13 in1 = new CInnerChild13();
		System.out.println(C3.CInner13.I);
		in1.m1();

		C3.CInner23 in2 = new CInnerChild23();
		System.out.println(C3.CInner23.J);
		in2.m2();
	}
}

class C4{
	interface CInner14{
		int I=10;
		void m1();
	}
	static interface CInner24{
		int J=20;
		void m2();
	}
}
class CInnerChild14 implements C4.CInner14{
	public void m1(){
		System.out.println("14");
	}
}
class CInnerChild24 implements C4.CInner24{
	public void m2(){
		System.out.println("24");
	}
}
class CUser4{
	public static void main(String args[]){
		C4.CInner14 in1 = new CInnerChild14();
		System.out.println(C4.CInner14.I);
		in1.m1();

		C4.CInner24 in2 = new CInnerChild24();
		System.out.println(C4.CInner24.J);
		in2.m2();
	}
}

class C5{
	interface CInner15{
		int I=10;
		void m1();
	}
	static interface CInner25{
		int J=20;
		void m2();
	}
}
class CInnerChild15 implements C5.CInner15{
	public void m1(){
		System.out.println("15");
	}
}
class CInnerChild25 implements C5.CInner25{
	public void m2(){
		System.out.println("25");
	}
}
class CUser5{
	public static void main(String args[]){
		C5.CInner15 in1 = new CInnerChild15();
		System.out.println(C5.CInner15.I);
		in1.m1();

		C5.CInner25 in2 = new CInnerChild25();
		System.out.println(C5.CInner25.J);
		in2.m2();
	}
}