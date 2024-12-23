class G {
	void m(){
		System.out.println("Thread.MAX_PRIORITY: " + Thread.MAX_PRIORITY);
		System.out.println("Thread.MIN_PRIORITY: " + Thread.MIN_PRIORITY);
		System.out.println("Thread.NORM_PRIORITY: " + Thread.NORM_PRIORITY);
	}
	public static void main(String[] args) {
		new G().m();
	}
}