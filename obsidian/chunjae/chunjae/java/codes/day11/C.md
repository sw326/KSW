package a.b;

public interface C {
    int I = 0; //상수
    void m1(); //추상메소드
    static void m2(){ //static메소드 
        System.out.println("C m2()");
    }
    default void m3(){ //default메소드
        System.out.println("C m3()");
    }
}  