import java.io.*;
import java.util.*;

class LottoC {
	String fname;
	FileReader fr;
	BufferedReader br;
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
	ArrayList<String> list = new ArrayList<String>();
	int winnum;

	void init(){
		try{
			p("파일 이름을 입력하세요(기본: list.txt): ");
			String line = file.readLine();  // 문자열을 입력 받음
			line = line.trim();
			if(line.length() == 0){
				fname = "list.txt";
			}else{
				fname = line;
			}
			fr = new FileReader(fname);
			br = new BufferedReader(fr);
		}catch(FileNotFoundException fe){
			pln(fname + " 파일이 존재하지 않습니다.");
			init();
		}catch(IOException ie){
		}
	}

	void in(){
		String line = null;
		try{
			while((line = br.readLine()) != null){
				if(line != null) line = line.trim();
				if(line.length() != 0) {
					list.add(line);
				}
			}
		}catch(IOException ie){
		}
	}

	void innum(){
		p("당첨 번호를 입력해주세요: ");
		try{
			String line = in.readLine();  // 문자열을 입력 받음
			line = line.trim();
			winnum = Integer.parseInt(line);
			if(winnum < 1 || winnum > list.size()){
				pln("범위: 1~" + list.size());
				innum();
			}else{
				out();
			}
		}catch(IOException ie){
		}catch(NumberFormatException ne){
			pln("!!잘못된 숫자를 입력했습니다!!");
			innum();
		}
	}

	Random r = new Random();

	Hashtable<Integer, String> ht = new Hashtable<Integer, String>();

	void out(){
		while(ht.size() != winnum){
			int idx = r.nextInt(winnum);
			ht.put(idx, list.get(idx));
		}

		Set<Integer> keys = ht.keySet();
		for(int key : keys){
			pln("번호: " + (key + 1) + ", 이름: " + ht.get(key));
		}
	}

	void p(String str){
		System.out.print(str);
	}

	void pln(String str){
		System.out.println(str);
	}

	public static void main(String[] args) {
		LottoC lo = new LottoC();
		lo.init();
		lo.in();
		lo.innum();
	}
}
/*
	1. 파일을 읽어오는 부분을 수정하여 한글로 수정했습니다.
	2. 입력 받는 부분을 수정하여 한글로 수정했습니다.
*/