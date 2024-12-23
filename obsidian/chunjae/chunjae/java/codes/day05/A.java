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
