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

-- 1. 전체 회원정보 다 가져와서 DAO에서 for문 + if문
-- 회원 많으면 조회가 매우 느림, DAO에서 뭔가 많이 해야함 <- 매우 비효율적 
select * from BPBASCP_MEMBER;

-- 보안코딩?
-- 해킹 기술중에 SQL injection
-- 빅데이터/인공지능/클라우드

-- 2. ID/PW에 해당하는 회원정보 가져오기
-- 회원수랑 무관, DAO에서 뭐 안 해도 됨 <- 괜찮아 보이는데 보안이 매우 취약함 SQL injection 때문에
select * from BPBASCP_MEMBER where bm_id='test' and bm_pw='1234';

-- 3. ID에 해당하는 회원정보 가져온다[PK라서 1개이거나 0개일 것]
-- 비밀번호는 DAO에서 검사하는 방식으로
select * from BPBASCP_MEMBER where bm_id='test';

delete from bpbascp_member where bm_id='asd';

drop table BPBASCP_MEMBER cascade constraint purge;