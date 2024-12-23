interface AI1 {
	void m1();
}
class AI1Child implements AI1 {
	public void m1(){
		System.out.println("AI1 m1() 구현1");
	}
}

interface AI2 {
	void m2(int i);
}

interface AI3 {
	int m3(int i, int j);
}

class A {
	void use1(){
		AI1 ai1 = new AI1Child(); //1
		AI1 ai2 = new AI1(){ //2
			public void m1(){
				System.out.println("AI1 m1() 구현2");
			}
		};
		AI1 ai3 = () -> System.out.println("AI1 m1() 구현3"); //3

		ai1.m1();
		ai2.m1();
		ai3.m1();
	}
	void use2(){
		AI2 ai = (i) -> { 
			int r = i + 1;
			System.out.println("AI2 m2() 구현 r: " + r); 
		};

		ai.m2(1);
	}
	void use3(){
		//AI3 ai = (i, j) -> { return i+j; };
		AI3 ai = (i, j) -> i+j;

		int sum = ai.m3(1,2);
		System.out.println("sum: " + sum);
	} 
	void use4(){
		//AI3 ai = (i, j) -> multiply(i,j);
		AI3 ai = (i, j) -> new AOther().multiply2(i,j);
		
		int mul = ai.m3(1, 2);
		System.out.println("mul: " + mul);
	}
	int multiply(int i, int j){ //더 많고 복잡한 ; 들이 존재할 때 
		i = i + 10; 
		j = j + 20;
		return i*j;
	}
	public static void main(String[] args) {
		A a = new A();
		//a.use1();
		//a.use2();
		//a.use3();
		a.use4();
	}
}

class AOther {
	int multiply2(int i, int j){ //더 많고 복잡한 ; 들이 존재할 때
		i = i + 100; 
		j = j + 200;
		return i*j;
	}
}

interface AI11{
	void m1();
}
class AI1Child1 implements AI11{
	public void m1(){
		System.out.println("1");
	}
}
interface AI21{
	void m2(int i);
}
interface AI31{
	int m3(int i, int j);
}
class A1{
	void use1(){
		AI11 ai1 = new AI1Child1(); //1
		AI11 ai2 = new AI11(){ //2
			public void m1(){
				System.out.println("2");
			}
		};
		AI11 ai3 = ()->System.out.println("3");
		ai1.m1();
		ai2.m1();
		ai3.m1();
	}
	void use2(){
		AI21 ai = (i)->{
			int r = i+1;
			System.out.println("r: "+r);
		};
		ai.m2(1);
	}
	void use3(){
		AI31 ai = (i,j)->i+j;

		int sum = ai.m3(1,2);
		System.out.println("sum: "+sum);
	}
	void use4(){
		AI31 ai=(i,j)-> new AOther().multiply2(i,j);

		int mul = ai.m3(1,2);
		System.out.println("mul: "+ mul);
	}
	int multiply(int i, int j){
		i+=10;
		j+=20;
		return i*j;
	}
	public static void main(String[] args){
		A a = new A();
		a.use1();
		a.use2();
		a.use3();
		a.use4();
	}
}
class AOther1{
	int multiply2(int i, int j){
		i+=100;
		j+=200;
		return i*j;
	}
}

interface AI12{
	void m1();
}
class AI1Child2 implements AI12{
	public void m1(){
		System.out.println("1");
	}
}
interface AI22{
	void m2(int i);
}
interface AI32{
	int m3(int i, int j);
}
class A2{
	void use1(){
		AI12 ai1= new AI1Child2();
		AI12 ai2= new AI12(){
			public void m1(){
				System.out.println("2");
			}
		};
		AI12 ai3=()->System.out.println("3");
		ai1.m1();
		ai2.m1();
		ai3.m1();
	}
	void use2(){
		AI22 ai=(i)->{
			int r = i+1;
			System.out.println(r);
		};
		ai.m2(1);
	}
	void use3(){
		AI32 ai=(i,j)->i+j;
		int sum = ai.m3(1,2);
		System.out.println(sum);
	}
	void use4(){
		AI32 ai=(i,j)->multiply(i,j);
		//AI32 ai=(i,j)->new AOther().multiply2(i,j);

		int mul=ai.m3(1,2);
		System.out.println(mul);
	}
	int multiply(int i, int j){
		i+=10;
		j+=20;
		return i*j;
	}
	public static void main(String[] args){
		A a = new A();
		a.use4();
	}
}