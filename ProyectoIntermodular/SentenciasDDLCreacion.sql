DROP DATABASE IF EXISTS Gimnasio_Andres_Stan;
CREATE DATABASE Gimnasio_Andres_Stan;
USE Gimnasio_Andres_Stan;

CREATE TABLE MEMBRESIAS (
    id_membresia INT PRIMARY KEY,
    duracion INT NOT NULL, -- en meses
    precio DECIMAL(10, 2) NOT NULL DEFAULT 0.00,
    CONSTRAINT ck_precio CHECK (precio >= 0)
);

CREATE TABLE MEMBRESIAS_BASICAS (
    id_membresia INT PRIMARY KEY,
    horario VARCHAR(50) NOT NULL,
    CONSTRAINT fk_membresia_basica FOREIGN KEY (id_membresia) 
        REFERENCES MEMBRESIAS(id_membresia) ON DELETE CASCADE
);

CREATE TABLE MEMBRESIAS_PREMIUM (
    id_membresia INT PRIMARY KEY,
    seguro_sanitario VARCHAR(100) NOT NULL,
    CONSTRAINT fk_membresia_premium FOREIGN KEY (id_membresia) 
        REFERENCES MEMBRESIAS(id_membresia) ON DELETE CASCADE
);

CREATE TABLE ENTRENADORES (
    id_entrenador INT PRIMARY KEY,
    nombre_completo VARCHAR(100) NOT NULL
);





CREATE TABLE SOCIOS (
    dni VARCHAR(9) PRIMARY KEY,
    nombre_completo VARCHAR(100) NOT NULL,
    correo_electronico VARCHAR(100) UNIQUE NOT NULL,
    fecha_alta DATE DEFAULT (CURRENT_DATE),
    telefono VARCHAR(15),
    id_membresia INT NOT NULL,
    dni_socio_invitador VARCHAR(9),
    CONSTRAINT fk_socio_membresia FOREIGN KEY (id_membresia) 
        REFERENCES MEMBRESIAS(id_membresia) ON DELETE RESTRICT,
    CONSTRAINT fk_socio_invitador FOREIGN KEY (dni_socio_invitador) 
        REFERENCES SOCIOS(dni) ON DELETE SET NULL
);

CREATE TABLE PAGOS (
    id_pago INT PRIMARY KEY,
    fecha DATE NOT NULL,
    importe DECIMAL(10, 2) NOT NULL,
    dni_socio VARCHAR(9) NOT NULL,
    CONSTRAINT fk_pago_socio FOREIGN KEY (dni_socio) 
        REFERENCES SOCIOS(dni) ON DELETE CASCADE,
    CONSTRAINT ck_importe CHECK (importe > 0)
);

CREATE TABLE SALAS (
    id_sala INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    capacidad INT NOT NULL DEFAULT 20,
    id_entrenador INT NOT NULL,
    CONSTRAINT fk_sala_entrenador FOREIGN KEY (id_entrenador) 
        REFERENCES ENTRENADORES(id_entrenador) ON DELETE RESTRICT,
    CONSTRAINT chk_capacidad CHECK (capacidad > 0)
);

CREATE TABLE SALAS_BASICAS (
    id_sala INT PRIMARY KEY,
    tiempo_maximo_uso INT NOT NULL, -- en minutos
    CONSTRAINT fk_sala_basica FOREIGN KEY (id_sala) 
        REFERENCES SALAS(id_sala) ON DELETE CASCADE
);

CREATE TABLE SALAS_PREMIUM (
    id_sala INT PRIMARY KEY,
    tipo_suelo VARCHAR(50),
    CONSTRAINT fk_sala_premium FOREIGN KEY (id_sala) 
        REFERENCES SALAS(id_sala) ON DELETE CASCADE
);




CREATE TABLE USA (
    dni_socio VARCHAR(9),
    id_sala INT,
    PRIMARY KEY (dni_socio, id_sala),
    CONSTRAINT fk_usa_socio FOREIGN KEY (dni_socio) 
        REFERENCES SOCIOS(dni) ON DELETE CASCADE,
    CONSTRAINT fk_usa_sala FOREIGN KEY (id_sala) 
        REFERENCES SALAS(id_sala) ON DELETE CASCADE
);

Una vez creadas las tablas procedo a la inserción de datos de prueba

INSERT INTO MEMBRESIAS (id_membresia, duracion, precio) VALUES 
(1, 1, 30.00),
(2, 6, 150.00),
(3, 12, 280.00);

INSERT INTO MEMBRESIAS_BASICAS (id_membresia, horario) VALUES 
(1, 'Mañanas 08:00 - 14:00'),
(2, 'Tardes 16:00 - 22:00');

INSERT INTO MEMBRESIAS_PREMIUM (id_membresia, seguro_sanitario) VALUES 
(3, 'Seguro Sanitas Todo Riesgo');

INSERT INTO ENTRENADORES (id_entrenador, nombre_completo) VALUES 
(10, 'Carlos Martínez'),
(20, 'Lucía Fernández'),
(30, 'Roberto Gómez');

INSERT INTO SOCIOS (dni, nombre_completo, correo_electronico, id_membresia, dni_socio_invitador) VALUES 
('12345678A', 'Juan Pérez', 'juan.perez@email.com', 1, NULL),
('87654321B', 'Marta García', 'marta.g@email.com', 3, '12345678A'),
('11223344C', 'Luis Ruiz', 'lruiz@email.com', 2, NULL);

INSERT INTO PAGOS (id_pago, fecha, importe, dni_socio) VALUES 
(100, '2026-05-01', 30.00, '12345678A'),
(101, '2026-05-02', 280.00, '87654321B'),
(102, '2026-05-05', 150.00, '11223344C');

INSERT INTO SALAS (id_sala, nombre, capacidad, id_entrenador) VALUES 
(501, 'Sala de Cardio', 30, 10),
(502, 'Sala de Pesas', 25, 20),
(503, 'Box Crossfit', 15, 30);

INSERT INTO SALAS_BASICAS (id_sala, tiempo_maximo_uso) VALUES 
(501, 60),
(502, 90);

INSERT INTO SALAS_PREMIUM (id_sala, tipo_suelo) VALUES 
(503, 'Caucho Reforzado');

INSERT INTO USA (dni_socio, id_sala) VALUES 
('12345678A', 501),
('87654321B', 503),
('11223344C', 502);
