abstract class E {
	abstract void m2();
}
class EChild extends E{
	void m1(){
		System.out.println("m1()");
	}
	@Override
	void m2(){
		System.out.println("m2()");
	}
}
class EUser{
	public static void main(String args[]){
		E e = new EChild();
		e.m2();
	}
}