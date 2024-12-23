import java.io.*;
import java.util.*;

class LottoC{
	String fname = "우리반.txt";
	FileReader fr;
	BufferedReader br;
	Vector<String> v = new Vector<String>();
	LottoC(){
		try{
			fr = new FileReader(fname);
			br = new BufferedReader(fr);
		}catch(FileNotFoundException fe){
			pln(fname+"이란 파일을 못 찾았습니다.");
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
			pln("파일 읽기 오류: " + ie);
		}
	}
	void showRan(){
		Random r = new Random();
		int i = r.nextInt(v.size());
		pln(" 총 인원: "+v.size());
		pln(" 당첨자 : "+v.get(i));
		pln("당첨 번호: "+(i+1));
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