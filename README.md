Tarea - Miguel Fuenzalida
=========================

Profesor: Sebastián Salazar

Una pequeña aplicación en maven con las siguentes tecnologias:

- Base de datos: Postgres (se espera una ves terminado, ocupar en la base SH41 para un dato en una tabla).
- Persistencia: mybatis-spring (http://code.google.com/p/mybatis/wiki/Spring).
- ...

La aplicación no esta terminada, exsisten unos problemas de configuración en mis archivos spring que ocupan mybatis-spring.

OBS:

- La tabla a utitizar es la que se creo a traves del siguente comando sql:

CREATE TABLE usuarios (
    rut             int        primary key,
    password        varchar
);

- La aplicación corre con el comando mvn tomcat:deploy sobre tomcat6.
