class J {
	String name;
	J(){
		this("이순신"); //2
	}
	J(String name){
		this.name = name; //1
		JUser user = new JUser(this); //3
		user.use();
	}
	
	int age = 10;
	void m(int age){
		this.age = age; //1
	}
	
	public static void main(String[] args) {
		new J();
	}
}
class JUser
{
	J j;
	JUser(J j){
		this.j = j;
	}
	void use(){
		j.m(20);
		System.out.println("j.age: " + j.age);
		System.out.println("j.name: " + j.name);
	}
}

class J1{
	String name;
	J1(){
		this("donald"); // 2
	}
	J1(String name){
		this.name = name; // 1
		JUser1 user = new JUser1(this); // 3
		user.use();
	}
	int age = 10;
	void m(int age){
		this.age = age; // 1
	}
	public static void main(String[] args){
		new J1();
	}
}
class JUser1{
	J1 j;
	JUser1(J1 j){
		this.j = j;
	}
	void use(){
		j.m(20);
		System.out.println("j.age: " + j.age);
		System.out.println("j.name: " + j.name);
	}
}

class J2{
	String name;
	J2(){
		this("날리면");
	}
	J2(String name){
		this.name = name;
		JUser2 user = new JUser2(this);
		user.use();
	}
	int age = 10;
	void m(int age){
		this.age = age;
	}
	public static void main(String[] args){
		new J2();
	}
}

class JUser2{
	J2 j;
	JUser2(J2 j){
		this.j=j;
	}
	void use(){
		j.m(20);
		System.out.println("j.age: " + j.age);
		System.out.println("j.name: " + j.name);
	}
}

class J3{
	String name;
	J3(){
		this("asd");
	}
	J3(String name){
		this.name = name;
		JUser3 user = new JUser3(this);
		user.use();
	}
	int age = 10;
	void m(int age){
		this.age = age;
	}
	public static void main(String []args){
		new J3();
	}
}
class JUser3{
	J3 j;
	JUser3(J3 j){
		this.j=j;
	}
	void use(){
		j.m(20);
		System.out.println("j.age: " + j.age);
		System.out.println("j.name: " + j.name);
	}
}