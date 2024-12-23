import java.util.Arrays;

class H 
{
	final static int[] is = {10, 20};  //is:멤버/클래스/상수/참조  
	public static void main(String args[]){
		is[0] = 30;
	}
}

class H2
{
	final static int[] is = {10, 20}; // is: 맴버/클래스/상수/참조
	public static void main(String[] args){
		is[0]=30;
	}
}

class H3
{
	final static int is[] = {10, 20};
	public static void main(String []args){
		// is = {30, 40}; 상수 변경 불가
	}
}

class H4
{
	final static int []is = {20, 30};
	public static void main(String[] args){
		is[1]=60;
	}
}

class H5{
	final int []is = {20, 30};
	public static void main(String[] args){
		H5 h = new H5();
		h.is[0]=50;
		System.out.println(Arrays.toString(h.is));
	}
}