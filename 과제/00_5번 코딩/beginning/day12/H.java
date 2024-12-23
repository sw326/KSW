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

class HTh11 extends Thread{
	@Override
		public void run(){
		for(int i=0;i<10;i++){
			System.out.println(i);
			this.yield();
		}
	}
}
class HTh21 extends Thread{
	@Override
		public void run(){
		for(int j=0;j<10;j++){
			System.out.println(j);
			this.yield();
		}
	}
}
class H1{
	public static void main(String[] args){
		Thread th1 = new HTh11();
		Thread th2 = new HTh21();

		th1.setPriority(Thread.MAX_PRIORITY);
		th2.setPriority(Thread.MIN_PRIORITY);
		int p1 = th1.getPriority();
		int p2 = th2.getPriority();
		System.out.println("p1: "+p1+", p2: " +p2);
		th1.start();
		th2.start();
		try{
			th1.join();
			th2.join();
		}catch(InterruptedException ie){}
		System.out.println("main() end");
	}
}

class HTh12 extends Thread{
	@Override
		public void run(){
		for(int i=0;i<10;i++){
			System.out.println(i);
			this.yield();
		}
	}
}
class HTh22 extends Thread{
	@Override public void run(){
		for(int j=0;j<10;j++){
			System.out.println(j);
			this.yield();
		}
	}
}
class H2{
	public static void main(String args[]){
		Thread th1=new HTh12();
		Thread th2=new HTh22();
		th1.setPriority(Thread.MAX_PRIORITY);
		th2.setPriority(Thread.MIN_PRIORITY);
		int p1=th1.getPriority();
		int p2=th2.getPriority();
		System.out.println(p1+p2);
		th1.start();
		th2.start();
		try{
			th1.join();
			th2.join();
		}catch(InterruptedException ie){}
		System.out.println("main end");
	}
}

class HTh13 extends Thread{
	@Override
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println(i);
			this.yield();
		}
	}
}
class HTh23 extends Thread{
	@Override
	public void run(){
		for(int j=0;j<10;j++){
			System.out.println(j);
			this.yield();
		}
	}
}
class H3{
	public static void main(String args[]){
		Thread th1=new HTh13();
		Thread th2=new HTh23();
		th1.setPriority(Thread.MAX_PRIORITY);
		th2.setPriority(Thread.MIN_PRIORITY);
		int p1=th1.getPriority();
		int p2=th2.getPriority();
		System.out.println(p1+p2);
		th1.start();
		th2.start();
		try{
			th1.join();
			th2.join();
		}catch(InterruptedException ie){}
		System.out.println("main end");
	}
}

class HTh14 extends Thread{
	@Override
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println(i);
			this.yield();
		}
	}
}
class HTh24 extends Thread{
	@Override
	public void run(){
		for(int j=0;j<10;j++){
			System.out.println(j);
		}
	}
}
class H4{
	public static void main(String args[]){
		Thread th1=new HTh14();
		Thread th2=new HTh24();
		th1.setPriority(Thread.MAX_PRIORITY);
		th2.setPriority(Thread.MIN_PRIORITY);
		int p1=th1.getPriority();
		int p2=th2.getPriority();
		System.out.println(p1+p2);
		th1.start();
		th2.start();
		try{
			th1.join();
			th2.join();
		}catch(InterruptedException ie){}
		System.out.println("main end");
	}
}

class HTh15 extends Thread{
	@Override
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println(i);
			this.yield();
		}
	}
}
class HTh25{
	@Override
	public void run(){
		for(int j=0;j<10;j++){
			System.out.println(j);
			this.yield();
		}
	}
}
class H5{
	public static void main(String args[]){
		Thread th1=new HTh15();
		Thread th2=new HTh25();
		th1.setPriority(Thread.MAX_PRIORITY);
		th2.setPriority(Thread.MIN_PRIORITY);
		int p1=th1.getPriority();
		int p2=th2.getPriority();
		System.out.println(p1+p2);
		th1.start();
		th2.start();
		try{
			th1.join();
			th2.join();
		}catch(InterruptedException ie){}
	}
}