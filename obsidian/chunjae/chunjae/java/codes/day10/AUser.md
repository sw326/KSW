package a.b;

import a.b.A;

class AUser {
    AUser(){
        super(); //new A();
        System.out.println("i: " + i ); //멤버
        m(); //메소드
    }
    public static void main(String[] args) 
    {
        new AUser();
    }
} 