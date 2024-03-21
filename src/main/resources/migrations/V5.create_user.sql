-- DDL statement

CREATE TABLE IF NOT EXISTS user_types(
id serial not null PRIMARY KEY,
name varchar(30) not null,
description varchar(50) not null,
status varchar(15) not null,
created_at timestamp not null,
updated_at timestamp not null,
deleted_at timestamp
)

CREATE TABLE IF NOT EXISTS users(
id serial not null PRIMARY KEY,
email varchar(50) not null unique,
password varchar(250) not null,
user_type_id integer REFERENCES user_types (id),
first_name varchar(100) not null,
last_name varchar(100) not null,
profile_image_url varchar(350),
status varchar(15) not null,
created_at timestamp not null,
updated_at timestamp not null,
deleted_at timestamp
);