#!/bin/bash

sudo mariadb << __END__
CREATE DATABASE testdb;
GRANT ALL PRIVILEGES ON testdb.* TO 'lantolin'@'localhost' IDENTIFIED BY 'changeme';
flush privileges;
__END__