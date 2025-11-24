-- Creacion de una base de datos
CREATE DATABASE prueba;
	
-- Nos posicionamos
USE prueba;

-- Creacion de dos tablas
CREATE TABLE uno (
	a int PRIMARY KEY,
	b int,
	c varchar(20)
);

CREATE TABLE dos (
	e int,
	f int,
	a int,
	CONSTRAINT pk_dos_e_f PRIMARY KEY (e,f),
	CONSTRAINT fk_dos_a FOREIGN KEY (a) REFERENCES uno (a)
	ON DELETE CASCADE
);