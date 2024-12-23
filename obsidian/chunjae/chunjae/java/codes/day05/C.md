```java
class C // continue 
{
    void m1(){
        aa:
        for(int j=0;j<2;j++){
            for(int i=0;i<5;i++){
                if(i==2) continue aa;
                System.out.println("j: "+j+", i: "+i);
            }
            System.out.println("inner for inner");
        }
        System.out.println("outer for outer");
    }
    public static void main(String[] args) 
    {
        C c = new C();
        c.m1();
    }
} 