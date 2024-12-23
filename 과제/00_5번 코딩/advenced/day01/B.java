import java.io.*;

// File -> File
class B {
	FileInputStream fis;
	FileOutputStream fos;
	String fn_in="A.java";
	String fn_out="ACopy.java";
	B(){
		try{
			fis = new FileInputStream(fn_in);
			fos = new FileOutputStream(fn_out);
		}catch(FileNotFoundException fnfe){}
	}
	void copy1(){
		byte[] bs = new byte[1024];
		try{
			int i = 0;
			long total = 0L;
			while((i=fis.read(bs)) != -1){
				fos.write(bs, 0, i);
				total += i;
			}
			fos.flush();
			System.out.println("복사성공(1): " + total+" bytes");
		}catch(IOException ie){
		}finally{
			try{
				fis.close();
				fos.close();
			}catch(IOException ie){}
		}
	}
	void copy2(){
		try{
			byte[] bs = fis.readAllBytes();
			fos.write(bs);
			fos.flush();
			System.out.println("복사성공(2): " +bs.length+" bytes");
		}catch(IOException ie){
		}finally{
			try{
				fis.close();
				fos.close();
			}catch(IOException ie){}
		}
	}
	public static void main(String[] args){
		//System.out.println("Hello World!");
		B b = new B();
		b.copy1();
		//b.copy2();
	}
}

class B1{
	FileInputStream fis;
	FileOutputStream fos;
	String fn_in = "A.java";
	String fn_out = "ACopy.java";
	B1(){
		try{
			fis = new FileInputStream(fn_in);
			fos = new FileOutputStream(fn_out);
		}catch(FileNotFoundException fn){}
	}
	void copy1(){
		byte[] bs = new byte[1024];
		try{
			int i = 0;
			long total = 0L;
			while((i=fis.read(bs))!= -1){
				fos.write(bs, 0, i);
				total +=i;
			}
			fos.flush();
			System.out.println("복사성공(1): " + total+" bytes");
		}catch(IOException ie){
		}finally{
			try{
				fis.close();
				fos.close();
			}catch(IOException ie){}
		}
	}
	void copy2(){
		try{
			byte[] bs = fis.readAllBytes();
			fos.write(bs);
			fos.flush();
			System.out.println("복사성공(2): " + bs.length+" bytes");
		}catch(IOException ie){
		}finally{
			try{
				fis.close();
				fos.close();
			}catch(IOException ie){}
		}
	}
	public static void main(String args[]){
		B1 b = new B1();
		b.copy1();
	}
}

class B2{
	FileInputStream fis;
	FileOutputStream fos;
	String fn_in="A.java";
	String fn_out="ACopy.java";
	B2(){
		try{
			fis = new FileInputStream(fn_in);
			fos = new FileOutputStream(fn_in);
		}catch(FileNotFoundException fn){}
	}
	void copy1(){
		byte[] bs = new byte[1024];
		try{
			int i = 0;
			long total = 0L;
			while((i=fis.read(bs))!=-1){
				fos.write(bs, 0, i);
				total+=i;
			}
			fos.flush();
			System.out.println("복사성공(1): " + total+" bytes");
		}catch(IOException ie){
		}finally{
			try{
				fis.close();
				fos.close();
			}catch(IOException ie){}
		}
	}
	void copy2(){
		try{
			byte[] bs = fis.readAllBytes();
			fos.write(bs);
			fos.flush();
			System.out.println("복사성공(2): " +bs.length+" bytes");
		}catch(IOException ie){
		}finally{
			try{
				fis.close();
				fos.close();
			}catch(IOException ie){}
		}
	}
	public static void main(String args[]){
		B2 b = new B2();
		b.copy2();
	}
}

class B3{
	FileInputStream fis;
	FileOutputStream fos;
	String fn_in="A.java";
	String fn_out="ACopy.java";
	B3(){
		try{
			fis = new FileInputStream(fn_in);
			fos = new FileOutputStream(fn_out);
		}catch(FileNotFoundException fn){}
	}
	void copy1(){
		byte[] bs = new byte[1024];
		try{
			int i = 0;
			long total = 0L;
			while((i=fis.read(bs))!=-1){
				fos.write(bs, 0, i);
				total+=i;
			}
			fos.flush();
			System.out.println("success");
		}catch(IOException ie){
		}finally{
			try{
				fis.close();
				fos.close();
			}catch(IOException ie){}
		}
	}
	void copy2(){
		try{
			byte[] bs = fis.radAllBytes();
			fos.write(bs);
			fos.flush();
			System.out.println("Success");
		}catch(IOException ie){
		}finally{
			try{
				fis.close();
				fos.close();
			}catch(IOException ie){}
		}
	}
	public static void main(String args[]){
		B3 b = new B3();
		b.copy1();
	}
}

class B4{
	FileInputStream fis;
	FileOutputStream fos;
	String fn_in="A.java";
	String fn_out="ACopy.java";
	B4(){
		try{
			fis = new FileInputStream(fn_in);
			fos = new FileOutputStream(fn_out);
		}catch(FileNotFoundException fnfe){}
	}
	void copy1(){
		byte[] bs = new byte[1024];
		try{
			int i = 0;
			long total = 0L;
			while((i=fis.read(bs))!=-1){
				fos.write(bs, 0 , i);
				total+=i;
			}
			fos.flush();
		}catch(IOException ie){
		}finally{
			try{
				fis.close();
				fos.close();
			}catch(IOException ie){}
		}
	}
	void copy2(){
		try{
			byte[] bs = fis.readAllBytes();
			fos.write(bs);
			fos.flush();
			System.out.println(bs.length);
		}catch(IOException ie){
		}finally{
			try{
				fis.close();
				fos.close();
			}catch(IOException ie){}
		}
	}
	public static void main(String args[]){
		B4 b = new B4();
		b.copy1();
	}
}

class B5{
	FileInputStream fis;
	FileOutputStream fos;
	String fn_in="A.java";
	String fn_out="ACopy.java";
	B5(){
		try{
			fis = new FileInputStream(fn_in);
			fos = new FileOutputStream(fn_out);
		}catch(FileNotFoundException fnfe){}
	}
	void copy1(){
		byte[] bs = new byte[1024];
		try{
			int i = 0;
			long total = 0L;
			while((i=fis.read(bs))!=-1){
				fos.write(bs, 0, i);
				total+=i;
			}
			fos.flush();
			System.out.println(total);
		}catch(IOException ie){
		}finally{
			try{
				fis.close();
				fos.close();
			}catch(IOException ie){}
		}
	}
	void copy2(){
		try{
			byte[] bs = fis.readAllBytes();
			fos.write(bs);
			fos.flush();
			System.out.println(bs.length);
		}catch(IOException ie){
		}finally{
			try{
				fis.close();
				fos.close();
			}catch(IOException ie){}
		}
	}
	public static void main(String args[]){
		B5 b = new B5();
		b.copy2();
	}
}