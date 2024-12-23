class D 
{
	void sum(int i, int j){
		return i+j;
	}
	public static void main(String[] args) 
	{
		D d = new D();
		int s = d.sum(10, 20);
		System.out.println("s: " +s);
	}
}
