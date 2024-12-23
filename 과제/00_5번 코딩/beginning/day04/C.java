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

class C1
{
	void m1() { // 1~100
		// 1, 2, 3, ........... 98, 99, 100
		int sum = 0;
		for(int i = 1; i<=100;i++){
			sum += i;
		}
		System.out.println(sum);
	}
	void m2(){ // 1~100 짝수함, 홀수함
		int evenSum = 0;
		for(int i = 0;i<=100;i+=2{
			evenSum += i;
		}
		System.out.println(evenSum);

		int oddSum = 0;
		for(int i =1;i<=100;i+=2){
			oddSum +=i;
		}
		System.out.println(oddSum);
	}
	void m3(){ // 1~100의 홀수합과 짝수합을 출력
		int even=0;
		int odd=0;
		for(int i=0;i<=100;i++){
			if(i%2==0){ // 짝수
				even +=i;
			}else{ // 홀수
				odd += i;
			}
		}
		System.out.println(even + odd);
	}
	public static void main(String[] args){
		C1 c = new C1();
		c.m1();
		c.m2();
		c.m3();
	}
}

class C2
{
	void m1(){ // 1~100
		int sum = 0;
		for(int i=1;i<=100;i++){
			sum+=i;
		}
		System.out.println(sum);
	}
	void m2(){ // 1~100 짝수합, 홀수합
		int evenSum=0;
		for(int i=0;i<=100;i+=2){
			evenSum+=i;
		}
		System.out.println(evenSum);
		int oddSum=0;
		for(int i=1;i<=100;i+=2){
			oddSum+=i;
		}
		System.out.println(oddSum);
	}
	void m3(){ // 1~100의 홀수합과 짝수합을 출력
		int even=0;
		int odd=0;
		for(int i=0;i<=100;i++){
			if(i%2==0){ // 짝수
				even+=i;
			}else{ // 홀수
				odd+=i;
			}
		}
		System.out.println(even+odd);
	}
	public static void main(String[] args){
		C2 c = new C2();
		c.m1();
		c.m2();
		c.m3();
	}
}

class C3
{
	void m1(){
		int sum=0;
		for(int i=1;i<=100;i++){
			sum+=i;
		}
		System.out.println(sum);
	}
	void m2(){
		int evenSum=0;
		for(int i=0;i<=100;i+=2){
			evenSum+=i;
		}
		System.out.println(evenSum);
	}
	void m3(){
		int even=0;
		int odd=0;
		for(int i=0;i<=100;i++){
			if(i%2==0){
				even+=i;
			}else{
				odd+=i;
			}
		}
		System.out.println(even+odd);
	}
	public static void main(String[] args){
		C3 c = new C3();
		c.m1();
		c.m2();
		c.m3();
	}
}

class C4
{
	void m1(){
		int sum=0;
		for(int i=1;i<=100;i++){
			sum+=i;
		}
		System.out.println(sum);
	}
	void m2(){
		int evenSum=0;
		for(int i=0;i<=100;i+=2){
			evenSum+=i;
		}
		System.out.println(evenSum);
	}
	void m3(){
		int even=0;
		int odd=0;
		for(int i=0;i<=100;i++){
			if(i%2==0){
				even+=i;
			}else{
				odd+=i;
			}
		}
		System.out.println(even+odd);
	}
	public static void main(String[] args){
		C4 c = new C4();
	}
}

class C5
{
	void m1(){
		int sum =0;
		for(int i=1;i<=100;i++){
			sum+=i;
		}
		System.out.println(sum);
	}
	void m2(){
		int evenSum=0;
		for(int i=0;i<=100;i+=2){
			evenSum+=i;
		}
		System.out.println(evenSum);
	}
	void m3(){
		int even=0;
		int odd=0;
		for(int i=0;i<=100;i++){
			if(i%2==0){
				even+=i;
			}else{
				odd+=i;
			}
		}
		System.out.println(even+odd);
	}
	public static void main(String[] args){
		C5 c = new C5();
	}
}