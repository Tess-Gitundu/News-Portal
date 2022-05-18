WildLife Warriors

A REST API for querying and retrieving scoped news and information. There are news that are available to all employees without navigating into any department, and others that are housed/classified within departments.

By Tess Gitundu

Setup/Installation Requirements
Make sure you have access to a working browser.
Click on the live link on the about section.
Git clone if necessary.
No dependencies required.
Install IntelliJ on your computer.
Install Gradle.
Install Postgres.
Install Maven.
Install Postman
Follow the link provided and fork then clone the git repository
Run the application on IntelliJ.
Test the routes on postman.
Have fun coding.
Known Bugs
There are no known bugs

Technologies Used
JAVA
Spark
jUnit
Gradle
Handlebars

DATABASE CREATION

CREATE DATABASE news_portal; \c news_portal;

CREATE TABLE users ( id SERIAL PRIMARY KEY, name VARCHAR, position VARCHAR, role VARCHAR, departmentid INT );

CREATE TABLE departments ( id SERIAL PRIMARY KEY, name VARCHAR );

CREATE TABLE posts ( id SERIAL PRIMARY KEY, userid INT, createdby VARCHAR, content VARCHAR, createdat BIGINT, type VARCHAR, departmentid INT );
Support and contact details
If you have any issues, questions, ideas, or concerns kindly feel free to contact me via; Email - njerigitundu003@gmail.com Phone Number - +254712477160

License
Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

Copyright (c) 2022 Tess Gitundu