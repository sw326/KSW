import java.io.*;
import java.util.*;

class LottoC 
{
	String fname = "우리반.txt";
	FileReader fr;
	BufferedReader br;
	ArrayList<String> list = new ArrayList<String>();
	void init(){
		try{
			fr = new FileReader(fname);
			br = new BufferedReader(fr);
		}catch(FileNotFoundException fe){
			pln(fname+"라는 파일을 찾지 못했습니다.");
		}
	}
	void in(){
		String line = null;
		try{
			while((line = br.readLine()) !=null){
				if(line != null) line = line.trim();
				if(line.length() != 0){
					list.add(line);
				}
			}
		}catch (IOException ie){
		}
	}
	void out(){
		Random r = new Random();
		int idx = r.nextInt(list.size());
		pln("총인원: "+ list.size());
		pln("당첨자: "+ list.get(idx));
		pln("당첨번호: "+(idx+1));
	}
	void pln(String str){
		System.out.println(str);
	}
	void p(String str){
		System.out.print(str);
	}
	public static void main(String[] args) 
	{
		LottoC lo = new LottoC();
		lo.init();
		lo.in();
		lo.out();
	}
}

/*
	1. 파일을 읽어서 컬렉션에 저장한다
	2. 랜덤한 숫자를 추출해서 해당 인덱스에 저장된 값을 출력
*/