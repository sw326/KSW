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
				System.out.print("i: "+(char)i+ " ");
				if(i==13) break;
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

// keyboard -> Monitor
class A1 {
	InputStream is = System.in;
	OutputStream os = System.out;
	A1(){
	}
	void inOut1(){
		byte[] bs = new byte[1024];
		try{
			int i = 0;
			while((i=is.read(bs)) != -1){
				os.write(bs, 0, i);
			}
			os.flush();
		}catch(IOException ie){
		}finally{
			try{
				is.close();
				os.close();
			}catch(IOException ie){}
		}
	}
	public static void main(String[] args) 
	{
		//System.out.println("Hello World!");
		A1 a = new A1();
		a.inOut1();
	}
}

// File -> Monitor
class A2 {
	InputStream is = System.in;
	OutputStream os = System.out;
	String fname = "A.java";
	void initKey(){ // keyboard
		is = System.in;
	}
	void initFile(){ // File
		try{
			is = new FileInputStream(fname); // File
		}catch(FileNotFoundException fe){}
	}
	void inOut1(){
		byte[] bs = new byte[1024];
		try{
			int i = 0;
			long total = 0L;
			while((i=is.read(bs)) != -1){
				os.write(bs, 0, i);
				total += i;
			}
			os.flush();
			System.out.println("(1)읽은 총 바이트수: " + total);
		}catch(IOException ie){
		}finally{
			try{
				is.close();
				os.close();
			}catch(IOException ie){}
		}
	}
	void inOut2(){
		try{
			byte[] bs = is.readAllBytes();
			os.write(bs);
			os.flush();
			System.out.println("(2)읽은 총 바이트 수: "+bs.length);
		}catch(IOException ie){
		}finally{
			try{
				is.close();
				os.close();
			}catch(IOException ie){}
		}
	}
	public static void main(String[] args) 
	{
		//System.out.println("Hello World!");
		A2 a = new A2();
		//a.initKey();
		a.initFile();
		//a.inOut1();
		a.inOut2();
	}
}

class A3{
	InputStream is = System.in;
	OutputStream os = System.out;
	String fname = "A.java";
	void initFile(){
		try{
			is = new FileInputStream(fname);
		}catch(FileNotFoundException fnfe){}
	}
	void inOut1(){
		byte[] bs = new byte[1024];
		try{
			int i = 0;
			long total = 0L;
			while((i=is.read(bs)) != -1){
				os.write(bs, 0, i);
				total += i;
			}
			os.flush();
			System.out.println("(1)읽은 총 바이트수: " + total);
		}catch(IOException ie){
		}finally{
			try{
				is.close();
				os.close();
			}catch(IOException ie){}
		}
	}
	void inOut2(){
		try{
			byte[] bs = is.readAllBytes();
			os.write(bs);
			os.flush();
			System.out.println("(2)읽은 총 바이트 수: "+bs.length);
		}catch(IOException ie){
		}finally{
			try{
				is.close();
				os.close();
			}catch(IOException ie){}
		}
	}
	public static void main(String args[]){
		A3 a = new A3();
		//a.initKey();
		a.initFile();
		//a.inOut1();
		a.inOut2();
	}
}

class A4{
	InputStream is = System.in;
	OutputStream os = System.out;
	String fname = "A.java";
	void initKey(){
		is = System.in;
	}
	void initFile(){
		try{
			is = new FileInputStream(fname);
		}catch(FileNotFoundException fe){}
	}
	void inOut1(){
		byte[] bs = new byte[1024];
		try{
			int i = 0;
			long total = 0L;
			while((i=is.read(bs)) != -1){
				os.write(bs, 0, i);
				total += i;
			}
			os.flush();
			System.out.println("(1)읽은 총 바이트수: " + total);
		}catch(IOException ie){}
	}
	void inOut2(){
		try{
			byte[] bs = is.readAllBytes();
			os.write(bs);
			os.flush();
			System.out.println("(2)읽은 총 바이트수: " + bs.length);
		}catch(IOException ie){
		}finally{
			try{
				is.close();
				os.close();
			}catch(IOException ie){}
		}
	}
	public static void main(String args[]){
		A4 a = new A4();
		a.initFile();
		a.inOut1();
	}
}

class A5{
	InputStream is = System.in;
	OutputStream os = System.out;
	String fname = "A.java";
	void initFile(){
		try{
			is = new FileInputStream(fname);
		}catch(FileNotFoundException fe){}
	}
	void inOut1(){
		byte[] bs = new byte[1024];
		try{
			int i = 0;
			long total = 0L;
			while((i=is.read(bs))!= -1){
				os.write(bs, o, i);
				total+=i;
			}
			os.flush();
			System.out.println("(1)읽은 총 바이트수: " + total);
		}catch(IOException ie){
		}finally{
			try{
				is.close();
				os.close();
			}catch(IOException ie){}
		}
	}
	void inOut2(){
		try{
			byte[] bs = is.readAllBytes();
			os.write(b);
			os.flush();
			System.out.println("(2)읽은 총 바이트수: " + bs.length);
		}catch(IOException ie){
		}finally{
			try{
				is.close();
				os.close();
			}catch(IOException ie){}
		}
	}
	public static void main(String args[]){
		A5 a = new A5();
		A2 a = new A2();
		//a.initKey();
		a.initFile();
		//a.inOut1();
		a.inOut2();
	}
}