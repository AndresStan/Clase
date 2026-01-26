-- Ejercicio 3 Andres Stan 29/11/2025
DROP DATABASE IF EXISTS logistica;


-- Creacion de la base de datos

CREATE DATABASE logistica;

-- Nos posicionamos en la base

USE logistica;

-- Creacion de la tabla proveedores

CREATE TABLE proveedores (
	id_prov NUMERIC PRIMARY KEY,
	nombre VARCHAR(30),
	telefono CHAR(9) UNIQUE,
	mail VARCHAR(20)
);

CREATE TABLE categorias (
	id_categoria CHAR(2) PRIMARY KEY,
	descripcion VARCHAR(50)
);

CREATE TABLE productos (
	numero_producto INTEGER PRIMARY KEY,
	nombre VARCHAR(30),
	precio_venta DECIMAL,
	stock INTEGER,
	id_categoria CHAR(2),
	CONSTRAINT fk_id_categoria_productos FOREIGN KEY (id_categoria) REFERENCES categorias (id_categoria)
);

CREATE TABLE productos_proveedores (
	id_prov NUMERIC,
	numero_producto INTEGER,
	CONSTRAINT fk_id_prov_proveedores FOREIGN KEY (id_prov) REFERENCES proveedores (id_prov),
	CONSTRAINT fk_numero_producto_productos FOREIGN KEY (numero_producto) REFERENCES productos (numero_producto)
);

CREATE TABLE clientes (
	id_cliente CHAR(3) PRIMARY KEY,
	nombre VARCHAR(25),
	apellidos VARCHAR(25),
	direccion VARCHAR(30),
	telefono CHAR(9) UNIQUE
);

CREATE TABLE empleados (
	id_empleado CHAR(3) PRIMARY KEY,
	nombre VARCHAR(30),
	apellidos VARCHAR(30),
	direccion VARCHAR(30),
	codigo_area CHAR(2)
);

CREATE TABLE pedidos (
	numero_pedido INTEGER PRIMARY KEY,
	fecha_pedido DATE,
	id_cliente CHAR(3) NOT NULL,
	id_empleado CHAR(3) NOT NULL,
	CONSTRAINT fk_id_cliente_pedidos FOREIGN KEY (id_cliente) REFERENCES clientes (id_cliente),
	CONSTRAINT fk_id_empleado_pedidos FOREIGN KEY (id_empleado) REFERENCES empleados (id_empleado)
);

CREATE TABLE detalles_pedidos (
	numero_pedido INTEGER,
	numero_producto INTEGER,
	cantidad INTEGER,
	precio DECIMAL(10,2),
	CONSTRAINT pk_detalles_pedidos PRIMARY KEY (numero_pedido,numero_producto),
	CONSTRAINT fk_numero_pedido_pedidos FOREIGN KEY (numero_pedido) REFERENCES pedidos (numero_pedido),
	CONSTRAINT fk_numero_producto FOREIGN KEY (numero_producto) REFERENCES productos (numero_producto),
	CONSTRAINT ck_cantidad CHECK (cantidad >= 1 AND cantidad <= 100)
	
	
);