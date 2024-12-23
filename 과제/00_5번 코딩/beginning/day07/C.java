import java.util.*;

class C 
{
	Hashtable ht = new Hashtable();
	void in(){
		ht.put(10, "Spring"); //put(int, String)
		ht.put(20, "Summer");
		ht.put(30, "Fall");
		ht.put(40, "Winter");
		System.out.println("ht.size(): " + ht.size());
	}
	void out(){
		Enumeration e = ht.keys();
		while(e.hasMoreElements()){
			Object key = e.nextElement();
			Integer keyObj = (Integer)key;
			int k = keyObj.intValue();

			Object value = ht.get(key);
			String v = (String)value;

			System.out.println("k: "+k+", v: " +v);
		}
	}
	public static void main(String[] args) 
	{
		C c = new C();
		c.in();
		c.out();
	}
}

class CC
{
	Hashtable ht = new Hashtable();
	void in(){
		ht.put(10, "Spring"); // put (int, String)
		ht.put(20, "Summer");
		ht.put(30, "Fall");
		ht.put(40, "Winter");
		System.out.println(ht.size());
	}
	void out(){
		Enumeration e = ht.keys();
		while(e.hasMoreElements()){
			Object key = e.nextElement();
			Integer keyObj = (Integer)key;
			int k = keyObj.intValue();

			Object value = ht.get(key);
			String v = (String)value;

			System.out.println(k+v);
		}
	}
	public static void main(String[] args){
		CC c = new CC();
		c.in();
		c.out();
	}
}