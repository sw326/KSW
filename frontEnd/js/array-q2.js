'use strict';

class Student {
  constructor(name, age, enrolled, score) {
    this.name = name;
    this.age = age;
    this.enrolled = enrolled;
    this.score = score;
  }
}
const students = [
  new Student('홍길동', 30, true, 46),
  new Student('이순신', 29, false, 81),
  new Student('강감찬', 31, true, 91),
  new Student('유관순', 40, false, 67),
  new Student('세종대왕', 19, true, 89),
];
//[Q1] 91점을 받은 학생을 찾으시오
{
  // find : 조건에 맞는 요소를 찾아서 반환
  const result = students.find((student) => student.score === 91);
  console.log(result);
}

//[Q2] 등록된 학생들 배열을 만드시오
{
  // filter : 조건에 맞는 요소들을 배열로 반환(요소의 수가 변할 수 있음)

  const result = students.filter((student) => student.enrolled);
  console.log(result);
}
//[Q3] 점수들의 배열을 만드시오 ( 결과: [46, 81, 91, 67, 89] )
{
  // map : 조건에 맞는 요소들을 배열로 반환(요소를 변환하되 수는 변하지 않음)

  const result = students.map((student) => student.score);
  console.log(result);
}

//[Q4] 50점보다 낮은 학생이 있는 지 체크하시오
{
  // 조건에 맞는 요소가 하나라도 있는지 체크
  const result = students.some((student) => student.score < 50);
  console.log(result);
}
//[Q5] 스코어의 평균을 출력하시오
{
  // reduce : 누적 결과를 생성
  const score = students.map((student) => student.score);
  const sum = score.reduce((acc, curr) => acc + curr, 0);
  const result = sum / score.length;
  console.log(result);
}

//[Q6] 50점 이상 점수들의 문자열을 만드시오 ( 결과: '81,91,67,89' )
{
  // filter().map() 체이닝
  const result = students
    .filter((student) => student.score >= 50)
    .map((student) => student.score)
    .join(',');
  console.log(result);
}

//[Q7] 점수들을 오름차순으로 정렬된 '문자열'을 만드시오 ( 결과: '46,67,81,89,91' )
{
  // map().sort() 체이닝
  const result = students
    .map((student) => student.score)
    .sort((a, b) => a - b)
    .join(',');
  console.log(result);
}
//[Q8] 이름들을 내림차순 정렬한 '문자열'을 만드시오
{
  // sort() 문자열 내림차순 localeCompare() 사용
  const result = students
    .map((student) => student.name)
    .sort((a, b) => b.localeCompare(a))
    .join(',');
  console.log(result);
}
