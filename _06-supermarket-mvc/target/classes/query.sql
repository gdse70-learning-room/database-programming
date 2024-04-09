drop database if exists kade;
create database if not exists kade;

use kade;

create table customers(
                         id varchar(35) primary key ,
                         name varchar(155) not null,
                         address text not null,
                         tel varchar(15) not null
);

create table orders(
                       order_id varchar(35) primary key,
                       cus_id varchar(35) not null,
                       date date not null,
                       constraint foreign key (cus_id) references customers(id)
                           on delete cascade on update cascade
);

create table items(
                     code varchar(35) primary key ,
                     description text not null ,
                     unit_price double not null,
                     qty_on_hand int not null
);

create table order_detail(
                             order_id varchar(35) not null ,
                             item_code varchar(50) not null,
                             qty int not null,
                             unit_price double not null,
                             constraint foreign key (order_id) references orders(order_id)
                                 on delete  cascade on update cascade,
                             constraint foreign key (item_code) references items(code)
                                 on delete cascade on update cascade
);

INSERT INTO customers VALUES ('C001', 'Gunapala', 'Galle', '078656565');

INSERT INTO orders VALUES ('O1', 'C001', '2024-04-19');
INSERT INTO orders VALUES ('O2', 'C001', '2024-04-20');

SELECT * FROM orders;

# Insert 10 items
INSERT INTO items (code, description, unit_price, qty_on_hand)
VALUES
    ('I001', 'Apple', 1.99, 100),
    ('I002', 'Banana', 0.49, 150),
    ('I003', 'Milk (1L)', 2.99, 80),
    ('I004', 'Bread', 2.49, 120),
    ('I005', 'Eggs (dozen)', 3.99, 50),
    ('I006', 'Potatoes (1kg)', 1.79, 70),
    ('I007', 'Chicken Breast (1kg)', 6.99, 40),
    ('I008', 'Rice (1kg)', 2.29, 90),
    ('I009', 'Pasta (500g)', 1.49, 60),
    ('I010', 'Tomato', 0.79, 110);
