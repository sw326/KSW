import java.io.*;
import java.util.*;

class LottoC{
	String fname = "�츮��.txt";
	FileReader fr;
	BufferedReader br;
	Vector<String> v = new Vector<String>();
	LottoC(){
		try{
			fr = new FileReader(fname);
			br = new BufferedReader(fr);
		}catch(FileNotFoundException fe){
			pln(fname+"�̶� ������ �� ã�ҽ��ϴ�.");
		}
	}
	void read(){
		String line = "";
		int i = 0;
		try{
			while((line=br.readLine()) !=null){
				if(line !=null) line =line.trim();
				if(line.length() !=0) v.add(line);
				i++;
			}
		}catch(IOException ie){
			pln("���� �б� ����: " + ie);
		}
	}
	void showRan(){
		Random r = new Random();
		int i = r.nextInt(v.size());
		pln(" �� �ο�: "+v.size());
		pln(" ��÷�� : "+v.get(i));
		pln("��÷ ��ȣ: "+(i+1));
	}
	void pln(String str){
		System.out.println(str);
	}
	void p(String str){
		System.out.println(str);
	}
	public static void main(String[] args){
		LottoC lo = new LottoC();
		lo.read();
		lo.showRan();
	}
}