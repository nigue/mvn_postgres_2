BEGIN TRANSACTION;

DROP TABLE IF EXISTS usuarios CASCADE;
CREATE TABLE usuarios (
        rut int NOT NULL,
        password varchar(40) NOT NULL,
        PRIMARY KEY (rut)
);

INSERT INTO usuarios VALUES (11111111, 'user_1');
INSERT INTO usuarios VALUES (22222222, 'user_2');
INSERT INTO usuarios VALUES (33333333, 'user_3');
INSERT INTO usuarios VALUES (44444444, 'user_4');

COMMIT;
