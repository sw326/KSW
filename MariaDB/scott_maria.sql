DROP TABLE IF EXISTS DEPT;
CREATE TABLE DEPT (
    DEPTNO INT(2) PRIMARY KEY,
    DNAME VARCHAR(14),
    LOC VARCHAR(13)
);

DROP TABLE IF EXISTS EMP;
CREATE TABLE EMP (
    EMPNO INT(4) PRIMARY KEY,
    ENAME VARCHAR(10),
    JOB VARCHAR(9),
    MGR INT(4),
    HIREDATE DATE,
    SAL DECIMAL(7,2),
    COMM DECIMAL(7,2),
    DEPTNO INT(2),
    CONSTRAINT FK_DEPTNO FOREIGN KEY (DEPTNO) REFERENCES DEPT(DEPTNO)
);

INSERT INTO DEPT VALUES (10, 'ACCOUNTING', 'NEW YORK');
INSERT INTO DEPT VALUES (20, 'RESEARCH', 'DALLAS');
INSERT INTO DEPT VALUES (30, 'SALES', 'CHICAGO');
INSERT INTO DEPT VALUES (40, 'OPERATIONS', 'BOSTON');

INSERT INTO EMP VALUES (7369, 'SMITH', 'CLERK', 7902, STR_TO_DATE('17-12-1980', '%d-%m-%Y'), 800, NULL, 20);
INSERT INTO EMP VALUES (7499, 'ALLEN', 'SALESMAN', 7698, STR_TO_DATE('20-2-1981', '%d-%m-%Y'), 1600, 300, 30);
INSERT INTO EMP VALUES (7521, 'WARD', 'SALESMAN', 7698, STR_TO_DATE('22-2-1981', '%d-%m-%Y'), 1250, 500, 30);
INSERT INTO EMP VALUES (7566, 'JONES', 'MANAGER', 7839, STR_TO_DATE('2-4-1981', '%d-%m-%Y'), 2975, NULL, 20);
INSERT INTO EMP VALUES (7654, 'MARTIN', 'SALESMAN', 7698, STR_TO_DATE('28-9-1981', '%d-%m-%Y'), 1250, 1400, 30);
INSERT INTO EMP VALUES (7698, 'BLAKE', 'MANAGER', 7839, STR_TO_DATE('1-5-1981', '%d-%m-%Y'), 2850, NULL, 30);
INSERT INTO EMP VALUES (7782, 'CLARK', 'MANAGER', 7839, STR_TO_DATE('9-6-1981', '%d-%m-%Y'), 2450, NULL, 10);
INSERT INTO EMP VALUES (7788, 'SCOTT', 'ANALYST', 7566, DATE_SUB(STR_TO_DATE('13-07-1987', '%d-%m-%Y'), INTERVAL 85 DAY), 3000, NULL, 20);
INSERT INTO EMP VALUES (7839, 'KING', 'PRESIDENT', NULL, STR_TO_DATE('17-11-1981', '%d-%m-%Y'), 5000, NULL, 10);
INSERT INTO EMP VALUES (7844, 'TURNER', 'SALESMAN', 7698, STR_TO_DATE('8-9-1981', '%d-%m-%Y'), 1500, 0, 30);
INSERT INTO EMP VALUES (7876, 'ADAMS', 'CLERK', 7788, DATE_SUB(STR_TO_DATE('13-07-1987', '%d-%m-%Y'), INTERVAL 51 DAY), 1100, NULL, 20);
INSERT INTO EMP VALUES (7900, 'JAMES', 'CLERK', 7698, STR_TO_DATE('3-12-1981', '%d-%m-%Y'), 950, NULL, 30);
INSERT INTO EMP VALUES (7902, 'FORD', 'ANALYST', 7566, STR_TO_DATE('3-12-1981', '%d-%m-%Y'), 3000, NULL, 20);
INSERT INTO EMP VALUES (7934, 'MILLER', 'CLERK', 7782, STR_TO_DATE('23-1-1982', '%d-%m-%Y'), 1300, NULL, 10);

DROP TABLE IF EXISTS BONUS;
CREATE TABLE BONUS (
    ENAME VARCHAR(10),
    JOB VARCHAR(9),
    SAL DECIMAL(10,2),
    COMM DECIMAL(10,2)
);

DROP TABLE IF EXISTS SALGRADE;
CREATE TABLE SALGRADE (
    GRADE INT,
    LOSAL DECIMAL(10,2),
    HISAL DECIMAL(10,2)
);

INSERT INTO SALGRADE VALUES (1, 700, 1200);
INSERT INTO SALGRADE VALUES (2, 1201, 1400);
INSERT INTO SALGRADE VALUES (3, 1401, 2000);
INSERT INTO SALGRADE VALUES (4, 2001, 3000);
INSERT INTO SALGRADE VALUES (5, 3001, 9999);

COMMIT;