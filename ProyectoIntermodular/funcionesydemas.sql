-- FUNCIÓN
-- Le pasas el dni de un socio y te devuelve el total que se ha gastado en el gimnasio
CREATE FUNCTION TotalGastado(dni_buscado VARCHAR(9)) RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
    DECLARE total DECIMAL(10,2);
    
    SELECT SUM(importe) INTO total 
    FROM PAGOS 
    WHERE dni_socio = dni_buscado;
    
    IF total IS NULL THEN
        SET total = 0.00;
    END IF;
    
    RETURN total;
END;


-- PROCEDIMIENTO
-- Para actualizar el telefono de un socio rapidamente pasándole su dni y el nuevo número
CREATE PROCEDURE ActualizarTelefono(IN p_dni VARCHAR(9), IN p_nuevo_tlf VARCHAR(15))
BEGIN
    UPDATE SOCIOS 
    SET telefono = p_nuevo_tlf 
    WHERE dni = p_dni;
END;


-- TRIGGER
-- Pasa el correo electrónico a minúsculas automáticamente antes de guardar un socio nuevo
CREATE TRIGGER correo_minusculas
BEFORE INSERT ON SOCIOS
FOR EACH ROW
BEGIN
    SET NEW.correo_electronico = LOWER(NEW.correo_electronico);
END;