drop table CT_EMP;
drop table CT_DEPT;
purge recyclebin;

create table CT_DEPT(
     DEPTNO number(2), -- PK부여 
     DNAME varchar2(14), -- default 
     LOC char(1) -- check부여 '1' or '2'
);
alter table CT_DEPT add constraint CT_DEPT_PK primary key(DEPTNO);
alter table CT_DEPT add constraint CT_DEPT_CK check(LOC in('1', '2'));
alter table CT_DEPT modify DNAME default '개발부';

create table CT_EMP(
     NO number(4),  -- PK부여
     NAME varchar2(10),  -- not null부여 
     ADDR varchar2(6), -- check부여 '서울'or'부산'
     JUMIN varchar2(13), -- unique부여 
     RDATE date, -- default 현재시간 
     DEPTNO number(2) -- FK부여 
);
--CT_EMP 에도 CT_DEPT에서 처럼 제약조건 부여해보기!

select CONSTRAINT_NAME, CONSTRAINT_TYPE from user_constraints where TABLE_NAME='CT_DEPT';
select CONSTRAINT_NAME, CONSTRAINT_TYPE from user_constraints where TABLE_NAME='CT_EMP';

insert into CT_DEPT(DEPTNO, LOC) values(10, '1');
insert into CT_DEPT(DEPTNO, LOC) values(20, '2');
select * from CT_DEPT;

insert into CT_EMP(NO, NAME, ADDR, JUMIN, DEPTNO) values(1000, '홍길동', '서울', '1234561234567', 10);
insert into CT_EMP(NO, NAME, ADDR, JUMIN, DEPTNO) values(2000, '이순신', '부산', '1234561234568', 20);
select * from CT_EMP;

commit;