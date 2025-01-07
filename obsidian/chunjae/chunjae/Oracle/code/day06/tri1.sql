drop table EMP_TRI;
purge recyclebin;

create table EMP_TRI(
    EMPNO number(4) primary key,
    ENAME varchar2(10),
    SAL NUMBER(7,2)
);

-- 트리거1: '사번만 입력'되면 자동으로 이름과 급여가 업데이트 되는 트리거
create or replace trigger TRI_SAL1
after
    insert on EMP_TRI
begin
    update EMP_TRI set ENAME='이순신', SAL=3000;
end;
/

insert into EMP_TRI(EMPNO) values(1000);
commit;
select * from EMP_TRI;