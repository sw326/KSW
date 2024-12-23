class A1
{
	int i = 1; // 객체변수(전역==맴버)
	static int ii = 2; // 클래스변수(전역==맴버)
	A1(int k){ // 지역
		int j = 3; // 지역
		System.out.println("A1() j: " + j);
		System.out.println("A1() k: " + k);
	}
	void m(){
		System.out.println("m() i: " + i);
		// System.out.println("A1() j: " + j);
		// System.out.println("A1() k: " + k);
	}
	public static void main(String[] args) 
	{
		A1 a = new A1(4);
		a.m();
		System.out.println("main() i: " + a.i);
		System.out.println("main() ii: " + A1.ii);
	}
}

class A2
{
	int i = 1;// 맴버/객체/변수/기본
	static int ii = 2; // 맴버/클래스/변수/기본
	A2(int k){
		int j = 3; // 지역/X/변수/기본
		System.out.println("A2() J: " + j);
		System.out.println("A2() k: " + k);
	}
	void m(){
		System.out.println("m() i: " + i);
	}
	public static void main(String[] args){
		A2 a = new A2(4);
		a.m();
		System.out.println("main() i: " + a.i);
		System.out.println("main() ii: " + a.ii);
	}
}

class A3
{
	int i = 1;
	static int ii = 2;
	A3(int k){
		int j = 3;
		System.out.println("A3() J: " + j);
		System.out.println("A3() k: " + k);
	}void m(){
		System.out.println("m() i: " + i);
	}
	public static void main(String args[]){
		A3 a = new A3(4);
		a.m();
		System.out.println("main() i: " + a.i);
		System.out.println("main() ii: " + a.ii);
	}
}

class A4
{
	int i = 1;
	static int ii = 2;
	A4(int k){
		int j = 3;
		System.out.println("A3() J: " + j);
		System.out.println("A3() k: " + k);
	}
	void m(){
		System.out.println("m() i: " + i);
	}
	public static void main(String []args){
		A4 a = new A4(4);
		a.m();
		System.out.println("main() i: " + a.i);
		System.out.println("main() ii: " + a.ii);
	}
}

class A5
{
	int i = 1;
	static int ii = 2;
	A5(int k){
		int j = 3;
		System.out.println("A3() J: " + j);
		System.out.println("A3() k: " + k);
	}
	void m(){
		System.out.println("m() i: " + i);
	}
	public static void main(String args[]){
		A5 a = new A5(4);
		a.m();
		System.out.println("main() i : " + a.i);
		System.out.println("main() ii : " + a.ii);
	}
}