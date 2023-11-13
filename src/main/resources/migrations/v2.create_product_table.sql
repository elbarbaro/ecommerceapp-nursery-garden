--DDL statement
CREATE TABLE IF NOT EXISTS products (
    id serial not null PRIMARY KEY,
    name            varchar(100) not null,
    large_name      varchar(150),
    description     varchar(250),
    quantity        integer,
    price           numeric,
    color           varchar(15),
    category_id     integer,
    status       status_enum not null,
    created_at      timestamp not null,
    updated_at      timestamp not null,
    deleted_at      timestamp
);