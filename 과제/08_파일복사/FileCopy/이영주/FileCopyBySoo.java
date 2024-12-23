import java.io.*;

class FileCopyBySoo {
	InputStream is = System.in;
	BufferedReader br = new BufferedReader(new InputStreamReader(is));
	FileInputStream fis;
	FileOutputStream fos;

	String cFilePath;
	String cFileDir;

	File f;
	//복사 붙여넣기 선택 메소드
	boolean selCopyCut(){
		String line ="";
		while(true){
			P.pln("1. 복사 2. 잘라내기 ");
			P.p("입력 : ");
			try{
				line = br.readLine();
				line = line.trim();
				int sel = Integer.parseInt(line);
				if(sel == 1 ) return false;
				else if(sel == 2) return true;
				else {
					P.pln("잘못입력하셧습니다.");
				}	
			}catch(IOException ie){}
			catch(NumberFormatException ne){
				P.pln("잘못입력하셨습니다.");
			}
		}
	}
	//원본파일 찾는 메소드
	void initFile(){
		String line = "";
		while(true){
			P.p("원본 파일 경로 : ");
			try{
				line = br.readLine();
				line = line.trim();
				f = new File(line);
				if(f.exists()){
					if(f.isFile()){
						f = new File(line);
						break;
					}
				}
			}catch(IOException ie){}
			P.pln("해당 파일이 없습니다.");
		}
		cFilePath = line;
	}
	//복사파일경로 찾는 메소드
	void filePath(){
		File fp;
		String line = "";
		while(true){
			P.p("복사 파일 경로 : ");
			try{
				line = br.readLine();
				line = line.trim();
				fp = new File(line);
				if(!fp.isFile()){
					if(fp.exists()){
						break;
					}else{
						if(makeDir(fp))
							break;
					}
				}
			}
			catch(IOException ie){}
			P.pln("잘못된 경로입니다.");
		}
		cFileDir = line;
	}
	//파일 만드는 메소드
	boolean makeDir(File fp){
		String line = "";
		while(true){
			try{
				P.pln("경로가 없습니다 경로를 생성하시겠습니까? (y/n)");
				line = br.readLine();
				line = line.trim();
				if(line.equals("y")||line.equals("Y")){
					P.pln("경로를 생성합니다.");
					fp.mkdirs();
					return true;
				}
				else if((line.equals("n")||line.equals("N")))
					return false;
			}catch(IOException ie){
				P.pln("잘못된입력입니다.");
			}
		}
	}
	//복사 혹은 잘라넣기
	void Copycut(boolean cut){
		int lIndex = cFilePath.lastIndexOf("\\");
		String fName = cFilePath.substring(lIndex);
		try{
			fis = new FileInputStream(cFilePath);
			fos = new FileOutputStream(cFileDir+fName);
			int i=0;
			byte[] bs = fis.readAllBytes(); 
			fos.write(bs);
			fos.flush();
		}catch(FileNotFoundException fnfe){}
		catch(IOException fnfe){}
		finally{
			try{
				fis.close();
				is.close();
				fos.close();
			}catch(IOException fnfe){}
		}
		if(cut){
			P.pln("파일을 잘라내기 하였습니다.");
			f.delete();
		}
		else{
			P.pln("파일을 복사하였습니다.");
		}
	}

	public static void main(String[] args) {
		FileCopyBySoo fcbs = new FileCopyBySoo();
		boolean cut = fcbs.selCopyCut();
		fcbs.initFile();
		fcbs.filePath();
		fcbs.Copycut(cut);
	}
}
