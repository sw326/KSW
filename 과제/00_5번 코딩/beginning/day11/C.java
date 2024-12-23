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

public interface C1{
	public static final int I = 0;
	public abstract void m1();
	public static void m2(){}
	public default void m3(){}
}

public interface C2{
	public static final int I = 0;
	public abstaract void m1();
	public static void m2(){}
	public default void m3(){}
}

public interface C3{
	public static final int I = 0;
	public abstract void m1();
	public static void m2(){}
	public default void m3(){}
}

public interface C4{
	public static final int I =0;
	public abstract void m1();
	public static void m2(){}
	public default void m3(){}
}

interface C5{
	int I = 0;
	void m1();
	static void m2(){}
	default void m3(){}
}