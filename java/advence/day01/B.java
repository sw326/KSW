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
