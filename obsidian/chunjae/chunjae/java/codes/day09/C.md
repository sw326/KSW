```java
class C 
{
    void m(){
        try{
            System.out.println("1");
            new ExceptionUser();
            System.out.println("2");
            //return;
            System.exit(-1); // 비정상종료
        }catch(MyException me){
            System.out.println("3");
        }finally{
            System.out.println("4");
        }
        System.out.println("5");
    }
    public static void main(String[] args) 
    {
        C c = new C();
        c.m();
        System.out.println("6");
    }
}