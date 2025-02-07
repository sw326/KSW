'use strict';

//[Q1] 문자열로 만드시오 ( 결과: '사과|바나나|오렌지' )
{
  const fruits = ['사과', '바나나', '오렌지'];
  const result = fruits.join('|');
  console.log(result);
}

//[Q2] 배열로 만드시오 ( 결과: ['배','수박','포도','키위'] )
{
  const fruits = '배,수박,포도,키위';
  //   const result = fruits.split(',');
  //   console.log(result);
  const result = [];
  const splitFruits = fruits.split(',');
  for (const fruit of splitFruits) {
    result.push(fruit);
  }
  console.log(result);
}

//[Q3] 거꾸로 배열을 만드시요 ( 결과: [5,4,3,2,1] )
{
  const arr = [1, 2, 3, 4, 5];
  const result = [];
  for (let i = arr.length - 1; i >= 0; i--) {
    result.push(arr[i]);
  }
  console.log(result);
  const result2 = arr.reverse();
}

//[Q4] 일부 배열값을 떼어내시오 ( 결과: [3,4,5] )
{
  const arr = [1, 2, 3, 4, 5];
  arr.splice(0, 2);
  console.log(arr);

  const arr2 = [1, 2, 3, 4, 5];
  const result = arr2.slice(2, 5); // 이상 ~ 미만
  console.log(result);
}
