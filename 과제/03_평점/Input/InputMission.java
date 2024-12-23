import java.io.*;

class InputMission {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int[] scores;
	int totalScore = 0;

	void input(String sub){
		p(sub+": ");
		try{
			String line = br.readLine();
			line = line.trim();
			int i = Integer.parseInt(line);
			
			if(i<0 || i>100){
				pln("0 ~ 100까지의 숫자만 입력해 주세요.");
				input(sub);
			}else{
				pln(sub+" 점수 : "+i);
				totalScore += i;
			}
		}catch(IOException ie){
		}catch(NumberFormatException ne){
			pln("숫자를 입력해 주세요.");
			input(sub);
		}
	}
	void scoreAndAverage() {
		pln("총점 : "+totalScore);
		int avg = totalScore/scores.length;
		pln("평균 : "+avg);
		if(avg>=90){
			pln("A 학점입니다.");
		}else if(avg>=80 && avg<90){
			pln("D 학점입니다.");
		}else if(avg>=70 && avg<80){
			pln("C 학점입니다.");
		}else if(avg>=60 && avg<70){
			pln("B 학점입니다.");
		}else{
			pln("D 학점입니다.");
		}
	}
	void pln(String str) {
		System.out.println(str);
	}
	void p(String str) {
		System.out.print(str);
	}
	public static void main(String[] args) {
		if(args.length<=1){
			System.out.println("사용법: java InputMission sub1 sub2 sub3 ... ");
			return;
		}
		InputMission a = new InputMission();
		a.scores = new int[args.length];

		for(int i=0;i<args.length;i++){
			a.input(args[i]);
		}
		a.scoreAndAverage();
	}
}
