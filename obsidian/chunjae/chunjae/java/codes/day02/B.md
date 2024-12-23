```java
class B 
{
    B(){
        System.out.println("2");
        m();
    }
    void m(){
        System.out.println("3");
    }
    public static void main(String[] args) 
    {
        System.out.println("1");
        new B();
        System.out.println("4");
    }
} 