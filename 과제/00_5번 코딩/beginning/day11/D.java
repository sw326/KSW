interface DInter1 {
	void m1();
}
interface DInter2 {
	void m2();
}
interface DInter extends DInter1, DInter2{
	void m3();
}

class D implements DInter {
	public void m1(){
		System.out.println("m1()");
	}
	public void m2(){
		System.out.println("m2()");
	}
	public void m3(){
		System.out.println("m3()");
	}
	public static void main(String[] args) {
		D d = new D();
		DInter i = d;
		DInter1 i1 = i;
		DInter2 i2 = i;
		i1.m1();
		i2.m2();
		System.out.println();
		i.m3();
		i.m1();
		i.m2();
	}
}

interface DInter11{
	void m1();
}
interface DInter21{
	void m2();
}
interface DInter01 extends DInter11, DInter21{
	void m3();
}
class D1 implements DInter01{
	public void m1(){
		System.out.println("m1()");
	}
	public void m2(){
		System.out.println("m2()");
	}
	public void m3(){
		System.out.println("m3()");
	}
	public static void main(String[] args){
		D1 d = new D1();
		DInter01 i = d;
		DInter11 i1 = i;
		DInter21 i2 = i;
		i1.m1();
		i2.m2();
		System.out.println();
		i.m3();
		i.m1();
		i.m2();
	}
}
interface DInter12{
	void m1();
}
interface DInter22{
	void m2();
}
interface DInter02 extends DInter12, DInter22{
	void m3();
}
class D2 implements DInter02{
	public void m1(){
		System.out.println("m1()");
	}
	public void m2(){
		System.out.println("m2()");
	}
	public void m3(){
		System.out.println("m3()");
	}
	public static void main(String []args){
		D2 d = new D2();
		DInter02 i = d;
		DInter12 i1 = i;
		DInter22 i2 = i;
		i1.m1();
		i2.m2();
		System.out.println();
		i.m3();
		i.m1();
		i.m2();
	}
}
interface DInter13{
	void m1();
}
interface DInter23{
	void m2();
}
interface DInter03 extends DInter13, DInter23{
	void m3();
}
class D3 implements DInter03{
	public void m1(){
		System.out.println("m1()");
	}
	public void m2(){
		System.out.println("m2()");
	}
	public void m3(){
		System.out.println("m3()");
	}
	public static void main(String []args){
		D3 d = new D3();
		DInter03 i = d;
		DInter13 i1 = i;
		DInter23 i2 = i;
		i1.m1();
		i2.m2();
		System.out.println();
		i.m3();
		i.m1();
		i.m2();
	}
}
interface DInter14{
	void m1();
}
interface DInter24{
	void m2();
}
interface DInter04 extends DInter14, DInter24{
	void m3();
}
class D4 implements DInter04{
	public void m1(){
		System.out.println("m1()");
	}
	public void m2(){
		System.out.println("m2()");
	}
	public void m3(){
		System.out.println("m3()");
	}
	public static void main(String []args){
		D4 d = new D4();
		DInter04 i = d;
		DInter14 i1 = i;
		DInter24 i2 = i;
		i1.m1();
		i2.m2();
		System.out.println();
		i.m3();
		i.m1();
		i.m2();
	}
}
interface DInter15{
	void m1();
}
interface DInter25{
	void m2();
}
interface DInter05 extends DInter15, DInter25{
	void m3();
}
class D5 implements DInter05{
	public void m1(){
		System.out.println("m1()");
	}
	public void m2(){
		System.out.println("m2()");
	}
	public void m3(){
		System.out.println("m3()");
	}
	public static void main(String []args){
		D5 d = new D5();
		DInter05 i = d;
		DInter15 i1 = i;
		DInter25 i2 = i;
		i1.m1();
		i2.m2();
		System.out.println();
		i.m3();
		i.m1();
		i.m2();
	}
}