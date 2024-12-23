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

class ITh1 extends Thread{
	public void run(){
		I1.m();
	}
}
class I1{
	static int i;
	I1(){
		Thread th1=new ITh1();
		Thread th2=new ITh1();
		th1.start();
		th2.start();
		try{
			th1.join();
			th2.join();
		}catch(InterruptedException ie){}
		System.out.println(i);
	}
	synchronized static void m(){
		for(int j=0;j<1000000;j++){
			i++;
		}
	}
	public static void main(String args[]){
		new I1();
	}
}

class ITh2 extends Thread{
	public void run(){
		I2.m();
	}
}
class I2{
	static int i;
	I2(){
		Thread th1=new ITh2();
		Thread th2=new ITh2();
		th1.start();
		th2.start();
		try{
			th1.join();
			th2.join();
		}catch(InterruptedException ie){}
		System.out.println(i);
	}
	synchronized static void m(){
		for(int j=0;j<10000;j++){
			i++;
		}
	}
	public static void main(String args[]){
		new I2();
	}
}
class ITh3 extends Thread{
	public void run(){
		I3.m();
	}
}
class I3{
	static int i;
	I3(){
		Thread th1=new ITh3();
		Thread th2=new ITh3();
		th1.start();
		th2.start();
		try{
			th1.join();
			th2.join();
		}catch(InterruptedException ie){}
		System.out.println(i);
	}
	synchronized static void m(){
		for(int j=0;j<1000;j++){
			i++;
		}
	}
	public static void main(String args[]){
		new I3();
	}
}

class ITh4 extends Thread{
	public void run(){
		I4.m();
	}
}
class I4{
	static int i;
	I4(){
		Thread th1=new ITh4();
		Thread th2=new ITh4();
		th1.start();
		th2.start();
		try{
			th1.join();
			th2.join();
		}catch(InterruptedException ie){}
		System.out.println(i);
	}
	synchronized static void m(){
		for(int j=0;j<10000;j++){
			i++;
		}
	}
	public static void main(String args[]){
		new I4();
	}
}

class ITh5 extends Thread{
	public void run(){
		I5.m();
	}
}
class I5{
	static int i;
	I5(){
		Thread th1=new ITh5();
		Thread th1=new ITh5();
		th1.start();
		th2.start();
		try{
			th1.join();
			th2.join();
		}catch(InterruptedException ie){}
		System.out.println(i);
	}
	synchronized static void m(){
		for(int j=0;j<10000;j++){
			i++;
		}
	}
	public static void main(String args[]){
		new I5();
	}
}