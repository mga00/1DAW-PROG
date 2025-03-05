#!/bin/bash

docker exec -i DDBB sqlplus test/changeme@XEPDB1 << __END__ 
DROP TABLE PRUEBA_TB;
CREATE TABLE PRUEBA_TB (
NOMBRE VARCHAR2(30) NOT NULL,
EMAIL VARCHAR2(100) NOT NULL);
insert into prueba_tb values ('Ernesto Mate','no@tengo.email.com');
insert into prueba_tb values ('Aitor Tilla','tampoco@tengo.email.com');
insert into prueba_tb values ('Jesus Todemuerte','sin@email.com');
exit;
__END__
