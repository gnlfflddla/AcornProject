drop table board;
create table board(
    num number(4) primary key,
    author varchar2(20),
    title varchar(50),
    content varchar2(100),
    writeday date default sysdate,
    readCnt number(4) default 0,
    repRoot number(4),
    repStep number(4),
    repIndent number(4)
);
drop sequence board_seq;
create sequence board_seq;
insert into board(num, author,title,content,repRoot,repStep,repIndent)
values(board_seq.nextval, '홍길동', '테스트','테스트입니다',board_seq.currval,0,0);
select * from board;

select * from member;

drop table board_comment;
create table board_comment(
    num number CONSTRAINT pk_bc_p1 PRIMARY KEY,
    rootnum number not null,
    repRoot number not null,
    author varchar(20),
    content varchar(100),
    writeday date DEFAULT sysdate,
    repStep number(4),
    repIndent number(4)
);
drop sequence comment_seq;
create sequence comment_seq;
commit;
select *
from board_comment;
select max(repStep)
from board_comment
where REPROOT='8';
commit;


-- 상품 등록 테이블
drop table product;
create table product(
 pcode varchar2(20) PRIMARY key,
 pName varchar2(20) not null,
 pimage varchar2(200) not null,
 pcontent varchar2(200) not null,
 pCategory varchar2(20) not null,
 pprice number not null 
 );
 
 -- 상품 색상, 사이즈 테이블 .. productinfo
drop table PRODUCTINFO;
CREATE TABLE PRODUCTINFO (	
PCODE VARCHAR2(20) NOT NULL, 
PCOLOR VARCHAR2(200) NOT NULL,
PSIZE VARCHAR2(20) NOT NULL,
PSTOCK NUMBER(5) NOT NULL,
CONSTRAINT PRODUCTINFO_FK1 FOREIGN KEY (PCODE)
REFERENCES PRODUCT(PCODE) ON DELETE CASCADE
);
 
 -- 장바구니 테이블
drop table productcart;
  create table productcart
  (  num NUMBER(6) PRIMARY KEY,
     userid VARCHAR2(10),
     pCode varchar2(20) not null,
     pName varchar2(50) not null,
     pPrice NUMBER(6) not null,
     pSize varchar2(20) not null,
     pColor VARCHAR2(10) not null,
     pAmount NUMBER(2) not null,
     pImage varchar2(20) not null
  );  

create sequence productcart_seq;


   --주문 테이블
   drop table OrderInfo;
  create table OrderInfo
  (  num NUMBER(6) PRIMARY KEY,
     userid VARCHAR2(10),
     pCode varchar2(20) not null,
     pName varchar2(50) not null,
     pPrice NUMBER(6) not null,
     pSize CHAR(1) not null,
     pColor VARCHAR2(10) not null,
     pAmount NUMBER(2) not null,
     pImage varchar2(20) not null,
     orderName VARCHAR2(10) NOT NULL,
     post VARCHAR2(5) NOT NULL,
     addr1 VARCHAR2(500) NOT NULL,
     addr2 VARCHAR2(500) NOT NULL,
     addr3 VARCHAR2(500) NOT NULL,
     phone VARCHAR2(11) NOT NULL,
     payMethod VARCHAR2(10) NOT NULL,
     orderDay DATE  DEFAULT SYSDATE
  );   
--  alter table orderInfo
--  add CONSTRAINT orderInfo_userid_fk FOREIGN KEY(userid)
--   REFERENCES member(userid) ON DELETE CASCADE;
     
  alter table OrderInfo
  add CONSTRAINT product_pCode_fk FOREIGN KEY(pCode)
   REFERENCES product(pCode) ON DELETE CASCADE; 
   drop sequence OrderInfo_seq;
   create sequence OrderInfo_seq;
   select OrderInfo_seq.nextval from dual;
drop function orderseq;
create function orderseq
return number
is 
begin
 return OrderInfo_seq.nextval;
end;
/


 create sequence cart_seq;
    
     create table orderInfo
  (  num NUMBER(6) PRIMARY KEY,
     userid VARCHAR2(10),
     gCode varchar2(20) not null,
     gName varchar2(50) not null,
     gPrice NUMBER(6) not null,
     gSize CHAR(1) not null,
     gColor VARCHAR2(10) not null,
     gAmount NUMBER(2) not null,
     gImage varchar2(20) not null,
     orderName VARCHAR2(10) NOT NULL,
     post VARCHAR2(5) NOT NULL,
     addr1 VARCHAR2(500) NOT NULL,
     addr2 VARCHAR2(500) NOT NULL,
     phone VARCHAR2(11) NOT NULL,
     payMethod VARCHAR2(10) NOT NULL,
     orderDay DATE  DEFAULT SYSDATE
  );   
  alter table orderInfo
  add CONSTRAINT orderInfo_userid_fk FOREIGN KEY(userid)
   REFERENCES member(userid) ON DELETE CASCADE;
   
   
     CREATE TABLE MEMBER
   (	USERID VARCHAR2(10) NOT NULL ENABLE, 
	PASSWD VARCHAR2(20) NOT NULL ENABLE, 
	USERNAME VARCHAR2(10) NOT NULL ENABLE, 
	POST VARCHAR2(10) NOT NULL ENABLE, 
	ADDR1 VARCHAR2(100) NOT NULL ENABLE, 
	ADDR2 VARCHAR2(100) NOT NULL ENABLE, 
	PHONE1 NUMBER(3) NOT NULL ENABLE, 
	PHOEN2 NUMBER(4) NOT NULL ENABLE, 
	PHONE3 NUMBER(4) NOT NULL ENABLE, 
	EMAIL1 VARCHAR2(20) NOT NULL ENABLE, 
	EMAIL2 VARCHAR2(20) NOT NULL ENABLE, 
	GRADENO VARCHAR2(10) NOT NULL ENABLE, 
	RECEPTION CHAR(2 BYTE) DEFAULT 'N', 
	CONSTRAINT "MEMBER_PK" PRIMARY KEY ("USERID")
 );
 


  CREATE TABLE U_GRADE
   (	GRADENO VARCHAR2(2) NOT NULL ENABLE, 
	GIMAGE VARCHAR2(20) NOT NULL ENABLE, 
	GNAME VARCHAR2(20) NOT NULL ENABLE, 
	CONSTRAINT "U_GRADE_PK" PRIMARY KEY ("GRADENO")
  );
 

