//import java.lang.*; //묵시적 import 
class Human extends Object { //묵시적 상속
	String name = "홍길동"; 
	Human(String name){
		super(); //new Object()
		this.name = name;
	}
	/*void walk(){
		System.out.println("걷는다");
	}*/
	void move(){
		System.out.println("걷는다");
	}
}
class SuperMan extends Human {
	int power = 100;
	SuperMan(){
		super("클락"); 
	}
	void fly(){
		System.out.println("난다");
	}
	void move(){ //재정의==오버라이딩
		System.out.println("난다");
	}
}
class PepsiMan extends Human {
	int speed = 200;
	PepsiMan(){
		super("펩시맨");
	}
	void move(){
		System.out.println("달린다");
	}
	void shakeHand(){
		System.out.println("손을 흔든다");
	}
}

class God{
	public static void main(String[] args) {
		SuperMan sman = new SuperMan();

		System.out.println("sman.name: " + sman.name);
		System.out.println("sman.power: " + sman.power);
		//sman.walk();
		//sman.fly();
		sman.move();
		System.out.println();		

		Human man = sman; //자동형변환(업캐스팅)
		System.out.println("man.name: " + man.name);
		//System.out.println("man.power: " + man.power); //불가!
		//man.fly(); //불가!
		man.move();
		System.out.println();

		SuperMan sman2 = (SuperMan)man; //강제형변환(다운캐스팅)
		System.out.println("sman2.name: " + sman2.name);
		System.out.println("sman2.power: " + sman2.power); 
		sman2.fly();
		sman2.move();
		System.out.println();

		//SuperMan sman3 = (SuperMan)new Human("이순신"); //잘못된형변환(실행시 에러)

		SuperMan sman4 = (SuperMan)new PepsiMan(); //잘못된형변환(컴파일시 에러)
	}
}