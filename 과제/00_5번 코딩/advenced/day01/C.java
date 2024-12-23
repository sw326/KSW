import java.io.*;

// Keyboard -> File
class C {
	InputStream is = System.in; // Node
	FileOutputStream fos; // Node

	BufferedInputStream bis; // filter
	BufferedOutputStream bos; // filter
	String fn = "C.txt";
	C(){
		bis = new BufferedInputStream(is, 1024);// read
		try{
			fos = new FileOutputStream(fn, true); // true는 append
		}catch(FileNotFoundException fnfe){}
		bos = new BufferedOutputStream(fos, 1024); // write
	}
	void save1(){
		byte[] bs = new byte[1024];
		try{
			int i = 0;
			long total = 0L;
			while((i=bis.read(bs)) != -1){
				bos.write(bs, 0, i);
				total += i;
			}
			bos.flush();
			System.out.println(fn+"에 쓰기 완료!");
		}catch(IOException ie){
		}finally{
			try{
				bis.close();
				bos.close();
			}catch(IOException ie){}
		}
	}
	void save2(){
		try{
			byte[] bs = bis.readAllBytes();
			bos.write(bs);
			bos.flush();
			System.out.println("복사성공(2): " +bs.length+" bytes");
		}catch(IOException ie){
		}finally{
			try{
				bis.close();
				bos.close();
			}catch(IOException ie){}
		}
	}
	public static void main(String[] args) {
		//System.out.println("Hello World!");
		C c = new C();
		//c.save1();
		c.save2();
	}
}

class C1{
	InputStream is = System.in; // node
	FileOutputStream fos; // node
	BufferedInputStream bis; // filter
	BufferedOutputStream bos; // filter
	String fn = "C.txt";
	C1(){
		bis = new BufferedInputStream(is, 1024); // read
		try{
			fos = new FileOutputStream(fn, true);
		}catch(FileNotFoundException fe){}
		bos = new BufferedOutputStream(fos, 1024); // write
	}
	void save1(){
		byte[] bs = new byte[1024];
		try{
			int i = 0;
			long total = 0L;
			while((i=bis.read(bs))!=-1){
				bos.write(bs, 0, i);
				total+=i;
			}
			bos.flush();
			System.out.println(fn);
		}catch(IOException ie){
		}finally{
			try{
				bis.close();
				bos.close();
			}catch(IOException ie){}
		}
	}
	void save2(){
		try{
			byte[] bs = bis.readAllBytes();
			bos.write(bs);
			bos.flush();
			System.out.println(bs.length);
		}catch(IOException ie){
		}finally{
			try{
				bis.close();
				bos.close();
			}catch(IOException ie){}
		}
	}
	public static void main(String[] args){
		C1 c = new C1();
		c.save1();
	}
}

class C2{
	InputStream is = System.in;
	FileOutputStream fos;
	BufferedInputStream bis;
	BufferedOutputStream bos;
	String fn ="C.txt";
	C2(){
		bis = new BufferedInputStream(is, 1024);
		try{
			fos = new FileOutputStream(fn, true);
		}catch(FileNotFoundException fe){}
		bos = new BufferedOutputStream(fos,1024);
	}
	void save1(){
		byte[] bs = new byte[1024];
		try{
			int i = 0;
			long total = 0L;
			while((i=bis.read(bs))!=-1){
				bos.write(bs, 0 ,i);
				total+=i;
			}
			bos.flush();
			System.out.println(fn);
		}catch(IOException ie){
		}finally{
			try{
				bis.close();
				bos.close();
			}catch(IOException ie){}
		}
	}
	void save2(){
		try{
			byte[] bs = bis.readAllBytes();
			bos.write(bs);
			bos.flush();
			System.out.println(bs.length);
		}catch(IOException ie){
		}finally{
			try{
				bis.close();
				bos.close();
			}catch(IOException ie){}
		}
	}
	public static void main(String args[]){
		C2 s = new C2();
		c.save1();
	}
}

class C3{
	InputStream is = System.in;
	FileOutputStream fos;
	BufferedInputStream bis;
	BufferedOutputStream bos;
	String fn = "C.txt";
	C3(){
		bis = new BufferedInputStream(is, 1024);
		try{
			fos = new FileOutputStream(fn, true);
		}catch(FileNotFoundException fe){}
		bos = new BufferedOutputStream(fos, 1024);
	}
	void save1(){
		byte[] bs = new byte[1024];
		try{
			int i = 0;
			long total = 0L;
			while((i=bis.read(bs))!=-1){
				bos.write(bs, 0, i);
				total+=i;
			}
			bos.flush();
		}catch(IOException ie){
		}finally{
			try{
				bis.close();
				bos.close();
			}catch(IOException ie){}
		}
	}
	void save2(){
		try{
			byte[] bs = bis.readAllBytes();
			bos.write(bs);
			bos.flush();
		}catch(IOException ie){
		}finally{
			try{
				bis.close();
				bos.close();
			}catch(IOException ie){}
		}
	}
	public static void main(String args[]){
		C3 c = new C3();
		c.save3();
	}
}

class C4{
	InputStream is = System.in;
	FileOutputStream fos;
	BufferedInputStream bis;
	BufferedOutputStream bos;
	String fn = "C.txt";
	C(){
		bis = new BufferedInputStream(is, 1024);
		try{
			fos = new FileOutputStream(fn, true);
		}catch(FileNotFoundException fn){
		}
		bos = new BufferedOutputStream(fos, 1024);
	}
	void save1(){
		byte[] bs = new byte[1024];
		try{
			int i = 0;
			long total = 0L;
			while((i=bis.read(bs))!=-1){
				bos.write(bs, 0, i);
				total+=i;
			}
			bos.flush();
		}catch(IOException ie){
		}fianlly{
			try{
				bis.close();
				bos.close();
			}catch(IOException ie){}
		}
	}
	void save2(){
		try{
			byte[] bs = bis.readAllBytes();
			bos.write(bs);
			bos.flush();
		}catch(IOException ie){
		}finally{
			try{
				bis.close();
				bos.close();
			}catch(IOException ie){}
		}
	}
	public static void main(String args[]){
		C4 c = new C4();
		c.save1();
	}
}