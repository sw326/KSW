import java.io.*;
import java.util.*;

class LottoMulti {

	String fname;
	FileReader fr;
	BufferedReader br;
	ArrayList<String> list = new ArrayList<String>();

	void init() {
		Scanner sc = new Scanner(System.in);
		p("파일명: (default: 우리반리스트.txt): ");
		String input = sc.nextLine();
		if (input.length() == 0) {
			fname = "우리반리스트.txt";
		} else {
			fname = input;
		}

		try {
			fr = new FileReader(fname);
			br = new BufferedReader(fr);
		} catch (FileNotFoundException fe) {
			pln(fname + "라는 파일이 없습니다.");
			init();
		}
	}

	void in() {
		String line = null;
		try {
			while ((line = br.readLine()) != null) {
				if (line != null)
					line = line.trim();
				if (line.length() != 0) {
					list.add(line);
				}
			}
		} catch (IOException ie) {
		}
	}

	void out() {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		
		try {
			p("몇명을 뽑을까요?: ");
			count = sc.nextInt();
			
			if (count <= 0) {
				pln("1명 이상을 입력하세요");
				out();
				return;
			} else if (count > list.size()) {
				pln("당첨자 수가 총 인원보다 많습니다.");
				out();
				return;
			}
		} catch (InputMismatchException ime) {
			pln("숫자를 입력하세요.");
			out();
			return;
		}

		Random r = new Random();
		ArrayList<Integer> winners = new ArrayList<>();

		while (winners.size() < count) {
			int idx = r.nextInt(list.size());
			if (!winners.contains(idx)) {
				winners.add(idx);
			}
		}

		for (int idx : winners) {
			p("당첨번호: " + (idx + 1));
			pln(", 당첨자: " + list.get(idx));
		}
	}

	void pln(String str) {
		System.out.println(str);
	}

	void p(String str) {
		System.out.print(str);
	}

	public static void main(String[] args) {
		LottoMulti lm = new LottoMulti();
		lm.init();
		lm.in();
		lm.out();
	}
}
