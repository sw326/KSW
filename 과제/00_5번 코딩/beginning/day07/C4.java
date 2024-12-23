import java.util.*;

class C4
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
		Set<K> keys = ht.keySet();
		for(int key : keys){
			System.out.println("key: "+key+", value: "+ht.get(key));
		}
	}
	public static void main(String[] args) 
	{
		C4 c = new C4();
		c.in();
		c.out();
	}
}
