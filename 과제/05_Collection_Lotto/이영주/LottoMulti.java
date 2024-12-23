import java.io.*;
import java.util.*;
class LottoMulti
{
	FileReader fr;
	BufferedReader br;
	Vector<String> menbers = new Vector<String>();
	void init(){
		try{
			String fname="";
			br = new BufferedReader(new InputStreamReader(System.in));
			fname = br.readLine();
			if(fname.length()!=0){
				fname = fname.trim();
				set_on(fname);
			}else{
				set_on("우리반.txt");
			}
		}catch(IOException ie){
		}
	}
	void set_on(String fname){
		try{
			fr = new FileReader(fname);
			br = new BufferedReader(fr);
		}catch(FileNotFoundException fe){
			pln(fname + "파일이 없습니다. 다시 입력해주세요");
			init();
		}
	}
	void read(){
		String line="";
		try{
			while((line=br.readLine())!=null){
				if(line != null) line = line.trim();
				if(line.length() !=0) menbers.add(line);
			}
		}
		catch(IOException ie){}
		}

	void show(){
		try{
		p("당첨 인원을 작성해주세요 : ");
		br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int selNum=Integer.parseInt(line);
			if(selNum<1||selNum>menbers.size()){
				pln("범위를 잘못 입력 하셧습니다.(1~"+menbers.size()+")");
				show();
			}else{
				pln("============================");
				Random r = new Random();
				TreeSet<Integer> sel = new TreeSet<Integer>();
				pln("총 인원 : " + menbers.size()+", 당첨자 수 : " + selNum);
				while(sel.size()<selNum){
					int ran = r.nextInt(menbers.size());
					sel.add(ran);
				}

				for(int i : sel) pln("당첨번호 : " + (i+1) +", 당첨자 : " + menbers.get(i));
				/*
				
				pln("당첨자 : " + menbers.get(i));
				pln("당첨번호 : " + (i+1));
				*/
			}
		}
		catch(NumberFormatException ne){
			pln("숫자를 입력하셔야 합니다.");
			show();
		}catch(IOException ie){}
	}
	void pln(String str){
		System.out.println(str);
	}
	void p(String str){
		System.out.print(str);
	}
	public static void main(String[] args) 
	{
		LottoMulti lot = new LottoMulti();
		lot.p("파일명(기본 우리반.txt) : ");
		lot.init();
		lot.read();
		lot.show();
	}
}
