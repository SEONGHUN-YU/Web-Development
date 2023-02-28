create table feb28_coffee(
	c_name varchar2(10 char) primary key,
	c_price number(4) not null
);

insert into feb28_coffee values('2녹차라떼4', 5000);

select * from feb28_coffee;