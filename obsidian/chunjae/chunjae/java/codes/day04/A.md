```java
class A 
{
    void m1(){
        int i = 0;
        if(i<0){
            System.out.println("Hello World!");
        } else if(i>0) {
            System.out.println("Yello World!");
        } else {
            System.out.println("Yellow World!");
        }
    }
    void m2(){
        int i = 2;
        switch(i // 정수형(byte short char int)과 String만){
            case 1: System.out.println("1"); break;
            case 2: System.out.println("2"); break;
            case 3: System.out.println("3"); break;
            default : System.out.println("1, 2, 3은 아니다"); // default의 위치는 상관은 없다
        }
        System.out.println("밖");
    }
    void m3(){
        String food = "점심";
        switch(food // String){
            case "아침": System.out.println("아침식사"); break;
            case "점심": System.out.println("점심식사"); break;
            case "저녁": System.out.println("저녁식사"); break;
            default : System.out.println("아침, 점심, 저녁은 아니다"); 
        }
        System.out.println("밖");
    }
    public static void main(String[] args) 
    {
        A a = new A();
        a.m1();
    }
} 