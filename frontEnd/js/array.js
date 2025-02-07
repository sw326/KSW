'use strict';

// 1. new
const arr1 = new Array();
const arr2 = [1, 2];

// 2. index and length
const fruits = ['apple', 'banana', 'cherry'];
console.log(fruits);
console.log(fruits.length);
console.log(fruits[fruits.length - 1]);

// 3. loop
// 3-1
for (let i = 0; i < fruits.length; i++) {
  console.log(fruits[i]);
}

// 3-2
for (const fruit of fruits) {
  console.log(fruit);
}

// 3-3
fruits.forEach((fruit) => console.log(fruit));

// 4. add, del
fruits.push('orange', 'peach'); // 뒤에 넣음
console.log(fruits);

fruits.unshift('strawberry'); // 앞에 넣음
console.log(fruits);

fruits.pop(); // 마지막 요소 제거
console.log(fruits);

fruits.shift(); // 첫 요소 제거
console.log(fruits);

fruits.splice(1, 1); // 1번째 요소 제거
console.log(fruits);

fruits.splice(1);
console.log(fruits);

fruits.splice(1, 0, 'orange', 'peach'); // 1번째 위치에 orange, peach 추가
console.log(fruits);

// 5. concat
const fruits2 = ['pineapple', 'grape'];
const newFruits = fruits.concat(fruits2);
console.log(newFruits);

// 6.
fruits.indexOf('peach');
console.log(fruits.indexOf('peach'));

fruits.indexOf('banana');
console.log(fruits.indexOf('banana')); // 없으면 -1

fruits.lastIndexOf('apple');
console.log(fruits.lastIndexOf('apple')); // 마지막 요소의 인덱스

fruits.push('apple');
console.log(fruits.indexOf('apple'));
console.log(fruits.lastIndexOf('apple'));

// 7. includes
console.log(fruits.includes('apple'));
console.log(fruits.includes('banana'));
