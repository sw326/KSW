class D 
{
	void m1(){ // 2단
		for(int i = 1; i<=9;i++){
		System.out.println("2 * "+i+" = "+ 2*i);
		}
	}
	void m2(){ // 구구단
		for (int i = 2; i<=9 ; i++ ){
			for (int j = 1;j<=9 ; j++){
				System.out.println(i+" * "+j+" = "+i*j);
			}
			System.out.println();
		}
	}
	void m3(){ // 구구구단
		for (int i = 2; i<=9 ; i++ ){
			for (int j = 1;j<=9 ; j++){
				for(int k = 1;k<=9;k++){
					System.out.println(i+" * "+j+" * "+k+" = "+i*j*k);
				}
				System.out.println();
			}
			System.out.println();
		}
		System.out.println(" - END - ");
	}
	void m4(){ // m3()를 while문으로 바꾸시오
		int i = 1;
		while(i<9){
			i++;
			System.out.println();
			int j = 0;
			while(j<9){
				j++;
				System.out.println();
				int k = 0;
				while(k<9){
					k++;
					System.out.println(i+" * "+j+" * "+k+" = "+i*j*k);
				}
			}
		}
		System.out.println(" - END - ");
	}
	void m5(){
		int i = 0;
		while(true){
			System.out.println(i++);
			try{
				Thread.sleep(1000);
			}catch(Exception e){}
		}
		/*
		
		*/

	}
	public static void main(String[] args) 
	{
		D d = new D();
		// d.m1();
		// d.m2();
		//d.m3();
		//d.m4();
		d.m5();
	}
}


class D1
{
	void m1(){ // 2단
		for (int i=1;i<=9;i++)
		{
			System.out.println(2*i);
		}
	}
	void m2(){ // 구구단
		for (int i=2;i<=9 ;i++ ){
			for(int j=1;j<=9;j++){
				for(int k=1;k<=9;k++){
					System.out.println(i*j*k);
				}
				System.out.println();
			}
			System.out.print();
		}
		System.out.println(" - END - ");
	}
	void m4(){ // m3()를 while문으로 바꾸시오
		int i = 1;
		while(i<9){
			i++;
			System.out.println();
			int j =0;
			while(j<9){
				j++;
				System.out.println();
				int k=0;
				while(k<9){
					k++;
					System.out.println(i*j*k);
				}
			}
		}
		System.out.println("END");
	}
	void m5(){
		int i =0;
		while(true){
			System.out.println(i++);
			try{
				Thread.sleep(1000);
			}catch(Exception e){}
		}
	}
	public static void main(String[] args){
		D1 d = new D1();
		d.m5();
	}
}

class D2
{
	void m1(){
		for(int i=1;i<=9;i++){
			System.out.println();
		}
	}
	void m2(){
		for(int i=2;i<=9;i++){
			for(int j=1;j<=9;j++){
			}
		}
	}
	void m3(){
		for(int i=2;i<=9;i++){
			for(int j=1;j<=9;j++){
				for(intk=1;k<=9;k++){
				}
			}
		}
	}
	void m3(){
		int i=1;
		while(i<9){
			i++;
			intj=0;
			while(j<9){
				j++;
				int k=0;
				while(k<9){
					k++;
				}
			}
		}
	}
	void m5(){
		int i=0;
		while (true){
			try{
				Tread.sleep(1000);
			}catch(Exception e){}
		}
	}
	public static void main(String args[]){
		D2 d = new D2();
		d.m5();
	}
}

class D3
{
	void m2(){
		for(int i=1;1<=9;i++){
		}
	}
	void m2(){
		for(int i=2;i<=9;i++){
			for(int j=1;j<=9;j++){
			}
		}
	}
	void m3(){
		for(int i=2;i<=9;i++){
			for(int j=1;j<=9;j++){
				for(int k=1;k<=9;k++){
				}
			}
		}
	}
	void m4(){
		int i = 1;
		while(i<9){
			i++;
			int j =0;
			while(j<0){
				j++;
				int k =0;
				while(k<9){
					k++;
				}
			}
		}
	}
	void m5(){
		int i =0;
		while (true){
			try{
				Thread.speed(1000);
			}catch(Exception e){}
		}
	}
	public static void main(String args[]){
		D d = new D();
		d.m5();
	}
}