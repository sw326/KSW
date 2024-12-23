import java.io.*;
import java.util.*;
import java.io.IOException;

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

class LottoNE{
	String fname;
	FileReader fr;
	BufferedReader br;
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
	ArrayList<String> list = new ArrayList<String>();
	int winNum;
	void init(){
		try{
			p("리스트 파일 경로 입력(기본: 우리반리스트.txt): ");
			String line = file.readLine(); // 문자열을 입력 받음
			line = line.trim();
			if(line.length() == 0){
				fname = "우리반리스트.txt";
			}else{
				fname = line;
			}
			fr = new FileReader(fname);
			br = new BufferedReader(fr);
		}catch(FileNotFoundException fe){
			pln(fname+"파일을 찾을 수 없음");
			init();
		}catch(IOException ie){
		}
	}
	void in(){
		String line = null;
		try{
			while((line = br.readLine()) != null){
				if(line != null) line = line.trim();
				if(line.length() != 0){
					list.add(line);
				}
			}
		}catch(IOException ie){
		}
	}
	void inNum(){
		p("당첨 인원을 입력해주세요: ");
		try{
			String line = in.readLine();
			line = line.trim();
			winNum = Integer.parseInt(line);
			if(winNum<1 || winNum>list.size()){
				pln("범위: 1~"+list.size());
				inNum();
			}else{
				out();
			}
		}catch(IOException ie){
		}catch(NumberFormatException ne){
			pln("숫자를 입력해주세요.");
			inNum();
		}
	}

	Random r = new Random();
	Hashtable<Integer, String> ht = new Hashtable<Integer, String>();

	void out(){
		while(ht.size() != winNum){
			int idx = r.nextInt(winNum);
			ht.put(idx, list.get(idx));
		}

		Set<Integer> keys = ht.keySet();
		for(int key : keys){
			pln("번호: "+(key+1)+", 당첨자: "+ht.get(key));
		}
	}
	void p(String str){
		System.out.print(str);
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String args[]){
		LottoNE lo = new LottoNE();
		lo.init();
		lo.in();
		lo.inNum();
	}
}

class LottoYJ {
	FileReader fr;
	BufferedReader br;
	ArrayList<String> members = new ArrayList<String>();
	void init(){
		try{
			String fname="";
			br = new BufferedReader(new InputStreamReader(System.in));
			fname = br.readLine();
			if(fname.length() !=0){
				fname = fname.trim();
				set_on(fname);
			}else{
				set_on("우리반리스트.txt");
			}
		}catch(IOException ie){
		}
	}
	void set_on(String fname){
		try{
			fr = new FileReader(fname);
			br = new BufferedReader(fr);
		}catch(FileNotFoundException fe){
			pln(fname+"파일이 없습니다. 다시 입력해주세요.");
			init();
		}
	}
	void read(){
		String line ="";
		try{
			while((line=br.readLine())!=null){
				if(line != null) line = line.trim();
				if(line.length() !=0) members.add(line);
			}
		}catch(IOException ie){
		}
	}
	void show(){
		try{
			p("당첨 인원을 작성해주세요: ");
			br = new BufferedReader(new InputStreamReader(System.in));
			String line = br.readLine();
			int selNum = Integer.parseInt(line);
			if(selNum<1||selNum>members.size()){
				pln("범위를 잘못 입력하셨습니다.(1~"+members.size()+")");
				show();
			}else{
				pln("====================================");
				Random r = new Random();
				TreeSet<Integer> sel = new TreeSet<Integer>();
				pln("총 인원: "+members.size()+", 당첨자 수: "+selNum);
				while(sel.size()<selNum){
					int ran = r.nextInt(members.size());
					sel.add(ran);
				}
				for(int i : sel)
					pln("당첨번호: "+(i+1)+", 당첨자: "+members.get(i));
			}
		}catch(NumberFormatException fe){
			pln("숫자를 입력하셔야 합니다.");
			show();
		}catch(IOException ie){
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	void p(String str){
		System.out.print(str);
	}
	public static void main(String args[]){
		LottoYJ lo = new LottoYJ();
		lo.p("파일명(기본 우리반.txt) : ");
		lo.init();
		lo.read();
		lo.show();
	}
}
/*
class LottoM{
	FileReader fr;
	BufferedReader br;
	ArrayList<String> members = new ArrayList<String>();
	void init(){
		try{
			String fname = null;
			br = new BufferedReader(new InputStreamReader(System.in));
			fname = br.readLine();
			if(fname.length() != 0){
				fname = fname.trim();
				setFile(fname);
			}else{
				setFile("우리반.txt");
			}
		}catch(IOException ie){
		}
	}
	void setFile(String fname){
		try{
			fr = new FileReader(fname);
			br = new BufferedReader(fr);
		}catch(FileNotFoundException fe){
			pln(fname+"파일이 없습니다. 다시 입력해주세요");
			init();
		}
	}
	void read(){
		String line = null;
		try{
			while((line = br.readLine()) != null){
				if(line != null) line = line.trim();
				if(line.length() != 0) members.add(line);
			}
		}catch(IOException ie){
		}
	}
	void show(){
		try{
			p("당첨 인원을 입력해주세요: ");
			br = new BufferedReader(new InputStreamReader(System.in));
			String line = br.readLine();
			int selNum = Integer.parseInt(line);
			if(selNum<1||sleNum>members.sizw()){
				pln("범위를 잘못 입력하셨습니다.( 1 ~ "+members.size()+")");
				show();
			}else{
				pln("==================================");
				Random r = new Random();
				TreeSet<Integer> sel = new TreeSet<Integer>();
				pln("총 인원: "+members.size()+", 당첨자 수: "+selNum);
				while(sel.size()<selNum){
					int ran = r.nextInt(members.size());)
					sel.add(ran);
				}
				for(int i : sel)
					pln("당첨번호: "+(i+1)+", 당첨자: "+members.get(i));
			}catch(NumberFormatException fe){
				pln("숫자를 입력하셔야 합니다.");
				show();
		}catch(IOException ie){
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	void p(String str){
		System.out.print(str);
	}
	public static void main(String args[]){
		LottoM lo = new LottoM();
		lo.init();
		lo.read();
		lo.show();
	}
}
*/







class P
{
	P(){
	}
	static void pln(String var0){
		System.out.println(var0);
	}
	static void p(String var0){
		System.out.print(var0);
	}
}
	//파일을 읽는 클래스
class ReadPath{
	LottoMulti lotto;
	BufferedReader brFile;
	String path;
	FileReader fr;

	ReaderPath(LottoMulti var1){
		this.lotto = var1;
	}

	boolean inputList(){
		try{
			P.p("리스트 파일(기본 : 우리반.txt) : ");
			this.path = this.lotto.br.readLine();
			if(this.path != null){
				this.path = this.path.trim();
			}
			if(this.path.length() ==0){
				this.path = "list.txt";
			}
			this.fr = new FilReader(this.path);
			return this.insertMap();
		}catch(FileNotFoundException fe){
			P.pln("그런 파일 없다.");
			return this.inputList();
		} catch(IOException var3){
			return this.inputList();
		}
	}
	
	boolean insertMap(){
		int var1 = 0;
		String var2 = "";
		this.brFile = new BufferedReader(this.fr);

		try{
			while((var2 = this.brFile.readLine()) != null{
				this.lotto.map.put(var1, var2);
				++var1;
			}
			LottoMulti.totalCont = var1;
			return this.copyListRes(var1);
		}catch(IOException var4){
			return false;
		}
	}

	void showMap(){
		Set var1 = this.lotto.map.keySet();
		Iterator_var2 = var1.iterator();

		while(var2.hasNext()){
			int var3 = (Integer)var2.next();
			P.pln("key : " + var3 ", value : "+(String)this.lotto.map.get(var3));
		}
	}

	boolean copyListRes(int var1){
		Set var2 = this.lotto.map.keySet();
		Iterator var3 = var2.iterator();

		while(var3.hasNext()){
			int var3 = (Integer)var2.next();
			P.pln("key : " + var3 + ", value : "+(String)this.lotto.map.get(var3));
		}
	}

	boolean copyListRes(int var1){
		Set var2 = this.lotto.map.keySet();
		Iterator var3 = var2.iterator();

		while(var3.hasNext()){
			int var4 = (Integer)var3.next();
			this.lotto.listRes.add(var4);
		}
		return this.lotto.listRes.size() == var1;
	}

	void showListRes(){
		Iterator var1 = this.lotto.listRes.iterator();

		while (var1.hasNext()){
			int var2 = (Integer)var1.next();
			P.plb("listRes의 idx : " + ㅍㅁㄱ2);
		}
	}
}
// Lotto의 위너를 뽑는 클래스
class Winner{
	LottoMulti lotto;
	Random ran = new Random();
	TreeSet<String> tset = new TreeSet();
	BufferedReader brRate;
	String target;
	float rate;

	Winner(LottoMulti var1){
		this.lotto = var1;
	}
	void moveStore(){
		for(int var1 = 0; var1 < this.lotto.su; ++var1){
			this.moveOne();
		}
		this.addWinners();
	}
	void moveOne(){
		int var1 = this.ran.nextInt(this.lotto.listRes.size());
		int var2 = (Integer)this.lotto.listRes.get(var1);
		this.lotto.listWin.add(var2);
		this.lotto.listRes.remove(var1);
	}

	void addWinners(){
		String var1 = "";
		String var2 = "";
		Iterator var3 = this.lotto.listWin.iterator();

		while(var3.hasNext()){
			int var4 = (Integer)var3.next();
			var1 = (String)this.lotto.map.get(var4);
			++var4;
			if(var4<10){
				var2="0"+var4;
			}else{
				var2 = "" +var4;
			}

			String var5 = "번호 : "+var2+", 이름 : "+var1.trim();
			this.test.add(var5);
		}
		this.descWinner();
	}

	void ascWinner(){
		Iterator var1 = this.test.iterator();

		while(var1.
}




class LottoMulti{
	BufferedReader br;
	static int totalCount;
	int su;
	Hashtable<Integer, String> map;
	Vector<Integer> listRes;
	Vector<Integer> listWin;

	LottoMulti(){
		this.br = new BufferedReader( new InputStreamReader(System.in));
		this.map = new Hashtable();
		this.listRes = new Vector();
		this.listWin = new Vector();
		ReadPath var1 = new ReadPath(this);
		ReadCount var2 = new ReadCount(this);
		if(var1.inputList()){
			var2.inputCount();
			Winner var = new Winner(this);
			var3.moveStore();
		}else{
			var1.inputList();
		}
	}
	public static void main(String[] args){
		new LottoMult();
	}
}


