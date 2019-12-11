create table member_info(
	member_id varchar2(15),
	member_pw varchar2(65),
	member_name varchar2(15),
	member_birth varchar2(15),
	member_gender varchar2(6),
	member_email varchar2(30),
	member_addr varchar2(30),
	member_genre varchar2(10),
	PRIMARY KEY (member_id)
);

create table movie(
	movie_num number,
	movie_poster varchar2(100),
	movie_subject varchar2(50),
	movie_start varchar2(15),
	movie_end	varchar2(15),
	PRIMARY KEY (movie_num)
);

create table board(
	board_num number,
	board_id varchar2(20),
	board_subject varchar2(50),
	board_content varchar2(2000),
	board_re_ref number,
	board_re_lev number,
	board_re_seq number,
	board_readcount number,
	board_date date,
	board_category varchar2(10),
	PRIMARY KEY (board_num)
);

insert into board values(2, 'dd','dd', 'dd',0,0,0,0,sysdate,'dd');
alter table memberboard
add constraint pk_board_id foreign key(board_id)
references member2(member_id);

select * from member_info;
select * from movie;
select * from board; 

drop table member_info purge;
drop table movie purge;
drop table board purge;

delete from member_info;
delete from movie;
delete from board;

