DROP DATABASE IF EXISTS enfermedades;

-- Creacion de base de datos 

CREATE DATABASE enfermedades;

USE enfermedades;

-- Creamos las tablas

CREATE TABLE enfermedad (
	id_enfermedad NUMERIC PRIMARY KEY,
	nombre VARCHAR(40) UNIQUE NOT NULL, 
	descripcion VARCHAR(100),
	t_recuperacion INTEGER
);

CREATE TABLE paciente (
	id_paciente NUMERIC PRIMARY KEY,
	nombre VARCHAR(25),
	apellidos VARCHAR(40),
	f_nacimiento DATE,
	poblacion VARCHAR(30),
	id_medico NUMERIC,
	CONSTRAINT fk_id_medico FOREIGN KEY (id_medico) REFERENCES paciente (id_paciente)
);

CREATE TABLE historial (
	id_historial INTEGER PRIMARY KEY,
	grupo_sanguineo CHAR(3),
	id_paciente NUMERIC,
	CONSTRAINT fk_id_paciente FOREIGN KEY (id_paciente) REFERENCES paciente (id_paciente)
);

CREATE TABLE linea_historial (
	num_linea INTEGER,
	id_historial INTEGER,
	id_enfermedad NUMERIC NOT NULL,
	f_inicio DATE,
	f_fin DATE,
	sintomas VARCHAR(100),
	observaciones VARCHAR(200),
	CONSTRAINT pk_linea_historial PRIMARY KEY (num_linea, id_historial, id_enfermedad),
	CONSTRAINT fk_id_historial FOREIGN KEY (id_historial) REFERENCES historial (id_historial),
	CONSTRAINT fk_id_enfermedad FOREIGN KEY (id_enfermedad) REFERENCES enfermedad (id_enfermedad),
	CONSTRAINT ck_f_fin CHECK (f_fin > f_inicio)
);

CREATE TABLE localizacion  (
	id_localizacion INTEGER PRIMARY KEY,
	cp CHAR(5),
	ciudad VARCHAR(25),
	riesgo INTEGER DEFAULT 1
);

CREATE TABLE estancias_pacientes(
	id_paciente NUMERIC,
	id_localizacion INTEGER,
	f_entrada DATE,
	f_salida DATE,
	CONSTRAINT pk_estancias_pacientes PRIMARY KEY (id_paciente, id_localizacion),
	CONSTRAINT fk_id_paciente_pacientes FOREIGN KEY (id_paciente) REFERENCES paciente (id_paciente),
	CONSTRAINT fk_id_localizacion FOREIGN KEY (id_localizacion) REFERENCES localizacion (id_localizacion)
	
	
);