import java.net.*;
import java.io.*;

class FClient {
	int port = 5000;
	String ip = "10.41.1.109";
	Socket s;
	String path = "D:/SOO/Advanced/자료실/IO.jpg";
	//String path = "D:/SOO/Advanced/자료실/goodwarriors.mpeg";

	FileInputStream fis;
	BufferedInputStream bis;
	OutputStream os;
	BufferedOutputStream bos;

	FClient(){
		try{
			s = new Socket(ip, port);

			makeStream();
			send();
		}catch(IOException ie){}
	}
	void makeStream(){
		try{
			fis = new FileInputStream(path);
			bis = new BufferedInputStream(fis, 2048);

			os = s.getOutputStream();
			bos = new BufferedOutputStream(os, 2048);
		}catch(IOException ie){}
	}
	void send(){ //File -> Socket 
		byte bs[] = new byte[512];
		try{
			int i = 0; 
			long totalSize = 0L;
			while((i=bis.read(bs)) != -1){
				bos.write(bs, 0, i);
				totalSize += i;
			}
			bos.flush();
			pln("파일 보내기 완료!("+totalSize+"bytes)");
		}catch(IOException ie){
		}finally{
			try{
				bis.close();
				fis.close();
				bos.close();
				os.close();
				s.close();
			}catch(IOException ie){}
		}
	}
	void p(String str){
		System.out.print(str);
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) {
		new FClient();
	}
}