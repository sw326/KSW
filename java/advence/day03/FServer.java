import java.net.*;
import java.io.*;

class FServer {
	int port = 5000;
	ServerSocket ss;
	Socket s;
	String ipClient;
	InputStream is;
	BufferedInputStream bis;
	FileOutputStream fos;
	BufferedOutputStream bos;
	String fname = "IO.jpg";
	//String fname = "goodwarriors.mpeg";

	FServer(){
		try{
			ss = new ServerSocket(port);
			pln(port+"번 포트에서 파일 서버 대기중..");
			s = ss.accept();
			ipClient = s.getInetAddress().getHostAddress();
			pln("파일 클라이언트("+ipClient+") 접속 성공");
			
			makeStream();
			receive();
		}catch(IOException ie){}
	}
	void makeStream(){
		try{
			is = s.getInputStream();
			bis = new BufferedInputStream(is, 2048);

			File dir = new File("store");
			if(!dir.exists()) dir.mkdir();

			fos = new FileOutputStream(dir+"/"+fname);
			bos = new BufferedOutputStream(fos, 2048);
		}catch(IOException ie){}
	}
	void receive(){ //Socket -> File
		byte bs[] = new byte[512];
		try{
			int i = 0; 
			long totalSize = 0L;
			while((i=bis.read(bs)) != -1){
				bos.write(bs, 0, i);
				totalSize += i;
			}
			bos.flush();
			pln("파일("+fname+") 받기 완료!("+totalSize+"bytes)");
		}catch(IOException ie){
		}finally{
			try{
				bis.close();
				is.close();
				bos.close();
				fos.close();
				s.close();
				ss.close();
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
		new FServer();
	}
}