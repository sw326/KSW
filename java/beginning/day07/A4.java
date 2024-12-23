import java.util.*;

class A4
{
	Vector<String> v = new Vector<String>();
	void in(){
		v.add("Spring");v.add("Summer");v.add("fall");v.add("winter");
		System.out.println("v.size(): " + v.size());
	}
	void out(){
		for(String str: v){
			System.out.println(str);
		}
	}
	public static void main(String[] args) 
	{
		A4 a = new A4();
		a.in();
		a.out();
	}
}

class A41
{
	Vector<String> v = new Vector<String>();
	void in(){
		v.add("Spring");v.add("Summer");v.add("fall");v.add("winter");
		System.out.println("v.size(): " + v.size());
	}
	void out(){
		for(String str: v){
			System.out.println(str);
		}
	}
	public static void main(String args[]){
		A41 a = new A41();
		a.in();
		a.out();
	}
}