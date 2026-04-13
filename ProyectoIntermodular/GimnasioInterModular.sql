-- Andres Alexandro Pescaru stan 
-- 1DAM 

DROP DATABASE IF EXISTS GimnasioInterModular;
CREATE DATABASE GimnasioInterModular;
USE GimnasioInterModular;

-- Creamos la tabla Logged que se usara para loguear a los usuarios
CREATE TABLE Logged (
	dni VARCHAR(9) NOT NULL PRIMARY KEY,
	contraseña VARCHAR(20) NOT NULL,
	admin BOOLEAN not null
);

-- Creamos la Tabla Socio
CREATE TABLE Socio (
    dni VARCHAR(20) NOT NULL,
    nombre_completo VARCHAR(100) NOT NULL,
    correo_electronico VARCHAR(100),
    fecha_alta DATE,
    telefono VARCHAR(20),
    CONSTRAINT pk_socio PRIMARY KEY (dni)
);

-- Creamos la Tabla Sala
CREATE TABLE Sala (
    id VARCHAR(20) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    capacidad INT,
    CONSTRAINT pk_sala PRIMARY KEY (id)
);

-- Creamos la tabla Entrenador 
CREATE TABLE Entrenador (
    id VARCHAR(20) NOT NULL,
    nombre_completo VARCHAR(100) NOT NULL,
    codigoSala VARCHAR(20),
    CONSTRAINT pk_entrenador PRIMARY KEY (id),
    CONSTRAINT fk_entrenador_sala FOREIGN KEY (codigoSala) REFERENCES Sala (id)
);

-- Creamos la Tabla Pago
CREATE TABLE Pago (
    id VARCHAR(20) NOT NULL,
    dni_socio VARCHAR(20) NOT NULL,
    fecha DATE NOT NULL,
    importe DECIMAL(10, 2),
    CONSTRAINT pk_pago PRIMARY KEY (id, dni_socio),
    CONSTRAINT fk_pago_socio FOREIGN KEY (dni_socio) REFERENCES Socio (dni) ON DELETE CASCADE
);

-- Creamos la Tabla Socio_Sala 
CREATE TABLE Socio_Sala (
    dni_socio VARCHAR(20) NOT NULL,
    id_sala VARCHAR(20) NOT NULL,
    CONSTRAINT pk_socio_sala PRIMARY KEY (dni_socio, id_sala),
    CONSTRAINT fk_usa_socio FOREIGN KEY (dni_socio) REFERENCES Socio (dni),
    CONSTRAINT fk_usa_sala FOREIGN KEY (id_sala) REFERENCES Sala (id)
);

-- Insertamos un usuario con privilegios y un usuario sin
insert into logged (dni, contraseña, admin)
values ("61091513V", "61091513V", True);
 

insert into logged (dni, contraseña, admin)
values ("61091513N", "61091513N", False)
