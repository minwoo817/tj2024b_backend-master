drop database if exists studentservice;
create database studentservice;
use studentservice;
create table student(
sno int auto_increment,
sname varchar(10) not null,
kscore int not null,
escore int not null,
mscore int not null,
constraint primary key(sno)
);
insert into student(sname, kscore, escore, mscore) values('장민우', 100, 100, 100);
insert into student(sname, kscore, escore, mscore) values('유재석', 70, 60, 50);
insert into student(sname, kscore, escore, mscore) values('강호동', 75, 84, 90);
insert into student(sname, kscore, escore, mscore) values('신동엽', 54, 96, 76);