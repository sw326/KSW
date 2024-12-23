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
		Enumeration<Integer> e = ht.keys();
		while(e.hasMoreElements()){
			//Object key = e.nextElement();
			Integer keyObj = e.nextElement();
			//int k = keyObj.intValue();
			int k = keyObj //UnBoxing ( Integer -> int )

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
