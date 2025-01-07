drop table CT_EMP;
drop table CT_DEPT;
purge recyclebin;

create table CT_DEPT(
     DEPTNO number(2), -- PK부여 
     DNAME varchar2(14), -- default 
     LOC char(1) -- check부여 '1' or '2'
);
create table CT_EMP(
     NO number(4),  -- PK부여
     NAME varchar2(10),  -- not null부여 
     ADDR varchar2(6), -- check부여 '서울'or'부산'
     JUMIN varchar2(13), -- unique부여 
     RDATE date, -- default 현재시간 
     DEPTNO number(2) -- FK부여 
);