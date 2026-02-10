-- Creamos una base de datos deportes 

DROP DATABASE IF EXISTS deportes;

CREATE DATABASE deportes;

USE deportes;

-- Crear tres tablas
--  Equipo (codigo (Entero autoincremental),
-- nombre, fecha_creacion

-- Jugador (codigo (texto 6), nombre, apellidos, posicion)

-- Juega (codigoJugador, codigoEquipo, fecha_contrato)

CREATE TABLE equipo (
	codigo INTEGER PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(25),
	fecha_creacion DATETIME
);

CREATE TABLE jugador(
	codigo VARCHAR(6) PRIMARY KEY,
	nombre VARCHAR(25),
	apellidos VARCHAR(30),
	posicion VARCHAR(30)
);

CREATE TABLE juega (
	codigoJugador VARCHAR(6),
	codigoEquipo INTEGER,
	fecha_contrato DATETIME,
	CONSTRAINT pk_juega PRIMARY KEY (codigoJugador, codigoEquipo, fecha_contrato),
	CONSTRAINT fk_codigojugador FOREIGN KEY (codigoJugador) REFERENCES jugador (codigo),
	CONSTRAINT fk_codigoequipo FOREIGN KEY (codigoEquipo) REFERENCES equipo (codigo)
);