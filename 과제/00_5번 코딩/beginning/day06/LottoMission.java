import java.io.*;
import java.util.*;

class LottoMission 
{
	String fname = "우리반.txt";
	FileReader fr;
	BufferedReader br;
	Random r = new Random();
	String names[];
	LottoMission(){
		try{
			fr= new FileReader(fname);
			br= new BufferedReader(fr);
		}catch(FileNotFoundException fe){
			pln(fname+"이란 파일을 못 찾음");
		}
	}
	void read(){
		String line = null;
		int count = 0;
		try{
			while((line = br.readLine()) != null){
				if(line != null) line = line.trim();
				if(line.length() !=0) count++;
			}

			names = new String[count];

			fr= new FileReader(fname);
			br= new BufferedReader(fr);

			int i = 0;
			while((line = br.readLine()) != null){
				if(line != null) line = line.trim();
				if(line.length() !=0){
					names[i] = line;
					i++;
				}
			}
		}
		catch (IOException ie){
			pln("파일 읽기 오류: " + ie);
		}
	}
	void showRan(){
		int ran = r.nextInt(names.length);
		pln("총 인 원: " +names.length);
		pln("당첨 번호: "+(ran+1));
		pln("당 첨 자: "+names[ran]);
	}
	void pln(String str){
		System.out.println(str);
	}
	void p(String str){
		System.out.print(str);
	}
	public static void main(String[] args) 
	{
		LottoMission l = new LottoMission();
		l.read();
		l.showRan();
	}
}

class LottoMission1
{
	String fname="우리반.txt";
	FileReader fr;
	BufferedReader br;
	LottoMission(){
		try{
			fr=new FileReader(fname);
			br=new BufferedReader(fr);
		}catch(FileNotFoundException fe){
			pln(fname+"이란 파일을 못 찾음");
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args){
		LottoMission1 l = new LottoMission1();
}