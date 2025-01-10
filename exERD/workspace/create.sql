-- create.sql

drop table EMP;
drop table DEPT;
purge recyclebin;

create table DEPT(
    DEPTNO NUMBER(2) constraint DEPT_PK primary key,
    DNAME VARCHAR2(14),
    LOC VARCHAR2(13)
);

create table EMP(
    EMPNO NUMBER(4) constraint EMPNO_PK primary key,
    ENAME VARCHAR2(10),
    JOB VARCHAR2(9),
    MGR NUMBER(4),
    HIREDATE DATE,
    SAL NUMBER(7,2),
    COMM NUMBER(7,2),
    DEPTNO NUMBER(2) constraint EMP_FK REFERENCES DEPT(DEPTNO)
);


select TABLE_NAME, CONSTRAINT_NAME, CONSTRAINT_TYPE from user_constraints 
where TABLE_NAME='DEPT' or TABLE_NAME='EMP';
desc DEPT
desc EMP

insert into DEPT values(10, 'develop', 'Seoul');
insert into DEPT values(20, 'finance', 'Busan');

insert into EMP values(1000, 'Hong', 'FE dev', 2000, sysdate, 3000, 300, 10);
insert into EMP values(2000, 'Lee', 'analist', 1000, sysdate, 4000, null, 20);

set linesize 120;
select * from DEPT;
select * from EMP;