class E {
	public final static int YES = 10;
	//final E(){} //불가!
	final void m(){
		final int NO = 20;
	}
}
class EChild extends E //자식을 못 낳음
{
	//void m(){} //불가!
}

class E1
{
	public final static int YES = 10;
		// final E(){} not allowed
		final void m(){
			fianl int NO = 20;
		}
}
class EChild1 extends E // no kids
{
	// void m(){} not allowed
}