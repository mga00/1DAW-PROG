#!/bin/bash

sudo mariadb << __END__
CREATE DATABASE testdb;
__END__

sudo mariadb << __END__
CREATE USER test@'localhost' IDENTIFIED BY 'changeme';
__END__

sudo mariadb << __END__
GRANT ALL PRIVILEGES ON testdb.* TO 'test'@'localhost' IDENTIFIED BY 'changeme';
flush privileges;
__END__