-- auto-generated definition
create table price
(
    id       serial           not null
        constraint price_pk
            primary key,
    goods_id integer          not null
        constraint price_goods_id_fk
            references goods,
    date     timestamp        not null,
    price    double precision not null
);

alter table price
    owner to postgres;

create unique index price_id_uindex
    on price (id);

