import java.net.*;
import java.io.*;

class AServer {
	int port = 4000;
	ServerSocket ss;
	Socket s;
	String ipClient;
	InputStream is;
	DataInputStream dis;
	OutputStream os;
	DataOutputStream dos;

	AServer(){
		try{
			ss = new ServerSocket(port);
			pln(port+"번 포트에서 TCP서버 대기중..");

			//while(true){
			s = ss.accept(); //대기시키는 메소드(IO블럭)
			InetAddress ia = s.getInetAddress();
			ipClient = ia.getHostAddress();
			pln("클라이언트("+ipClient+") 접속 완료!");
			//}

			is = s.getInputStream();
			dis = new DataInputStream(is);

			os = s.getOutputStream();
			dos = new DataOutputStream(os);

			new Thread(()->listen()).start();
			speak();
			
		}catch(IOException ie){
			pln(port+"번 포트는 이미 사용중입니다");
		}finally {
			try{
				s.close();
				ss.close();
			}catch(IOException ie){}
		}
	}
	void listen(){ //Socket -> Moniter 
		String msg = "";
		try{
			while(true){
				msg = dis.readUTF();
				pln("Client>> " + msg);
			}
		}catch(IOException ie){
			pln("서버 퇴장! 2초후에 종료할께요~");
			try{
				Thread.sleep(2000);
			}catch(Exception e){}
			System.exit( -1);
		}finally {
			try{
				dis.close();
				is.close();
			}catch(IOException ie){}
		}
	}
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	void speak(){ //keyboard -> socket
		String line = "";
		try{
			while(true){
				line = br.readLine();
				dos.writeUTF(line);
				dos.flush();
			}
		}catch(IOException ie){
		}finally{
			try{
				dos.close();
				os.close();
				br.close();
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
		new AServer();
	}
}