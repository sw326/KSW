import java.io.*;

//D.java -> File('D.txt') -> Moniter 
class D {
	FileOutputStream fos; //근본
	DataOutputStream dos; //목적 
	String fn = "D.txt";

	FileInputStream fis; //근본 
	DataInputStream dis; //목적

	byte b = 1;
	short s = 2;
	char c = 'A';
	int i = 3;
	long lo = 4L;
	float f = 5.0f;
	double d = 6.0;
	boolean flag = false;
	String str = "점심식사"; //3*4=12

	D(){
		try{
			fos = new FileOutputStream(fn);
			dos = new DataOutputStream(fos);

			fis = new FileInputStream(fn);
			dis = new DataInputStream(fis);
		}catch(FileNotFoundException fe){
		}
	}
	void w(){ //D.java -> File('D.txt')
		try{
			dos.writeByte(b);
			dos.writeShort(s);
			dos.writeChar(c);
			dos.writeInt(i);
			dos.writeLong(lo);
			dos.writeFloat(f);
			dos.writeDouble(d);
			dos.writeBoolean(flag);
			dos.writeUTF(str);
			dos.flush();
			System.out.println(fn+"에 쓰기완료!");
		}catch(IOException ie){}
	}
	void r() throws IOException { //File('D.txt') -> Moniter 
		byte r1 = dis.readByte();
		short r2 = dis.readShort();
		char r3 = dis.readChar();
		int r4 = dis.readInt();
		long r5 = dis.readLong();
		float r6 = dis.readFloat();
		double r7 = dis.readDouble();
		boolean r8 = dis.readBoolean();
		String r9 = dis.readUTF();

		System.out.println(
			"r1:"+r1+",r2:"+r2+",r3:"+r3+",r4:"+r4
			+",r5:"+r5+",r6:"+r6+",r7:"+r7+",r8:"+r8+",r9:"+r9);
	}
	public static void main(String[] args) {
		D d = new D();
		d.w();
		try{
			d.r();
		}catch(IOException ie){}
	}
}

class D1{
	FileOutputStream fos;
	DataOutputStream dos;
	String fn = "D.txt";
	FileInputStream fis;
	DataInputStream dis;

	byte b = 1;
	short s = 2;
	char c = 'A';
	int i = 3;
	long lo = 4L;
	float f = 5.0f;
	double d = 6.0;
	boolean flag = false;
	String str = "점심식사"; //3*4=12

	D1(){
		try{
			fos = new FileOutputStream(fn);
			dos = new DataOutputStream(fos);

			fis = new FileInputStream(fn);
			dis = new DataInputStream(fis);
		}catch(FileNotFoundException fe){
		}
	}
	void w(){ //D.java -> File('D.txt')
		try{
			dos.writeByte(b);
			dos.writeShort(s);
			dos.writeChar(c);
			dos.writeInt(i);
			dos.writeLong(lo);
			dos.writeFloat(f);
			dos.writeDouble(d);
			dos.writeBoolean(flag);
			dos.writeUTF(str);
			dos.flush();
			System.out.println(fn+"에 쓰기완료!");
		}catch(IOException ie){}
	}
	void r() throws IOException { //File('D.txt') -> Moniter 
		byte r1 = dis.readByte();
		short r2 = dis.readShort();
		char r3 = dis.readChar();
		int r4 = dis.readInt();
		long r5 = dis.readLong();
		float r6 = dis.readFloat();
		double r7 = dis.readDouble();
		boolean r8 = dis.readBoolean();
		String r9 = dis.readUTF();

		System.out.println(
			"r1:"+r1+",r2:"+r2+",r3:"+r3+",r4:"+r4
			+",r5:"+r5+",r6:"+r6+",r7:"+r7+",r8:"+r8+",r9:"+r9);
	}
	public static void main(String args[]){
		D1 d = new D1();
		d.w();
		try{
			d.r();
		}catch(IOException ie){}
	}
}