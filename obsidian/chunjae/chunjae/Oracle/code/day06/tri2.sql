-- 트리거2: EMP_TRI에 insert가 될 때, 자동으로 
-- EMP2에서 이름과 급여를 (EMP_TRI의 이름과 급여로) update

create or replace trigger TRI_SAL2
after
    insert on EMP_TRI
    for each row
begin
    update EMP2 set ENAME=:new.ENAME, SAL=:new.SAL
    where EMPNO=:new.EMPNO;
end;
/

insert into EMP_TRI values(7369, '유관순', 7000);
commit;
select * from EMP_TRI;
select EMPNO, ENAME, SAL from EMP2;