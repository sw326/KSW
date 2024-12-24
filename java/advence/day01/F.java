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
