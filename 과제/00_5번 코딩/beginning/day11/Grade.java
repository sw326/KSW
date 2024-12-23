import hava.io.*;

class Grade{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String[] subjects;
	int scores[];
	Grade(String[] subjects){
		this.subjects = subjects;
		scores = new int[subjects.length];
	}
	void input(int i){
		String line = "";
		p(subjects[i] + ": ");
		try{
			line = br.readLine();
			if(line!=null) line.trim();
			if(line.length() !=0){
				scores[i] = Integer.parseInt(line);
				if(scores[i]<0 || scores[i]>100){
					pln("점수의 범위는 0~100입니다.");
					intput(i);
				}
			}else{
				input(i);
			}
		}catch(IOException ie){
		}catch(NumberFormatException ne){
			pln("숫자의 형태만 가능합니다.");
			input(i);
		}
	}
	int total = 0;
	int avg = 0;
	String grade = "F";
	void cal(){
		for(int score : scores){
			total += score;
		}
		pln("총점: "+ total);
		avg = total/scores.length;
		pln("평균: "+avg);
	}
	void showGrade(){
		switch(avg/10){
			case 10:
			case 9: grade = "A"; break;
			case 8: grade = "B"; break;
			case 7: grade = "C"; break;
			case 6: grade = "D"; break;
		}
		pln("학점: "+ grade);
	}
	void p(String str){
		System.out.print(str);
	}
	void pln(String str){
		System.out.println(str);
	}
	public staic main(String[] subjects){
		Grade g = new Grade(subjects);
		if(subjects.length == 0){
			g.pln("사용법 Grade 과목1 과목2 ...");
			return;
		}
		//1. input logic
		for(int i=0;i<subjects.length;i++){
			g.input(i);
		}
		//2. judge logic
		g.cal();

		//3. grade print logic
		g.showGrade();
	}
}