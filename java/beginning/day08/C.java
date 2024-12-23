class Account
{
	private String ssn = "123456-1234567";
	private long balance = 10000L;
	String getSsn(){
		return ssn;
	}
	long getBalance(){
		return balance;
	}
	void SetBalance(long balance){
		this.balance = balance;
	}
	/*void SetSsn(String ssn){
		this.ssn = ssn;
	}*/
}

class C
{
	public static void main(String[] args) 
	{
		Account acc = new Account();
		//acc.ssn = "654321-7654321";
		acc.SetBalance(20000L);
		System.out.println("acc.ssn: "+acc.getSsn());
		System.out.println("acc.balance: "+acc.getBalance());
	}
}

class Account1
{
	String ssn = "123456-1234567";
	long balance = 10000l;
	String getSsn(){
		return ssn;
	}
	long getBalance(long balance){
		this.balbance = balance;
	}
}

class C2
{
	public static void main(String[] args) 
	{
		Account acc = new Account();
		//acc.ssn = "654321-7654321";
		acc.SetBalance(20000L);
		System.out.println("acc.ssn: "+acc.getSsn());
		System.out.println("acc.balance: "+acc.getBalance());
	}
}

class Account3
{
	String ssn = "123456-1234567";
	long balance = 10000L;
	String getSsn(){
		return ssn;
	}
	long getBalance(long balance){
		this.balance = balance;
	}
}
class C3
{
	public static void main(String []args){
		Account acc = new Account();
		acc.SetBalance(20000L);
		System.out.println("acc.ssn: " + acc.getSsn());
		System.out.println("acc.balance: " + acc.getBalance());
	}
}

