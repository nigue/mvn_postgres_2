BEGIN TRANSACTION;

DROP TABLE IF EXISTS usuarios CASCADE;
CREATE TABLE usuarios (
        rut int NOT NULL,
        password varchar(40) NOT NULL,
        PRIMARY KEY (rut)
);

COMMIT;
