'use strict';

// 2. let: Mutable (RW)
let globalName = 'gName';
{
  let na = 'chum';
  console.log(na);
  na = 'chumji';
  console.log(na);
}
// console.log(na);
console.log(globalName);

console.log('====================================');

// 3. const: Immutable (R)
const count = 7;
// count = 8;
console.log(count);

// 4. variable types
// primitive, single item: number, string, boolean, null, undefined, symbol
// object, box container
// function, first-class function

// (1) number
console.log(`value ${count}, type ${typeof count}`);
// console.log(`str ${str}`); // Error
console.log(`type ${typeof str}`); // undefined

const a = 1 / 0;
console.log(`a ${a}, type ${typeof a}`); // Infinity
const b = -1 / 0;
console.log(`b ${b}, type ${typeof b}`); // -Infinity
const c = 'chum' / 2;
console.log(`c ${c}, type ${typeof c}`); // NaN

console.log('====================================');

// (2) string
const hello = 'hello';
console.log(`value ${hello}, type ${typeof hello}`);
const name = 'chum';
const sayHello = hello + ' ' + name;
console.log(`value ${sayHello}, type ${typeof sayHello}`);

console.log('====================================');

console.log(`
    백틱은 
    여러 줄을
    가능하게 합니다.
    ${sayHello}
    `);

// (3) boolean
// false: 0, null, undefined, NaN, ''
// true: any other value
let isTrue = '';
console.log(`value ${isTrue}, type ${typeof isTrue}`);
if (isTrue) {
  console.log('true');
} else {
  console.log('false');
}

console.log('====================================');

// (4) null
let nothing = null;
console.log(`value ${nothing}, type ${typeof nothing}`); // null, object

// (5) undefined
let x;
console.log(`value ${x}, type ${typeof x}`); // undefined

// (6) symbol, create unique identifiers for objects
const symbol1 = Symbol('id');
const symbol2 = Symbol('id');
console.log(symbol1 === symbol2); // false
const gSymbol1 = Symbol.for('id');
const gSymbol2 = Symbol.for('id');
console.log(gSymbol1 === gSymbol2); // true
console.log(`value ${symbol1.description}, type ${typeof symbol1}`);

// (7) Dynamic typing: dynamically typed language
let text = 'hello';
console.log(`text.charAt(0) ${text.charAt(0)}`);
console.log(`value ${text}, type ${typeof text}`);
text = 1;
console.log(`value ${text}, type ${typeof text}`);
text = '7' + 5;
console.log(`value ${text}, type ${typeof text}`);
text = '8' / '2';
console.log(`value ${text}, type ${typeof text}`);
console.log(text.charAt(0)); // Error

//(8) object
const obj = {name: '홍길동', age: 30}; //new Human("홍길동", 30);
console.log(`value ${obj.name}(${obj.age}), type ${typeof obj}`); //object
obj.name = '이순신';
console.log(`value: ${obj.name}`);
