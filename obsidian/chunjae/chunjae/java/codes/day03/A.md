```java
class A 
{
    int i = 1; // 객체변수(전역==맴버)
    static int ii = 2; // 클래스변수(전역==맴버)
    A(int k){ // 지역
        int j = 3; // 지역
        System.out.println("A() j: " + j);
        System.out.println("A() k: " + k);
    }
    void m(){
        System.out.println("m() i: " + i);
        // System.out.println("A() j: " + j);
        // System.out.println("A() k: " + k);
    }
    public static void main(String[] args) 
    {
        A a = new A(4);
        a.m();
        System.out.println("main() i: " + a.i);
        System.out.println("main() ii: " + A.ii);
    }
}