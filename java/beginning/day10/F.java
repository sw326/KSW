abstract class F 
{
	int j; // 
	// abstract int i; 불가
	// abstract F(){}; 불가
	abstract void m(); // 바디가 없는 경우 가능 // 추상 메소드
	void m2(){ // 일반 메소드
		System.out.println("m2()");
	}
}

class FChild extends F {
	void m(){
		System.out.println("m() in Child");
	}

}

class FUser {
	public static void main(String[] args){
		F f = new FChild();
		// 추상클래스 F의 객체를 만들어서.. 자원을 사용해보세요
		f.m();
		f.m2();
	}
}