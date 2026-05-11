
-- 1. Inserción de datos a partir del resultado de una consulta.
-- Apuntamos automáticamente a la sala de Pesas que es el id 502 a todos los socios que han sido invitados por el DNI 12345678A
INSERT INTO USA (dni_socio, id_sala)
SELECT dni, 502 
FROM SOCIOS 
WHERE dni_socio_invitador = '12345678A';

-- 2. Modificación de datos utilizando la cláusula WHERE junto con una subconsulta.
-- Subimos el precio un 10% a las membresías que tienen los socios que se apuntaron antes de este año
UPDATE MEMBRESIAS
SET precio = precio * 1.10
WHERE id_membresia IN (
    SELECT id_membresia 
    FROM SOCIOS 
    WHERE fecha_alta < '2026-01-01'
);

-- 3. Modificación de datos, de forma que el nuevo valor se obtenga mediante una subconsulta.
-- Actualizamos la capacidad de la sala 501 poniéndole el doble del número de socios que la usan actualmente
UPDATE SALAS
SET capacidad = (
        SELECT COUNT(*) * 2 
        FROM USA 
        WHERE USA.id_sala = 501
    )
WHERE id_sala = 501;

-- 4. Modificar o eliminar datos utilizando una consulta correlacionada.
-- Borramos de la base de datos a los socios que están registrados pero no tienen ningún pago hecho
DELETE FROM SOCIOS S
WHERE NOT EXISTS (
    SELECT 1 
    FROM PAGOS P 
    WHERE P.dni_socio = S.dni
);