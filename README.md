Tarea - Miguel Fuenzalida
=========================

Profesor: Sebastián Salazar

Una pequeña aplicación en maven con las siguentes tecnologias:

- Base de datos: Postgres (se espera una ves terminado, ocupar en la base SH41 para un dato en una tabla).
- Persistencia: mybatis-spring (http://code.google.com/p/mybatis/wiki/Spring).
- ...

La aplicación no esta terminada, exsisten unos problemas de configuración en mis archivos spring que ocupan mybatis-spring.

OBS:

- La tabla a utitizar es la que se creo a traves del comando sql que se encuentra en el archivo dentro de SQL.
- La aplicación corre con el comando mvn tomcat:deploy sobre tomcat6.
- Se utiliza Mybatis.annotation (anotaciones) para ejecutar las consultas SQL sobre los ...Mapper.java

Tarea: (Próximo Jueves)

- [COMPLETO] corregir el convertidor de rut (tipo 99.999.999-9).
- [COMPLETO] corregir el SHA1.  php -r '$n=sha1("asdf"); echo "\n$n\n";'
- crear una tabla de accesos. (usuario, ip, hora)
- crear estadisticas y graficos de los accesos. (promedio, moda, etc...).
- crear un login sencillo.
- implementar spring-security para el login.
- estudiar PLR o R con java.
- el modelo va a cambiar a plural y debe ajustarse en el código.
