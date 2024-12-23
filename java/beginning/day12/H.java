class HTh1 extends Thread {
	@Override
	public void run(){
		for(int i=0; i<10; i++){
			System.out.println("i: " + i);
			this.yield();
		}
	}
}
class HTh2 extends Thread {
	@Override
	public void run(){
		for(int j=0; j<10; j++){
			System.out.println("j: " + j);
			this.yield();
		}
	}
}
class H {
	public static void main(String[] args) {
		Thread th1 = new HTh1();
		Thread th2 = new HTh2();
		
		th1.setPriority(Thread.MAX_PRIORITY);
		th2.setPriority(Thread.MIN_PRIORITY);
		int p1 = th1.getPriority();
		int p2 = th2.getPriority();
		System.out.println("p1: " + p1 + ", p2: " + p2);

		th1.start();
		th2.start();

		try{
			th1.join();
			th2.join();
		}catch(InterruptedException ie){}

		System.out.println("main() 끝");
	}
}