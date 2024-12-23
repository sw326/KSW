import java.util.*;

class C2 
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
		C2 c = new C2();
		c.in();
		c.out();
	}
}

class C21
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
			String v = ht.get(k);
			System.out.println(k+v);
		}
	}
	public static void main(String srgs[]){
		C21 c = new C21();
		c.in();
		c.out();
	}
}

class C22
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
			String v = ht.get(k);
			System.out.println(k+v);
		}
	}
	public static void main(String[] args){
		C22 c = new C22();
		c.in();
		c.out();
	}
}