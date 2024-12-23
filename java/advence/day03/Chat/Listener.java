import java.net.*;
import java.io.*;

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
				p.pln(">> " + msg);
			}
		}catch(IOException  ie){
		}finally{
			try{
				dis.close();
				is.close();
			}catch(IOException ie){}
		}
	}
}