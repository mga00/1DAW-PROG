#!/bin/bash

# sin variable (mySQL)

mvn exec:java -Dexec.mainClass="com.gsd.daw.prog.App"

# mySQL

SGBD=MYSQL mvn exec:java -Dexec.mainClass="com.gsd.daw.prog.App"

# ORACLE

SGBD=ORACLE mvn exec:java -Dexec.mainClass="com.gsd.daw.prog.App"

# postgresql
#
# SGBD=POSTGRESQL mvn exec:java -Dexec.mainClass="com.gsd.daw.prog.App"
