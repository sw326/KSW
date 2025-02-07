'use strict';

//1. 클래스
class Person {
  constructor(name, age) {
    this.name = name;
    this.age = age;
  }
  show() {
    console.log(`이름 ${this.name}, 나이 ${this.age}`);
  }
}
const man = new Person('홍길동', 23); //{name:'홍길동', age:23}
man.show();

//2. Getter, Setter
class User {
  constructor(name, age) {
    this.name = name;
    this.age = age;
  }
  get age() {
    return this._age;
  }
  set age(age) {
    this._age = age;
  }
}
const user = new User('이순신', 33);
console.log(`(1)이름 ${user.name}, 나이: ${user.age}`); //내부적으로 getter 호출
user.age = 44; //내부적으로 setter 호출
console.log(`(2)이름 ${user.name}, 나이: ${user.age}`);

//3. 접근제한자( public, private, protected )
class Access {
  publicField = 1;
  #privateField = 2;
}
const acc = new Access();
console.log(`(1) publicField ${acc.publicField}`); //1
console.log(`(2) privateField ${acc.privateField}`); //undefined

//4. 소유제한자( static ): JS에서 static자원은 객체에게 공유되지 않음
class Static {
  a = 'khs';
  static c = 'soo';
  constructor(b) {
    this.b = b;
  }
  showA() {
    return this.a; //멤버
  }
  showB() {
    return this.b; //멤버
  }
  static showC() {
    return Static.c; //멤버
  }
}
const obj = new Static(1);
console.log(`obj.a ${obj.a}`);
console.log(`obj.b ${obj.b}`);
console.log(`obj.showA() ${obj.showA()}`);
console.log(`obj.showB() ${obj.showB()}`);

console.log(`Static.c ${Static.c}`); //soo
console.log(`Static.showC() ${Static.showC()}`); //soo
console.clear();

//5. 상속성과 다형성
class Shape {
  //constructor(){} //case1 일때
  constructor(color) {
    //case2 일때
    this.color = color;
  }
  draw() {
    console.log('도형을 그리다');
  }
  toString() {
    return this.color;
  }
}
class Rectangle extends Shape {
  /*constructor(color){ //생략가능!
        super(color);
    }*/
}
const rec = new Rectangle('빨강');
console.log(`rec.color ${rec.color}`); //빨강
rec.draw(); //도형을 그리다

class Triangle extends Shape {
  draw() {
    console.log('삼각형을 그리다');
  }
}
const tri = new Triangle('파랑');
console.log(`tri.color ${tri.color}`); //파랑
console.log(`tri.toString() ${tri.toString()}`); //파랑
tri.draw(); //삼각형을 그리다

//6. instanceof
console.log(tri instanceof Triangle); //true
console.log(tri instanceof Shape); //true
console.log(tri instanceof Object); //true

const sh = new Shape('초록');
console.log(sh instanceof Triangle); //false
