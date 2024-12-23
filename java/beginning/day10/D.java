class D {
	static int i; //1개
	int j; //2개
	void m(){
		i++;
		j++;
	}
	void show(){
		System.out.println("i: " + i);
		System.out.println("j: " + j);
	}
	public static void main(String[] args) {
		D d1 = new D();
		d1.m();
		D d2 = new D();
		d2.m();

		d2.show();
		//System.out.println("i: " + d2.i);
		//System.out.println("j: " + d1.j);
	}
}