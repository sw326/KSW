import java.net.*;
import java.io.*;

class Speaker implements Runnable{
	OutputStream os;
	DataOutputStream dos;
	Socket s;
	String ipServer = "10.41.1.109";
	BufferedReader br;
	
	Speaker(Socket s){
		try{
			this.s = s;
			this.os = s.getOutputStream();
			this.dos = new DataOutputStream(os);
			this.br = new BufferedReader(new InputStreamReader(System.in));
		}catch(IOException  ie){}
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
