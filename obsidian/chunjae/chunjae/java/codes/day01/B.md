```java
class B 
{
    B(){
        System.out.println("B객체 생성");
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("B객체 생성 끝!");
    }
    public static void main(String[] args) 
    {
        new B();
    }
} 