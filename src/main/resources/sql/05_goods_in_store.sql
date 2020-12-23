-- auto-generated definition
create table goods_in_store
(
    id       serial  not null
        constraint goods_in_store_pk
            primary key,
    store_id integer not null
        constraint goods_in_store_store_id_fk
            references store (id),
    goods_id integer not null
        constraint goods_in_store_goods_id_fk
            references goods,
    quantity integer
);

alter table goods_in_store
    owner to postgres;

create unique index goods_in_store_id_uindex
    on goods_in_store (id);

