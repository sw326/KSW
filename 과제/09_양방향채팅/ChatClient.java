import java.net.*;
import java.io.*;

class ChatClient {
	Socket s;
	String ipServer = "10.41.2.105";
	int port = 4000;
	OutputStream os;
	DataOutputStream dos;

	void in(){
		try{
			ss = new ServerSocket(port);
			pln(port+"번 포트에서 TCP서버 대기중..");

			s = ss.accept();
			InetAddress ia = s.getInetAddress();
			ipClient = ia.getHostAddress();
			pln("클라이언트("+ipClient+") 접속 완료!");

			is = ss.getInpurStream();
			dis = new DataInputStream(is);

			listen();
		}catch(IOException ie){
			pln(port+"번 포트는 이미 사용중입니다");
		}finally {
			try{
				s.close();
				ss.close();
			}catch(IOException ie){}
		}
	}
	void out(){
		try{
			s = new Socket(ipServer, port);
			pln("서버와 접속 성공");

			os = s.getOutputStream();
			dos = new DataOutputStream(os);
			speak();
		}catch(UnknownHostException ue){
		}catch(IOException ie){
			pln("네트워상에 그런 주소(ip와 port)의 서버를 찾을 수 없음");
		}finally{
			try{
				s.close();
				pln("서버와 접속 해제");
			}catch(IOException ie){}
		}
	}
	void listen(){
		try{
			while(true){
				String msg = dis.readUTF();
				pln("Client>> " + msg);
			}
		}catch(IOException ie){
		}finally{
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
		new ChatClient();
	}
}