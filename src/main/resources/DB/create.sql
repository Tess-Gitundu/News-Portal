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
 numberOfEmployees INTEGER
 );

 CREATE TABLE IF NOT EXISTS news (
 id int PRIMARY KEY auto_increment,
 newsTitle VARCHAR,
 content VARCHAR,
 employeeId INTEGER
 );

 CREATE TABLE IF NOT EXISTS departments_employees (
  id int PRIMARY KEY auto_increment,
  employeeId INTEGER,
  departmentId INTEGER
 );

CREATE DATABASE news_portal_test WITH TEMPLATE news_portal;