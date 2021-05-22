create table if not exists vaccine(
    id int identity,
    manufacturer_name varchar(255) not null,
    research_name varchar(255) not null unique,
    number_of_shots number not null,
    available_doses number not null,
    type varchar(12) not null,
    primary key (id)
);

create table if not exists side_effect(
    id int identity,
    short_description varchar(50) not null,
    description varchar(255) not null,
    frequency number not null,
    vaccine int not null,
    primary key (id),
    constraint fk_vaccine foreign key (vaccine) references vaccine(id) on delete cascade
);

create table if not exists user(
    id       identity,
    username varchar(100) not null,
    password varchar(250) not null,
    first_name varchar(250) not null,
    last_name varchar(250) not null
);

create table if not exists authority(
    id   identity,
    name varchar(100) not null
);

create table if not exists user_authority(
    user_id      bigint not null,
    authority_id bigint not null,
    constraint fk_user foreign key (user_id) references user(id),
    constraint fk_authority foreign key (authority_id) references authority(id)
);