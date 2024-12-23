import java.io.*;
class Tip1  
{
	String fname = "우리반.txt";
	FileReader fr;
	BufferedReader br;
	String names[] = new String[8];
	Tip1(){
		try{
			fr = new FileReader(fname);
			br = new BufferedReader(fr);
		}catch (FileNotFoundException fe){
			pln(fname+"이란 파일을 못 찾음");
		}
	}
	void read(){
		String line = null;
		try{
			int i = 0;
			while((line= br.readLine()) != null){
				if(line != null) line = line.trim();
				if(line.length() !=0){
					names[i] = line;
					i++;
				}
			}
		}
		catch (IOException ie){}
	}
	void showNames(){
		for(int i=0;i<names.length;i++){
			pln("names["+i+"]: "+names[i]);
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	void p(String str){
		System.out.print(str);
	}
	public static void main(String[] args) 
	{
		Tip1 t = Tip1();
		t.read();
		t.showNames();
	}
}

// 무작위로 뽑는 기능
// 파일에서 데이터를 가져오는 기능 '우리반.txt'
