class 요리
{
	String 메뉴 = "스파게티";
	int 시간 = 1;
	요리(){
	}
	요리(String 메뉴, int 시간){
		this.메뉴 = 메뉴;
		this.시간 = 시간;
	}
	void 맛있다(){
		System.out.println("맛있어요!");
	}
	void 실패함(){
		System.out.println("실패했다ㅠㅠ");
	}
}

class 주방
{
	요리 밥1, 밥2;
	String 이름 = "다운";
	주방(String 이름){
		this.이름 = 이름;
	}
	void 요리한다(){
		밥1 = new 요리();
		밥2 = new 요리("치킨", 2);
		System.out.println("음식 2개를 요리했다.");
	}
}




class 나
{
	public static void main(String[] args) 
	{
		주방 요리사 = new 주방("영희");
		System.out.print(요리사.이름 + "(이)가 ");
		요리사.요리한다();

		System.out.print(
			요리사.밥1.시간 + "시간 동안 요리한 " + 요리사.밥1.메뉴 + "는 ");
		요리사.밥1.실패함();

		System.out.print(
			요리사.밥2.시간 + "시간 동안 요리한 " + 요리사.밥2.메뉴 + "는 ");
		요리사.밥2.맛있다();
	}
}