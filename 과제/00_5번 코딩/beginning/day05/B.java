class B
{
	void m1(){ // break
		aa:
		for(int j=0;j<3;j++){
			for(int i=0;i<5;i++){
				//if(i==3) break; // 안 for밖
				if(i==3) break aa; // 밖 for밖
				System.out.println("i: " + i);
			}//1
			System.out.println("안 for밖");
		}//2
		System.out.println("밖 for밖");
	}
	void m2(){
		char c = 'B';
		switch(c){
			case 'A': System.out.println("A"); break;
			case 'B': 
				int i = 20;
				switch(i){
					case 10: System.out.println("10"); break;
					case 20: System.out.println("20"); break;
					default: System.out.println("Not 10 or 20");
				}
				System.out.println("안 switch밖");
				break;
			default: System.out.println("Not A or B");
		}
		System.out.println("밖 switch밖");
	}
	void m3(){ //m2()를 if문으로 변경
		char c = 'A';
		if(c=='A'){
			System.out.println("A");
		}else if(c=='B'){
			int i = 20;
			if(i == 10){
				System.out.println("10");
			}else if(i == 20){
				System.out.println("20");
			}else{
				System.out.println("Not 10 or 20");
			}
			System.out.println("안 if밖");
		}else{
			System.out.println("Not A or B");
		}
		System.out.println("밖 if밖");
	}
	public static void main(String[] args) 
	{
		B b = new B();
		b.m3();
		System.out.println("main의 끝");
	}
}

class B1
{
	void m1(){
		aa:
		for(int j=0;j<3;j++){
			for(int i=0;i<5;i++){
				if(i==3) break aa;
				System.out.println(i);
			}
			System.out.println("안, 밖");
		}
		System.out.println("밖, 밖");
	}
	void m2(){
		char c = 'B';
		switch(c){
			case 'A': System.out.println("A"); break;
			case 'B':
				int i = 20;
				switch(i){
					case 10: System.out.println("10"); break;
					case 20: System.out.println("20"); break;
					default: System.out.println("Not 10 or 20");
				}
				System.out.println("안, 밖");
				break;
			default: System.out.println("Not A or B");
		}
		System.out.println("밖, 밖");
	}
	void m3(){
		char c ='A';
		if(c=='A'){
			System.out.println("A");
		}else if(c=='B'){
			int i= 20;
			if(i == 10){
				System.out.println("10");
			}else if(i == 20){
				System.out.println("20");
			}else{
				System.out.println("Not 10 or 20");
			}
			System.out.println("안 밖");
		}else{
			System.out.println("Not A or B");
		}
		System.out.println("밖 밖");
	}
	public static void main(String args[]){
		B1 b = new B1();
		b.m3();
		System.out.println("main");
	}
}

class B2
{
	void m1(){
		aa:
		for(int j=0;j<3;j++){
			for(int i=0;i<5;i++){
				if(i==3) break aa;
				System.out.println(i);
			}
			System.out.println("안 밖");
		}
		System.out.println("밖 밖");
	}
	void m2(){
		char c = 'B';
		switch(c){
			case 'A': System.out.println("10"); break;
			case 'B':
				int i = 20;
				switch(i){
					case 10: System.out.println("10"); break;
					case 20: System.out.println("20"); break;
					default: System.out.println("Not 10 or 20");
				}
				System.out.println("안 밖");
				break;
			default: System.out.println("Not A or B");
		}
		System.out.println("밖 밖");
	}
	void m3(){
		char c = 'A';
		if(c=='A'){
			System.out.println("A");
		}else if(c=='B'){
			int i=20;
			if(i==10){
				System.out.println("10");
			}else if(1==20){
				System.out.println("20");
			}else{
				System.out.println("Not 10 or 20");
			}
			System.out.println("안 밖");
		}else{
			System.out.println("Not A or B");
		}
		System.out.println("밖 밖");
	}
	public static void main(String args[]){
		B2 b = new B2();
		b.m3();
		System.out.println();
	}
}
