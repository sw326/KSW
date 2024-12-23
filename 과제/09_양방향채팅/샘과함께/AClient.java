import java.net.*;
import java.io.*;

class AClient {
	Socket s;
	String ipServer = "10.41.2.105";
	int port = 4000;
	InputStream is;
	DataInputStream dis;
	OutputStream os;
	DataOutputStream dos;

	AClient(){
		//Socket(String host,int port) throws UnknownHostException, IOException
		try{
			s = new Socket(ipServer, port);
			pln("서버와 접속 성공");

			is = s.getInputStream();
			dis = new DataInputStream(is);

			os = s.getOutputStream();
			dos = new DataOutputStream(os);

			new Thread(()->listen()).start();
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
	void listen(){ //Socket -> Moniter 
		String msg = "";
		try{
			while(true){
				msg = dis.readUTF();
				pln("Server>> " + msg);
			}
		}catch(IOException ie){
			pln("클라이언트 퇴장! 2초후에 종료할께요~");
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
		new AClient();
	}
}