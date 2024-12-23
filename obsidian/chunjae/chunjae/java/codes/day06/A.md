```java
class A 
{
    void m1(){
        //String strs[] = null; // (1)선언
        //strs = new String[4]; //(2)생성
        //String strs[] = new String[4];
        //strs[0] = "spring"; // in (3)초기화
        //strs[1] = "summer"; // in
        
        String strs[] = {"spring", "summer", "fall", "winter"}; // 선언 밒 생성 및 초기화

        for(int i = 0;i<strs.length;i++){
            System.out.println(strs[i]); //out
        }
    }
    void m2(){
        //int is[] = null; // (1) 선언
        //is = new int[2]; // (2) 생성
        //int is[] = new int[2];
        //is[0] = 10; // 초기화
        //is[1] = 20;

        int is[] = {10, 20}; // 선언 밒 생성 및 초기화

        for(int i=0;i<is.length;i++){
            System.out.println(is[i]); // out
        }
    }
    public static void main(String[] args) 
    {
        A a = new A();
        a.m1();
    }
}