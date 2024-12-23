import java.util.*;

class Tip2{
	String name = "김희진";
	int rate =50;
	Random r = new Random();
	String winner;

	ArrayList<String> names = new ArrayList<String>();
	void in(){
		names.add("김노은");
		names.add("김다예");
		names.add("김성우");
		names.add("김희진 ");
		names.add("민성빈");
		names.add("신혜서");
		names.add("엄태정");
		names.add("이영주");
	}
	/*void out(){
		for(String name: names) pln(name);
	}*/
	void show(){
		int i = r.nextInt(100); // 0~99
		if(i >=0 && i<rate) {// 0~49
			winner = name;
		}else{
			names.remove(name);

			int idx = r.nextInt(names.size()); //0~6
			winner = names.get(idx);
		}
		pln("winner: "+ winner);
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args){
		Tip2 t = new Tip2();
		t.in();
		//t.out();
		t.show();
		/*
		int yes = 0;
		int no = 0;
		for(int i=0; i<100000000; i++){
			t.show();
			if(t.winner.equals(t.name)){
				yes++;
			}else{
				no++;
			}
		}
		System.out.println("yes: " + yes + ", no: " + no);
		*/
	}
}
