import java.util.*;

class C3
{
	Hashtable<Integer, String> ht = new Hashtable<Integer, String>();
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

			//Object value = ht.get(key);
			//String v = (String)value;
			String v = ht.get(keyObj);

			System.out.println("k: "+k+", v: " +v);
		}
	}
	public static void main(String[] args) 
	{
		C3 c = new C3();
		c.in();
		c.out();
	}
}

class C31
{
	Hashtable<Integer, String> ht = new Hashtable<Integer, String>();
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
			Object key =e.nextElement();
			Integer keyObj = (Integer)key;
			int k = keyObj.intValue();
			String v = ht.get(keyObj);
			System.out.println(k+v);
		}
	}
	public static void main(String[] args){
		C31 c = new C31();
		c.in();
		c.out();
	}
}

class C32
{
	Hashtable<Integer, String> ht = new Hashtable<Integer, String>();
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
			String v = ht.get(keyObj);
			System.out.println(k+v);
		}
	}
	public static void main(String[] args){
		C32 c = new C32();
		c.in();
		c.out();
	}
}