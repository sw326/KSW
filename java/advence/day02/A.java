import java.io.File;

class A {
	String path = "D:\\KSW\\java\\advence";
	File f;
	void m1(){ // 존재와 식별
		f = new File (path);
		if(f.exists()){
			pln("f exists here -> "+ f);
			if(f.isFile()){
				pln("File");
			}else{
				pln("Directory");
			}
		}else{
			pln("not exists");
		}
	}
	void m2(){
		File[] kids = f.listFiles();
		for(File kid: kids){
			if(kid.isFile()){
				p("[F]");
			}else{
				p("[D]");
			}
			pln(kid.getName());
		}
	}
	String dir = "aa/bb/cc";
	void m3(){ // 디렉토리 생성
		File f = new File(dir);
		f.mkdirs();
	}

	String newF = dir + "/test.txt";
	void m4(){ // 파일 생성
		File f = new File(newF);
		try{
			f.createNewFile();
		}catch(java.io.IOException ie){}
	}
	void m5(){
		File f = new File(newF);
		f.delete();
	}
	void pln(String str){
		System.out.println(str);
	}
	void p(String str){
		System.out.print(str);
	}
	public static void main(String[] args) {
		A a = new A();
		//a.m1();
		//a.m2();
		//a.m3();
		//a.m4();
		a.m5();

	}
}
