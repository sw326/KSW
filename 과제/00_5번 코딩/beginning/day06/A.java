class A 
{
	void m1(){
		//String strs[] = null; // (1)선언
		//strs = new String[4]; //(2)생성
		//String strs[] = new String[4];
		//strs[0] = "spring"; // in (3)초기화
		//strs[1] = "summer"; // in
		
		String strs[] = {"spring", "summer", "fall", "winter"}; // 선언 밒 생성 및 초기화

		for(int i = 0;i<strs.length;i++){
			System.out.println(strs[i]); //out
		}
	}
	void m2(){
		//int is[] = null; // (1) 선언
		//is = new int[2]; // (2) 생성
		//int is[] = new int[2];
		//is[0] = 10; // 초기화
		//is[1] = 20;

		int is[] = {10, 20}; // 선언 밒 생성 및 초기화

		for(int i=0;i<is.length;i++){
			System.out.println(is[i]); // out
		}
	}
	public static void main(String[] args) 
	{
		A a = new A();
		a.m1();
	}
}

class A1
{
	void m1(){
		String strs[] = null;
		strs = new String[4];
		String strs[] = new String[4];
		strs[0] = "spring';
		strs[1] = 'summer';
		String strs[] = {"spring", "summer", "fall", "winter"}
		for(int i=0;i<is.length;i++){
			System.out.println(str[i]);
		}
	}
	void m2(){
		int is[] = null;
		is = new int[2];
		int is[] = new int[2];
		is[0] = 10;
		is[1] = 20;
		int is[] = {10, 20};
		for(int i=0;i<is.length;i++){
			System.out.println(is[i]);
		}
	}
	public static void main(String[] args){
		A1 a = new A1();
		a.m1();
	}
}

class A2
{
	void m1(){
		String strs[] = null;
		strs = new String[4];
		String strs[] = new String[4];
		strs[0] = "spring";
		strs[1] = "summer";
		String strs[] = {"spring", "summer", "fall", "winter"}
		for(int i=0;i<strs.length;i++){
			System.out.println(strs[i]);
		}
	}
	void m2(){
		int is[] = null;
		is= new int[2];
		int is[] = new int[2];
		is[0] = 10;
		is[1] = 20;
		int is[] = {10, 20};
		for(int i=0;i<is.length;i++){
			System.out.println(is[i]);
		}
	}
	public static void main(String args[]){
		A2 a = new A2();
		a.m1();
	}
}

class A3
{
	void m1(){
		String strs[] = null;
		strs = new String [4];
		String strs[] = new String[4];
		strs[0] = "spring";
		strs[1] = "summer";
		for(int =i=0;i<strs.length;i++){
			System.out.println(strs[i]);
		}
	}
	void m2(){
		int is[] = new int[2];
		is[0] = 10;
		is[1] = 20;
		for(int i=0;i<is.length;i++){
			System.out.println(is[i]);
		}
	}
	public static void main(String []args){
		A3 a = A3();
		a.m1();
	}
}

class A4
{
	void m1(){
		String strs[] = new String[4];
		strs[0] = "spring";
		strs[1] = "summer";
		for(int i=0;i<strs.length;i++){
			System.out.println(strs[i]);
		}
	}
	void m2(){
		int is[] = new int[2];
		is[0] = 10;
		is[1] = 20;
		for(int i=0;i<is.length;i++){
			System.out.println(is[i]);
		}
	}
	public static void main(String []args){
		A3 a = A3();
		a.m();
	}
}

class A5
{
	void m1(){
		String strs[] = {"spring", "summer", "fall", "winter"};
		for(int i = 0;i<strs.length;i++){
			System.out.println(strs[i]);
		}
	}
	void m2(){
		int is[] = {10, 20};
		for(int i=0;i<is.length;i++){
			System.out.println(is[i]);
		}
	}
	public static void main(String []args){
		A5 a = A5();
		a.m2();
	}
}