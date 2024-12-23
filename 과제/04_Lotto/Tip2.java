import java.util.*;

class Tip2 
{
	Random r = new Random();
	int n = 8;

	void showRan(){
		int i = r.nextInt(n); // 0~(n-1) 
		pln("i: "+i);
	}
	void pln(String str){
		System.out.println(str);
	}
	void p(String str){
		System.out.print(str);
	}
	public static void main(String[] args) 
	{
		Tip2 t = new Tip2();
		t.showRan();
	}
}
