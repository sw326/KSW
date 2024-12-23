```java
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
    void out2(){ // value값들만 꺼내기
        System.out.println("(1) Iterator를 이용하는 방법");
        Collection col = ht.values();
        Iterator iter =  col.iterator();
        while(iter.hasNext()){
            Object obj = iter.next();
            String value = (String)obj;
            System.out.print("value: " + value+ " ");
        }
    }
    void out3(){
        System.out.println("(2) toArray를 이용하는 방법");
        Collection col = ht.values();
        Object[] values = col.toArray();
        for(int i=0; i<values.length;i++){
            Object obj = values[i];
            String value = (String)obj;
            System.out.println("value: " + value);
        }
    }
    public static void main(String[] args) 
    {
        C c = new C();
        c.in();
        //c.out();
        //c.out2();
        c.out3();
    }
}