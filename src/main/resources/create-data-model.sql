CREATE TABLE warehouses (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    address VARCHAR(255) NOT NULL,
    UNIQUE UQ_ADDRESS_1 (address),
    PRIMARY KEY (id)
);

create table if not exists kryvorotenkos_shop
(
    id      serial primary key,
    address  varchar(255) not null
);

create table if not exists vitaliy_user
(
    id       serial primary key,
    created  varchar(255),
    status   varchar(255),
    name     varchar(255),
    email    varchar(255),
    password varchar(255)
);

CREATE TABLE items (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    warehouse_id INT UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (warehouse_id) REFERENCES warehouses (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE providers (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE items_providers (
    item_id INT UNSIGNED NOT NULL,
    provider_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (item_id) REFERENCES items (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (provider_id) REFERENCES providers (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

DROP TABLE IF EXISTS book;
CREATE TABLE IF NOT EXISTS book(
  id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  name VARCHAR(255) NOT NULL CHECK(name!=''),
  author VARCHAR(255) NOT NULL CHECK(author!=''),
  genre VARCHAR(255) NOT NULL CHECK(genre!='')
);

create table if not exists phoneShop
(
    id  INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    model  varchar(255) NOT NULL,
    price INT NOT NULL
);
