# < DBMS >
- Oracle
- MariaDB
- MySql
- MsSql
- MongoDB ( NoSQL == Not only SQL ) : JS객체 형태로 저장 - 입출력 빠름, 대용량 접합(빅데이터)

RDBMS - 무결성, 정확성
MongoDB - 속도, 유연성

**트랜젝션** : 트랜잭션은 데이터베이스에서 **하나의 논리적 작업 단위**를 의미하며, 여러 작업을 하나의 묶음으로 처리하는 것을 말합니다. 트랜잭션은 데이터의 일관성을 유지하기 위해 반드시 **ACID 속성**을 준수해야 합니다.
- ACID ( Atomicity, Consistency, Isolation, Durability )


-- 최대 급여를 받는 사원의 이름을 출력 ? 
	select max(SAL) from EMP; 
	select ENAME from EMP where SAL=(select max(SAL) from EMP);


# < Function >
1) 함수 (function)이란?
   어떤 일을 수행하는 기능으로서 주어진 인수(argument)를 재료로 '처리'하여, 그 결과를 return하는 일
2) 기능에따른 분류
	1) Data 계산
	2) Data 변환
3) 종류
	1) 단일행 함수 ( ex: nvl, .. )
	   - 하나의 행(row)당, 하나의 결과값을 리턴하는 함수
	2) 복수행 함수
	   - 여러개의 행(row)당, 하나의 결과값을 리턴하는 함수
4) 단일행 함수
	1) 문자 함수
	   1. chr
	      select chr(65) from DUAL;
	   2. concat(컬럼명, '붙일 문자열');
	      select ENAME || ' is a ' JOB from EMP;
	      select concat(ENAME, ' is a '), JOB from EMP;
	   3. initcap(문자열) 
	      select initcap('the lion' )from DUAL
	   4. lower(문자열)
	      select lower('the lion' )from DUAL
	      select lower(ENAME)from DUAL
	   5. lpad('문자열1', 자리수, '문자열2') 
	      select lpad('khs', 13, '*#') from DUAL; 
	      설명) lpad("대상문자열", "총 문자길이", "채움문자")
	   6. rpad('문자열1', 자리수, '문자열2') 
	      select rpad('khs', 13, '*#') from DUAL; 
	      설명) rpad("대상문자열", "총 문자길이", "채움문자")
	   7. ltrim('문자열1', '문자열2') 
	      select ltrim('xyxXxyLAST WORDxy', 'xy') from DUAL; 
	      select ltrim('xyyXxyLAST WORDxy', 'yx') from DUAL; 
	      select ltrim(' LAST WORDxy', ' ') from DUAL;
	   8. rtrim('문자열1', '문자열2') 
	      select rtrim('xyxXxyLAST WORDxy', 'xy') from DUAL; 
	      select rtrim('xyyXxyLAST WORDxyx', 'xy') from DUAL; 
	      select rtrim('WORDxy ', ' ') from DUAL; 
	      select rtrim('WORDxy ') from DUAL; 
	      select length(rtrim('WORDxy ')) from DUAL;
	   9. replace('문자열1', '문자열2', '문자열3') 
	      select 'JACK and JUE' from DUAL; 
	      select replace('JACK and JUE', 'J', 'BL') from DUAL; 
	      select DNAME from DEPT; 
	      select replace(DNAME, 'A', 'a') from DEPT;
	   10. substr('문자열', 자리수, 갯수)
	       select substr('ABCDEFGHIJ', 3, 2) from DUAL;
	       select ENAME from EMP where ENAME like '_A%';
	       select ENAME from EMP where substr(ENAME, 2, 1)='A';
	   11. ascii(문자열)
	       select ascii('A') from DUAL;
	       select ascii('''') from DUAL;
	       select ascii(' ') from DUAL;
	       select ascii('#') from DUAL;
	       select ascii('3') from DUAL;
	   12. length('문자열')
	       select length('진달래 꽃') from DUAL;
	       select length('abc D') from DUAL;
	   13. greatest('문자열1', '문자열2', '문자열3')
	       select greatest('CC', 'ABCDE', 'CA') from DUAL;
	       select greatest('12', '132', '119') from DUAL;
	       select greatest('가나', '가다', '가자') from DUAL;
	   14. least
	       select least('CC', 'ABCDE', 'CA') from DUAL;
	       select least('12', '132', '119') from DUAL;
	       select least('가나', '가다', '가자') from DUAL;
	   15. instr('문자열1', '문자열2', 자리수1, 자리수2)
	       select instr('CORPORATE FLOOR', 'OR', 3, 2) from DUAL // 14
	       select instr('CORPORATE FLOOR', 'OR', 6, 1) from DUAL // 14
	   16. nvl(컬럼명, 숫자)
	       select ENAME, nvl(COMM, -1) from EMP;
	       
	2) 숫자 함수
		1) abs(숫자)
		   select abs(-10) form DUAL; -- 절대값은  0과의 거리
		   
		2) ceil(숫자)
		   select ceil(11.012) from DUAL; -- 12
		   select ceil(-11.012) from DUAL; -- -11
		   
		3) floor(숫자)
		   select floor(11.999) from DUAL -- 11
		   select floor(-11.999) from DUAL -- 11
		   
		4) round(숫자)
		   select round(12.5) from DUAL -- 13
		   select round(-12.5) from DUAL -- -13
		   
		5) cos(숫자[rad])
		   select cos(90*3.141592/180) from DUAL;
		   
		6) sin(숫자[rad])
		   select sin(90*3.141592/180) from DUAL;
		   
		7) tan(숫자[rad])
		   select tan(45*3.141592/180) from DUAL;
		   
		8) exp(숫자)
		   select exp(2) from DUAL;
		   
		9) log(숫자1, 숫자2)
		   select log(10, 100) from DUAL;
		   
		10) mod(숫자1, 숫자2)
		    select mod (11, 4) from DUAL;
		    
		11) power(숫자1, 숫자2)
		    select power(2, 50) from DAUL; -- 신문지 1장 50번 접으면 두께가? (100장에 1cm일 때)
		    
		12) trunc(숫자1, 숫자2)
		    select trunc(15.789, 2) from DUAL;
		    select trunc(15.789, 0) from DUAL;
		    select trunc(15.789) from DUAL;
		    select trunc(-15.789, 2) from DUAL;
		    
	3) 날짜 함수(**)
		1) SYSDATE
		   select SYSDATE from DUAL;
		   
		2) add_months
		   select HIREDATE from EMP where EMPNO=7782;
		   select HIREDATE, add_months(HIREDATE, 7) from EMP where EMPNO=7782;
		   
		3) last_day
		   select last_day('25/01/02') from dual; 
		   select HIREDATE, last_day(HIREDATE) from EMP;
		   
		4) months_between
		   select MONTHS_BETWEEN(SYSDATE, HIREDATE) from EMP where EMPNO=7782;
		   
		5) next_day
		   select SYSDATE, next_day(SYSDATE, 5) from DUAL;
		   select SYSDATE, next_day(SYSDATE,1) from DUAL; --25/01/05
		   select SYSDATE, next_day(SYSDATE,2) from DUAL; --25/01/06 
		   select SYSDATE, next_day(SYSDATE,5) from DUAL; --25/01/09 
		   select SYSDATE, next_day(SYSDATE,6) from DUAL; --25/01/03 
		   설명) 일(1), 월(2), 화(3), 수(4), 목(5), 금(6), 토(7)
		   
	4) 문자 변환 함수()
	   -> to_Char(날짜컬럼 or 날짜 데이터, '변환포멧')
	   1) 'D'
	      select SYSDATE, to_char(SYSDATE, 'D') from DUAL; --5
	   2) 'DAY'
	      select SYSDATE, to_char(SYSDATE, 'DAY') from DUAL; --목요일
	   3) 'DY'
	      select SYSDATE, to_char(SYSDATE, 'DY') from DUAL; --목
	   4) 'DD'
	      select SYSDATE, to_char(SYSDATE, 'DD') from DUAL; --02
	   5) 'MM'
	      select SYSDATE, to_char(SYSDATE, 'MM') from DUAL; --01
	   6) 'MON'
	      select SYSDATE, to_char(SYSDATE, 'MON') from DUAL; --1월
	      cf)  alter session set NLS_LANGUAGE='ENGLISH';
	      select SYSDATE, to_char(SYSDATE, 'MON') from DUAL; --JAN
	   7) 'MONTH'
	      select SYSDATE, to_char(SYSDATE, 'MONTH') from DUAL; --JANUARY cf) alter session set NLS_LANGUAGE='KOREAN'; select SYSDATE, to_char(SYSDATE, 'MONTH') from DUAL; --1월
	   8) 'YY'
	      select SYSDATE, to_char(SYSDATE, 'YY') from DUAL; --25
	   9) 'YYYY'
	      select SYSDATE, to_char(SYSDATE, 'YYYY') from DUAL; --2025
	   10) 'YY-MM-DD'
	       select SYSDATE, to_char(SYSDATE, 'YY-MM-DD') from DUAL; --25-01-02
	   11) 'HH'
	        select SYSDATE, to_char(SYSDATE, 'HH') from DUAL; --01
	        select SYSDATE, to_char(SYSDATE, 'HH24') from DUAL; --13
	   12) 'MI'
	       select SYSDATE, to_char(SYSDATE, 'MI') from DUAL; 
	   13) 'SS'
	       select SYSDATE, to_char(SYSDATE, 'SS') from DUAL;
	   14) 'AM' or 'PM'
	       select SYSDATE, to_char(SYSDATE, 'AM') from DUAL; select SYSDATE, to_char(SYSDATE, 'PM') from DUAL;
	       
	   14) 현재 날짜를 '2025-01-02 오후 01:41:59 목요일' 식으로 출력!
	       select to_char(SYSDATE, 'YYYY-MM-DD PM HH:MI:SS DAY') from DUAL;
	       
	       tip1) 세션의 기본 포멧 변경
		       alter session set NLS_DATE_FORMAT='YYYY-MM-DD PM HH:MI:SS DAY'
	       tip2) 서수
		       select SYSDATE, to_char(SYSDATE, 'DDSP') from DUAL; --one, two, three, .. select SYSDATE, to_char(SYSDATE, 'DDTH') from DUAL; --1st, 2nd, 3rd, .. select SYSDATE, to_char(SYSDATE, 'DDSPTH') from DUAL; --first, second, third, ..
5) 복수행 함수 ( Group Function )
   1) count(컬럼명)
      -- 사원수를 출력
      select count(EMPNO) from EMP;
      select count(COMM) from EMP;
      select count(*) from EMP; 
   2) sum(컬럼명)
      -- 모든 사원의 급여 총합
      select sum(SAL) from EMP;
      select sum(COMM) from EMP;
  3) avg(컬럼명)
     --평균급여
     select avg(SAL) from EMP;
     select avg(COMM) from EMP;
     select avg(nvl(COMM,0)) from EMP;
  4) max(컬럼명) min(컬럼명)
     -- 최대급여, 최소급여
     select max(SAL) from EMP;
     select min(SAL) from EMP;
     select max(SAL)-min(SAL) from EMP;
     
     -- 최저 급여자의 사원이름과 급여를 출력
     select ENAME, SAL from EMP where SAL = min(SAL); --(X)그룹 함수는 where 절에서 직접 나올 수 없음
     select ENAME, SAL from EMP where SAL = (select min(SAL)from EMP);
  5) variance(컬럼명) : 분산
     select variance(COMM) from EMP;
     select variance(nvl(COMM,0)) from EMP;
  6) stddev(컬럼명): 표준편차
     select stddev(COMM) from EPM;
     select stddev(nvl(COMM,0)) from EMP;


### < Question >
-- 부서별 평균 급여를 출력
select 10 as DEPTNO, AVG(SAL) from EMP where DEPTNO=10
union
select 20, AVG(SAL) from EMP where DEPTNO=20
union
select 30, AVG(SAL) from EMP where DEPTNO=30;

select DEPTNO, AVG(SAL) from EMP group by DEPTNO;
select DEPTNO, round(AVG(SAL)) from EMP group by DEPTNO;

-- 급여 2000 이상인 사원들의 부서별 평균 급여의 반올림값 ( 부서번호의 오름차순 정렬 )
select DEPTNO, ROUND(AVG(SAL)) from EMP where SAL>=2000 group by DEPTNO order by DEPTNO;

-- 급여 2000 이상인 사원들의 부서별 평균 급여의 반올림 값 (급여가 높은 순 정렬)
select DEPTNO, ROUND(AVG(SAL)) as 평균급여
from EMP where SAL >=2000
group by DEPTNO
order by 평균급여 desc;

select DEPTNO, ROUND(AVG(SAL))
from EMP where SAL >=2000
group by DEPTNO
order by 2 desc;

-- 급여가 1000 이상인 사원들의 부서별 평균 급여의 반올림값을 부서번호로 내림차순 정렬하라 단, 부서별 평균급여가 2000 이상인 값만 출력!

select DEPTNO, ROUND(AVG(SAL)) "평균급여" from EMP 
where SAL >=1000
group by DEPTNO
having round(AVG(SAL)) >= 2000
order by DEPTNO desc;

select DEPTNO, ROUND(AVG(SAL)) "평균급여" from EMP 
where SAL >=1000
group by DEPTNO
having "평균급여" >= 2000 -- (X) having 절에서는 alias 사용 불가!
order by DEPTNO desc;


-- 급여 1000이상인 사원의 부서별 평균급여의 반올림값을 부서번호로 내림차순 정렬하라
	단, 부서번호가 20 이상인 값만 출력!

select DEPTNO, ROUND(AVG(SAL)) from EMP 
where SAL >=1000
group by DEPTNO
having DEPTNO >= 20
order by DEPTNO desc;

-- 각 부서별 같은 업무를 하는 사원의 인원수를 구하여 부서번호, 엄무명, 인원수를 출력하라 단, 부서번호와 업무명으로 각각 내림차순 정렬!

select DEPTNO, JOB, count(EMPNO) from EMP 
group by DEPTNO, JOB
order by 1 desc, 2 desc;

< 일반화 >
1) 순서 ( SF-WGHO)
2) 그룹 함수는 where 절에서는 사용불가
3) group by 절이나 having 절에서는 alias 사용 불가


