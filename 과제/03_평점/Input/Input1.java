class Input1 {
	void m(String[] args){
		if(args.length != 3){
			System.out.println("사용법> java Input1 점수1 점수2 점수3");
			return;
		}
		
		for(int i=0; i<args.length; i++){
			System.out.println("args["+i+"]: " + args[i]);
		}
	}
	public static void main(String[] args) 
	{
		//System.out.println("args.length: " + args.length);
		new Input1().m(args);
	}
}