class Tip1{
	String str = "          김성우      50       ";
	String name;
	int rate = -1;

	void m1(){
		str = str.trim();
		int i = str.indexOf(" ");
		if(i==-1){
			name=str;
		}else{
			name = str.substring(0, i); // 이상 미만
			String strRate = str.substring(i); // 이상
			strRate = strRate.trim();
			try{
				rate = Integer.parseInt(strRate);
			}catch(NumberFormatException ne){
				pln("Wrong Rate");
			}
		}
		pln("name: " +name+", rate: "+rate);
	}
	void m2(){
		int i = 0;
		String items[] = str.split(" ");
		for(String item: items){
			item = item.trim();
			if(item.length()!=0){
				if(i==0){
					name = item;
				}else{
					rate = Integer.parseInt(item);
				}
				i++;
			}
		}
		pln("name: " + name + ", rate: " + rate);
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) {
		Tip1 t = new Tip1();
		//t.m1();
		t.m2();
	}
}
