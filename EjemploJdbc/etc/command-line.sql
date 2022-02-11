CREATE DATABASE testdb;
GRANT ALL PRIVILEGES ON testdb.* TO 'user'@'localhost' IDENTIFIED BY 'changeme';
flush privileges;
use testdb;
CREATE TABLE prueba_tb (
     id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
     nombre VARCHAR(30) NOT NULL,
     email VARCHAR(50) NOT NULL );
     
insert into prueba_tb (nombre,email) values ("Ernesto Mate","no@tengo.email.com");
insert into prueba_tb (nombre,email) values ("Aitor Tilla","no@tengo.email.com");
insert into prueba_tb (nombre,email) values ("Jesus Todemuerte","no@tengo.email.com");
