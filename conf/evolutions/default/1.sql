# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table my_todo (
  id                        bigint not null,
  commentaire               varchar(255),
  creation_date             timestamp,
  constraint pk_my_todo primary key (id))
;

create sequence my_todo_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists my_todo;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists my_todo_seq;

