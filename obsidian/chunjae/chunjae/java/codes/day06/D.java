class D 
{
	int is[] = {1, 2};
	int iss[][] = {is, {30, 40, 50, 60}, {700}};
	void out(){
		for(int i=0;i<iss.length;i++){
			for(int j=0;j<iss[i].length;j++){
				System.out.println("iss["+i+"]["+j+"]: " + iss[i][j]);
			}
		}
	}
	public static void main(String[] args) 
	{
		new D().out();
	}
}

class D1
{
	int is[]={1,2};
	int iss[][]={is,{20,30,40,50,60},{700}};
	void out(){
		for(int i=0;i<iss.length;i++){
			for(int j=0;j<iss[i].length;j++){
				System.out.println(iss[i][j]);
			}
		}
	}
	public static void main(String[] args){
		new D1().out();
	}
}

class D2
{
	int is[]={1,2};
	int iss[][]={is,{30,40,50,60},{700}};
	void out(){
		for(int i=0;i<iss.length;i++){
			for(int j=0;j<iss[i].length;j++){
				System.out.println(iss[i][j]);
			}
		}
	}
	public static void main(String args[]){
		new D2().out();
	}
}