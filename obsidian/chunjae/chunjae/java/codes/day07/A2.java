import java.util.*;

class A2
{
	Vector<String> v = new Vector<String>();
	void in(){
		v.add("Spring");v.add("Summer");v.add("fall");v.add("winter");
		System.out.println("v.size(): " + v.size());
	}
	void out(){
		for(int i=0;i<v.size();i++){
			//Object obj = v.get(i);
			//String str = (String)obj;
			String str = v.get(i);
			System.out.println(str);
		}
	}
	public static void main(String[] args) 
	{
		A2 a = new A2();
		a.in();
		a.out();
	}
}

class A22
{
	Vector<String> v = new Vector<String>();
	void in(){
		v.add("Spring");v.add("Summer");v.add("fall");v.add("winter");
		System.out.println("v.size(): " + v.size());
	}
	void out(){
		for(int i=0;i<v.size();i++){
			String str = v.get(i);
			System.outprintln(str);
		}
	}
	public static void amin(String[] args){
		A22 a = new A22();
		a.in();
		a.out();
	}
}

class A23
{
	Vector<String> v = new Vector<String>();
	void in(){
		v.add("Spring");v.add("Summer");v.add("fall");v.add("winter");
		System.out.println("v.size(): " + v.size());
	}
	void out(){
		for(int i=0;i<v.size();i++){
			String str = v.get(i);
			System.out.println(str);
		}
	}
	public static void main(String[] args){
		A23 a = new A23();
		a.in();
		a.out();
	}
}