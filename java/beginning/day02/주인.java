class 주인 {
	붕어빵 빵1, 빵2;
	String 성별 = "아줌마";
	주인(String 성별){
		this.성별 = 성별;
	}
	void 굽는다(){
		빵1 = new 붕어빵(); // 객체1
		빵2 = new 붕어빵("설탕", 700); // 객체2
		System.out.println("붕어빵 두개를 구웠다");
	}
}