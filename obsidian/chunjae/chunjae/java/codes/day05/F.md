```java
class F 
{
    F(){
        System.out.println("F()");
        //return;
    }
    void m1(){
        System.out.println("m1()");
        //return;
    }
    String m2(){
        System.out.println("m2()");
        if(true){
            return "lunch";
        }
        return "dinner";
    }
    public static void main(String[] args) 
    {
        F f = new F();
        f.m1();
        String r = f.m2();
        System.out.println("main() r: " +r);
        //return;
    }
}