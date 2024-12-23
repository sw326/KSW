class G // OCJP 시험 
{
	final abstract void m(); //오버라이딩을 막고 오버라이딩을 해야하는 모순된 문법
}

class G1{
	final abstract void m();
}

class G2 final abstract void m();