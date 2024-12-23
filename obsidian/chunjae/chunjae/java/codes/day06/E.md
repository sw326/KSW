```java
class E 
{
    int is[] = {1, 2};
    int iss[][] = {is, {30, 40, 50, 60}, {700}};
    int isss[][][] = {iss, {{8000, 9000,}, {10000}} };
    void m1(){
        for(int i=0;i<isss.length;i++){
            for(int j=0;j<isss[i].length;j++){
                for(int k=0;k<isss[i][j].length;k++){
                    System.out.println("isss["+i+"]["+j+"]["+k+"]: " + isss[i][j][k]);
                }
            }
        }
    }
    public static void main(String[] args) 
    {
        E e = new E();
        e.m1();
    }
} 