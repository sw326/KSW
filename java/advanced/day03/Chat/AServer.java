import java.net.*;
import java.io.*;

class AServer {
	int port = 4000;
	ServerSocket ss;
	Socket s;
	P p = new P();
	
	AServer(){
		try{
			ss = new ServerSocket(port);
			p.pln(port+"번 포트에서 TCP서버 대기중..");

			s = ss.accept(); //대기시키는 메소드(IO블럭)
			InetAddress ia = s.getInetAddress();
			String ipClient = ia.getHostAddress();
			p.pln("클라이언트("+ipClient+") 접속 완료!");

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
		}catch(IOException ie){
			p.pln(port+"번 포트는 이미 사용중입니다");
		}finally {
			try{
				s.close();
				ss.close();
			}catch(IOException ie){}
		}
	}
	public static void main(String[] args) {
		new AServer();
	}
}
