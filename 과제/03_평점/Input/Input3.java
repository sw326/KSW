import java.util.*;

class Input3 {
	Scanner s = new Scanner(System.in);

	void input(){
		p("국어: ");
		int i = s.nextInt();
		pln("유효한 점수: " + i);
	}
	void pln(String str){
		System.out.println(str);
	}
	void p(String str){
		System.out.print(str);
	}
	public static void main(String[] args) 
	{
		Input3 a = new Input3();
		a.input();
	}
}