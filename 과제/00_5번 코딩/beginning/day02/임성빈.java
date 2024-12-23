class 음료
{
	String 이름 = "커피";
	int 가격 = 2500;
	음료(){}
	음료(String 이름, int 가격){
		this.이름 = 이름;
		this.가격 = 가격;
	}
	void 맛있다(){
		System.out.println("맛있어!");
	}
	void 달다(){
		System.out.println("달아!");
	}
}

class 주문
{
	음료 밥1, 밥2;
	String 아르바이트 = "스타벅스"; // 식당

	주문(String 아르바이트){
		this.아르바이트 = 아르바이트;
	}
	void 주문하다(){
		밥1 = new 음료();
		밥2 = new 음료("에이드", 3500);
		System.out.println("맛있다");
	}
}

class 꿀꺽
{
	public static void main(String[] args) 
	{
		주문 주문1 = new 주문("식당") // 객체 생성
		주문1.주문한다(); // 메소드 호출
		System.out.print(주문1.아르바이트+"에서 ");
		System.out.print("오늘 "+주문1.밥1.이름+"를 주문하였고, 가격은 "+주문1.밥1.가격+"원인 음료가 ");
		주문1.밥1.맛있다();
		System.out.print("오늘 "+주문1.밥2.이름+"를 주문하였고, 가격은 "+주문1.밥2.가격+"원인 음료가 ");
		주문1.밥1.달다();
	}
}
