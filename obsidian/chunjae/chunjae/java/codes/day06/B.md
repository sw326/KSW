```java
class B 
{
    boolean flags[] = new boolean[2];
    int is[] = new int[2];
    double ds[] = new double[2];
    String strs[] = new String[2];

    void out(){
        System.out.println("flags[0]: " + flags[0]);
        System.out.println("is[0]: " + is[0]);
        System.out.println("ds[0]: " + ds[0]);
        System.out.println("strs[0]: " + strs[0]);
    }
    public static void main(String[] args) 
    {
        B b = new B();
        b.out();
    }
} 