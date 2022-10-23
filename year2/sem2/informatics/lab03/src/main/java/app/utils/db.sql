CREATE TABLE "user"
(
    id            integer PRIMARY KEY NOT NULL,
    username      varchar,
    salt          varchar,
    password_hash varchar,
    firstname     varchar,
    lastname      varchar,
    address       varchar,
    telephone     integer,
    created_at    timestamp
);

CREATE TABLE "product"
(
    id                  integer PRIMARY KEY NOT NULL,
    name                varchar,
    SKU                 varchar,
    category_id         integer,
    price               decimal,
    discount_percentage integer
);

CREATE TABLE "category"
(
    id   integer PRIMARY KEY NOT NULL,
    name varchar
);

CREATE TABLE "order_item"
(
    id         integer PRIMARY KEY NOT NULL,
    product_id integer,
    quantity   integer,
    created_at timestamp
);

CREATE TABLE "order_details"
(
    id                 integer PRIMARY KEY NOT NULL,
    order_item_id     integer,
    total              decimal,
    payment_details_id integer,
    created_at         timestamp
);

CREATE TABLE "order"
(
    id                integer PRIMARY KEY NOT NULL,
    user_id           integer,
    order_details_id integer
);

CREATE TABLE "payment_details"
(
    id       integer PRIMARY KEY NOT NULL,
    amount   integer,
    provider varchar
);

Alter Table "product"
    ADD CONSTRAINT fk_category
        FOREIGN KEY (category_id)
            REFERENCES category (id);

ALTER TABLE "order_item"
    ADD CONSTRAINT fk_product
        FOREIGN KEY (product_id)
            REFERENCES product (id);

ALTER TABLE "order_details"
    ADD CONSTRAINT fk_order_items
        FOREIGN KEY (order_item_id)
            REFERENCES order_item (id);

ALTER TABLE "order_details"
    ADD CONSTRAINT fk_payment_details
        FOREIGN KEY (payment_details_id)
            REFERENCES "payment_details" (id);

ALTER TABLE "order"
    ADD CONSTRAINT fk_user
        FOREIGN KEY (user_id)
            REFERENCES "user" (id);

ALTER TABLE "order"
    ADD CONSTRAINT fk_orders_details
        FOREIGN KEY (order_details_id)
            REFERENCES "order_details" (id);

