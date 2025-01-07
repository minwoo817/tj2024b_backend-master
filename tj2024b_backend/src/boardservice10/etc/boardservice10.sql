# 프로적트 : boardservice10 DML과 샘플 INSERT
# 1. DB 구성한다.
drop database if exists boardservice10;
create database boardservice10;
use boardservice10;

# 2. 테이블 생성, PK 테이블 먼저 생성한다. 적절하게 타입과 제약조건을 고려한다.
create table member(
	mno int unsigned auto_increment,
    mid varchar(30) not null unique,
    mpwd varchar(30) not null,
    mname varchar(5) not null,
    mphone char(13) not null unique,
    mdate datetime default now(),
	constraint primary key(mno)
);
insert into member(mid, mpwd, mname, mphone) values('qwe123', 'a123456', '유재석', '010-3333-3333');
insert into member(mid, mpwd, mname, mphone) values('asd123', 'b123456', '강호동', '010-4444-4444');
insert into member(mid, mpwd, mname, mphone) values('zxc123', 'c123456', '신동엽', '010-5555-5555');
insert into member(mid, mpwd, mname, mphone) values('rty123', 'd123456', '서장훈', '010-6666-6666');
insert into member(mid, mpwd, mname, mphone) values('fgh123', 'e123456', '하하', '010-7777-7777');

# [2] 카테고리 테이블 생성
create table category(
	cno int unsigned auto_increment,
    cname varchar(20) not null unique,
    cdate datetime default now(),
    constraint primary key(cno)
);
# [2] 카테고리 샘플 레코드 삽입
insert into category(cname) values('자유');
insert into category(cname) values('질문');
insert into category(cname) values('노하우');
insert into category(cname) values('공부');
insert into category(cname) values('친목');

# [3] 보드 테이블 생성
create table board(
	bno int unsigned auto_increment,
    btitle varchar(30) not null,
    bcontent varchar(100) not null,
    bview int unsigned default 0,
    bdate datetime default now(),
    constraint primary key(bno),
    mno int unsigned,
    constraint foreign key(mno) references member(mno) on update cascade on delete cascade,
    cno int unsigned,
    constraint foreign key(cno) references category(cno) on update cascade on delete cascade
);
# [3] 보드 샘플 레코드 삽입
insert into board(btitle, bcontent, mno, cno) values('안녕하세요1', '힘찬 자바1', 1, 1);
insert into board(btitle, bcontent, mno, cno) values('안녕하세요2', '힘찬 자바2', 1, 3);
insert into board(btitle, bcontent, mno, cno) values('안녕하세요3', '힘찬 자바3', 4, 3);
insert into board(btitle, bcontent, mno, cno) values('안녕하세요4', '힘찬 자바4', 2, 5);
insert into board(btitle, bcontent, mno, cno) values('안녕하세요5', '힘찬 자바5', 3, 2);

create table reply(
	rno int unsigned auto_increment,
    rcontent varchar(100) not null,
    rdate datetime default now(),
	constraint primary key(rno),	
    mno int unsigned,
    constraint foreign key(mno) references member(mno) on update cascade on delete cascade,
    bno int unsigned,
    constraint foreign key(bno) references board(bno) on update cascade on delete cascade
);
,insert into reply(rcontent, mno, bno) values('하하하 댓글2', 3, 3);
insert into reply(rcontent, mno, bno) values('하하하 댓글3', 4, 5);
insert into reply(rcontent, mno, bno) values('하하하 댓글4', 5, 5);
insert into reply(rcontent, mno, bno) values('하하하 댓글5', 1, 4);

