import java.util.*;

class B
{
	TreeSet ts = new TreeSet();
	void in(){
		ts.add("Spring");ts.add("Summer");ts.add("fall");ts.add("winter");ts.add("fall");
		System.out.println("ts.size(): " + ts.size());
	}
	void out(){
		Iterator iter = ts.iterator();
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

class BB
{
	TreeSet ts = new TreeSet();
	void in(){
		ts.add("Spring");ts.add("Summer");ts.add("fall");ts.add("winter");ts.add("fall");
		System.out.println("ts.size(): " + ts.size());
	}
	void out(){
		Iterator iter = ts.iterator();
		while(iter.hasNext()){
			Object obj = iter.next();
			String str = (String)obj;
			System.out.println(str);
		}
	}
	public static void main(String[] args){
		BB b = new BB();
		b.in();
		b.out();
	}
}

class BBB
{
	TreeSet ts = new TreeSet();
	void in(){
		ts.add("Spring");ts.add("Summer");ts.add("fall");ts.add("winter");ts.add("fall");
		System.out.println("ts.size(): " + ts.size());
	}
	void out(){
		Iterator iter = ts.iterator();
		while(iter.hasNext()){
			Object obj = iter.next();
			String str = (String)obj;
			System.out.println(str);
		}
	}
	public static void main(String args[]){
		BBB b = new BBB();
		b.in();
		b.out();
	}
}