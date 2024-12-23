class A {
	class AInner1 {
		int i;
		void m1(){
			System.out.println("AInner m()");
		}
		/*
		public static void main(String[] args) {
			A.AInner1 in1 = new A().new AInner1();
			System.out.println("in1.i: " + in1.i);
			in1.m1();

			A.AInner2 in2 = new A.AInner2();
			System.out.println("in2.j: " + in2.j);
			in2.m2();	
		}*/
	}
	static class AInner2 {
		int j;
		void m2(){
			System.out.println("AInner m()");
		}
		public static void main(String[] args) {
			A.AInner1 in1 = new A().new AInner1();
			System.out.println("in1.i: " + in1.i);
			in1.m1();

			A.AInner2 in2 = new A.AInner2();
			System.out.println("in2.j: " + in2.j);
			in2.m2();	
		}
	}
	/*
	public static void main(String[] args) {
		A.AInner1 in1 = new A().new AInner1();
		System.out.println("in1.i: " + in1.i);
		in1.m1();

		A.AInner2 in2 = new A.AInner2();
		System.out.println("in2.j: " + in2.j);
		in2.m2();	
	}*/
}
/*
class AUser{
	public static void main(String[] args) {
		A.AInner1 in1 = new A().new AInner1();
		System.out.println("in1.i: " + in1.i);
		in1.m1();

		A.AInner2 in2 = new A.AInner2();
		System.out.println("in2.j: " + in2.j);
		in2.m2();	
	}
}
*/

class A1{
	class AInner11{
		int i;
		void m1(){
			System.out.println();
		}
	}
	static class AInner21{
		int J;
		void m2(){
			System.out.println();
		}
	}
}
class AUser1{
	public static void main(String args[]){
		A1.AInner11 in1 = new A1().new AInner11();
		System.out.println();
		in1.m1();

		A1.AInner21 in2 = new A1.AInner21();
		System.out.println();
		in2.m2();
	}
}

class A2{
	class AInner12{
		int i;
		void m1(){
			System.out.println();
		}
	}
	class AInner22{
		int j;
		void m2(){
			System.out.println();
		}
	}
	public static void main(String args[]){
		A2.AInner12 in1 = new A2().new AInner12();
		System.out.println();
		in1.m1();

		A2.AInner22 in2 = new A2().new AInner22();
		in2.m2();
	}
}

class A3{
	class AInner13{
		int i;
		void m1(){
			System.out.println();
		}
		public static void main(String args[]){
			A3.AInner13 in1 = new A3().new AInner13();
			System.out.println();
			in1.m1();

			A3.AInner23 in2 = new A3().new AInner23();
			in2.m2();
		}
	}
	class AInner23{
		int j;
		void m2(){
			System.out.println();
		}
	}
}

class A4{
	class AInner14{
		int i;
		void m1(){
			System.out.println();
		}
	}
	class AInner24{
		int j;
		void m2(){
			System.out.println();
		}
		public static void main(String []args){
			A4.AInner14 in1 = new A4().new AInner14();
			System.out.println("in1.i: "+in1.i);
			in1.m1();

			A4.AInner24 in2 = new A4().new AInner24();
			System.out.println("in2.j: "+in2.j);
			in2.m2();
		}
	}
}

class A5{
	class AInner15{
		int i;
		void m1(){
			System.out.println();
		}
		public static void main(String []args){
			A5.AInner15 in1 = new A5().new AInner15();
			System.out.println("i: "+in1.i);
			in1.m1();

			A5.AInner25 in2 = new A5().new AInner25();
			System.out.println("j: "+in2.j);
			in2.m2();
		}
	}
	class AInner25{
		int j;
		void m2(){
			System.out.println();
		}
	}
}