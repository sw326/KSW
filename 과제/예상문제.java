class Q{
	void m01(){
		int sum = 0;
		for(int n=0; n<=10;n++){ // n <= 10까지 반복
			sum += n; // Sum을 sum으로 수정
		}
		System.out.println("Sum: " + sum);
	}
	int x = 12;
	void m02(int x){
		x += x;
		System.out.println(x); // x는 10 // x의 값을 출력
	}
	void m03(){
		switch(0){ // switch의 괄호 안에 조건 추가. 정수형(byte, short, char, int) & String 타입
			case 1: System.out.println("1"); break; // case 문 수정
			case 2: System.out.println("2"); break; // case 문 수정
			default: System.out.println("3"); // default 문 수정
		}
	}
	void m04(){ // 배열 선언
		int[] arr1 = {10, 20}; // O
		int arr2[] = {10, 20}; // O
		Object arr3[] = new String[3]; // O 객체 배열 선언
	}

	void m05(){ // 객체 비교
		Object obj1 = new Object(); // 객체 생성
		Object obj2 = new Object();
		if(obj1.equals(obj2)){
			// equals는 객체의 '동등성'을 비교합니다.
			System.out.println("1");
		}else{
			System.out.println("2");
		}
	}

	void m06(){ // final 키워드 설명
		final String str = "상수"; // final 변수 선언
		final int num = 10; // final 변수 선언
		final Object obj = new Object(); // final 객체 선언
	}
	void m078910(){ // 접근 제어자 설명
	}
	void m11(){ // try-catch 예외 처리
	}
	void m1213(){ // StringBuffer 사용
		StringBuffer sb; // StringBuffer 선언
		// StringBuffer는 문자열을 수정할 수 있는 객체입니다.
		String s; // 문자열 변수 선언
	}
	void m14(){ // 예외 처리
	}
	void m15(){ // 메서드 오버라이딩
	}
	void m16(){ // 접근 제어자 설명
	}
	void m17(){ // 접근 제어자 설명
	}
	void m18(){
	}
	void m19(){
	}
	void m20(){ // 메서드 설명
	}

	public static void main(String[] args) {
		Q q =  new Q();
		q.m01();
		q.m02(5); // m02 메서드 호출
	}
}
