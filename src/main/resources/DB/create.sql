SET MODE PostgreSQL;

CREATE DATABASE news_portal;
\c news_portal;

CREATE TABLE IF NOT EXISTS employees (
 id int PRIMARY KEY auto_increment,
 employee VARCHAR,
 role VARCHAR,
 position VARCHAR,
 email VARCHAR,
 departmentId INTEGER
 );

 CREATE TABLE IF NOT EXISTS departments (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 description VARCHAR,
 number of employees INTEGER
 );

 CREATE TABLE IF NOT EXISTS news (
 id int PRIMARY KEY auto_increment,
 newsTitle VARCHAR,
 content VARCHAR,
 departmentId INTEGER
 );