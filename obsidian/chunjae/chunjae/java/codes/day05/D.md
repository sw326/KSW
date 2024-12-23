```java
class D 
{
    int i;
    D(){
        System.out.println("D()의 시작");
        m1();
        System.out.println("D()의 끝");
    }
    void m1(){
        System.out.println("m1()의 시작");
        if(i==0) return;
        System.out.println("m1()의 끝");
    }
    public static void main(String[] args) 
    {
        D d = new D();
        //d.m1();
        if(d.i==0) return;
        System.out.println("main의 끝");
    }
}