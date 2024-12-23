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
