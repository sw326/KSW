import java.io.*;
import java.net.*;

class ChatSer{
	int port = 4000;
	ServerSocket ss;
	Socket s;
	String ipClient;
	InputStream is;
	DataInputStream dis;
	OutputStream os;
	DataOutputStream dos;

	ChatSer(){
		try{
			ss = new ServerSocket(port);
			pln(port+"번 포트에서 TCP서버 대기중..");

			s = ss.accept();
			InetAddress ia = s.getInetAddress();
			ipClient = ia.getHostAddress();
			pln("클라이언트("+ipClient+") 접속 완료!");

			is = s.getInputStream();
			dis = new DataInputStream(is);
			os = s.getOutputStream();
			dos = new DataOutputStream(os);

			new Thread(()->listen()).start();
			speak();
		}catch(IOException ie){
			pln(port+"번 포트는 이미 사용중입니다");
		}finally{
			try{
				s.close();
				ss.close();
			}catch(IOException ie){}
		}
	}
	void listen(){
		String msg = "";
		try{
			while(true){
				msg=dis.readUTF();
				pln("Client>> "+ msg);
			}
		}catch(IOException ie){
			pln("서버 퇴장! 2초 후에 종료할게요");
			try{
				Thread.sleep(2000);
			}catch(Exception e){
				System.exit(-1);
			}finally{
				try{
					dis.close();
					is.close();
				}catch(IOException iee){}
			}
		}
	}
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	void speak(){
		String line ="";
		try{
			while(true){
				line = br.readLine();
				dos.writeUTF(line);
				dos.flush();
			}
		}catch(IOException ie){}
	}
	void p(String str){
		System.out.print(str);
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args){
		new ChatServer();
	}
}

class chatCli{
	Socket s;
	String ipServer = "10.41.2.105";
	int port = 4000;
	InputStream is;
	DataInputStream dis;
	OutputStream os;
	DataOutputStream dos;

	ChatCli(){
		try{
			s=new Socket(ipServer, port);
			pln("서버와 접속 성공");

			is = s.getInputStream();
			dis = new DataInputStream(is);

			os = s.getOutputStream();
			dos = new DataOutputStream(os);

			new Thread(()->listen()).start();
			speak();
		}catch(){}
	}
	public static void main(String args[]){
		new ChatCli();
	}
}