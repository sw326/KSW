class 커피 //클래스
{
	String 이름 = "얼죽아"; //맴버
	int 가격 = 1500;//맴버
	커피(){
	}
	커피(String 이름, int 가격){
		this.이름 = 이름;
		this.가격 = 가격;
	}
	void 졸지않는다(){
		System.out.println("졸지 않는다");
	}
	void 너무쓰다(){
		System.out.println("너무 쓰다");
	}
}


class 공급자 //클래스
{
	커피 얼죽아, 아샷추; //맴버
	String 이름 = "이영주"; //맴버
	공급자(String 이름){
		this.이름 = 이름;
	}
	void 커피를_쏜다() {
		얼죽아 = new 커피();
		아샷추 = new 커피("아샷추", 2000);
	}
}


class 수급자 //클래스
{
	public static void main(String[] args) 
	{
		공급자 골든벨 = new 공급자("이영주");
		골든벨.커피를_쏜다();

		System.out.println(
			골든벨.이름+ "가 "+골든벨.얼죽아.가격+"원인 "+골든벨.얼죽아.이름+"를 쐈고 그것을 마시니");
		골든벨.얼죽아.졸지않는다();
		System.out.println(
			골든벨.이름+ "가 "+골든벨.아샷추.가격+"원인 "+골든벨.아샷추.이름+"를 쐈고 그것을 마시니");
		골든벨.아샷추.너무쓰다();
	}
}
