import java.net.*;
import java.io.*;

class AClient {
	Socket s;
	String ipServer = "10.41.2.105";
	int port = 4000;
	P p = new P();

	AClient(){
		try{
			s = new Socket(ipServer, port);
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
			p.pln("네트워상에 그런 주소(ip와 port)의 서버를 찾을 수 없음");
		}finally{
			try{
				s.close();
				p.pln("서버와 접속 해제");
			}catch(IOException ie){}
		}
	}
	public static void main(String[] args) {
		new AClient();
	}
}