BEGIN TRANSACTION;

DROP TABLE IF EXISTS usuarios CASCADE;
CREATE TABLE usuarios (
        rut int NOT NULL,
        password varchar(40) NOT NULL,
        PRIMARY KEY (rut)
);

INSERT INTO usuarios VALUES (16567393, 'user_1');
INSERT INTO usuarios VALUES (24525711, 'user_2');
INSERT INTO usuarios VALUES (16659132, 'user_3');
INSERT INTO usuarios VALUES (20322478, 'user_4');

DROP TABLE IF EXISTS accesos CASCADE;
CREATE TABLE accesos ( 
        id SERIAL NOT NULL,
        usuario int NOT NULL,
        ip varchar(16) NOT NULL,
        fecha timestamp NOT NULL,
        PRIMARY KEY (id)
);

INSERT INTO accesos (usuario, ip, fecha) VALUES (2234, '120.0.0.1', '2004-10-19 15:23:54');

COMMIT;
