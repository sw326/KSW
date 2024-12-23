class A{
	void m(){
		System.out.println("A's m()");
	}
}
class AChild extends A{
	void m(){
		System.out.println("AChild's m()");
	}
}

// < (메소드)오버라이딩의 조건 >
// 1) 메소드 이름이 같아야 함
// 2) 리턴타입이 일치해야 함
// 3) 파라미터의 타입과 순서와 갯수가 모두 일치해야 함
// 4) 생성자는 불가능
// 5) 자식 접근제한자가 부모 접근제한자보다 같거나 넓어야 한다.