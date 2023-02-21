create table feb21_snack(
	s_no number(3) primary key,
	s_name varchar2(10 char) not null,
	s_price number(5) not null
);

drop table feb21_snack cascade constraint purge;

create sequence feb21_snack_seq;
drop sequence feb21_snack_seq;

-- C
insert into feb21_snack values(feb21_snack_seq.nextval, '테스트', 1000);

-- R
select * from feb21_snack;

-- U
update feb21_snack set s_price = s_price * 0.5 where s_name = '테스트';

-- D
delete from feb21_snack where s_name = '테스트';
