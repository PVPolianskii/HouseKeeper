-- auto-generated definition
create table goods
(
    id   serial       not null
        constraint goods_pk
            primary key,
    name varchar(255) not null,
    note varchar(255)
);

alter table goods
    owner to postgres;

create unique index goods_id_uindex
    on goods (id);

create unique index goods_name_uindex
    on goods (name);

