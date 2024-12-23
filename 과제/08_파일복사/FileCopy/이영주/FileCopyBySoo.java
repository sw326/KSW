import java.io.*;

class FileCopyBySoo {
	InputStream is = System.in;
	BufferedReader br = new BufferedReader(new InputStreamReader(is));
	FileInputStream fis;
	FileOutputStream fos;

	String cFilePath;
	String cFileDir;

	File f;
	//���� �ٿ��ֱ� ���� �޼ҵ�
	boolean selCopyCut(){
		String line ="";
		while(true){
			P.pln("1. ���� 2. �߶󳻱� ");
			P.p("�Է� : ");
			try{
				line = br.readLine();
				line = line.trim();
				int sel = Integer.parseInt(line);
				if(sel == 1 ) return false;
				else if(sel == 2) return true;
				else {
					P.pln("�߸��Է��ϼ˽��ϴ�.");
				}	
			}catch(IOException ie){}
			catch(NumberFormatException ne){
				P.pln("�߸��Է��ϼ̽��ϴ�.");
			}
		}
	}
	//�������� ã�� �޼ҵ�
	void initFile(){
		String line = "";
		while(true){
			P.p("���� ���� ��� : ");
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
			P.pln("�ش� ������ �����ϴ�.");
		}
		cFilePath = line;
	}
	//�������ϰ�� ã�� �޼ҵ�
	void filePath(){
		File fp;
		String line = "";
		while(true){
			P.p("���� ���� ��� : ");
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
			P.pln("�߸��� ����Դϴ�.");
		}
		cFileDir = line;
	}
	//���� ����� �޼ҵ�
	boolean makeDir(File fp){
		String line = "";
		while(true){
			try{
				P.pln("��ΰ� �����ϴ� ��θ� �����Ͻðڽ��ϱ�? (y/n)");
				line = br.readLine();
				line = line.trim();
				if(line.equals("y")||line.equals("Y")){
					P.pln("��θ� �����մϴ�.");
					fp.mkdirs();
					return true;
				}
				else if((line.equals("n")||line.equals("N")))
					return false;
			}catch(IOException ie){
				P.pln("�߸����Է��Դϴ�.");
			}
		}
	}
	//���� Ȥ�� �߶�ֱ�
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
			P.pln("������ �߶󳻱� �Ͽ����ϴ�.");
			f.delete();
		}
		else{
			P.pln("������ �����Ͽ����ϴ�.");
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
