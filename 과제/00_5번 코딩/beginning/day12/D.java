class D {
	private int i;
	private void m(){
		System.out.println("m()");
	}
	class DInter{
		void use(){
			System.out.println("i: "+i);
			m();
		}
	}
}
class DUser {
	public static void main(String args[]){
		D.DInter in = new D().new DInter();
		in.use();
	}
}

class D1{
	private int i;
	private void m(){
		System.out.println("m()");
	}
	class DInter1{
		void use(){
			System.out.println("i: "+i);
			m();
		}
	}
}
class DUser1{
	public static void main(String args[]){
		D1.DInter1 in = new D1().new DInter1();
		in.use();
	}
}

class D2{
	int i;
	void m(){
		System.out.println("m()");
	}
	class DInter2{
		void use(){
			System.out.println(i);
			m();
		}
	}
}
class DUser2{
	public static void main(String args[]){
		D2.DInter2 in = new D2().new DInter2();
		in.use();
	}
}

class D3{
	private int i;
	private void m(){
		System.out.println("m()");
	}
	class DInner3{
		void use(){
			System.out.println(i);
			m();
		}
	}
}
class DUser3{
	public static void main(String args[]){
		D3.DInner3 in = new D3().new DInner3();
		in.use();
	}
}

class D4{
	private int i;
	private void m(){
		System.out.println("m()");
	}
	class DInner4{
		void use(){
			System.out.println(i);
			m();
		}
	}
}
class DUser4{
	public static void main(String args[]){
		D4.DInner4 in = new D4().new DInner4();
		in.use();
	}
}

class D5 {
	private int i;
	private void m(){
		System.out.println("m()");
	}
	class DInner5{
		void use(){
			System.out.println(i);
			m();
		}
	}
}
class DUser5{
	public static void main(String args[]){
		D5.DInner5 in = new D5().new DInner5();
		in.use();
	}
}