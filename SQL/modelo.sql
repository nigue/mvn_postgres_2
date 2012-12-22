BEGIN TRANSACTION;

DROP TABLE IF EXISTS usuario CASCADE;
CREATE TABLE usuario (
        rut int NOT NULL,
        password varchar(40) NOT NULL,
        PRIMARY KEY (rut)
);

INSERT INTO usuario VALUES (11111111, 'user_1');
INSERT INTO usuario VALUES (22222222, 'user_2');
INSERT INTO usuario VALUES (33333333, 'user_3');
INSERT INTO usuario VALUES (44444444, 'user_4');

COMMIT;
