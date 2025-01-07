drop table CT_EMP;
drop table CT_DEPT;
purge recyclebin;

create table CT_DEPT(
     DEPTNO number(2) primary key, -- PK부여 
     DNAME varchar2(14) default '개발부', -- default 
     LOC char(1) check(LOC in('1', '2')) -- check부여 '1' or '2'
);
create table CT_EMP(
     NO number(4) primary key,  -- PK부여
     NAME varchar2(10) not null,  -- not null부여 
     ADDR varchar2(6) check(ADDR in ('서울','부산')), -- check부여 '서울'or'부산'
     JUMIN varchar2(13) unique, -- unique부여 
     RDATE date default SYSDATE, -- default 현재시간 
     DEPTNO number(2) references CT_DEPT(DEPTNO) -- FK부여 
);

select CONSTRAINT_NAME, CONSTRAINT_TYPE from user_constraints where TABLE_NAME='CT_DEPT';
select CONSTRAINT_NAME, CONSTRAINT_TYPE from user_constraints where TABLE_NAME='CT_EMP';

insert into CT_DEPT(DEPTNO, LOC) values(10, '1');
insert into CT_DEPT(DEPTNO, LOC) values(20, '2');
select * from CT_DEPT;

insert into CT_EMP(NO, NAME, ADDR, JUMIN, DEPTNO) values(1000, '홍길동', '서울', '1234561234567', 10);
insert into CT_EMP(NO, NAME, ADDR, JUMIN, DEPTNO) values(2000, '이순신', '부산', '1234561234568', 20);
select * from CT_EMP;

commit;