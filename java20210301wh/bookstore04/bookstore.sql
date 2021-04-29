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