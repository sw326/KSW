import a.b.C;
import a.b.CChild;

class CUser {
	public static void main(String args[]){
		C c = new CChild();
		System.out.println("C.I: " + C.I);
		c.m1(); //추상메소드 호출
		C.m2(); //static메소드 호출
		c.m3(); //default메소드 호출 
	}
}