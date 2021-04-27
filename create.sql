create sequence hibernate_sequence start with 1 increment by 1
create table event_history (id bigint not null, event_description varchar(255) not null, time timestamp not null, time_create timestamp not null, event_type_id bigint not null, vehicle_id bigint not null, primary key (id))
create table event_type (id bigint not null, name varchar(255), primary key (id))
create table vehicle (id bigint not null, veh_name varchar(255), primary key (id))
create table properties (id bigint not null, prop_name varchar(255), prop_type varchar(255), primary key (id))
create table vehicle_property (vehicle_id bigint not null, properties_id bigint not null)
alter table event_history add constraint FKnhdoo0alasjougwn1b04c8r1g foreign key (event_type_id) references event_type
alter table event_history add constraint FK25v4xb481kdsbe4qbetrmr69f foreign key (vehicle_id) references vehicle
create sequence hibernate_sequence start with 1 increment by 1
create table event_history (id bigint not null, event_description varchar(255) not null, time timestamp not null, time_create timestamp not null, event_type_id bigint not null, vehicle_id bigint not null, primary key (id))
create table event_type (id bigint not null, name varchar(255), primary key (id))
create table vehicle (id bigint not null, veh_name varchar(255), primary key (id))
alter table event_history add constraint FKnhdoo0alasjougwn1b04c8r1g foreign key (event_type_id) references event_type
alter table event_history add constraint FK25v4xb481kdsbe4qbetrmr69f foreign key (vehicle_id) references vehicle
alter table vehicle_property add constraint FK1xxiee7d724iuq8tiry8pplbr foreign key (properties_id) references vehicle
alter table vehicle_property add constraint FKjngbaadapqx4ipnpi3e8i5enm foreign key (vehicle_id) references properties