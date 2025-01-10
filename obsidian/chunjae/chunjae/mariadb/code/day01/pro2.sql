DELIMITER //

CREATE OR REPLACE PROCEDURE INCRE2(IN n INT, IN r FLOAT)
BEGIN
    DECLARE newPay FLOAT;

    -- 현재 SAL 값을 가져옴
    SELECT SAL INTO newPay 
    FROM EMP2 
    WHERE EMPNO = n;

    -- 새로운 SAL 값을 계산
    SET newPay = newPay + newPay * r / 100;

    -- SAL 값을 업데이트
    UPDATE EMP2 
    SET SAL = newPay 
    WHERE EMPNO = n;

    -- 변경 사항 커밋
    COMMIT;
END //

DELIMITER ;
