-- member(회원) table
create table member(
    num int primary key auto_increment,
    id varchar(20) not null ,
    pass varchar(20) not null,
    name varchar(30) not null ,
    age int not null,
    email varchar(30) not null ,
    phone varchar(30) not null,
                   unique key (id)
);

-- SQL (CRUD), JDBC
select * from member;

-- insert(저장)
insert into member(id,pass,name,age,email,phone)
values ('admin','admin','관리자',28,'6k2hbc@gamil.com',010-9459-4254);

-- update(수정)
update member set age=45,phone='010-9965-5691' where id='admin';

-- delete(삭제)
delete from member where id='admin';


