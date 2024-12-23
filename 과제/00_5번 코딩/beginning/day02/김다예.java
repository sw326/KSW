class 책
{
	String 책종류 = "동화책"
	String 저자 = "철수";
	책(){
	}
	책(String 책종류, String 저자){
		this.책종류 = 책종류;
		this.저자 = 저자;
	}
	void 재미있다(){
		System.out.println("재미있다");
	}
	void 슬프다(){
		System.out.println("슬프다");
	}
}

class 도서관 {
	책 도서1, 도서2;
	String 독서녀 = "영희";
	도서관(String 독서녀){
		this.독서녀 = 독서녀;
	}
	void 읽는다(){
		도서1 = enw 책();
		도서2 = new 책("소설책", "영수");
		System.out.println("책을 2권 읽었다.");
	}
}

class 나
{
	public static void main(String[] args) 
	{
		도서관 주인공 = new 도서관("청소년");
		System.out.print(주인공.독서녀+"가 ");
		주인공.읽는다();

		System.out.print("오늘은 "+주인공.도서1저자+"가 쓴 책은 " + 주인공.도서1.책종류+"이고 ");
		주인공.도서1.재미있다();
		System.out.print("오늘은 "+주인공.도서2.저자+"가 쓴 책은 "+주인공.도서2.책종류+"이고 ");
		주인공.도서2.슬프다();
	}
}
