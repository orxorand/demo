create table message
(
    message_id serial
        constraint message_pk
            primary key,
    code       varchar(100)  not null,
    region     varchar(5)    not null,
    msg_value  varchar(1000) not null
);

alter table message
    owner to postgres;

create unique index message_message_id_uindex
    on message (message_id);

create unique index "message_name-region_index"
    on message (code, region);
