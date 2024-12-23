```java
class E 
{
    void m1(){
        byte b = 10;
        short s = 20;
        int r = b + s;
        System.out.println("r: " +r);
    }
    public static void main(String[] args) 
    {
        E e = new E();
        e.m1();
    }
} 