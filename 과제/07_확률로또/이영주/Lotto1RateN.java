import java.util.*;
class Lotto1RateN
{
	Vector<String> menbers = new Vector<String>();
	void init(){
		In in = new In(this);
		in.input();
		in.read();
		Shower shower = new Shower(this);
		shower.rateSet();
		while(!shower.rateDraw(in.qGetIntInput("´çÃ·ÀÚ ¼ö : "))){}
		shower.rateShow();

	}
	public static void main(String[] args) 
	{
		Lotto1RateN lot = new Lotto1RateN();
		lot.init();
	}
}
