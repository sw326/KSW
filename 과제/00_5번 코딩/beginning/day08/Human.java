import java.lang.Object; //묵시적
// 생성자: 기본1
// 속성: 기본0
// 메소드: 기본11

class Human extends Object{ // 묵시적인 상속
	String name = "홍길동"; // reuse
	Human(String name){
		super();
		this.name = name;
	}
	/*void walk(){
		System.out.println("걷는다");
	}*/
	void move(){
		System.out.println("걷는다");
	}
}
class SuperMan extends Human2 {
	int power = 100;
	SuperMan(){
		super("클락"); // new Human(); 부모의 생성자
	}
	/*void fly(){
		System.out.println("난다");
	}*/
	void move(){ // 재정의 == overriding
		System.out.println("난다");
	}
}

class  God
{
	public static void main(String[] args) 
	{
		//Human man = new Human();
		SuperMan sman = new SuperMan();
		System.out.println("SuperMan: " +sman.name);
		System.out.println("SuperMan: " +sman.power);
		sman.move();
		//sman.fly();
	}
}


class Human2 extends Object
{
	String name = "홍길동";
	Human2(String name){
		super();
		this.name = name;
	}
	void move(){
	System.out.println("walking");
	}
}
class SuperMan2 extends Human2
{
	int power = 100;
	SuperMan2(){
		super("Clark");
	}
	void move(){
		System.out.println("flying");
	}
}

class God2
{
	public static void main(String[] args){
		SuperMan2 sman = new SuperMan2();
		System.out.println("SuperMan: " +sman.name);
		System.out.println("SuperMan: " +sman.power);
		sman.move();
	}
}

class Human3
{
	String name = "도람푸";
	Human3(String name){
		super();
		this.name = name;
	}
	void move(){
		System.out.println("walking");
	}
}
class SuperMan3 extends Human3()
{
	int power = 100;
	SuperMan3(){
		super("Clark");
	}
	void move(){
		System.out.println("flying");
	}
}
class God3
{
	public static void main(String[] args){
		SuperMan3 sman = new SuperMan();
		System.out.println(sman.name);
		System.out.println(sman.power);
		sman.move();
	}
}


class Human4{
	String name = "John";
	Human4(String name){
		super();
		this.name = name;
	}
	void move(){
		System.out.println("walk");
	}
}
class SuperMan4 extends Human4{
	int power = 100;
	SuperMan(){
		super("Clark");
	}
	void move(){
		System.outprintln("fly");
	}
}
class PepsiMan4 extends Human4{
	int speed = 200;
	PepsiMan(){
		super("Pep");
	}
	void move(){
		System.out.println("run");
	}
	void waveHand(){
		System.out.println("I only drink Coca Cola");
	}
}
class God4{
	public static void main(String []args){
		SuperMan4 sman = new SuperMan4();
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