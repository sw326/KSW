import java.io.*;

class In{
	FileReader fr;
	BufferedReader br;
	Lotto1RateN lot;

	In(Lotto1RateN lot){
		this.lot = lot;
	}
	void input(){
		P.p("���ϸ�(�⺻ �츮��.txt) : ");
		try{
			String fname="";
			br = new BufferedReader(new InputStreamReader(System.in));
			fname = br.readLine();
			if(fname.length()!=0){
				fname = fname.trim();
				fileSet(fname);
			}else{
				fileSet("�츮��.txt");
			}
		}catch(IOException ie){
		}
	}

	void fileSet(String fname){
		try{
			fr = new FileReader(fname);
			br = new BufferedReader(fr);
		}catch(FileNotFoundException fe){
			P.pln(fname + "������ �����ϴ�. �ٽ� �Է����ּ���");
			input();
		}
	}

	int qGetIntInput(String reQuestion){
		P.p(reQuestion);
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line = br.readLine();
			line.trim();
			return Integer.parseInt(line);
		}
		catch (IOException ie){
			P.pln("�߸� �Է��ϼ˽��ϴ�.");
			return qGetIntInput(reQuestion);
		}
		catch (NumberFormatException ne){
			P.pln("���ڸ� �Է��ϼž��մϴ�.");
			return qGetIntInput(reQuestion);
		}
	}
	void read(){
		String line="";
		try{
			while((line=br.readLine())!=null){
				if(line != null) line = line.trim();
				if(line.length() !=0) lot.menbers.add(line);
			}
		}
		catch(IOException ie){}
	}
}
