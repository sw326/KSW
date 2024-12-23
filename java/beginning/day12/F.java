class FTh1 implements Runnable { //서빙을 하는 쓰레드
	public void run(){ //고용인하는 일
		int i = 0; 
		while(true){
			System.out.println("서빙을 한다: " + i++);
			try{
				Thread.sleep(1000);
			}catch(InterruptedException ie){}
		}
	}
}
class FTh2 extends Thread {
	public void run(){ //고용인하는 일
		int i = 0; 
		while(true){
			System.out.println("요리를 한다: " + i++);
			try{
				Thread.sleep(2000);
			}catch(InterruptedException ie){}
		}
	}
}
class F  {
	F(){
		Runnable r = new FTh1();
		new Thread(r).start();
		new FTh2().start();
		int i = 0; 
		while(true){
			System.out.println("돈을 받는다: " + i++);
			try{
				Thread.sleep(3000);
			}catch(InterruptedException ie){}
		}
	}
	public static void main(String[] args) {
		new F();
	}
}