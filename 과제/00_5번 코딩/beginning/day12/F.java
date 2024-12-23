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

class FTh11 implements Runnable{
	public void run(){
		int i=0;
		while(true){
			System.out.println("Serve: " + i++);
			try{
				Thread.sleep(1000);
			}catch(InterruptedException ie){}
		}
	}
}
class FTh21 extends Thread{
	public void run(){
		int i=0;
		while(true){
			System.out.println("Cook: "+i++);
			try{
				Thread.sleep(2000);
			}catch(InterruptedException ie){}
		}
	}
}
class F1{
	F1(){
		Runnable r = new FTh11();
		new Thread(r).start();
		new FTh21().start();
		int i = 0;
		while(true){
			System.out.println("Get Money: "+ i++);
			try{
				Thread.sleep(3000);
			}catch(InterruptedException ie){}
		}
	}
	public static void main(String []args){
		new F1();
	}
}

class FTh12 implements Runnable{
	public void run(){
		int i = 0;
		while(true){
			System.out.println("Serve: " +i++);
			try{
				Thread.sleep(1000);
			}catch(InterruptedException ie){}
		}
	}
}
class FTh22 extends Thread {
	public void run(){
		int i=0;
		while(true){
			System.out.println("Cook: "+i++);
			try{
				Thread.sleep(2000);
			}catch(InterruptedException ie){}
		}
	}
}
class F2{
	F2(){
		Runnable r = new FTh12();
		new Thread(r).start();
		new FTh22().start();
		int i = 0;
		while(true){
			System.out.println("get Money: "+ i++);
			try{
				Thread.sleep(3000);
			}catch(InterruptedException ie){}
		}
	}
	public static void main(String args[]){
		new F2();
	}
}

class FTh13 implements Runnable{
	public void run(){
		int i = 0;
		while (true){
			System.out.println("Serve: "+i++);
			try{
				Thread.sleep(1000);
			}catch(InterruptedException ie){}
		}
	}
}
class FTh23 extends Thread{
	public void run(){
		int i=0;
		while(true){
			System.out.println("Cook: "+ i++);
			try{
				Thread.sleep(2000);
			}catch(InterruptedException ie){}
		}
	}
}
class F3{
	F3(){
		Runnable r = new FTh13();
		new Thread(r).start();
		new FTh23().start();
		int i = 0;
		while(true){
			System.out.println("Get Money: "+i++);
			try{
				Thread.sleep(3000);
			}catch(InterruptedException ie){}
		}
	}
	public static void main(String args[]){
		new F3();
	}
}

class FTh14 implements Runnable{
	public void run(){
		int i=0;
		while(true){
			System.out.println("Serve :"+i++);
			try{
				Thread.sleep(1000);
			}catch(InterruptedException ie){}
		}
	}
}
class FTh24 extends Thread{
	public void run(){
		int i=0;
		while(true){
			System.out.println("Cook: "+i++);
			try{
				Thread.sleep(1000);
			}catch(InterruptedException ie){}
		}
	}
}
class F4{
	F4(){
		Runnable r = new FTh14();
		new Thread(r).start();
		new FTh24().start();
		int i = 0;
		while(true){
			System.out.println("Get Money: "+i++);
			try{
				Thread.sleep(3000);
			}catch(InterruptedException ie){}
		}
	}
	public static void main(String args[]){
		new F4();
	}
}

class FTh15 implements Runnable{
	public void run(){
		int i=0;
		while(true){
			System.out.println("Serve: "+i++);
			try{
				Thread.sleep(1000);
			}catch(InterruptedException ie){}
		}
	}
}
class FTh25 extends Thread {
	public void run(){
		int i=0;
		while(true){
			System.out.println("COOK: "+i++);
			try{
				Thread.sleep(2000);
			}catch(InterruptedException ie){}
		}
	}
}
class F5{
	F5(){
		Runnable r = new FTh15();
		new Thread(r).start();
		new FTh25().start();
		int i=0;
		while(true){
			System.out.println("GET MONEY: "+i++);
			try{
				Thread.sleep(3000);
			}catch(InterruptedException ie){}
		}
	}
	public static void main(String args[]){
		new F5();
	}
}