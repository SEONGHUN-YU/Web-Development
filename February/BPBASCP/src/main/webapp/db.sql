-- 글자(byte) char, varchar2
-- 숫자(byte) number
-- 시간/날짜(byte) date
-- 파일(MB~) : 용량이 압도적으로 큼
-- 파일을 DB서버쪽에 저장해놓으면
-- DB서버에서 -> WAS로, WAS에서 -> 사용자로 이게 시간이 엄청 걸릴 것
-- 파일을 WAS에 두는 게 이상적일 것, WAS에 있는 파일을 사용자가 다운받는 시간이 걸리는 건 어쩔 수 없음

-- 파일은 WAS에 저장
-- DB서버에는 파일명을 저장
create table bpbascp_member(
	bm_id varchar2(10 char) primary key,
	bm_pw varchar2(10 char) not null,
	bm_name varchar2(10 char) not null,
	bm_birthday date not null,				-- 날짜 얘기
	bm_photo varchar2(100 char) not null	-- 파일 얘기
);

insert into bpbascp_member
values('asd123', 'a1', '홍길동',
to_date('19991231', 'YYYYMMDD'), 'ball.png');

select * from BPBASCP_MEMBER;

drop table BPBASCP_MEMBER;