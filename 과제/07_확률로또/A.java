import java.io.*;

// keyboard -> Monitor
class A {
	InputStream is = System.in;
	OutputStream os = System.out;
	A(){
	}
	void inOut1(){
		try{
			while(true){
				int i = is.read();
				System.out.println("i: "+(char)i);
			}
		}catch(IOException ie){}
	}
	public static void main(String[] args) 
	{
		//System.out.println("Hello World!");
		A a = new A();
		a.inOut1();
	}
}
