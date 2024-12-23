class G 
{
	// +, -, *, /, %, ++, --, =, ==, &, |, <, >
	void m1(){ // 1)산술 ex) +, -, *, /, %
		double i = 5/3.0;
		int j = 5%3;
		System.out.println("i: "+i+" j: "+j);
	}
	void m2(){ // 2) 증감 ex) ++, --
		int i=1;
		int j=1 + ++i;
		System.out.println("i: "+i+" j: "+j);
	}
	void m3(){ // 4) 산술대입 ex) +=, -=, *=, /=, %=
		int j=0;
		j%=2;
		System.out.println("j: "+j);
	}
	void m4(){ // 5) 비트 ex) &, |, ~, 시프트( <<, >>, <<< )
		int i = 3; // 11
		int j = 2; // 10
		int k = i & j;
		System.out.println("k: "+k);
	}
	void m5(){ // 6) 비교 ex) `==`, !=, <, >, <=, >=
		int i = 1;
		if(i<=1){
			System.out.println("operate");
		}
	}
	void m6(){ // 7) 논리 ex) &, &&, |, ||
		int i = 1;
		int j = 1;
		//boolean flag = true && i<0;
		//boolean flag1 = true || i<0;
		boolean flag2 = i==1 | i--<0; // 결과가 나와도 뒤까지 연산
		System.out.println("flag: " + flag2 + ", i: " +i);
		boolean flag3 = j==1 || j--<0; // 결과가 나오면 뒤는 연산하지 않음( 지름길 효과 )
		System.out.println("flag: " + flag3 + ", j: " +j);
	}
	void m7(){ // 8) 논리대입 ex) &=, |=

		boolean flag = true;
		flag &= true;
		System.out.println(flag);
	}

	void m8(){ // 9) 조건 ex) A? b : C
		int i = 1 < 0 ? 100:200;
		System.out.println(i);
	}
	void m9(){ // 10) instanceof ex) 객체 instanceof 클래스
		Object str = new String("봄"); // JVM
		if(str instanceof String){
			String result = (String)str; // 개발자
			System.out.println(result);
		}
	}
	public static void main(String[] args) 
	{
		G g = new G();
		//g.m1();
		//g.m2();
		g.m9();
	}
}


class G1
{
	void m1(){
		double i = 5/3.0;
		int j = 5%3;
		System.out.println(i+j);
	}
	void m2(){
		int i=1;
		int j=1 + ++i;
		System.out.println(i+j);
	}
	void m3(){
		int j=0;
		j%=2;
		System.out.println(j);
	}
	void m4(){
		int i=3;
		int j= 2;
		int k=i&j;
		System.out.println(k);
	}
	void m5(){
		int i=1;
		if(i<=1){
			System.out.println("go");
		}
	}
	void m6(){
		int i=1;
		intj=1;
		booleanflag = i=1 || i--<0;
		System.out.println(flag + i);
	}
	void m7(){
		boolean flag=true;
		flag&=true;
		System.out.println(flag);
	}
	void m8(){
		int i = 1< 0? 100:200;
		System.out.println(i);
	}
	void m9(){
		Object str = new String("spring");
		if(str instanceof String){
			String result = (String)str;
			System.out.println(result);
		}
	}
	public static void main(String args[]){
		G1 g= new G1();
		g.m9();
	}
}