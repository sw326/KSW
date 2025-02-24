# ADDRESS
```sql
DROP TABLE IF EXISTS ADDRESS;

create table ADDRESS(
   SEQ int AUTO_INCREMENT PRIMARY KEY, 
   NAME varchar(10), 
   ADDR varchar(20), 
   RDATE datetime
);
insert into ADDRESS(NAME, ADDR, RDATE) values('홍길동', '서울시', now());
insert into ADDRESS(NAME, ADDR, RDATE) values('이순신', '부산시', now());
insert into ADDRESS(NAME, ADDR, RDATE) values('강감찬', '대전시', now());
insert into ADDRESS(NAME, ADDR, RDATE) values('유관순', '광주시', now());

select * from ADDRESS;
```


# BOARD
```sql
DROP TABLE IF EXISTS BOARD;

CREATE TABLE BOARD (
   SEQ INT AUTO_INCREMENT PRIMARY KEY, 
   WRITER VARCHAR(15), 
   EMAIL VARCHAR(20),
   SUBJECT VARCHAR(20), 
   CONTENT VARCHAR(20),
   
   RDATE DATETIME DEFAULT CURRENT_TIMESTAMP
); 

INSERT INTO BOARD (WRITER, EMAIL, SUBJECT, CONTENT)
VALUES ('김노은', 'kim@hanmail.net','제목1', '내용1'),
       ('김다예', 'lee@hanmail.net','제목2', '내용2'),
       ('김성우', 'han@hanmail.net','제목3', '내용3'),
       ('김희진', 'oh@hanmail.net','제목4', '내용4'),
       ('민성빈', 'chm@hanmail.net','제목5', '내용5'),
       ('신혜서', 'kim@hanmail.net','제목6', '내용6'),
       ('엄태정', 'lee@hanmail.net','제목7', '내용7'),
       ('이영주', 'han@hanmail.net','제목8', '내용8');


SELECT * FROM BOARD ORDER BY SEQ DESC;


--ALTER TABLE BOARD
--    ADD COLUMN FNAME VARCHAR(30) DEFAULT '' AFTER CONTENT,
--    ADD COLUMN OFNAME VARCHAR(30) DEFAULT '' AFTER FNAME;
```


## ADDRESS File
```sql
alter table ADDRESS 
add column FNAME varchar(30) default '' after ADDR, 
add column OFNAME varchar(30) default '' after FNAME, 
add column FSIZE int default 0 after OFNAME; 

alter table ADDRESS drop column FNAME; 
alter table ADDRESS drop column OFNAME; 
alter table ADDRESS drop column FSIZE;
```

## BOARD File
```sql
alter table BOARD 
add column FNAME varchar(30) default '' after CONTENT, 
add column OFNAME varchar(30) default '' after FNAME, 
add column FSIZE int default 0 after OFNAME; 

alter table BOARD drop column FNAME; 
alter table BOARD drop column OFNAME; 
alter table BOARD drop column FSIZE;
```


## FILE
```sql
-- create table FILE( 다수 파일 )
```