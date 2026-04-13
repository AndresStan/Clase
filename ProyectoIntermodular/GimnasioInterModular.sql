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

-- Insertamos un par de usuarios con privilegios y usuarios sin
insert into logged (dni, contraseña, admin)
values ("61091513V", "61091513V", True);
 

insert into logged (dni, contraseña, admin)
values ("61091513N", "61091513N", False);

INSERT INTO logged (dni, contraseña, admin) VALUES 
("61091513Z", "61091513Z", False), ("20341567A", "pass2034", True),
("71829304B", "user7182", False), ("10293847C", "admin102", True),
("55443322D", "clave554", False), ("99887766E", "99887766E", True),
("12312312F", "secret12", False), ("45645645G", "45645645G", False),
("78978978H", "root7890", True), ("11221122I", "11221122I", False),
("33443344J", "33443344J", True), ("55665566K", "p@ssw0rd1", False),
("77887788L", "77887788L", True), ("99009900M", "admin990", False),
("11112222P", "11112222P", True), ("33334444Q", "user3333", False),
("55556666R", "55556666R", True), ("77778888S", "clv7777S", False),
("99990000T", "99990000T", True), ("12123434U", "12123434U", False),
("56567878V", "admin565", True), ("90901212W", "user9090", False),
("34345656X", "34345656X", True), ("78789090Y", "78789090Y", False),
("13572468Z", "pass1357", True), ("24681357A", "24681357A", False),
("86427531B", "admin864", True), ("97531864C", "97531864C", False),
("15926347D", "clv1592D", True), ("48261735E", "48261735E", False);


