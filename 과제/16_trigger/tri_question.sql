drop table TR_MYHOME;
drop table TR_LOGIN;
drop table TR_MEMBER;
drop sequence TR_MYHOME_SEQ;
purge recyclebin;
-- 회원
create table TR_MEMBER(
    ID varchar2(10) constraint TR_MEMBER_PK primary key,
    PWD varchar2(10) constraint TR_MEMBER_PWD_NN not null,
    NAME varchar2(20) constraint TR_MEMBER_NAME_NN not null,
    EMAIL varchar2(20) constraint TR_MEMBER_UQ unique,
    RDATE date
);
-- 로그인
create table TR_LOGIN(
    ID varchar2(10),
    PWD varchar2(10),
    constraint TR_LOGIN_PK primary key(ID),
    constraint TR_LOGIN_FK foreign key(ID) references TR_MEMBER(ID) on delete cascade
);
-- 홈페이지
create table TR_MYHOME(
    SEQ number constraint TR_MYHOME_PK primary key,
    ID varchar2(10) constraint TR_MYHOME_ID_NN not null,
    HNAME varchar2(30) constraint TR_MYHOME_HNAME_NN not null,
    TOTCOUNT number default 0,
    HMSG varchar2(20),
    CDATE date,
    constraint TR_MYHOME_FK foreign key(ID) references TR_MEMBER(ID) on delete cascade
);
create sequence TR_MYHOME_SEQ start with 1 increment by 1 nocache;
select TNAME from tab;
select SEQUENCE_NAME from seq;
--select TR_MYHOME_SEQ.nextval from DUAL;
--Q1) trigger1:회원가입을 하면
     -- '로그인 테이블'에 ID/PWD입력,
     -- '홈페이지 테이블'에 시퀀스와 ID/HNAME에 입력되는 트리거
create or replace trigger TR_SIGNIN
after
    insert on TR_MEMBER
    for each row
begin
    insert into TR_LOGIN (ID, PWD) values (:new.ID, :new.PWD);
    insert into TR_MYHOME (SEQ, ID, HNAME) 
    values (TR_MYHOME_SEQ.NEXTVAL, :new.ID, :new.NAME || '님의 홈페이지');
end;
/

--Q2) trigger2:회원비번수정시.. 로긴 테이블의 PWD도 수정되는 트리거
create or replace trigger TR_UPDT_PWD
after
    update of PWD on TR_MEMBER
    for each row
begin
    update TR_LOGIN set PWD=:new.PWD where ID=:new.ID;
end;
/

-- 더미데이터 30개
INSERT INTO TR_MEMBER (ID, PWD, NAME, EMAIL, RDATE) VALUES ('user01', 'pass01', '홍길동', 'user01@example.com', SYSDATE - 30);
INSERT INTO TR_MEMBER (ID, PWD, NAME, EMAIL, RDATE) VALUES ('user02', 'pass02', '이몽룡', 'user02@example.com', SYSDATE - 29);
INSERT INTO TR_MEMBER (ID, PWD, NAME, EMAIL, RDATE) VALUES ('user03', 'pass03', '성춘향', 'user03@example.com', SYSDATE - 28);
INSERT INTO TR_MEMBER (ID, PWD, NAME, EMAIL, RDATE) VALUES ('user04', 'pass04', '변학도', 'user04@example.com', SYSDATE - 27);
INSERT INTO TR_MEMBER (ID, PWD, NAME, EMAIL, RDATE) VALUES ('user05', 'pass05', '최치원', 'user05@example.com', SYSDATE - 26);
INSERT INTO TR_MEMBER (ID, PWD, NAME, EMAIL, RDATE) VALUES ('user06', 'pass06', '황진이', 'user06@example.com', SYSDATE - 25);
INSERT INTO TR_MEMBER (ID, PWD, NAME, EMAIL, RDATE) VALUES ('user07', 'pass07', '장보고', 'user07@example.com', SYSDATE - 24);
INSERT INTO TR_MEMBER (ID, PWD, NAME, EMAIL, RDATE) VALUES ('user08', 'pass08', '이순신', 'user08@example.com', SYSDATE - 23);
INSERT INTO TR_MEMBER (ID, PWD, NAME, EMAIL, RDATE) VALUES ('user09', 'pass09', '김유신', 'user09@example.com', SYSDATE - 22);
INSERT INTO TR_MEMBER (ID, PWD, NAME, EMAIL, RDATE) VALUES ('user10', 'pass10', '강감찬', 'user10@example.com', SYSDATE - 21);
INSERT INTO TR_MEMBER (ID, PWD, NAME, EMAIL, RDATE) VALUES ('user11', 'pass11', '유관순', 'user11@example.com', SYSDATE - 20);
INSERT INTO TR_MEMBER (ID, PWD, NAME, EMAIL, RDATE) VALUES ('user12', 'pass12', '신사임당', 'user12@example.com', SYSDATE - 19);
INSERT INTO TR_MEMBER (ID, PWD, NAME, EMAIL, RDATE) VALUES ('user13', 'pass13', '안중근', 'user13@example.com', SYSDATE - 18);
INSERT INTO TR_MEMBER (ID, PWD, NAME, EMAIL, RDATE) VALUES ('user14', 'pass14', '유성룡', 'user14@example.com', SYSDATE - 17);
INSERT INTO TR_MEMBER (ID, PWD, NAME, EMAIL, RDATE) VALUES ('user15', 'pass15', '김홍도', 'user15@example.com', SYSDATE - 16);
INSERT INTO TR_MEMBER (ID, PWD, NAME, EMAIL, RDATE) VALUES ('user16', 'pass16', '정약용', 'user16@example.com', SYSDATE - 15);
INSERT INTO TR_MEMBER (ID, PWD, NAME, EMAIL, RDATE) VALUES ('user17', 'pass17', '홍범도', 'user17@example.com', SYSDATE - 14);
INSERT INTO TR_MEMBER (ID, PWD, NAME, EMAIL, RDATE) VALUES ('user18', 'pass18', '장영실', 'user18@example.com', SYSDATE - 13);
INSERT INTO TR_MEMBER (ID, PWD, NAME, EMAIL, RDATE) VALUES ('user19', 'pass19', '세종대왕', 'user19@example.com', SYSDATE - 12);
INSERT INTO TR_MEMBER (ID, PWD, NAME, EMAIL, RDATE) VALUES ('user20', 'pass20', '이황', 'user20@example.com', SYSDATE - 11);
INSERT INTO TR_MEMBER (ID, PWD, NAME, EMAIL, RDATE) VALUES ('user21', 'pass21', '이익', 'user21@example.com', SYSDATE - 10);
INSERT INTO TR_MEMBER (ID, PWD, NAME, EMAIL, RDATE) VALUES ('user22', 'pass22', '이이', 'user22@example.com', SYSDATE - 9);
INSERT INTO TR_MEMBER (ID, PWD, NAME, EMAIL, RDATE) VALUES ('user23', 'pass23', '박지원', 'user23@example.com', SYSDATE - 8);
INSERT INTO TR_MEMBER (ID, PWD, NAME, EMAIL, RDATE) VALUES ('user24', 'pass24', '최영', 'user24@example.com', SYSDATE - 7);
INSERT INTO TR_MEMBER (ID, PWD, NAME, EMAIL, RDATE) VALUES ('user25', 'pass25', '이성계', 'user25@example.com', SYSDATE - 6);
INSERT INTO TR_MEMBER (ID, PWD, NAME, EMAIL, RDATE) VALUES ('user26', 'pass26', '왕건', 'user26@example.com', SYSDATE - 5);
INSERT INTO TR_MEMBER (ID, PWD, NAME, EMAIL, RDATE) VALUES ('user27', 'pass27', '고려인', 'user27@example.com', SYSDATE - 4);
INSERT INTO TR_MEMBER (ID, PWD, NAME, EMAIL, RDATE) VALUES ('user28', 'pass28', '신라인', 'user28@example.com', SYSDATE - 3);
INSERT INTO TR_MEMBER (ID, PWD, NAME, EMAIL, RDATE) VALUES ('user29', 'pass29', '백제인', 'user29@example.com', SYSDATE - 2);
INSERT INTO TR_MEMBER (ID, PWD, NAME, EMAIL, RDATE) VALUES ('user30', 'pass30', '고구려인', 'user30@example.com', SYSDATE - 1);

update TR_MEMBER set PWD='PWD30' where ID='user30';
commit;

SELECT * FROM TR_MEMBER;
SELECT * FROM TR_LOGIN;
SELECT * FROM TR_MYHOME; 
