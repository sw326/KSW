import java.util.*;

class B
{
	TreeSet ts = new TreeSet();
	void in(){
		ts.add("Spring");ts.add("Summer");ts.add("fall");ts.add("winter");ts.add("fall");
		System.out.println("ts.size(): " + ts.size());
	}
	void out(){
		Iterator iter = ts.iterator();// 오름차순 정렬
		Iterator iter = ts.descendingIterator();//내림차순 정렬
		while(iter.hasNext()){
			Object obj = iter.next();
			String str = (String)obj;
			System.out.println(str);
		}
	}
	public static void main(String[] args) 
	{
		B b = new B();
		b.in();
		b.out();
	}
}

