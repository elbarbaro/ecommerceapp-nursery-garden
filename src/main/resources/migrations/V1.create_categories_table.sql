-- DDL statement
create table if not exists categories(
    id serial not null primary key,
    name varchar(100) not null,
    description varchar(250),
    created_at timestamp not null,
    updated_at timestamp not null,
    deleted_at timestamp
);