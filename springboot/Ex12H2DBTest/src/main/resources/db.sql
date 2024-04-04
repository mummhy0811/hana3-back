-- 회원가입 DB 만들기

-- H2 Database SQL

-- 테이블 삭제
Drop table if exists member;

--테이블 생성
create table member(
    id bigint primary key,
    user_id varchar(255),
    user_pw varchar(255),
    user_name varchar(255),
    user_role varchar(255),
    joindate date default CURRENT_TIMESTAMP()
);

-- Row
insert into member( id, user_id, user_pw, user_name, user_role, joindate ) values ( 1, 'hong', '1234', '홍길동', 'ROLE_USER', '2022-09-09');
insert into member( id, user_id, user_pw, user_name, user_role, joindate ) values ( 2, 'tom', '1234', '톰아저씨', 'ROLE_USER', '2022-09-09');
insert into member( id, user_id, user_pw, user_name, user_role, joindate ) values ( 3, 'admin', '1234', '관리자', 'ROLE_ADMIN', '2022-09-09');

-- 검색
select * from member;

-- 커밋: 실제 물리적으로 파일에 작성
commit;

