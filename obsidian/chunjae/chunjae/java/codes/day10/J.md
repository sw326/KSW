```java
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
``` 