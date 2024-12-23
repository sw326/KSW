```java
class Boxing 
{
    //WrapperClass: Byte, Short, Character, Integer, Long Float, Double, Boolean
    byte b = 1;
    short s= 2;
    char c= 'A';
    int i = 3;
    long lo = 4;
    float f = 5.0f;
    double d = 6.0;
    boolean flag = true;

    Byte bObj = b;
    Short sObj = s;
    Character cObj = c;
    Integer iObj = i;
    Long loObj = lo;
    Float fObj = f;
    Double dObj = d;
    Boolean flagObj = flag;
    
    void box(){
        bObj = b;
        sObj = s;
        cObj = c;
        iObj = i;
        loObj = lo;
        fObj = f;
        dObj = d;
        flagObj = flag;
    }
    void unbox(){
        b= bObj;
        s = sObj;
        c = cObj;
        i = iObj;
        lo = loObj;
        f = fObj;
        d = dObj;
        flag = flagObj;

        System.out.println("다시 기본형이 되었을까?" +(b+1));
    }
    public static void main(String[] args) 
    {
        Boxing b = new Boxing();
        b.box();
        b.unbox();
    }
} 