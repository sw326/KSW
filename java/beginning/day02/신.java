class 신 {
	public static void main(String[] args) {
		주인 사장 = new 주인("아저씨");
		주인 사장2 = new 주인("아줌마");
		사장.굽는다();
		System.out.println(사장.성별 + "가 ");
		사장.굽는다();

		System.out.println(
			"앙꼬가 "+사장.빵1.앙꼬+"이고, 가격은 "+사장.빵1.가격+"원인 첫번째 붕어빵이 ");
		사장.빵1.배부르게한다();

		System.out.println(
			"앙꼬가 "+사장.빵2.앙꼬+"이고, 가격은 "+사장.빵2.가격+"원인 첫번째 붕어빵이 ");
		사장.빵2.따스하게한다();
	}
}