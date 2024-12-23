import java.net.*;
import java.io.*;

class ChatServer{
	int port = 4000;
	ServerSocket ss;
	Socket s;
	P p = new P();

	ChatServer(){
		try{
			ss=new ServerSocket(port);
			p.pln(port+"번 포트에서 TCP서버 대기중...");

			s=ss.accept();
			InetAddress ia=s.getInetAddress();
			String ipClient=ia.getHostAddress();
			p.pln("클라이언트("+ipClient+") 접속 완료!");
				
			Thread listen = new Thread(new Listener(s));
			Thread speak = new Thread(new Speaker(s));
			// 쓰레드 시작
			listen.start();
			speak.start();
			try{
				listen.join();
				speak.join();
			}catch(InterruptedException ie){}
		}catch(IOException ie){
			p.pln(port+"번 포트는 이미 사용중입니다");
		}finally{
			try{
				s.close();
				ss.close();
			}catch(IOException ie){}
		}
	}
	public static void main(String args[]){
		new ChatServer();
	}
}

class ChatClient{
	Socket s;
	String ipServer = "10.41.2.105";
	int port = 4000;
	P p = new P();
	ChatClient(){
		try{
			s=new Socket(ipServer, port);
			p.pln("서버와 접속 성공");

			Thread listen = new Thread(new Listener(s));
			Thread speak = new Thread(new Speaker(s));
			// 쓰레드 시작
			listen.start();
			speak.start();
			
			// 쓰레드가 끝날 때까지 대기
			try{
				listen.join();
				speak.join();
			}catch(InterruptedException ie){}
		}catch(UnknownHostException ue){
		}catch(IOException ie){
			p.pln("네트워크 상에 그런 주소와 포트의 서버를 찾을 수 없음");
		}finally{
			try{
				s.close();
				p.pln("서버와 접속 해제");
			}catch(IOException ie){}
		}
	}
	public static void main(String[] args){
		new ChatClient();
	}
}

class Listener implements Runnable{
	DataInputStream dis;
	InputStream is;
	Socket s;
	P p = new P();

	Listener(Socket s){
		try{
			this.s = s;
			this.is = s.getInputStream();
			this.dis = new DataInputStream(is);
		}catch(IOException ie){}
	}
	public void run(){
		try{
			while(true){
				String msg = dis.readUTF();
				p.pln(">> "+msg);
			}
		}catch(IOException ie){
		}finally{
			try{
				dis.close();
				is.close();
			}catch(IOException ie){}
		}
	}
}

class Speaker implements Runnable{
	OutputStream os;
	DataOutputStream dos;
	Socket s;
	String ipServer = "10.41.2.105";
	BufferedReader br;

	Speaker(Socket s){
		try{
			this.s = s;
			this.os = s.getOutputStream();
			this.dos = new DataOutputStream(os);
			this.br = new BufferedReader(new InputStreamReader(System.in));
		}catch(IOException ie){}
	}
	public void run(){
		try{
			while(true){
				String line = br.readLine();
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
}
class P{
	void pln(String str){
		System.out.println(str);
	}
	void p(String str){
		System.out.print(str);
	}
}