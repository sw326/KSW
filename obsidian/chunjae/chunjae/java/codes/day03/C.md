```java
class C 
{
    byte b = 127;
    void m1(){
        b = (byte)(b + 1);
        System.out.println("B: "+b);
    }
    void m2(){
        float f1 = 100.1111111111f;
        float f2 = 200.2222222222f;
        float f = f1 + f2;
        System.out.println("f: " + f);

        double d2 = 200.2222222222;
        double d = f1 +d2;
        System.out.println("d: " + d);
    }
    void m3(){
        long lo = 12345678901234567890L;
        System.out.println("lo: " + lo);
    }
    public static void main(String[] args) 
    {
        C c = new C();
        // c.m1();
        // c.m2();
        c.m3();
    }
}