-- Ejercicio 1 -- Andres Stan 

-- Borramos la base de datos 
DROP DATABASE terfrutos;
-- Creacion de la base de datos
CREATE DATABASE terfrutos;

-- Nos posicionamos en la base de datos
USE terfrutos;

-- Creamos la tabla TIENDAS
CREATE TABLE tiendas (
	numero_tienda NUMERIC(2),
	direccion VARCHAR(100),
	cp_tienda CHAR(5),
	telefono CHAR(9),
	CONSTRAINT pk_tiendas_numero PRIMARY KEY(numero_tienda)
);

CREATE TABLE vendedores (
	nif char(12),
	nombre VARCHAR(90),
	domicilio VARCHAR(100),
	cp_vendedor CHAR(5),
	telefono CHAR(9),
	fecha_nacimiento DATE,
	estado_civil VARCHAR(20),
	numero_hijos SMALLINT,
	numero_tienda NUMERIC(2),
	CONSTRAINT pk_vendedores_nif PRIMARY KEY (nif),
	CONSTRAINT fk_vendedores_tienda FOREIGN KEY (numero_tienda) REFERENCES tiendas(numero_tienda) ON DELETE SET NULL
);
	



	

