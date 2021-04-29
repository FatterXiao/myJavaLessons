--创建数据库
CREATE DATABASE bookstore;

--创建users表
CREATE TABLE users(
id INT PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(100) UNIQUE,
PASSWORD VARCHAR(100) NOT NULL,
email VARCHAR(100)
)

--创建books表
CREATE TABLE books(
id INT PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(100) NOT NULL,
author VARCHAR(100) NOT NULL,
price DOUBLE(11,2) NOT NULL,
sales INT NOT NULL,
stock INT NOT NULL,
img_path VARCHAR(100)
)

--创建orders表
create table orders(
    id varchar(100) primary key,
    order_time datetime not null ,
    total_count int not null,
    total_amount double(11,2) not null,
    state int not null,
    user_id int not null,
    foreign key(user_id) references users(id)
)

--创建order_items表
create table order_items(
    id int primary key auto_increment,
    count int not null,
    amount double(11,2) not null,
    title varchar(100) not null,
    author varchar(100) not null,
    price double(11,2) not null ,
    img_path varchar(100) not null,
    order_id varchar(100) not null,
    foreign key(order_id) references orders(id)
)