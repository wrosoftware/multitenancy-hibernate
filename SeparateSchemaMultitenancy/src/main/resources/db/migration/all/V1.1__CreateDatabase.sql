CREATE TABLE address
(
    id bigint NOT NULL,
    city character varying(255) COLLATE pg_catalog."default",
    country character varying(255) COLLATE pg_catalog."default",
    flat_no character varying(255) COLLATE pg_catalog."default",
    house_no character varying(255) COLLATE pg_catalog."default",
    street character varying(255) COLLATE pg_catalog."default",
    zip_code character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT address_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE address
    OWNER to postgres;
    
CREATE TABLE customer
(
    id bigint NOT NULL,
    login character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    password character varying(255) COLLATE pg_catalog."default",
    surname character varying(255) COLLATE pg_catalog."default",
    address_id bigint,
    CONSTRAINT customer_pkey PRIMARY KEY (id),
    CONSTRAINT fkglkhkmh2vyn790ijs6hiqqpi FOREIGN KEY (address_id)
        REFERENCES address (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE customer
    OWNER to postgres;

CREATE TABLE warehouse
(
    id bigint NOT NULL,
    amount numeric(19,2),
    CONSTRAINT warehouse_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE warehouse
    OWNER to postgres;
    

    
CREATE TABLE product
(
    id bigint NOT NULL,
    description character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    price numeric(19,2),
    warehouse_id bigint,
    CONSTRAINT product_pkey PRIMARY KEY (id),
    CONSTRAINT fkk6edvfdkq61mjhltx856ncs3x FOREIGN KEY (warehouse_id)
        REFERENCES warehouse (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE product
    OWNER to postgres;
    
CREATE TABLE sale
(
    id bigint NOT NULL,
    customer_id bigint,
    CONSTRAINT sale_pkey PRIMARY KEY (id),
    CONSTRAINT fkjw88ojfoqquyd9f1obip1ar0g FOREIGN KEY (customer_id)
        REFERENCES customer (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE sale
    OWNER to postgres;
    
CREATE TABLE sale_product
(
    sale_id bigint NOT NULL,
    product_id bigint NOT NULL,
    CONSTRAINT fk4dtibi1vwxkx8gjs59nhp0cnq FOREIGN KEY (sale_id)
        REFERENCES sale (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkrtwiisrmdqeslt86pacdwwn1o FOREIGN KEY (product_id)
        REFERENCES product (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE sale_product
    OWNER to postgres;
    
