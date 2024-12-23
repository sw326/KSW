class A
{
	A(){ // 구구단에서 홀수단만 출력하시오.
		for(int i=2;i<=9;i++){
			if(i%2 !=0){
			// if(i%2 == 0) continue;
				for(int j=1;j<=9;j++){
					System.out.println(i+" * "+j+" = "+i*j);		
					if(j==5) break;
				}
				System.out.println();
			}
			//if(i==5) break;
			if(i==5) return;
		}
		System.out.println(" - END - ");
	}
	public static void main(String[] args) 
	{
		new A();
	}
}

class A1
{
	A1(){ // 구구단에서 홀수단만 출력하시오.
		for(int i=2;i<=9;i++){
			if(i%2 !=0){
				for (int j=1;j<=9;j++){
					System.out.println(i+" * "+j+" = "+i*j);
					if(j==5) break;
				}
				System.out.println();
			}
			if(i==5) break;
		}
		System.out.println("--END--");
	}
	public static void main(STring []args){
		new A1();
	}
}

class A2
{
	A2(){
		for(int i=2;i<=9;i++){
			if(i%2 !=0){
				for (int j=1;j<=9;j++){
					System.out.println(i*j);
					if(j==5) return;
				}
				System.out.println();
			}
			if(i==5) return;
		}
		System.out.println("END");
	}
	public static void main(String args[]){
		new A2();
	}
}

class A3
{
	A3(){
		for(int i=2;i<=9;i++){
			if(i%2 !=0){
				for(int j=1;j<=9;j++){
					System.out.println(i*j);
					if(j==5) return;
				}
				System.out.println();
			}
			if(i==5) break;
		}System.out.println("END");
	}
	public static void main(String[] args){
		new A3();
	}
}

class A4
{
	A4(){
		for(int i = 2; i<=9;i++){
			if(i%2 !=0){
				for(int j=1;j<=9;j++){
					System.out.println(i*j);
					if(j==5) break;
				}
				System.out.println();
			}
			if(i==5) return;
		}
		System.out.println("END");
	}
	public static void main(String[] args){
		new A4();
	}
}

class A5
{
	A5(){
		for(int i = 2; i<=9;i++){
			if(i%2 !=0){
				for(int j=1;j<=9;j++){
					System.out.println(i*j);
					if(j==5) break;
				}
				System.out.println();
			}
			if(i==5) return;
		}
		System.out.println("END");
	}public static void main(String[] args){
		new A5();
	}
}