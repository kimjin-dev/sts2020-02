create table emp(
sabun int primary key AUTO_INCREMENT ,
 name varchar(10),
title varchar(10) ,
nalja date ,
pay int 
);
insert into emp (name,title,nalja,pay) values ('tester','test1',now(),1000);
insert into emp (name,title,nalja,pay) values ('tester','test2',now(),1000);
insert into emp (name,title,nalja,pay) values ('tester','test3',now(),1000);
insert into emp (name,title,nalja,pay) values ('tester','test4',now(),1000);
commit;
select * from emp;