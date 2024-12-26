class Q {
	/*void m01(){ // 1~10까지 합 
		int sum = 0; 
		for(int n=0; n < 10; n++){
			sum += n;
			System.out.println("SUM= "+sum);
		}
	}*/

	int x = 12;
	void m02(int x){ // x의 값은?
		x += x;
		System.out.println(x);
	}

	/*void m03(){
		switch(){ // 조건형: byte, short, char, int, String 
			case 1: // 로직1
			case 2: // 로직2
			default: // 로직3
		}
	}*/

	void m04(){
		int[] arr1 = {10, 20};
		int arr2[] = {10, 20};
		Object arr3[] = new String[3];
	}
	void m05(){
		Object obj1 = new Object();
		Object obj2 = new Object();
		if(obj1.equals(obj2)){
			System.out.println("1");
		}else{
			System.out.println("2");
		}
	}
	void m06(){ // final 키워드 
		// final이 붙으면: 수정 불가
		// final 메서드: 오버라이딩 불가
		// final 클래스: 상속 불가
	}
	void m07080910(){ // 메서드 설명 
	}
	void m11(){ // try-catch 예외 처리 
	}
	void m1213(){
		StringBuffer sb; // 문자열을 수정할 수 있는 객체
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
	void m20(){ // 메서드 설명 
	}
	public static void main(String[] args) {
		Q q = new Q();
		//q.m01();
		//q.m02(5);
		//q.m04();
		//q.m05();
	}
}
