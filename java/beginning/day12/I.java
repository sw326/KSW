class ITh extends Thread{
	public void run(){
		I.m();
	}
}

class I {
	static int i;

	I(){
		Thread th1 = new ITh();
		Thread th2 = new ITh();
		th1.start(); // JVM -> new 제어 -> run();
		th2.start();

		try{
			th1.join();
			th2.join();
		}catch(InterruptedException ie){}

		System.out.println("i: "+i);
	}
	synchronized static void m(){
		for(int j=0;j<100000000;j++){
			i++;
		}
	}
	public static void main(String[] args) {
		new I();
	}
}
