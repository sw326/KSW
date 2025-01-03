-- 사원번호와 부서 이름을 출력하라
select EMP.EMPNO, DEPT.DNAEM from EMP
inner join DEPT.DEPTNO = EMP.DEPTNO;

select EMPNO, DNAME from EMP, DEPT where EMP.DEPTNO = DEPT.DEPTNO;

# 3. Join & SubQuery

1) 조인(Join)
	1) 설명
	   하나의 테이블로 원하는 결과를 가져올 수 없는 경우,
	   고나련된 테이블들을 '논리적 결합'하여 원하는 컬럼 정보를 가져오는 방법
	   
	2) 조건
	   논리적으로 결합되는 2개 이상의 테이블에는 반드시 '공통 컬럼'이 존재해야함
	   이 공통 컬럼은 '동일한 데이터 타입'과 '동일한 데이터를 의미'해야 함
	   
	3) 예 -- 사원번호와 부서이름을 출력
	    select EMP.EMPNO, DEPT.DNAME from EMP, DEPT where EMP.DEPTNO=DEPT.DEPTNO; --형태1
        select e.EMPNO, d.DNAME from EMP e, DEPT d where e.DEPTNO=d.DEPTNO; --형태2
        select e.EMPNO, d.DNAME from EMP e join DEPT d on e.DEPTNO=d.DEPTNO; --형태3
        select EMPNO, DNAME from EMP join DEPT using(DEPTNO); --형태4
        select EMPNO, DNAME from EMP natural join DEPT; --형태5

	4) 종류
		1) Cross 조인
		   2개 이상의 테이블이 조인 될 때 'where 절'에 의해 공통되는 컬럼에 의한 결합이 '발생하지 않는 경우' 즉, 테이블 전체 행의 전체 컬럼이 조인에 사용되는 조인을 의미함. 따라서, 모든 데이터가 검색 결과가 됨

		2) Natural 조인 == Equi 조인 : 가장 일반적
		   '공통 컬럼'들이 동등 연산자(=)에 의해 비교되는 조인
		   
		   -- 사원번호와 부서이름을 출력(단, 30번 부서만)
		   select EMP.EMPNO, DEPT.DNAME from EMP, DEPT where EMP.DEPTNO=DEPT.DEPTNO and DEPT.DEPTNO=30;
		   select e.EMPNO, d.DNAME from EMP e, DEPT d where e.DEPTNO=d.DEPTNO and d.DEPTNO=30;
		   select e.EMPNO, d.DNAME from EMP e join DEPT d on e.DEPTNO=d.DEPTNO where d.DEPTNO=30;
           select e.EMPNO, d.DNAME from EMP e join DEPT d on e.DEPTNO=d.DEPTNO and d.DEPTNO=30;
           select EMPNO, DNAME from EMP join DEPT using(DEPTNO) where DEPTNO=30;
           select EMPNO, DNAME from EMP natural join DEPT where DEPTNO=30;
		   
		3) self 조인
            가져와야 할  컬럼이 '자신의 테이블

            -- SMITH의 매니저는 FORD 이다.
            1) select e.ENAME, m.ENAME from EMP e, EMP m where e.MGR=m.EMPNO;
            2) select e.ENAME, m.ENAME from EMP e join EMP m on e.MGR=m.EMPNO;

            select e1.EMPNO, e1.ENAME, e2.ENAME from EMP e1 
            join EMP e2 on e1.MGR = e2.EMPNO where e1.ENAME = 'SMITH';


		4) outer 조인
            한쪽 테이블에는 해당하는 데이터가 존재하고,
            다른쪽 테이블에는 데이터가 존재하지 않을 경우에 '기준 테이블'을 이용한 조인
            1) Left
               기본> select T1.NO, T1.NAME, T2.NO, T2.NAME 
	                from T1 left outer join T2 on T1.NO=T2.NO;
	            응용> select T1.NO, T1.NAME, T2.NO, T2.NAME 
	                from T1 left outer join T2 on T1.NO=T2.NO
		            where T2.NO is not null;

            2) Right
                기본> select T1.NO, T1.NAME, T2.NO, T2.NAME 
	                from T1 right outer join T2 on T1.NO=T2.NO;
                응용> select T1.NO, T1.NAME, T2.NO, T2.NAME 
	                from T1 right outer join T2 on T1.NO=T2.NO
		            where T1.NO is not null;

            3) Full
                기본> select T1.NO, T1.NAME, T2.NO, T2.NAME 
	                from T1 full outer join T2 on T1.NO=T2.NO;
                응용> select T1.NO, T1.NAME, T2.NO, T2.NAME 
	                from T1 full outer join T2 on T1.NO=T2.NO
		            where T2.NO is not null;

		5) inner 조인
		   select T1.NO, T1.NAME, T2.NO, T2.NAME from T1 inner left join T2
		   on T1.NO 

        < 일반화: 배치와 실행순서 >
        - Select XX    ----> 6
        - From XX   -------> 1     
        - (XX join XX) ----> 2 
        - Where XX     ----> 3 
        - Group by XX  ----> 4 
        - Having XX    ----> 5 
        - Order by XX  ----> 7 

2) 서브쿼리 (SubQuery)
   -- 사원 번호가 7900인 사원의 부서 이름 출력
   join -> select EMPNO, DNAME from EMP natural join DEPT where EMPNO=7900;
   
   sub -> select DEPTNO from EMP where EMPNO=7900;
   main -> select DNAME from DEPT where DEPTNO=30;
   결합 -> select DNAME from DEPT where DEPTNO=(select DEPTNO from EMP where EMPNO=7900);

   1) 설명
      하나의 select 문 장에 포함된 또 다른 select 문장
      (두번 이상 질의를 해야 얻을 수 있는 결과를 한번의 질의로 통합한 쿼리)
      
   2) 용어
      1. Main-Query or Outer-Query
      2. Sub-query or Inner-Query
         
   3) 특징
      1. '괄호'를 묶어야 함
      2. '실행 순서'는 '대부분' Sub-Query가 먼저 수행되고, Main-Query가수행됨
      3. Sub-Query는 Main-Query의 다음 부분에 위치할 수 있음
         - select/delete/update 문장의 from절 / where 절
         - insert 문장의 into절
         - update 문장의 set 절
      4. Sub-Query는 order by 절 사용 불가

   4) 종류
      1. 단일행 Sub-Query
         --부서 번호가 10번인 사원 급여와 급여가 같은 사원의 이름과 커미션을 출력
         sub-> select SAL from EMP where DEPTNO=10;
         Main-> select ENAME, COMM from EMP where SAL=?;
         Err->select ENAME, COMM from EMP where SAL=(select SAL from EMP where DEPTNO=10);
         
         -- 사번이 7369인 사원의 '급여와 커미션'이 같은.. 사원의 이름과 커미션을 출력
         sub-> select SAL, COMM from EMP where EMPNO=7369
         main-> select ENAME, COMM from EMP where SAL=?
         Err> select ENAME, COMM from EMP where SAL=(select SAL, COMM from EMP where EMPNO=7369);
         
         -- 평균 급여보다 많이 받는 사원의 이름과 급여 출력
         sub-> select AVG(SAL) from EMP;
         Main> select ENAME, SAL from EMP where SAL>?
         결합-> select ENAME, SAL from EMP where SAL>(select AVG(SAL) from EMP);
	 2. 복수행 Sub-Query
		    실행결과가 '둘 이상의 데이터 행'만 리턴 해주는 쿼리
		    -- 
		    select sal from emp where job='MANAGER';
		    select job, sal from emp where sal>=(select sal from emp where job='MANAGER');
		    select job, sal from emp where sal>=all(select sal from emp where job='MANAGER');
		    -- 
		    select job, sal from emp where sal<=all(select sal from emp where job='SALESMAN');
		    select job, sal from emp where sal<any(select sal from emp where job='SALESMAN');
		    --
		    select * from EMP where DEPTNO=10;
		    select DNAME from EMP;
	 3. 복수 컬럼 Sub-Query
		    --'부서번호'가 30인 사원의 (SAL과 COMM)이 같은 사원들의 이름과 부서번호 출력
		    select SAL, COMM from EMP where DEPTNO=30;
		    select ENAME, DEPTNO from EMP where (SAL, COMM) in ?;
		    select ENAME, DEPTNO from EMP where (SAL, COMM) in (select SAL, COMM from EMP where DEPTNO=30);
            select ENAME, DEPTNO from EMP where (SAL, nvl(COMM,0)) in (select SAL, nvl(COMM,0) from EMP where DEPTNO=30);
	 4. 상호관련 Sub-Query
		    
   1) 
1) 




# < Q >
-- 부서번호가 10번인 사원 평균 급여보다 급여가 적은 사원의 이름과 급여 단, 급여가 높은 순 정렬

sub> select AVG(SAL) from emp where deptno=10;
main> select ename, sal from emp where SAL<(select AVG(SAL) from emp where deptno=10);

select ename, sal from emp 
where SAL<(select AVG(SAL) from emp where deptno=10)
order by SAL desc;

-- 부서번호가 10번인 사원 평균급여 보다 급역 적은 사원들의 부서별 평균 급여. 단, 10번부서는 출력 제외, 부서번호 역정렬, 급여는 반올림.
sub> select AVG(SAL) from EMP where deptno=10;
main> select AVG(SAL) from EMP where SAL<(select AVG(SAL) from EMP where DEPTNO=10)

select DEPTNO, round(avg(SAL)) from EMP 
where SAL<(select AVG(SAL) from EMP where DEPTNO=10)
group by DEPTNO
having DEPTNO !=10
order by DEPTNO desc;




# DML (Data Manipulation Language)
1) 설명
   테이블 내의 데이터를 '입력', '수정', '삭제'하는 SQL문
   
2) 종류
	1) insert
	    insert into DEPT3 values(50, '개발부', '서울');
	    
	    insert into EMP3 values(8000, '홍길동', '개발', '7900', SYSDATE, 4000, null, 50); -- FK위배
	    
	    insert into EMP3(EMPNO, ENAME, SAL, HIREDATE) values(8000, '이순신', 4500, SYSDATE); -- PK 위배
	    
	    insert into EMP3(EMPNO, ENAME, SAL, HIREDATE) values(9000, '이순신', 4500, SYSDATE);
	    
	    insert into EMP3(ENAME, SAL, HIREDATE) values('강감찬', 4800, SYSDATE); --PK위배
	    
	2) update
	   update EMP3 set ENAME='김길동', SAL=6000 where EMPNO=8000;
	   update EMP3 set EMPNO=8001 where EMPNO=8000;
	   update EMP3 set DEPTNO=10 where EMPNO=8001;
	   
	3) delete
	   delete from EMP3 where EMPNO=9000;
	   delete from EMP3 where DEPTNO=10;
	   delete from DEPT3 where DEPTNO=20; -- cascade 여부에 따라 다름
	   
	   cf1) cascade 옵션을 이용한 부모 테이블 삭제
	   drop table <-- 마찬가지로 FK 제약에 걸린다.
	   
	   cf2) purge recyclebin;


## TCL (Transaction Control Language)
DML 실행 결과가 DBMS에 '영구 저장'되거나, '되돌리기'위한 SQL