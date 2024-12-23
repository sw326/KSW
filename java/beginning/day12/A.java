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