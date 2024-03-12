CREATE DATABASE kade;

USE kade;

CREATE TABLE customers
(
    id      VARCHAR(35) PRIMARY KEY,
    name    VARCHAR(100),
    address TEXT,
    tel     VARCHAR(20)
);