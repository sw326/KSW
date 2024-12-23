import java.lang.*;
class A extends Object{
	public A(){
		super();
	}
	public String toString(){
		return "Good Luck!";
	}
}
class AUser
{
	public static void main(String[] args) 
	{
		A a = new A();
		String str = a.toString();
		System.out.println(str);
	}
}
