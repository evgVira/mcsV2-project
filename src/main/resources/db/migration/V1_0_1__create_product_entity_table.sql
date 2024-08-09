create table if not exists product_sc.product
(
    product_id serial primary key,
    product_name varchar not null,
    product_description text not null,
    created_dt timestamp not null,
    updated_dt timestamp not null
);