import java.util.*;
import java.util.Random;
class Shower {
	final int MAX_RATE = 100;
	Lotto1RateN lot;
	int zeroRate = 0;
	TreeSet<Integer> sel = new TreeSet<Integer>();
	HashMap<Integer,String> rate = new HashMap<Integer,String>();
	Shower(Lotto1RateN lot){
		this.lot = lot;
	}
	void rateShow(){
		for(Integer i : sel) 
			P.pln("��÷�� : " + rate.get(i));
	}

	void rateCheck(){
		Set<Integer> keys = rate.keySet();
		for(Integer key : keys){
			P.pln("key : " + key + ", �̸� " + rate.get(key));
		}
	}

	boolean rateDraw(int people){
		if(people<1||people>(lot.menbers.size()-zeroRate)){
			P.pln("������ �߸� �Է� �ϼ˽��ϴ�.(1~"+(lot.menbers.size()-zeroRate)+")");
			return false;
		}else{
			Random r = new Random();
			String winners[] = new String[people];
			Integer ran = r.nextInt(MAX_RATE);
			sel.add(ran);
			winners[0] = rate.get(ran);
			while(sel.size() < people){
				ran = r.nextInt(MAX_RATE);
				for(int i=0;i<sel.size();i++){
					if(winners[i].equals(rate.get(ran))||sel.size() == people)
						break;
					if(i == sel.size()-1){
						sel.add(ran);
						winners[sel.size()-1] = rate.get(ran);
					}
				}
			}
			return true;
		}
	}

	void rateSet(){
		int nowCount=0;
		int error=0;
		//Ȯ���� ���� ����� ���� �ֱ�
		for(int i=0;i<lot.menbers.size();i++){
			if(nowCount > MAX_RATE){
				P.pln("Ȯ�� ������ " + MAX_RATE + "�� �ѽ��ϴ�.");
				System.exit(-1);
			}
			int countNum = 0;
			String name = lot.menbers.get(i);
			name = name.trim();
			if(name.contains(" ")){
				int strIndex = name.lastIndexOf(" ")+1;
				try{
					countNum = Integer.parseInt(name.substring(strIndex));
				}catch(NumberFormatException ne){
					error++;
					continue;
				}
				if(countNum==0) zeroRate++;
				
				name = name.substring(0,name.indexOf(" "));
				for(int j=0;j<countNum;j++){
					rate.put(nowCount++,name);
				}
			}
		}
		while(nowCount < MAX_RATE){ //������ ��� Ȯ�� ���ȭ
			for(int i=0;i<lot.menbers.size();i++){
				if(nowCount >= MAX_RATE)
					break;
				String name = lot.menbers.get(i);
				name = name.trim();
				if(name.contains(" "))
					continue;
				rate.put(nowCount++,name);
			}
		}
		if(error > 0)
			P.pln(error+" ���� �߸��� ���� ������ �����˴ϴ�.");
	}
}

