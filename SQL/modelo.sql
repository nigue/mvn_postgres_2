BEGIN TRANSACTION;

DROP TABLE IF EXISTS usuarios CASCADE;
CREATE TABLE usuarios (
	pk serial NOT NULL,
	rut int NOT NULL,
	nombre varchar(255) NOT NULL,
	password varchar(40) NOT NULL,
	UNIQUE (rut),
	PRIMARY KEY (pk)
);

DROP TABLE IF EXISTS accesos CASCADE;
CREATE TABLE accesos ( 
	pk bigserial NOT NULL,
	usuario_fk int NOT NULL REFERENCES usuarios(pk) ON UPDATE CASCADE ON DELETE CASCADE,
	ip varchar(40) NOT NULL,
	fecha timestamptz NOT NULL,
	PRIMARY KEY (pk)
);


COMMIT;
