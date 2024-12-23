class 호떡
{
	String 맛이름 = "팥채";
	int 가격 = 2000;
	String 토핑이름 = "팥";
	호떡(){
	}
	호떡(String 맛이름, int 가격){
		this.맛이름 = 맛이름;
		this.가격 = 가격;
	}
	void 맛있다(){
		System.out.println("달콤한 팥이 아주 맛있었어요.");
	}
	void 뜨겁다(){
		System.out.println("뜨거웠다.");
	}
	void 토핑한다(String 토핑이름){
		System.out.println(토핑이름+"토핑을 토핑한다.");
	}
}

class 가게
{
	호떡 호떡1, 호떡2;
	String 제조처 = "CJ";
	가게(String 제조처){
		this.제조처 = 제조처;
	}
	void 판매하다(){
		호떡1 = new 호떡();
		호떡2 = new 호떡("슈크림", 500);
		System.out.println("두 종류의 호떡을 팔았다.");
	}
}

class 손님
{
	public static void main(String[] args) 
	{
		가게 가게1 = new 가게("CJ");
		System.out.print(가게1.제조처+"에서 ");
		가게1.판매하다();

		System.out.print("가격은 "+가게1.ㅗ떡1.가격+"원인 "+가게1.호떡1.맛이름+"호떡은 ");
		가게1.호떡1.맛있다();

		가게1.호떡1.토핑한다("팥");

		System.out.print("반면, ");

		System.out.print("팥채호떡보다 "+가게1.호떡2.가격+"원 싸서 그런지 "+가게1.호떡2.맛이름+"호떡은 ");
		거게1.호떡2.뜨겁다();
	}
}


class 버스
{
	버스(){
	}
	String 번호 = "급행";
	int 요금액 = 1500;
	int 시간 = 40;
	버스(String 번호, int 요금액, int 시간){
		this.번호 = 번호;
		this.요금액 = 요금액;
		this.시간 = 시간;
	}
	void 시간(){
		System.out.println("시간 걸리고,");
	}
	void 환승(){
		System.out.println("환승1회로 도착할 수도 있음");
}

class 정류장
{
	버스 버스1, 버스2;
	String 회사 = "네이버";
	정류장(String 회사){
		this.회사 = 회사;
	}
	void 참색(){
		버스1 = new 버스();
		버스2 = new 버스("마을철", 2000, 20);
		System.outprintln("2개의 버스를 찾았다.");
	}
}

class 승객
{
	public static void main(String[] args){
		정류장 정류 = new 정류장("카카오");
		System.out.println(정류.버스1.번호+"를 타면 "+정류.버스1.요금액+"원이고 "+정류.버스1.시간);
		정류.버스1.시간();

		System.out.println(정류.버스2.번호+"는 "+정류.버스1.번호+"를 타고(환승 1회) "+정류.버스2.시간+"분이 걸리고 "+정류.버스2.요금액+"원이면 ");
		정류.버스2.환승();
	}
}