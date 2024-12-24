import java.io.*;

//File -> File
class E{
	Reader r;
	Writer w;
	String fn_in = "E.java";
	String fn_out = "E.txt";

	E(){
		try{
			r = new FileReader(fn_in);
			w = new FileWriter(fn_out);
		}catch(FileNotFoundException fnfe){
		}catch(IOException ie){}
	}
	void copy(){
		char[] cs = new char[128];
		try{
			int i = 0;
			long total = 0L;
			while((i=r.read(cs)) != -1){
				w.write(cs, 0, i);
				total += i;
			}
			w.flush();
			System.out.println("복사완료! 읽은 총 문자수: " + total);
		}catch(IOException ie){
		}finally{
			try{
				r.close();
				w.close();
			}catch(IOException ie){}
		}
	}
	public static void main(String[] args) {
		E e = new E();
		e.copy();
	}
}

//File -> File & Monitor
class E1{
	Reader r;
	Writer w;
	String fn_in = "E.java";
	String fn_out = "E.txt";
	OutputStream os = System.out; // 쓰기2 (모니터)
	OutputStreamWriter osw;

	E1(){
		try{
			r = new FileReader(fn_in);
			w = new FileWriter(fn_out);
			osw = new OutputStreamWriter(os);
		}catch(FileNotFoundException fnfe){
		}catch(IOException ie){}
	}
	void copy(){
		char[] cs = new char[128];
		try{
			int i = 0;
			long total = 0L;
			while((i=r.read(cs)) != -1){
				w.write(cs, 0, i); // 파일에 쓰기
				osw.write(cs, 0, i); // 모니터에 쓰기
				total += i;
			}
			w.flush();
			osw.flush();
			System.out.println("복사완료! 읽은 총 문자수: " + total);
		}catch(IOException ie){
		}finally{
			try{
				r.close();
				w.close();
				osw.close();
			}catch(IOException ie){}
		}
	}
	public static void main(String[] args) {
		E1 e = new E1();
		e.copy();
	}
}
