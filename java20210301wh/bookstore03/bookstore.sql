--创建数据库
CREATE DATABASE bookstore;

--创建users表
CREATE TABLE users(
id INT PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(100) UNIQUE,
PASSWORD VARCHAR(100) NOT NULL,
email VARCHAR(100)
)