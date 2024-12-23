import java.util.*;

class B2
{
	TreeSet<String> ts = new TreeSet<String>();
	void in(){
		ts.add("Spring");ts.add("Summer");ts.add("fall");ts.add("winter");ts.add("fall");
		System.out.println("ts.size(): " + ts.size());
	}
	void out(){
		Iterator<String> iter = ts.iterator();// 오름차순 정렬
		//Iterator<String> iter = ts.descendingIterator();//내림차순 정렬
		while(iter.hasNext()){
			//Object obj = iter.next();
			//String str = (String)obj;
			String str = iter.next();
			System.out.println(str);
		}
	}
	public static void main(String[] args) 
	{
		B2 b = new B2();
		b.in();
		b.out();
	}
}

class B22
{
	TreeSet<String> ts = new TreeSet<String>();
	void in(){
		ts.add("Spring");ts.add("Summer");ts.add("fall");ts.add("winter");ts.add("fall");
		System.out.println("ts.size(): " + ts.size());
	}
	void out(){
		Iterator<String> iter = ts.iterator();// 오름차순 정렬
		//Iterator<String> iter = ts.descendingIterator();//내림차순 정렬
		while(iter.hasNext()){
			String str = iter.next();
			System.out.println(str);
		}
	}
	public static void main(String args[]){
		B22 b = new B22();
		b.in();
		b.out();
	}
}

class B23
{
	TreeSet<String> ts = new TreeSet<String>();
	void in(){
		ts.add("Spring");ts.add("Summer");ts.add("fall");ts.add("winter");ts.add("fall");
		System.out.println("ts.size(): " + ts.size());
	}
	void out(){
		Iterator<String> iter = ts.descendingIterator();
		while(iter.hasNext()){
			String str = iter.next();
			System.out.println(str);
		}
	}
	public static void main(String[] args){
		B23 b = new B23();
		b.in();
		b.out();
	}
}

class B24
{
	TreeSet<String> ts = new TreeSet<String>();
	void in(){
		ts.add("Spring");ts.add("Summer");ts.add("fall");ts.add("winter");ts.add("fall");
		System.out.println("ts.size(): " + ts.size());
	}
	void out(){
		Iterator<String> iter = ts.descendingIterator();
		while(iter.hasNext()){
			String str = iter.next();
			System.out.println(str);
		}
	}
	public static void main(String[] args){
		B24 b = new B24();
		b.in();
		b.out();
	}
}