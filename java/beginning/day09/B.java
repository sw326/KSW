class MyException extends Exception{
	void myM(){
		System.out.println("MyException의 예외 처리 메소드");
	}
}
class YourException extends Exception{
	void yourM(){
		System.out.println("YourException의 예외 처리 메소드");
	}
}
class ExceptionUser{
	boolean flag;
	ExceptionUser()throws MyException{
		if(flag){
			throw new MyException();
		}
	}
	void use() throws YourException{
		if(!flag){
			throw new YourException();
		}
	}
	void use2() throws Exception{
		boolean flag2 = true;
		if(flag2){
			throw new Exception();
		}
	}
}
class B 
{
	B() throws Exception{
		try{
			System.out.println("1");
			ExceptionUser user = new ExceptionUser();
			System.out.println("2");
			user.use();
			System.out.println("3");
			user.use2();
			System.out.println("4");
		}catch(MyException me){
			me.myM();
		}catch(YourException ye){
			ye.yourM();
		}
	}
	public static void main(String[] args) throws Exception {
		new B();
	}
}
