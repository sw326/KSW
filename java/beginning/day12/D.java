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