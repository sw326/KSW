import java.io.*;
import java.util.*;

class RanLotto{
	String fname = "list.txt"; // 기본 파일 이름
	BufferedReader br;
	Random r = new Random();
	
	// 이름과 확률을 저장할 리스트
	class Candidate{
		String name;
		int rate;

		Candidate(String name, int rate){
			this.name = name;
			this.rate = rate;
		}
	}

	ArrayList<Candidate> candidates = new ArrayList<Candidate>(); //전체 후보자 리스트
	Candidate winner = null;

	void init(){
		try{
			File file = new File(fname); // 기본 파일 이름
			if(file.exists()){
				// 파일이 존재하면 읽음
				br = new BufferedReader(new FileReader(file));
			}else{
				p(fname + " 파일이 존재하지 않습니다. 다시 입력해주세요. :");
				br = new BufferedReader(new InputStreamReader(System.in));
				fname = fname.trim();
				fileName(fname);
			}
		}catch(IOException ie){}
	}

	void fileName(String fname){
		try{
			File file = new File(fname);
			br = new BufferedReader(new FileReader(file));
		}catch(FileNotFoundException fe){
			init();
		}
	}

	void read(){
		String line;
		try{
			while((line=br.readLine()) != null){
				if(line!=null) line=line.trim();
				if(line.length()!=0) splitLine(line);
			}
		}catch(IOException ie){}
	}

	void splitLine(String line){
		int i = line.indexOf(" ");
		if(i==-1){ // 확률이 없는 경우
			candidates.add(new Candidate(line, 0));
		}else{ // 확률이 있는 경우
			String name = line.substring(0, i).trim(); // 이상 미만
			String strRate = line.substring(i).trim(); // 이상
			try{
				int rate = Integer.parseInt(strRate);
				candidates.add(new Candidate(name, rate));
			}catch(NumberFormatException ne){
				pln("Wrong Rate");
				candidates.add(new Candidate(name, 0));
			}
		}
	}

	void show(){
        // 확률이 있는 후보부터 당첨 검사
		int totalProbability = 0;
        for (Candidate c : candidates) {
            totalProbability += c.rate;
			if(totalProbability>100){
				pln("확률의 합은 100이 넘어갈 수 없습니다.");
				System.exit(-1);
			}
        }

		// 0~99난수 생성
		if(totalProbability>0){
			int rand = r.nextInt(100);
			int currentPosition = 0;

			// 확률 구간별 처리
			for(Candidate c : candidates){
				if(c.rate>0){
					int nextPosition = currentPosition + c.rate;
					// 현재 구간에 난수가 포함되는지 확인
					if(rand >= currentPosition && rand < nextPosition){
						winner = c;
						break;
					}
					currentPosition = nextPosition;

					// 누적 확률이 100을 넘어가면 중단
					if(currentPosition >=100) break;
				}
			}
			// 확률에 당첨된 사람이 없다면 무작위로 한 명 선택
			if (winner == null && !candidates.isEmpty()) {
				int idx = r.nextInt(candidates.size());
				winner = candidates.get(idx);
			}
			// 결과 출력
			pln("당첨자: " + winner.name);
		}
	}
	void pln(String str) {
		System.out.println(str);
	}

	void p(String str) {
		System.out.print(str);
	}
	public static void main(String[] args){
		RanLotto rl = new RanLotto();
		rl.init();
		rl.read();
		rl.show();

		/*int yes = 0;
		int no = 0;
		for(int i=0;i<1000000;i++){
			rl.show();
			if(rl.winner.qww !=0){
				yes++;
			}else{
				no++;
			}
		}
		System.out.println("yes: " + yes + ", no: " + no);*/
	}
}
