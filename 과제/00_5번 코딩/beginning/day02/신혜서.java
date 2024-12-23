class 성적
{
	String 과목 = "컴퓨터개론";
	String 학점 = "B+";
	성적(){
	}
	성적(String 과목, String 학점){
		this.과목 = 과목;
		this.학점 = 학점;
	}
	void 공부하다(){
		System.out.println("열심히 공부해!");
}

class 학생들
{
	성적 성적1, 성적2;
	String 이름 = "이근서";
	String 이름2 = "김서연";
	학생들(String 이름){
		this.이름 = 이름;
	}
	void 성적확인하다(){
		성적1 = new 성적("자료구조", "A+");
		성적2 = new 성적("JAVA프로그래밍", "B+");
		System.out.println("학교에서 공부 잘하겠네!");
	}
}

class 학교
{
	public static void main(String[] args) 
	{
		학생들 학생1 = new 학생들("이근서");
		학생1.성적확인하다();
		System.out.print(학생1.이름 +"학생의 최신 ");
		System.out.println(학생1.성적1.과목 + "과목의 학점은 "+학생1.성적1.학점);
		System.out.print(학생1.성적2.과목+"과목의 학점은 "+학생1.성적2.학점);
		System.out.println("입니다.");
	}
}
