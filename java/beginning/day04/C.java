class C
{
	void m1(){ //1~100
		// 1, 2, 3, ...............98, 99, 100
		int sum = 0;
		for(int i = 1; i<=100;i++){
			sum += i;
		}
		System.out.println("sum: " + sum);
	}
	void m2(){ // 1~100 짝수합, 홀수합
		int evenSum = 0;
		for(int i = 0;i <= 100; i+=2){
			evenSum += i;
		}
		System.out.println("even: " + evenSum);

		int oddSum = 0;
		for(int i = 1;i <= 100; i+=2){
			oddSum += i;
		}
		System.out.println("odd: " + oddSum);
	}

	void m3(){ // 1~100의 홀수합과 짝수합을 출력
		int even = 0;
		int odd = 0;
		for(int i = 0; i<=100;i++){
			if(i%2 == 0){ // 짝수
				even += i;
			}else{ // 홀수
				odd += i;
			}
		}
		System.out.println("전체 합: " + (even + odd));
	}
	public static void main(String[] args) 
	{
		C c = new C();
		// c.m1();
		// c.m2();
		c.m3();
	}
}
