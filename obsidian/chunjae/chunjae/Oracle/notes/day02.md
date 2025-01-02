1. DQL
   (1) 기본
        show user
        select TNAME from tab; --뷰(논리적)
        desc user_tables 
        select TABLE_NAME from user_tables; --테이블(물리적)
        desc DEPT
        select * from DEPT;
        select DEPTNO, DNAME from DEPT;
        select DEPTNO, LOC from DEPT;

   (2) all / distinct
        desc EMP
        set linesize 120
        select * from EMP;
        select JOB from EMP; --12
        select all JOB from EMP; --12	
        select distinct JOB from EMP; --5

   (3) order by
        -- 모든 사원의 사번과 급여 출력 
        select EMPNO, SAL from EMP;
        select EMPNO, SAL from EMP order by EMPNO asc; --오름
        select EMPNO, SAL from EMP order by EMPNO desc; --내림
        -- 모든 사원의 사번과 급여 출력( 단, 급여가 적은 순으로 )
        select EMPNO, SAL from EMP order by SAL asc;
        select EMPNO, SAL from EMP order by SAL;
        -- 모든 사원의 사번과 급여 출력( 단, 급여가 많은 순으로 )
        select EMPNO, SAL from EMP order by SAL desc;
        -- 모든 사원의 사번과 급여를 출력 ( 급여가 높은 순, 같은 급여일 땐 EMPNO 오름차순 )
        select EMPNO, SAL from EMP order by SAL desc, EMPNO asc;
        select EMPNO, SAL from EMP order by SAL desc, EMPNO;

        -- 모든 사원의 사번과 커미션을 출력( 커미션 낮or높 순 )
        select EMPNO, COMM from EMP order by COMM;
        select EMPNO, COMM from EMP order by COMM desc;

        -- (null 제외한) 모든 사원의 사번과 커미션을 출력
        select EMPNO, COMM from EMP where COMM is not null; 
        -- (null 제외한) 모든 사원의 사번과 커미션을 출력 ( 단, 커미션이 높은 순으로 정렬 )
        select EMPNO, COMM from EMP where COMM is not null order by COMM desc;

        -- JOB에 대해서 오름차순 정렬한 후, 급여(SAL)가 높은 순으로 정렬
        select JOB, SAL from EMP order by JOB, SAL desc;

   (4) where 
        -- (부서번호가 20인) 사번과 부서번호 출력 
        select EMPNO, DEPTNO from EMP where DEPTNO=20;

        -- 30번 부서인 부서번호(DEPTNO)와 급여(SAL)와 사번(EMPNO)을 출력(단, 급여가 높은 순)
        select DEPTNO, SAL, EMPNO from EMP where DEPTNO=30 order by SAL desc;

        -- 입사일이 81년 12월 3일 이후의 '사번과 이름과 입사일과 부서번호' 출력 (단, 사번의 내림차순)
        select EMPNO, ENAME, HIREDATE, DEPTNO from EMP
        where HIREDATE>='81/12/3'
        order by EMPNO desc;

        -- 입사일이 81년 12월 3일 이후의 '사번과 이름과 입사일과 부서번호' 출력 (단, 사번의 내림차순, 20번부서만 )
        select EMPNO, ENAME, HIREDATE, DEPTNO from EMP
        where HIREDATE>='81/12/3' and DEPTNO=20
        order by EMPNO desc;

   (5) Alias
        select JOB as "직업", SAL as "급여" from EMP;
        select JOB "직업", SAL "급여" from EMP;
        select JOB 직업, SAL 급여 from EMP;
        select JOB 직업, SAL "1234" from EMP;
        select JOB 직업, SAL "!@#$" from EMP;
        select JOB 직업, SAL "급 여" from EMP;

        cf) 일반적인 경우
        select JOB j, SAL s from EMP;	

   (6) 연산자(Operator)
        1) 산술연산자 ( +, -, *, / )
        
        -- 30번 부서 사원의 급여를 10% 인상해서 사번(EMPNO)과 급여(SAL)를 출력
        select EMPNO, SAL*1.1 from EMP where DEPTNO=30;

        -- 30번 부서 사원의 '연말보너스'를 이름과 함께 연말보너스를 출력(연말보너스가 높은 순) 
        -- ( 단, 연말보너스는 급여의 2배와 커미션의 1/2의 합이다.)
        select ENAME, SAL*2+COMM/2 연말보너스 from EMP
        where DEPTNO=30
        order by 연말보너스 desc;

        select ENAME, SAL*2+NVL(COMM,0)/2 연말보너스 from EMP
        where DEPTNO=30
        order by 연말보너스 desc;

        2) 비교연산자 ( =, !=, >, >=, <, <= )
        -- 급여가 3000 이상인 사원의 이름(ENAME)과 급여(SAL)를 출력
        select ENAME, SAL from EMP where SAL>=3000;

        -- 30부서가 아닌 사원의 이름(ENAME)과 급여(SAL)와 부서번호(DEPTNO)를 출력
        -- ( 부서번호의 오름차순, 높은 급여순, 이름 오름차순 )
        select ENAME, SAL, DEPTNO from EMP where DEPTNO!=30
        order by DEPTNO, SAL desc, ENAME;

        3) 논리연산자( and , or , not )
        -- 20번 부서이면서 급여 3000이상인 사원의 이름, 급여, 부서번호를 출력
        select ENAME, SAL, DEPTNO from EMP where DEPTNO=20 and SAL>=3000;

        -- 업무가 'SALESMAN'이고 부서번호가 30번인 이름, 직업, 부서번호를 출력
        select ENAME, JOB, DEPTNO from EMP where JOB='SALESMAN' and DEPTNO=30;

        -- 급여가 1000 미만이거나, 4000 이상인 사원의 사번, 급여를 출력
        select EMPNO, SAL from EMP where SAL<1000 or SAL>=4000;
        select EMPNO, SAL from EMP where not (SAL>=1000 and SAL<4000);

        4) SQL연산자( in , any, all, between, like, is null, is not null, exists )	
        -- 부서번호가 10 or 20 or 100 인 사원의 부서번호과 이름을 출력
        select DEPTNO, ENAME from EMP where DEPTNO=10 or DEPTNO=20 or DEPTNO=100;
        select DEPTNO, ENAME from EMP where DEPTNO in(10,20,100);
        select DEPTNO, ENAME from EMP where DEPTNO=any(10,20,100);

        -- 30부서의 최대 급여보다 더 큰 급여를 받는 사원의 이름, 급여 출력
        select SAL from emp where DEPTNO=30;
        select ENAME, SAL from emp where SAL>all(select SAL from emp where DEPTNO=30);
        cf) all은 모두 만족시켜야 true 
        select max(SAL) from emp where DEPTNO=30;
        select ENAME, SAL from emp where SAL>(select max(SAL) from emp where DEPTNO=30);

        -- 급여가 1250 이상 3000 이하인 사원의 이름과 급여 출력
        select ENAME, SAL from EMP where SAL>=1250 and SAL<=3000;
        select ENAME, SAL from EMP where SAL between 1250 and 3000;	

        -- 이름이 'FORD'와 'KING' 사이의 사원 이름을 출력!(단, 알파벳 순 정렬) 
        select ENAME from EMP where ENAME between 'FORD' and 'KING' order by ENAME;

        -- 이름이 'J'로 시작되는 사원 이름을 출력(단, 오름차순 정렬)
        select ENAME from EMP where ENAME like 'J%' order by ENAME;

        -- 이름에 'T'가 들어있는 사원 이름을 출력
        select ENAME from EMP where ENAME like '%T%';

        -- 이름에 세번째 문자가 'A'인 사원의 이름을 출력
        select ENAME from EMP where ENAME like '__A%';	

        -- 급여의 십의 자리가 5인 사원의 급여를 출력
        select SAL from EMP where SAL like '%5_';

        -- 커미션이 NULL인 사원의 사번과 커미션을 출력
        select EMPNO, COMM from EMP where COMM is null;

        -- 커미션이 NULL인 아닌 사원의 사번과 커미션을 출력
        select EMPNO, COMM from EMP where COMM is not null;

        -- 이름이 'FORD'라는 사원이 존재하면 모든 사원의 이름을 출력
        select ENAME from EMP where ENAME='FORD';
        select ENAME from EMP where exists(select ENAME from EMP where ENAME='FORD');

        5) 결합연산자 ( || )
        -- SMITH의 급여는 800입니다
        select ENAME||'의 급여는 ', SAL||'입니다' from EMP;

        6) 집합연산자( union, union all, intersect(교), minus(차) )
        -- 사원의 사번과 이름 출력하고, 부서의 번호와 부서이름을 출력
        select EMPNO, ENAME from EMP
        union
        select DEPTNO, DNAME from DEPT;

        -- 사원의 사번과 이름 출력하고, 사원의 사번과 이름 출력
        select EMPNO, ENAME from EMP
        union	
        select EMPNO, ENAME from EMP; --12

        select EMPNO, ENAME from EMP
        union all 	
        select EMPNO, ENAME from EMP; --24

        -- '사원의 사번과 이름'과 '부서의 번호와 부서이름'의 공통부분을 출력
        select EMPNO, ENAME from EMP
        intersect
        select DEPTNO, DNAME from DEPT; --0

        select EMPNO, ENAME from EMP
        intersect
        select EMPNO, ENAME from EMP where ENAME='FORD'; --1개

        select EMPNO, ENAME from EMP
        minus
        select EMPNO, ENAME from EMP where ENAME='FORD'; --11개

        cf) 연산자 우선 순위
        <1> 1순위: 비교, SQL, 산술 
        <2> 2순위: not 
        <3> 3순위: and 
        <4> 4순위: or 
        <5> 5순위: ||, 집합

        select ENAME, SAL from EMP
        where NOT SAL>1000 and SAL<3000;  --2개 

        select ENAME, SAL from EMP
        where NOT (SAL>1000 and SAL<3000); --4개 