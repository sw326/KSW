select CONSTRAINT_NAME, CONSTRAINT_TYPE from user_constraints
where TABLE_NAME='EMP2';
alter table EMP2 drop constraint EMP2_PK;
desc EMP2
alter table EMP2 add constraint EMP2_PK primary key(EMPNO, DEPTNO);
desc EMP2
insert into EMP2(EMPNO, ENAME, DEPTNO) values(7369, '이순신', 10);
select * from EMP2;