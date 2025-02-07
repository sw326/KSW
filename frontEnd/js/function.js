'use strict';

const {func} = require('prop-types');

// 1. 선언
function f1() {
  console.log('This is f1');
}

// 2. 호출
f1(); // This is f1

// 3. 매개변수
function f2(a, b) {
  console.log(`a = ${a}, b = ${b}`);
}

f2(1, 2); // a = 1, b = 2

function f3(obj) {
  console.log(`obj.name = ${obj.name}`);
  obj.name = '이순신';
}
const obj = {name: '홍길동'};
f3(obj); // obj.name = 홍길동
console.log(`obj.name = ${obj.name}`); // obj.name = 이순신

// 4. 디폴트 파라미터
function f4(a = 0, b = 0) {
  console.log(`a = ${a}, b = ${b}`);
}
f4(1); // a = 1, b = 0
f4(); // a = 0, b = 0

// 5. Rest 파라미터
function f5(...args) {
  for (let i = 0; i < args.length; i++) {
    console.log(`args[${i}] = ${args[i]}`);
  }
  for (const arg of args) {
    console.log(`arg = ${arg}`);
  }
  args.forEach((arg, index) => console.log(`args[${index}] = ${arg}`));
}

// 6. 로컬 변수
function f6() {
  const a = 1;
  console.log(`a = ${a}`);
}
f6(); // a = 1
// console.log(a); // ReferenceError: a is not defined

// 7. return 값
function f7(a, b) {
  return a + b;
}
console.log(`f7(1, 2) = ${f7(1, 2)}`); // f7(1, 2) = 3

// 8. early return
function f8(a, b) {
  if (a < 0) {
    return;
  }
  return a + b;
}

// 9. fubction expression
const f9 = function () {
  console.log('This is f9');
};
f9();

const f10 = function () {
  return 'This is f10';
};
console.log(f10());

// 10. callback function
function f11(callback) {
  callback();
}
f11(function () {
  console.log('This is callback function');
});

function f12(anser, yes, n0) {
  if (anser === 'correct') {
    yes();
  } else {
    n0();
  }
}
const yes = function () {
  console.log('yes');
};
const no = function () {
  console.log('no');
};

f12('correct', yes, no);
f12('wrong', yes, no);

// 11. arrow function
const f13 = () => console.log('f13()');
f13();

const f14 = (a, b) => {
  return a + b;
};
console.log(`f14(1, 2) = ${f14(1, 2)}`);

const f15 = (a, b) => a + b;
console.log(`f15(1, 2) = ${f15(1, 2)}`);

const f16 = (a, b) => {
  const c = a + b;
  return c;
};

// 12. 정의와 호출을 합치기
function f17() {
  console.log('f17');
}
f17();

(function f17() {
  console.log('f17');
})();

(function (a, b) {
  console.log(`a + b = ${a + b}`);
})(1, 2);
