--DDL statement
ALTER TABLE product_images
ALTER COLUMN image_url SET DEFAULT '',
ALTER COLUMN image_url SET NOT NULL;