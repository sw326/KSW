```java
import java.util.*;

class A
{
    Vector v = new Vector();
    void in(){
        v.add("Spring");v.add("Summer");v.add("fall");v.add("winter");
        System.out.println("v.size(): " + v.size());
    }
    void out(){
        for(int i=0;i<v.size();i++){
            Object obj = v.get(i);
            String str = (String)obj;
            System.out.println(str);
        }
    }
    public static void main(String[] args) 
    {
        A a = new A();
        a.in();
        a.out();
    }
}