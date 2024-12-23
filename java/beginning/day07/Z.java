import java.util.ArrayList;

class  Z
{
	ArrayList list = new ArrayList();
	void in(){
		list.add(10); // 가변배열
		list.add(20);
	}
	void out(){
		Object obj1 = list.get(0);
		Integer iObj1 = (Integer)obj1; // 강제 형변환(Object -> Integer)
		int i = iObj1.intValue(); // 언박싱(참조형->기본형)

		System.out.println("obj1: "+i+1);
	}
	public static void main(String[] args) 
	{
		Z z = new Z();
		a.in();
		a.out();
	}
}
