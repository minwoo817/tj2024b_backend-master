-- 한줄주석
# 한줄주석
/*여러줄 주석*/
-- 실행할 명령어에 커서를 두고 CTRL + ENTER
show databases;
show variables like 'datadir';
create database mydb1230;
drop database mydb1230;
drop database if exists mydb1230;
use mydb1230;

# [1] 테이블 생성한다. create table 테이블명(필드명 타입);
create table testtable1( 필드명 int );
# [2] 현재 활성화(사용)중인 DB내 모든 테이블 조회
show tables;
# [3] 테이블 생성한다. create table 테이블명(필드명 타입, 필드명 타입);
# 여러개 필드가 존재할 경우 , (쉼표) 구분한다.
create table testtable2( 필드명1 int , 필드명2 double);
# [4] 테이블 삭제한다. drop table 테이블명;
drop table testtable1;
drop table if exists testtable2;

create table testtable3( # 테이블 생성 시작 # 주의할점 : DB 사용 활성화가 된 상태에서 가능 , use ~~ 실행 확인
	정수필드1 tinyint, 정수필드2 smallint, 정수필드3 mediumint, 정수필드4 int, 정수필드5 bigint,
    실수필드1 float, 실수필드2 double, 
    날짜필드1 date, 날짜필드2 time, 날짜필드3 datetime,
    문자필드1 char(100), 문자필드2 varchar(100), 문자필드3 text, 문자필드4 longtext,
    논리필드1 bool	# 마지막 필드 뒤에는 ,(쉼표) 넣지 않는다.
);
# 테이블 생성 끝
show tables;
# [6] 특정한 테이블 조회
select * from testtable3;
# 실습 : boardservice의 DB 설계 하시오.
# 1단계 : DB서버의 DB만들기
create database boardservice9;
# 2단계 : 지정한 DB의 테이블 만들기 위해서 DB 활성화
use boardservice9;
# 3단계 : 지정한 DB의 테이블 생성하기.
create table board(
	title varchar(100),		# 임의로 제목은 최대한 100글자로 설계		# 자바 : private String title;
    content longtext,		# 임의로 내용은 긴글과 사진도 넣기 위해 설계 # 자바 : private String content;
    writer varchar(30)		# 임의로 작성자는 최대 30글자로 설계		# 자바 : private String writer;
);
show tables;
# 실습2 : day09 패키지의 Waiting SErvice의 DB 설계하시오.
create database waitingservice; 	# 1단계 : DB서버의 DB만들기
use waitingservice;					# 2단계 : DB서버의 사용할 DB 활성화하기
create table waiting(				# 3단계 : 활성화 한 DB내 테이블을 적당한 타입으로 선언한다.
	phone char(13),		# 임의로 핸드폰번호는 13자리로 고정해서 사용하겠다는 설계 	# String phone;
    count int				# 임의로 인원수는 int 타입으로 설계				# int count;
);
show tables;

# [7] 제약조건 : 테이블에서 문제/결함되는 데이터가 입력되지 않도록 제약
use mydb1230;
create table testtable4(
	# 필드명 타입 제약조건
    필드명1 tinyint not null, 	-- 지정한 필드에는 null을 대입할 수 없다.
    필드명2 smallint unique,		-- 지정한 필드에는 중복값을 대입할 수 없다.
	필드명3 int default 10,		-- 지정한 필드에는 레코드삽입 시 값을 생략하면 자동으로 기본값 대입
    필드명4 bigint auto_increment, -- 지정한 필드에는 레코드 삽입시 순서대로 자동번호 대입
    PK필드명5 double, 
    constraint primary key(PK필드명5)	 -- 지정한 필드를 pk 필드로 설정(not null과 unique 포함)    
);
create table testtable5(
	FK필드명1 double,
    constraint foreign key(FK필드명1) references testtable4(PK필드명5)
    -- 지정한 필드를 FK 필드로 설정하고 참조할 PK필드가 위치한 테이블명과 PK필드명을 작성한다.
);
# 실습1 : boardservice7에서 회원제 게시판 DB 설계하시오.
	# 회원테이블, 게시판테이블 => 회원이 존재해야 게시물이 존재한다. 즉] 회원(PK) 게시물(FK)
create database boardservice7;
use boardservice7;
# 회원 테이블
create table member(
	mno int auto_increment , 	
    -- 회원번호는 자동번호 부여하기 위해 auto_increment 제약조건 선택
    -- 회원번호는 최대 20억 이상이 될 경우가 없을것 같아서 int 타입 선택
    mid varchar(30) not null unique,
    -- 회원아이디는 공백이라는 아이디가 존재하면 안되서 not null 제약조건 선택
    -- 회원아이디는 중복을 차단해야 하므로 unique 제약조건 선택
    mpw varchar(30) not null,
    -- 회원 비밀번호는 공백을 차단하기 위해 not null 제약조건 선택
    mname varchar(10) not null,
	-- 회원명은 공백을 차단하기 위해 not null 제약조건 선택, / 회원명은 최대 10글자까지 입력받기 위해 varchar(10)으로 선택
    constraint primary key(mno) 	-- 회원번호를 pk필드로 선정, not null과 unique 포함
);
# 게시판 테이블
create table board(
	bno bigint auto_increment, 
    -- 게시물번호는 자동번호를 부여하기위해 auto_increment 사용, 20억 이상 게시물 번호 표현하기 위해 bigint 사용
    btitle varchar(100) not null,
    -- 게시물제목은 공백을 없애기 위해 not null 사용, 문자가 최대 100글자까지 가능하도록 사용
    bcontent text, 
    -- 게시물 내용은 공백을 허용하고 최대 4GB까지 대용량 입력 가능하도록 사용
    bdate datetime default now(),
    -- 게시물작성일에는 default 기본값에 now() 함수를 사용하면 자동으로 시스템 날짜/시간이 삽입
    bview int default 0,
    -- 게시물조회수에는 기본값을 0으로 한다.
    constraint primary key(bno), # 게시물번호를 PK 필드로 지정
    mno int, # FK 필드/ 회원번호 FK
    constraint foreign key(mno) references member(mno) -- board테이블의 mno필드가 member테이블의 mno필드를 참조
);	
create database kiosk;
use kiosk;
create table customer(
	cno int auto_increment, -- 주문번호는 자동번호를 부여
    cdate datetime default now(), -- 주문 날짜는 자동으로 시스템 날짜/시간 삽입
    constraint primary key(cno) -- 주문번호 PK 지정
);
create table category(
	cgno int not null unique, -- 카테고리번호는 not null 제약조건, 중복이 없어야되므로 unique 제약조건 선택
    cgname varchar(30) not null, -- 카테고리이름은 not null 제약조건 선택
    constraint primary key(cgno) -- 카테고리번호 PK 지정
);
create table product(
	pno int not null unique, -- 제품번호는 not null 제약조건 , 중복이 없어야되므로 unique 제약조건 선택
    pname varchar(30) not null, -- 제품이름은 not null 제약조건 선택
    pprice int not null, -- 제품가격은 not null 제약조건 선택
    pqul int default 0, -- 제품 수량의 기본값은 0
    constraint primary key(pno), -- 제품번호 PK 지정
    cgno int, -- category번호 FK
    constraint foreign key(cgno) references category(cgno) -- product 테이블의 cgno필드가 category 테이블의 cgno필드 참조
);