import java.io.*;

class In {
    Grade g;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    In(Grade g){
        this.g = g;
    }
    void input(int i){
        String line = "";
        P.p(g.subjects[i] + ": ");
        try{
            line = br.readLine();
            if(line!=null) line.trim();
            if(line.length() != 0){
                g.scores[i] = Integer.parseInt(line);
                if(g.scores[i]<0 || g.scores[i]>100){
                    P.pln("점수의 범위는 0~100입니다");
                    input(i);
                }
                //P.pln("scores["+i+"]: " + scores[0]); 
            }else{
                input(i);
            }
        }catch(IOException ie){
        }catch(NumberFormatException ne){
            P.pln("숫자의 형태만 가능합니다");
            input(i);
        }
    }
} 