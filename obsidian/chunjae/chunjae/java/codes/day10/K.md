```java
class K {
    String name;
    K(String name){
        this.name = name;
    }
    void m(){
        System.out.println("K의 m()");
    }
}
class KChild extends K{
    String name = "이순신";
    KChild(){
        super("홍길동"); //1
    }
    void showName(){
        System.out.println("this.name: " + name);
        System.out.println("super.name: " + super.name); //2
        m();
        super.m(); //3
    }
    void m(){ //오버라이딩
        System.out.println("KChild의 m()");
    }
}

class KUser {
    public static void main(String[] args) {
        KChild kc = new KChild();
        kc.showName();
    }
}