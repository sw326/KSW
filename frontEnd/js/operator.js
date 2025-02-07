'use strict';

// 1. 산술 연산자
console.log(`1 + 2 = ${1 + 2}`); // 1 + 2 = 3
console.log(`1 - 2 = ${1 - 2}`); // 1 - 2 = -1
console.log(`1 * 2 = ${1 * 2}`); // 1 * 2 = 2
console.log(`1 / 2 = ${1 / 2}`); // 1 / 2 = 0.5
console.log(`1 % 2 = ${1 % 2}`); // 1 % 2 = 1
console.log(`1 ** 2 = ${1 ** 2}`); // 1 ** 2 = 1
console.log(`1 + 2 * 3 = ${1 + 2 * 3}`); // 1 + 2 * 3 = 7
console.log(`(1 + 2) * 3 = ${(1 + 2) * 3}`); // (1 + 2) * 3 = 9

// 2. 할당 연산자
const count1 = ++a;
console.log(`count1 = ${count1}, a = ${a}`); // count1 = 2, a = 2
const count2 = a++;
console.log(`count2 = ${count2}, a = ${a}`); // count2 = 2, a = 3

let a = 1;
a += 1;
console.log(`a = ${a}`); // a = 2
a -= 1;
console.log(`a = ${a}`); // a = 1
a *= 2;
console.log(`a = ${a}`); // a = 2
a /= 2;
console.log(`a = ${a}`); // a = 1
a %= 2;
console.log(`a = ${a}`); // a = 1
a **= 2;
console.log(`a = ${a}`); // a = 1

// 3. 비교 연산자
const b = 1;

// 4. 논리 연산자
console.log(`true && 1<0 = ${true && 1 < 0}`);

// 5. 동등 연산자
const c = 1;
const d = '1';
// loose equality ( with type conversion )
console.log(`c == d = ${c == d}`); // c == d = true
console.log(`c != d = ${c != d}`); // c != d = false
// strict equality ( no type conversion )
console.log(`c === d = ${c === d}`); // c === d = false
console.log(`c !== d = ${c !== d}`); // c !== d = true
