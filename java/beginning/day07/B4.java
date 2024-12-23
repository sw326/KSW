import java.util.*;

class B4
{
	TreeSet<String> ts = new TreeSet<String>();
	void in(){
		ts.add("Spring");ts.add("Summer");ts.add("fall");ts.add("winter");ts.add("fall");
		System.out.println("ts.size(): " + ts.size());
	}
	void out(){
		for(String str : ts){
			System.out.println(str);
		}
	}
	public static void main(String[] args) 
	{
		B4 b = new B4();
		b.in();
		b.out();
	}
}

