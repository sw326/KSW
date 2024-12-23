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

	void init() {
		try {
			p("리스트 파일 경로 입력(기본: 우리반.txt): ");
			String line = file.readLine(); // 문자열을 입력 받음
			line = line.trim();
			if (line.length() == 0) {
				fname = "우리반.txt";
			} else {
				fname = line;
			}
			fr = new FileReader(fname);
			br = new BufferedReader(fr);
		} catch (FileNotFoundException fe) {
			pln(fname + "파일을 찾을 수 없음");
			init();
		} catch (IOException ie) {
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

	void innum() {
		p("당첨될 인원 입력해주세요: ");
		try {
			String line = in.readLine(); // 문자열을 입력 받음
			line = line.trim();
			winnum = Integer.parseInt(line);
			if (winnum < 1 || winnum > list.size()) {
				pln("범위: 1~" + list.size());
				innum();
			} else {
				out();
			}
		} catch (IOException ie) {
		} catch (NumberFormatException ne) {
			pln("!!숫자의 형태로 입력해주세요!!");
			innum();
		}
	}

	Random r = new Random();

	Hashtable<Integer, String> ht = new Hashtable<Integer, String>();

	void out() {
		while (ht.size() != winnum) {
			int idx = r.nextInt(winnum);
			ht.put(idx, list.get(idx));
		}

		Set<Integer> keys = ht.keySet();
		for (int key : keys) {
			pln("번호: " + (key + 1) + ", 당첨자: " + ht.get(key));
		}
	}

	void p(String str) {
		System.out.print(str);
	}

	void pln(String str) {
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
 * 1. 파일을 읽어 컬렉션에 저장
 * 2. 원하는 숫자를 랜덤해서 해당 컬렉션 인덱스의 내용을 출력 함
 */