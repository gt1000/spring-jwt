drop sequence if exists member_seq;

create sequence member_seq start with 1 increment by 1 minvalue=1 maxvalue=999999999999 cache 1;
