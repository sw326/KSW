import java.io.*;

// Keyboard -> File
class F{
	BufferedReader br; // filter = new BufferedReader(new InputStreamReader(System.in));
	InputStreamReader isr; // bridge
	InputStream is = System.in; // Node

	PrintWriter pw; // filter ( no need bridge )
	FileOutputStream fos; // Node

	String fn = "F.txt";
	F(){
		isr = new InputStreamReader(is);
		br = new BufferedReader(isr);

		try{
			fos = new FileOutputStream(fn, true);
		}catch(FileNotFoundException fe){}
		pw = new PrintWriter(fos, true);
	}
	void save(){
		String line ="";
		try{
			line = br.readLine();
			pw.println(line);
		}catch(IOException ie){
		}finally{
			try{
				br.close();
				isr.close();
				is.close();
				pw.close();
				fos.close();
			}catch(IOException ie){}
		}
	}
	public static void main(String[] args){
		F f = new F();
		f.save();
	}
}

class F1{
	BufferedReader br;
	InputStreamReader isr;
	InputStream is = System.in;

	PrintWriter pw;
	FileOutputStream fos;
	String fn = "F.txt";
	F1(){
		isr = new InputStreamReader(is);
		br = new BufferedReader(isr);
		try{
			fos = new FileOutputStream(fn, true);
		}catch(FileNotFoundException fe){}
		pw=new PrintWriter(fos, true);
	}
	void save(){
		String line = "";
		try{
			line = br.readLine();
			pw.println(line);
		}catch(IOException ie){
		}finally{
			try{
				br.close();
				isr.close();
				is.close();
				pw.close();
				fos.close();
			}catch(IOException ie){}
		}
	}
	public static void main(String args[]){
		F1 f = new F1();
		f.save();
	}
}

class F2{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw;
	FileOutputStream fos;
	String fn = "F.txt";
	F2(){
		try{
			fos = new FileOutputStream(fn, true);
		}catch(FileNotFoundException fe){}
		pw = new PrintWriter(fos, true);
	}
	void save(){
		String line = "";
		try{
			line = br.readLine();
			pw.println(line);
		}catch(IOException ie){
		}finally{
			try{
				br.close();
				pw.close();
				fos.close();
			}catch(IOException ie){}
		}
	}
	public static void main(String args[]){
		F2 f = new F2();
		f.save();
	}
}

class F3{
	String fn = "F.txt";
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw;
	F3(){
		try{
			PrintWriter pw = new PrintWriter(new FileOutputStream(fn, true));
		}catch(FileNotFoundException fe){}
	}
	void save(){
		String line = "";
		try{
			line = br.readLine();
			pw.println(line);
		}catch(IOException ie){
		}finally{
			try{
				br.close();
				pw.close();
			}catch(IOException ie){
			}catch(NullPointerException ne){}
		}
	}
	public static void main(String args[]){
		F3 f = new F3();
		f.save();
	}
}