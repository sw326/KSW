-- 사원번호와 급여인상률을 넣으면 해당사원의 급여가 인상되는 프로시저
create or replace procedure INCRE2(n in EMP2.EMPNO%TYPE, r in NUMBER)
is
    newPay NUMBER;
begin
    select SAL into newPay from EMP2 where EMPNO=n;
    newPay := newPay + newPay*r/100;
    update EMP2 set SAL = newPay where EMPNO=n;
    commit;
end;
/

-- call INCRE2(7369, 20);
-- select EMPNO, SAL from EMP2 where EMPNO=7369;