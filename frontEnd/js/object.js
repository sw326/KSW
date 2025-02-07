'use strict';

// 1. 객체 생성
const obj1 = {};
const obj2 = new Object();
const man = {
  name: '홍길동',
  age: 20,
};
man.job = true;
console.log(`${man.name}은 ${man.age}살이고, 직업은 ${man.job}입니다.`);
delete man.job;
console.log(`${man.name}은 ${man.age}살이고, 직업은 ${man.job}입니다.`);
delete man.age;
console.log(`${man.name}은 ${man.age}살이고, 직업은 ${man.job}입니다.`);

// 2. Computed Property
console.log(man.name);
console.log(man['name']);

const a = 'name';
console.log(man[a]);

function printValue(obj, key) {
  console.log(man[key]);
}
printValue(man, 'name');
printValue(man, 'age');

// 3. Property Value Shorthand(속기)
const m1 = {
  name: '이순신',
  age: 30,
};
console.log(`${m1.name}은 ${m1.age}살입니다.`);

function makeMan(name, age) {
  return {name, age};
}
const m2 = makeMan('홍길동', 20);
console.log(`${m2.name}은 ${m2.age}살입니다.`);

// 4. Constructor Function
function Man(name, age) {
  this.name = name;
  this.age = age;
  // return this; // 생략 가능
}
const m3 = new Man('강감찬', 40);
console.log(`${m3.name}은 ${m3.age}살입니다.`);

console.log('name' in m3);
console.log('age' in m3);
console.log('job' in m3);

console.log(m3.hasOwnProperty('name'));
console.log(m3.hasOwnProperty('job'));

for (const key in m3) {
  console.log(`${key}: ${m3[key]}`);
}

// for of 문 ( 값을 가져옴 )
const array = [1, 2, 3, 4, 5];
for (const value of array) {
  console.log(value);
}

// for in 문 ( 키를 가져옴 )
for (const key in array) {
  console.log(`${key}: ${array[key]}`);
}

// 6. cloning
const user1 = {
  name: '홍길동',
  age: 20,
};
const user2 = user1;
user2.name = '이순신';
console.log(user1);
console.log(user2);

const user3 = {};
for (const key in user1) {
  user3[key] = user1[key];
}
user1.name = '강감찬';
console.log(`user3.name: ${user3.name}, user3.age: ${user3.age}`);

// 향상된 클로닝
const user4 = Object.assign({}, user1);
user1.name = '김첨지';
console.log(`user4.name: ${user4.name}, user4.age: ${user4.age}`);

// 6.
const fruit1 = {color: 'blue', size: 'big'};
const fruit2 = {color: 'red', taste: 'sweet'};
const mixed = Object.assign({}, fruit1, fruit2);
console.log(mixed);
