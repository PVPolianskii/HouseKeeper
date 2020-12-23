-- auto-generated definition
create table store
(
    id          serial       not null,
    name        varchar(255) not null,
    location_id integer      not null
        constraint store_location_id_fk
            references location
);

alter table store
    owner to postgres;

create unique index store_id_uindex
    on store (id);

