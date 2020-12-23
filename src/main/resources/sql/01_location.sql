-- auto-generated definition
create table location
(
    id              serial       not null
        constraint location_pk
            primary key,
    name            varchar(255) not null,
    settlement_type varchar(255),
    settlement_name varchar(255) not null,
    street          varchar(255),
    building        varchar(255),
    housing         varchar(255),
    apartment       varchar(255)
);

alter table location
    owner to postgres;

create unique index location_id_uindex
    on location (id);

create unique index location_name_uindex
    on location (name);

