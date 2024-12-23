```java
class E 
{
    void m1(){
        for(int i = 1;i<=4;i++){
            System.out.println();
            for(int j = 1;j<=4;j++){
                System.out.print("* ");
            }
        }
    }
    void m2(){
        for(int i = 1;i<=4;i++){
            for(int j = 1;j<=4;j++){
                for(int k = 1;k<=4;k++){
                    for(int l = 1;l<=4;l++){
                        System.out.print("* ");
                    }
                    System.out.print(" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    public static void main(String[] args) 
    {
        E e = new E();
        e.m2();
    }
} 