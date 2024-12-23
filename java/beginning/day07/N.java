import java.util.*;

class N 
{
	Hashtable<Integer, String> map1 = new Hashtable<Integer, String>();
	Hashtable<Integer, String> map2 = new Hashtable<Integer, String>();

	HashSet<Hashtable<Integer, String>> hs = new HashSet<Hashtable<Integer, String>>();
	void in(){
		map1.put(1, "breakfast");
		map1.put(2, "lunch");
		map1.put(3, "dinner");

		map2.put(10, "work out");
		map2.put(20, "English class");
		map2.put(30, "swimming");

		hs.add(map1);
		hs.add(map2);
	}
	void out(){
		for(Hashtable<Integer, String> ht :hs){
			Set<Integer> keys = ht.keySet();
			for(int key: keys){
				System.out.println("key: " + key + ", value: "+ ht.get(key));
			}
		}
	}
	public static void main(String[] args) 
	{
		N n = new N();
		n.in();
		n.out();
	}
}
