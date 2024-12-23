import java.io.*;

class FileCopy {
    BufferedReader br;

    void init() {
        pln("1. 복사   2. 잘라내기");
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            String choose = br.readLine();
            choose = choose.trim();
            exceptChoose(choose);
            copyCut(choose);
        } catch (IOException ie) {
            pln("입력 중 오류 발생: " + ie.getMessage());
        }
    }

    void exceptChoose(String choose) {
        if (choose.length() == 0) {
            pln("입력은 필수다");
            init();
        } else if (!isNumeric(choose)) {
            pln("숫자만 입력하도록");
            init();
        } else if (Integer.parseInt(choose) != 1 && Integer.parseInt(choose) != 2) {
            pln("선택지는 1과 2뿐이다 애송이");
            init();
        }
    }

    boolean isNumeric(String choose) {
        try {
            Integer.parseInt(choose);
            return true;
        } catch (NumberFormatException ne) {
            return false;
        }
    }

    String path;
    String destination;
    File f;

    void copyCut(String choose) {
        p("복사할 원본 파일: ");
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            String path = br.readLine();
            f = new File(path);
            if (path.length() == 0) {
                pln("입력은 필수다");
                copyCut(choose);
            } else if (f.isFile()) {
                if (Integer.parseInt(choose) == 1) {
                    copy();
                } else {
                    cut();
                }
            } else {
                pln("입력한 파일이 없다");
                copyCut(choose);
            }
        } catch (IOException ie) {
            pln("입력 중 오류 발생: " + ie.getMessage());
        }
    }

    void copy() {
        p("복사할 위치: ");
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            String destination = br.readLine();
            File destFile = new File(destination);
            if (destination.length() == 0) {
                pln("입력은 필수다");
                copy();
            } else if (destFile.getParentFile().exists()) {
                destFile = new File(destination + File.separator + f.getName());
                FileInputStream fis = new FileInputStream(f);
                FileOutputStream fos = new FileOutputStream(destFile);

                byte[] bs = new byte[1024];
                int i;
                while ((i = fis.read(bs)) != -1) {
                    fos.write(bs, 0, i);
                }

                fis.close();
                fos.close();

                pln("복사 완료!");
            } else {
                pln("존재하지 않는 디렉토리");
                copy();
            }
        } catch (IOException ie) {
            pln("파일 복사 중 오류 발생: " + ie.getMessage());
        } catch (NullPointerException ne) {
            pln("Null 포인터 오류 발생: " + ne.getMessage());
        }
    }

    void cut() {
        p("잘라낼 위치: ");
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            String destination = br.readLine();
            File destFile = new File(destination);
            if (destination.length() == 0) {
                pln("입력은 필수다");
                cut();
            } else if (destFile.getParentFile().exists()) {
                destFile = new File(destination + File.separator + f.getName());
                FileInputStream fis = new FileInputStream(f);
                FileOutputStream fos = new FileOutputStream(destFile);

                byte[] bs = new byte[1024];
                int i;
                while ((i = fis.read(bs)) != -1) {
                    fos.write(bs, 0, i);
                }

                fis.close();
                fos.close();
                f.delete();

                pln("잘라내기 완료!");
            } else {
                pln("존재하지 않는 디렉토리");
                cut();
            }
        } catch (IOException ie) {
            pln("파일 잘라내기 중 오류 발생: " + ie.getMessage());
        } catch (NullPointerException ne) {
            pln("Null 포인터 오류 발생: " + ne.getMessage());
        }
    }

    void pln(String str) {
        System.out.println(str);
    }

    void p(String str) {
        System.out.print(str);
    }

    public static void main(String[] args) {
        FileCopy fc = new FileCopy();
        fc.init();
    }
}
