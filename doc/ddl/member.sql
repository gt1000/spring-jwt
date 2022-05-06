drop table if exists member;

create table member (
    member_id               bigint          not null                        comment '사용자 id',
    name                    varchar(20)                                     comment '사용자 이름',
    password                varchar(255)                                    comment '비밀번호',
    roles                   varchar(100)                                    comment 'Role 목록',
    modified_date           datetime(6) default current_timestamp on update current_timestamp comment '수정 시간',
    created_date            datetime(6) default current_timestamp comment '등록 시간',
    primary key (member_id)
) engine=InnoDB;
alter table member comment = '사용자 정보';
