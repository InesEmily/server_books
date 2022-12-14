create table Shop
(
    id   integer      not null AUTO_INCREMENT,
    name varchar(255) not null,
    primary key (id)
);
insert into Shop (name) values ('Amazon');
insert into Shop (name) values ('Barnes & Noble');