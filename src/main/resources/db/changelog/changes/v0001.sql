create table env (
  id bigserial not null,
  name varchar(50) not null,
  properties text,
  primary key (id)
);

create table service (
  id bigserial not null,
  name varchar(50) not null,
  env_id bigint not null references env (id),
  primary key (id)
);

create sequence if not exists ENV_ID_SEQ;
