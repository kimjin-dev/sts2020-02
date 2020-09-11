create table dept(
deptno number primary key,
dname varchar2(10),
loc varchar2(10) 
);
insert into dept values (10,'총무부','서울');
insert into dept values (20,'회계부','서울');
insert into dept values (30,'생산관리부','수원');
insert into dept values (40,'영업부','광명');
commit;
select * from dept;