import java.io.*;

class Input2 
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	void input(String subject){
		p(subject+": ");
		try{
			String line = br.readLine();
			line = line.trim();
			int i = Integer.parseInt(line);
			if(i<0 || i>100){
				pln("정수의 범위는 0~100점 사이에요");
				input(subject);
			}else{
				pln("유효한 점수 : " +i);
			}
		}catch(IOException ie){
		}catch(NumberFormatException ne){
			pln("숫자의 형태가 아니에요 ㅜㅜ");
			input(subject);
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	void p(String str){
		System.out.println(str);
	}
	public static void main(String[] args) 
	{
		if(args.length !=3){
			System.out.println("실행예) java Input2 국어 영어 수학");
			return;
		}
		Input2 a = new Input2();
		a.input(args[0]);
		a.input(args[1]);
		a.input(args[2]);
	}
}
