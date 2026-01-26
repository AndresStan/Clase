-- Ejercicio 3
-- Andres STAN

DROP DATABASE IF EXISTS BIBLIOTECA_DIGITAL;

-- CREO LA BASE DE DATOS

CREATE DATABASE BIBLIOTECA_DIGITAL;

-- ENTRO DENTRO DE LA BASE

USE BIBLIOTECA_DIGITAL;

-- Creo la tabla editoriales


CREATE TABLE EDITORIALES(
	cif VARCHAR(12) PRIMARY KEY,
	nombre VARCHAR(80) NOT NULL UNIQUE,
	pais_origen VARCHAR(50),
	anio_fundacion INTEGER(4),
	web VARCHAR(150),
	activa CHAR(1) DEFAULT 'S',
	CONSTRAINT ck_anio_fundacion CHECK(anio_fundacion > 1800 AND anio_fundacion < 2026),
	CONSTRAINT ck_activa CHECK (activa IN ('S', 'N'))
);

-- Creo la tabla autores

CREATE TABLE AUTORES(
	id_autor INTEGER PRIMARY KEY AUTO_INCREMENT,
	nombre_completo VARCHAR(100) NOT NULL,
	nacionalidad VARCHAR(50),
	fecha_nacimiento DATE NOT NULL,
	fecha_fallecimiento DATE,
	biografia TEXT,
	premios VARCHAR(200),
	CONSTRAINT ck_fecha_fallecimiento CHECK ( fecha_fallecimiento > fecha_nacimiento)
);

-- Creo la tabla libros

CREATE TABLE LIBROS(
	isbn VARCHAR(17) PRIMARY KEY,
	titulo VARCHAR(150) NOT NULL,
	anio_publicacion INTEGER(4),
	num_paginas INTEGER,
	idioma VARCHAR(20),
	genero VARCHAR(30) NOT NULL,
	formato VARCHAR(15) DEFAULT 'DIGITAL',
	precio_compra DECIMAL(6,2),
	disponible CHAR(1) DEFAULT 'S',
	cif_editorial VARCHAR(12),
	CONSTRAINT ck_anio_publicacion CHECK (anio_publicacion > 1000 AND anio_publicacion < 2027),
	CONSTRAINT ck_num_paginas CHECK (num_paginas > 0),
	CONSTRAINT ck_idioma CHECK (idioma IN ('ESPAÑOL', 'INGLES', 'FRANCES', 'ALEMAN', 'ITALIANO', 'PORTUGUES')),
	CONSTRAINT ck_formato CHECK (formato IN ('DIGITAL', 'FISICO', 'AMBOS')),
	CONSTRAINT ck_precio_compra CHECK (precio_compra > 0),
	CONSTRAINT ck_disponible CHECK (disponible IN ('S', 'N')),
	CONSTRAINT fk_cif_editorial FOREIGN KEY (cif_editorial) REFERENCES EDITORIALES (cif) ON DELETE RESTRICT
);

-- Creo la tabla libros_autores

CREATE TABLE LIBROS_AUTORES(
	isbn VARCHAR(17),
	id_autor INTEGER,
	orden_autor INTEGER DEFAULT (1),
	CONSTRAINT fk_isbn	FOREIGN KEY (isbn) REFERENCES LIBROS (isbn) ON DELETE CASCADE,
	CONSTRAINT fk_autor	FOREIGN KEY (id_autor) REFERENCES AUTORES (id_autor) ON DELETE CASCADE,
	CONSTRAINT ck_orden_autor CHECK (orden_autor > 0),
	CONSTRAINT pk_isbn_autor PRIMARY KEY (isbn, id_autor)
);

-- Creo la tabla socios

CREATE TABLE SOCIOS(
	num_socio INTEGER AUTO_INCREMENT PRIMARY KEY,
	dni VARCHAR(10) UNIQUE NOT NULL,
	nombre VARCHAR(40) NOT NULL,
	apellidos VARCHAR(60) NOT NULL,
	email VARCHAR(100) NOT NULL UNIQUE,
	telefono VARCHAR(12),
	fecha_alta DATETIME DEFAULT NOW(),
	tipo_socio VARCHAR(15) DEFAULT 'BASICO',
	cuota_pagada CHAR(1) DEFAULT 'N',
	penalizaciones INTEGER DEFAULT 0,
	CONSTRAINT ck_tipo_socio CHECK ( tipo_socio IN ('BASICO', 'PREMIUM', 'VIP')),
	CONSTRAINT ck_cuota_pagada CHECK ( cuota_pagada IN ('S', 'N')),
	CONSTRAINT ck_penalizaciones CHECK ( penalizaciones >= 0 AND penalizaciones <= 10)
);

CREATE TABLE PRESTAMOS(
	id_prestamos INTEGER AUTO_INCREMENT PRIMARY KEY,
	num_socio INTEGER,
	isbn VARCHAR(17),
	fecha_prestamo DATETIME DEFAULT NOW() NOT NULL,
	fecha_devolucion_prevista DATE NOT NULL,
	fecha_devolucion_real DATE, 
	estado VARCHAR(20) DEFAULT 'EN_PRESTAMO',
	renovaciones INTEGER DEFAULT 0,
	CONSTRAINT fk_num_socio FOREIGN KEY (num_socio) REFERENCES SOCIOS (num_socio) ON DELETE RESTRICT,
	CONSTRAINT fk_isbn2 FOREIGN KEY (isbn) REFERENCES LIBROS (isbn) ON DELETE RESTRICT,
	CONSTRAINT ck_estado CHECK (estado IN ('EN_PRESTAMO', 'DEVUELTO', 'RETRASADO', 'PERDIDO')),
	CONSTRAINT ck_renovaciones CHECK (renovaciones >= 0 AND renovaciones <= 3),
	CONSTRAINT ck_devolucion_prevista CHECK (fecha_devolucion_prevista > fecha_prestamo)
);

