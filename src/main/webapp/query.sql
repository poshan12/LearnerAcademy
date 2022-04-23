
drop table login;
create table login (
username varchar2(30),
password varchar2(30)
);

insert into login values('system','system');

drop table class;
create table class(
classid number,
className varchar2(50)
);
 insert into class values(classid.nextval , 'class1');
 insert into class values(classid.nextval , 'class2');


CREATE SEQUENCE classid
   start with 1
   increment by 1
   minvalue 1
   maxvalue 100
   cycle;
   
 drop table teacher;
 create table teacher(
 teacherid number,
 teacherName varchar2(50)
 );
 
 CREATE SEQUENCE teacherid
   start with 1
   increment by 1
   minvalue 1
   maxvalue 100
   cycle;
   
 insert into teacher values(teacherid.nextval,'Ramesh');
 insert into teacher values(teacherid.nextval,'Rahul');
 
   
  create table subject(
  subjectId number,
  subjectName varchar2(25),
  classid number
  );
  CREATE SEQUENCE subjectId
   start with 1
   increment by 1
   minvalue 1
   maxvalue 100
   cycle;
   
   insert into subject values(subjectid.nextval, 'Hindi',1);
   insert into subject values(subjectid.nextval, 'English',2);
   
   
 
 
 
 CREATE SEQUENCE studentId
   start with 1
   increment by 1
   minvalue 1
   maxvalue 100
   cycle;
 create table student(
 studentId number,
 studentName varchar2(30),
 classId number
 )
 insert into student values(studentid.nextval,'Poshan',1);
 insert into student values(studentid.nextval,'Bhagwat',2);
 
  CREATE SEQUENCE assignId
   start with 1
   increment by 1
   minvalue 1
   maxvalue 100
   cycle;
   drop table assignclass;
 create table assignclass(
 assignid number,
 className varchar2(30),
 subjectName varchar2(30),
 teacherName varchar2(30)
 );
 