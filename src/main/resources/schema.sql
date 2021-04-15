drop table if exists event_history CASCADE;
drop table if exists event_type CASCADE;
drop table if exists vehicle CASCADE;
drop sequence if exists hibernate_sequence;


create sequence if not exists hibernate_sequence start with 1 increment by 1;

create table event_history
(
    id                bigint       not null  AUTO_INCREMENT,
    event_description varchar(255) not null,
    time              timestamp    not null,
    time_create       timestamp    not null,
    event_type_id     bigint       not null,
    vehicle_id        bigint       not null,
    primary key (id)
);

create table event_type
(
    id   bigint not null   AUTO_INCREMENT,
    name varchar(255),
    primary key (id)
);

create table vehicle
(
    id       bigint not null   AUTO_INCREMENT,
    veh_name varchar(255),
    primary key (id)
);

alter table event_history
    add constraint event_type_id_constraint foreign key (event_type_id) references event_type;
alter table event_history
    add constraint vehicle_id__constraint foreign key (vehicle_id) references vehicle;