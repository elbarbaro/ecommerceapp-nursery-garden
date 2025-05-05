CREATE TABLE IF NOT EXISTS product_images (
    id serial not null PRIMARY KEY,
    product_id integer REFERENCES products (id),
    image_url varchar(350),
    status varchar(15) not null,
    created_at timestamp not null,
    updated_at timestamp not null,
    deleted_at timestamp
);