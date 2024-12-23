```java
class ArrayT 
{
    int is[] = {10, 20, 30};//배열
    void in(){
    }
    void out(){
        for(int i: is){ //Enhanced Loop 적용
            System.out.println(i);
        }
    }
    public static void main(String[] args) 
    {
        new ArrayT().out();
    }
}