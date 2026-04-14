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
    id int NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    capacidad INT,
    CONSTRAINT pk_sala PRIMARY KEY (id)
);

-- Creamos la tabla Entrenador 
CREATE TABLE Entrenador (
    id INT NOT NULL,
    nombre_completo VARCHAR(100) NOT NULL,
    codigoSala VARCHAR(20),
    CONSTRAINT pk_entrenador PRIMARY KEY (id),
    CONSTRAINT fk_entrenador_sala FOREIGN KEY (codigoSala) REFERENCES Sala (id)
);

-- Creamos la Tabla Pago
CREATE TABLE Pago (
    id int NOT NULL,
    dni_socio VARCHAR(20) NOT NULL,
    fecha DATE NOT NULL,
    importe DECIMAL(10, 2),
    CONSTRAINT pk_pago PRIMARY KEY (id, dni_socio),
    CONSTRAINT fk_pago_socio FOREIGN KEY (dni_socio) REFERENCES Socio (dni) ON DELETE CASCADE
);

-- Creamos la Tabla Socio_Sala 
CREATE TABLE Socio_Sala (
    dni_socio VARCHAR(20) NOT NULL,
    id_sala int NOT NULL,
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

use gimnasiointermodular

-- 1. SALA (No depende de nadie)
INSERT INTO sala (id, nombre, capacidad) VALUES
(1, 'Musculación', 50),
(2, 'Cardio', 30),
(3, 'Spinning', 20),
(4, 'Crossfit', 25),
(5, 'Yoga', 15),
(6, 'Pilates', 15),
(7, 'Zumba', 40),
(8, 'Artes Marciales', 20),
(9, 'Piscina', 60),
(10, 'Estiramientos', 10);

-- 2. ENTRENADOR (Depende de sala)
INSERT INTO entrenador (id, nombre_completo, codigoSala) VALUES
(1, 'Carlos Perez', 1),
(2, 'Ana Gomez', 2),
(3, 'Luis Martinez', 3),
(4, 'Marta Lopez', 4),
(5, 'David Garcia', 5),
(6, 'Elena Sanchez', 6),
(7, 'Jorge Fernandez', 7),
(8, 'Laura Rodriguez', 8),
(9, 'Pedro Ruiz', 9),
(10, 'Sofia Diaz', 10);

-- 3. SOCIO (No depende de nadie)
INSERT INTO socio (dni, nombre_completo, correo_electronico, fecha_alta, telefono) VALUES
('11111111A', 'Juan Ramirez', 'juan@email.com', '2023-01-15', '600111222'),
('22222222B', 'Maria Torres', 'maria@email.com', '2023-02-20', '600222333'),
('33333333C', 'Antonio Navarro', 'antonio@email.com', '2023-03-10', '600333444'),
('44444444D', 'Carmen Gil', 'carmen@email.com', '2023-04-05', '600444555'),
('55555555E', 'Jose Morales', 'jose@email.com', '2023-05-12', '600555666'),
('66666666F', 'Isabel Ortiz', 'isabel@email.com', '2023-06-18', '600666777'),
('77777777G', 'Francisco Castro', 'fran@email.com', '2023-07-22', '600777888'),
('88888888H', 'Paula Rubio', 'paula@email.com', '2023-08-30', '600888999'),
('99999999I', 'Miguel Serrano', 'miguel@email.com', '2023-09-14', '600999000'),
('00000000J', 'Lucia Molina', 'lucia@email.com', '2023-10-01', '600000111');

-- 4. PAGO (Depende de socio)
INSERT INTO pago (id, dni_socio, fecha, importe) VALUES
(1, '11111111A', '2023-11-01', 30),
(2, '22222222B', '2023-11-02', 30),
(3, '33333333C', '2023-11-03', 45),
(4, '44444444D', '2023-11-04', 30),
(5, '55555555E', '2023-11-05', 50),
(6, '66666666F', '2023-11-06', 45),
(7, '77777777G', '2023-11-07', 30),
(8, '88888888H', '2023-11-08', 50),
(9, '99999999I', '2023-11-09', 30),
(10, '00000000J', '2023-11-10', 45);

