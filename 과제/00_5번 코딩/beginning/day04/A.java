class A 
{
	void m1(){
		int i = 0;
		if(i<0){
			System.out.println("Hello World!");
		} else if(i>0) {
			System.out.println("Yello World!");
		} else {
			System.out.println("Yellow World!");
		}
	}
	void m2(){
		int i = 2;
		switch(i){ // 정수형(byte short char int)과 String만
			case 1: System.out.println("1"); break;
			case 2: System.out.println("2"); break;
			case 3: System.out.println("3"); break;
			default : System.out.println("1, 2, 3은 아니다"); // default의 위치는 상관은 없다
		}
		System.out.println("밖");
	}
	void m3(){
		String food = "점심";
		switch(food){ // String
			case "아침": System.out.println("아침식사"); break;
			case "점심": System.out.println("점심식사"); break;
			case "저녁": System.out.println("저녁식사"); break;
			default : System.out.println("아침, 점심, 저녁은 아니다"); 
		}
		System.out.println("밖");
	}
	public static void main(String[] args) 
	{
		A a = new A();
		a.m1();
	}
}


class A1
{
	void m1(){
		int i =0;
		if(i<0){
			System.out.println("Hello World!");
		}else if(i>0){
			System.out.println("Yello World!");
		}else{
			System.out.println("Yellow World!");
		}
	}
	void m2(){
		int i = 2;
		switch(i){ // 정수형과 String만 가능
			case 1: System.out.println("1"); break;
			case 2: System.out.println("2"); break;
			case 3: System.out.println("3"); break;
			default : System.out.println("1,2,3은 아니다"); // default의 위치는 상관은 없다
		}
		System.out.println("outside");
	}
	void m3(){
		String food = "점심";
		switch (food){ // String
		case "아침": System.out.println("breakfast"); break;
		case "점심": System.out.println("lunch"); break;
		case "저녁": System.out.println("dinner"); break;
		default: System.out.println("식사 아니다!");		
		}
		System.out.println("outside");
	}
	public static void main(String args[]){
		A1 a = new A1();
		a.m1();
		a.m2();
		a.m3();
	}
}

class A2
{
	void m1(){
		int i = 3;
		if(i<0){
			System.out.println("Hello World!");
		}else if(i>0){
			System.out.println("Yello World!");
		}else{
			System.out.println("Yellow World!");
		}
	}
	void m2(){
		int i = 3;
		switch (i)
		{
		case 1: System.out.println("breakfast"); break;
		case 2: System.out.println("lunch"); break;
		case 3: System.out.println("dinner"); break;
		default: System.out.println("not a meal");
		}
	}
	public static void main(String[] args){
		A2 a = new A2();
		a.m1();
		a.m2();
	}
}

class A3
{
	void m1(){
		int i = 3;
		if(i<0){
			System.out.println("Hello World!");
		}else if (i>0)
		{
			System.out.println("Yello World!");
		}else{
			System.out.println("Yellow World!);
		}
	}
	void m2(){
		int i = 2;
		switch (i)
		{
		case 1: System.out.printlm("breakfast"); break;
		case 2: System.out.println("lunch"); break;
		case 3: System.out.println("dinner"); break;
		default: System.out.println("not a meal");
		}
	}
	public static void main(String[] args){
		A3 a = new A3();
		a.m1();
		a.m2();
	}
}

class A4
{
	void m1(){
		int i = 3;
		if(i<0){
			System.out.println("1");
		}else if(i>0){
			System.out.println("2");
		}else{
			System.out.println("3");
		}
	}
	void m2(){
		int i = 2;
		switch(i){
			case 1: System.out.println("bf"); break;
			case 2: System.out.println("ln"); break;
			case 3: System.out.println("dn"); break;
			default: System.out.println("not a meal");
		}
	}
	public static void main(String args[]){
		A4 a = new A4();
		a.m1();
		a.m2();
	}
}

class A5
{
	void m1(){
		int i = 3;
		if(i<0){
			System.out.println("1");
		}else if(i>0){
			System.out.println("2");
		}else{
			System.out.println("3");
		}
	}
	void m2(){
		int i = 1;
		switch (i)
		{
		case 1: System.out.println("bf"); break;
		case 2: System.out.println("ln"); break;
		case 3: System.out.println("dn"); break;
		default: Systemout.println("n a m");
		}
	}
	public static void main(String[] args){
		A5 a = new A5();
		a.m1();
		a.m2();
	}		
}