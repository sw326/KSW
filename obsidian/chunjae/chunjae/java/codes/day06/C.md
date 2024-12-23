```java
class C
{
    byte b = 10;
    short s = 20;
    char c = 'A';
    int i = 30;
    long lo = 40L;
    float f = 50.0f;
    double d = 60.0;

    C(){
        int is[] = {b, s, c, i, (int)lo, (int)f, (int)d};
        out(is);
    }
    void out(int is[]){
        for (int i=0;i<is.length;i++){
            System.out.println("is["+i+"]: "+is[i]);
        }
    }
    public static void main(String[] args) 
    {
        new C();
    }
} 