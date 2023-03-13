#!/bin/bash

# Las configuraciones e inicializaciones previas que son necesarias para
# que las siguientes instrucciones de ORACLE funcionen son parte de otra práctica
# No las vas a encontrar aquí 😜
# Estas instrucciones son meramente orientativas, yo uso Oracle XE 21 sobre Docker,
# igualmente tu usuario, passwd y servicio pueden variar 

docker exec -i DDBB sqlplus / as sysdba << __END__
__END__
