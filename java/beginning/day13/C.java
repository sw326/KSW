class RunChild implements Runnable{
	public void run(){
		while(true){
			System.out.println("일1");
			try{Thread.sleep(1000);}catch(Exception e){}
		}
	}
}

class C {
	void use1(){
		Runnable r = new RunChild();
		Thread t = new Thread(r);
		t.start();
	}
	void use2(){
		Runnable r = new Runnable(){
			public void run(){
				while(true){
					System.out.println("일2");
					try{Thread.sleep(1000);}catch(Exception e){}
				}
			}
		};
		Thread t = new Thread(r);
		t.start();
	}
	void use3(){
		Runnable r = () -> {
			while(true){
				System.out.println("일3");
				try{Thread.sleep(1000);}catch(Exception e){}
			}
		};
		Thread t = new Thread(r);
		t.start();
	}
	void use4(){
		Runnable r = () -> work();
		Thread t = new Thread(r);
		t.start();
	}
	void work(){
		while(true){
			System.out.println("Work");
			try{Thread.sleep(1000);}catch(Exception e){}
		}
	}
	void use5(){
		new Thread(() -> {
			while(true){
				System.out.println("Work");
				try{Thread.sleep(1000);}catch(Exception e){}
			}
		}).start();
	}
	void use6(){
		new Thread(() -> work()).start();
	}
	public static void main(String[] args){
		C c = new C();
		//c.use1();
		//c.use2();
		//c.use3();
		//c.use4();
		c.use5();
	}
}
