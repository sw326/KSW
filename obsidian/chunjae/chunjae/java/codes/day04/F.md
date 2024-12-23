```java
class F 
{
    void m1(){
        for (int i=1;i<=4;i++){
            for (int j= -i;j<=-1;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    void m2(){
        for (int i=0;i<=4;i++){
            for (int j=0;j<4-i;j++){
                System.out.print("  ");
            }
            for (int k=0;k<i;k++ ){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    void m3(){
        for (int i=1;i<=4;i++){
            for (int j=i;j<=4;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    void m4(){
        for (int i=0;i<=3;i++){
            for (int j= -i;j<0;j++){
                System.out.print("  ");
            }
            for (int k=i;k<=3;k++ ){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) 
    {
        F f = new F();
        f.m1();
        System.out.println();
        f.m2();
        System.out.println();
        f.m3();
        System.out.println();
        f.m4();
    }
} 