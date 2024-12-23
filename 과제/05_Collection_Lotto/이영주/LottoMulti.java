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
				set_on("�츮��.txt");
			}
		}catch(IOException ie){
		}
	}
	void set_on(String fname){
		try{
			fr = new FileReader(fname);
			br = new BufferedReader(fr);
		}catch(FileNotFoundException fe){
			pln(fname + "������ �����ϴ�. �ٽ� �Է����ּ���");
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
		p("��÷ �ο��� �ۼ����ּ��� : ");
		br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int selNum=Integer.parseInt(line);
			if(selNum<1||selNum>menbers.size()){
				pln("������ �߸� �Է� �ϼ˽��ϴ�.(1~"+menbers.size()+")");
				show();
			}else{
				pln("============================");
				Random r = new Random();
				TreeSet<Integer> sel = new TreeSet<Integer>();
				pln("�� �ο� : " + menbers.size()+", ��÷�� �� : " + selNum);
				while(sel.size()<selNum){
					int ran = r.nextInt(menbers.size());
					sel.add(ran);
				}

				for(int i : sel) pln("��÷��ȣ : " + (i+1) +", ��÷�� : " + menbers.get(i));
				/*
				
				pln("��÷�� : " + menbers.get(i));
				pln("��÷��ȣ : " + (i+1));
				*/
			}
		}
		catch(NumberFormatException ne){
			pln("���ڸ� �Է��ϼž� �մϴ�.");
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
		lot.p("���ϸ�(�⺻ �츮��.txt) : ");
		lot.init();
		lot.read();
		lot.show();
	}
}
