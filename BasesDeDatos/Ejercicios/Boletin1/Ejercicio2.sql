-- Ejercicio 2 
-- Fecha 9/1/26
-- Andres Alexandro Pescaru STANDBY
-- Borramos la base de datos si existiera

DROP DATABASE IF EXISTS ACADEMIA_VIRTUAL;

-- Creamos la base de datos

CREATE DATABASE ACADEMIA_VIRTUAL;

-- Nos situamos en la base de datos

USE ACADEMIA_VIRTUAL;

-- Creamos la tabla categorias

CREATE TABLE CATEGORIAS(
	id_categoria INTEGER AUTO_INCREMENT PRIMARY KEY,
	nombre_categoria VARCHAR(40) UNIQUE NOT NULL,
	descripccion VARCHAR(150),
	activa CHAR(1) DEFAULT 'S',
	CONSTRAINT ck_activa CHECK (activa IN ('S', 'N'))
);

-- Creamos la tabla instructores

CREATE TABLE INSTRUCTORES (
	email VARCHAR(100) PRIMARY KEY,
	nombre_completo VARCHAR(80) NOT NULL,
	biografia TEXT,
	fecha_registro DATETIME DEFAULT NOW(),
	puntuacion_media DECIMAL(3,2),
	certificado CHAR(1),
	linkedin TEXT,
	CONSTRAINT ck_puntuacion_media CHECK (puntuacion_media >= 0 AND puntuacion_media <= 5),
	CONSTRAINT ck_certificado CHECK (certificado IN ('S', 'N'))
);

-- Creamos la tabla cursos

CREATE TABLE CURSOS(
	cod_curso VARCHAR(10) PRIMARY KEY,
	titulo VARCHAR(100) NOT NULL,
	descripcion TEXT,
	nivel VARCHAR(15),
	duracion_horas INTEGER,
	precio DECIMAL(6,2),
	fecha_creacion DATETIME DEFAULT NOW(),
	plazas_max INTEGER,
	id_categoria INTEGER,
	email_instructor VARCHAR(100),
	CONSTRAINT ck_nivel CHECK (nivel IN ('BASICO', 'INTERMEDIO', 'AVANZADO', 'EXPERTO')),
	CONSTRAINT ck_duracion_horas CHECK (duracion_horas > 0 AND duracion_horas < 500),
	CONSTRAINT ck_precio CHECK (precio >= 0),
	CONSTRAINT ck_plazas_max CHECK (plazas_max >0 AND plazas_max <= 100),
	CONSTRAINT fk_id_categoria FOREIGN KEY (id_categoria) REFERENCES CATEGORIAS (id_categoria) ON DELETE RESTRICT,
	CONSTRAINT fk_email_instructor FOREIGN KEY (email_instructor) REFERENCES INSTRUCTORES (email) ON DELETE CASCADE
);

-- Creamos la tabla estudiantes

CREATE TABLE ESTUDIANTES(
	id_estudiante INTEGER AUTO_INCREMENT PRIMARY KEY,
	email VARCHAR(100) UNIQUE NOT NULL,
	nombre VARCHAR(40) NOT NULL,
	apellidos VARCHAR(60) NOT NULL,
	pais VARCHAR(50),
	fecha_nacimiento DATETIME,
	premium CHAR(1) DEFAULT 'N'	
);

-- Creamos la tabla matriculas

CREATE TABLE MATRICULAS(
	id_matricula INTEGER AUTO_INCREMENT PRIMARY KEY,
	id_estudiante INTEGER,
	cod_curso VARCHAR(10),
	fecha_matricula DATETIME DEFAULT NOW(),
	progreso INTEGER DEFAULT '0',
	calificacion_final DECIMAL(4,2),
	completado CHAR(1) DEFAULT 'N',
	CONSTRAINT fk_id_estudiante FOREIGN KEY (id_estudiante) REFERENCES ESTUDIANTES (id_estudiante) ON DELETE CASCADE,
	CONSTRAINT fk_cod_curso FOREIGN KEY (cod_curso) REFERENCES CURSOS (cod_curso) ON DELETE RESTRICT,
	CONSTRAINT ck_progreso CHECK (progreso >= 0 AND progreso <= 100),
	CONSTRAINT ck_calificacion_final CHECK (calificacion_final >= 0 AND calificacion_final <= 10),
	CONSTRAINT ck_completado CHECK (completado IN ('S', 'N')),
	CONSTRAINT uq_estud_curso UNIQUE(id_estudiante, cod_curso)
);

-- EMPIEZO LAS PRUEBAS DE INSERCCION

INSERT INTO CATEGORIAS (nombre_categoria, activa) VALUES ('Programacion', 's')

INSERT INTO INSTRUCTORES (email, nombre_completo, puntuacion_media, certificado) VALUES ('juan.perez@academia.com', 'Juan Perez Sanchez', 4,75, 'S')