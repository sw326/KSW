-- 1. createUser.sql
create user genius identified by 1234;
grant CONNECT, RESOURCE, UNLIMITED TABLESPACE to genius;
conn genius/1234
