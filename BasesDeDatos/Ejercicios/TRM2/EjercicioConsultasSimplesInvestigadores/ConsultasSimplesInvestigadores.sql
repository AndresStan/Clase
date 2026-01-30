-- Andres Stan 
-- 1 DAM

-- 1. Crea una consulta que muestre todos los campos (datos) de los investigadores ordenados por
-- facultad.

select * from investigadores order by facultad;

-- 2. Crea una consulta que muestre los campos nombre como “NomInvestigador”, apellidos como
-- “ApellInvestigador” y “DNI” ordenados alfabéticamente por apellido, de los investigadores

select nombre as NomInvestigador, apellidos as ApelInvestigador, dni from investigadores order by apellidos;


-- 3. Crea una consulta que muestre todas las facultades que contengan la palabra “Ciencias” en su
-- nombre.

select NomFacultad  from facultades where NomFacultad  like '%Ciencias%';

-- 4. Crea una consulta que muestre todos los datos (campos) de los equipos pertenecientes a la
-- facultad de IdFacultad 2

select * from equipos where IdFacultad = 2;

-- 5. Crea una consulta que muestre todos los datos de los equipos cuyo IdEquipo comienza por “H”.

select * from equipos where IdEquipo like 'H%';

-- 6. Crea una consulta que muestre todos los datos de los equipos cuyo IdEquipo NO comienza por “H”.

select * from equipos where IdEquipo not like 'H%';


-- 7. Crea una consulta que muestre todos los datos de los investigadores adscritos a la facultad 2 o a la
-- facultad 4.

select * from investigadores where facultad in (2, 4);


--8. Crea una consulta que muestre los campos “DNI”, “IdEquipo” y “FInicio” de las reservas cuya
-- “FInicio” sea del mes de noviembre de 2007.

select dni, idEquipo, Finicio from reservas where FInicio like '2007-11-%';

-- 9. Modifica la consulta “Reservas noviembre”anterior para que muestre el campo “FFin” en vez del
-- campo “FInicio”. El criterio debe seguir siendo que la “FInicio” sea del mes de noviembre de 2024.

 select dni, idEquipo, FFin  from reservas where FInicio like '2007-11-%';


-- 10. Crea una consulta que muestre las reservas (todos los campos) cuya “FInicio” y “FFin” son del mes
-- de octubre de 2024.

select * from reservas where FInicio like '2024-10-%' and FFin like '2024-20-%';

-- 11. Visualiza todos los datos de los investigadores cuyo apellido terminen en z y contengan una o,
-- ordenados alfabéticamente por apellido.

select * from investigadores where apellidos like '%o%z' order by apellidos;


-- 12. Visualiza el nombre y apellidos de los investigadores que tengan una beca mayor de 8000 €.


select nombre, apellidos from investigadores where (beca > 8000);

-- 13. Visualiza el DNI de los investigadores que hayan reservado (FInicio) algún equipo en el mes de
-- septiembre.

select dni from reservas where FInicio like '%-09-%';


-- 14. Visualiza el DNI de los investigadores, su cuantía de beca y como quedaría ésta si la aumentamos un
-- 5 %, visualiza este último dato como Nueva_Cuantía y ordénalos por este nuevo valor en orden descendente.

select dni, beca, beca*1.05 as Nueva_Cuantia from investigadores order by nueva_cuantia desc

-- 15. ¿Cuál es la descripción del equipo con IdEquipo H555?


select Descripcion from equipos where IdEquipo ='H555'

--SUBCONSULTAS
-- 1. Visualiza los nombres de los investigadores que están en la facultad de Ciencias Matematicas.

select nombre from investigadores where facultad = (select idFacultad from facultades where NomFacultad='Ciencias Matematicas') ;

-- 2. Visualiza todos los datos de las reservas del equipo de Descripción Telemetro laser SICK

select * from reservas where IdEquipo = (select idEquipo from equipos where Descripcion = 'Telemetro laser SICK');

-- 3. Visualiza los datos de las reservas de los investigadores que están en la facultad de Ciencias
-- Geologicas

select * from reservas where dni in (select dni from investigadores where facultad = (select IdFacultad from facultades where NomFacultad = 'Ciencias Geologicas'));


-- 4. Visualiza los datos de las reservas de los investigadores que están en la facultad de Ciencias
-- Geologicas con un sueldo entre 2000 y 6000.

select * from reservas where dni in (select dni from investigadores where facultad = (select IdFacultad from facultades where NomFacultad = 'Ciencias Geologicas') and beca between 2000 and 6000);

-- 5. Visualiza los datos de las reservas de los investigadores que están en la facultad de Ciencias
-- Geologicas, que hayan escogido el equipo H222.

 select * from reservas where dni in (select dni from investigadores where facultad = (select IdFacultad from facultades where NomFacultad = 'Ciencias Geologicas'))  and IdEquipo = 'H222';

-- 6. Visualiza los datos de las reservas de los investigadores que están en la facultad de Ciencias
-- Geologicas, que hayan escogido equipos de la Facultad de Ciencias Químicas.

select * from reservas where dni in (select dni from investigadores where facultad = (select IdFacultad from facultades where NomFacultad = 'Ciencias Geologicas')) and IdEquipo in (select IdEquipo  from equipos where IdFacultad = (select IdFacultad from facultades where NomFacultad = 'Ciencias Químicas'));

-- MULTITABLAS
-- 1. Visualiza los datos de los investigadores junto con el nombre de la facultad.

select inv.*, fa.NomFacultad from investigadores inv inner join facultades fa on inv.facultad=fa.IdFacultad;

-- 2. Visualiza los datos de los investigadores junto con el nombre de la facultad, y también que se
-- visualicen los nombres de la facultad, aunque no haya investigadores.



-- 3. Visualiza los datos de las reservas, pero que aparezca el nombre del investigador y apellidos.

select re.*, CONCAT(inv.nombre, " ", inv.apellidos) as NombreApellidos from reservas re inner join investigadores inv on re.DNI=inv.DNI;

-- 4. Visualiza los datos de las reservas, pero que aparezca el nombre del investigador y apellidos, y la
-- descripción del equipo.

select re.*, CONCAT(inv.nombre, " ", inv.apellidos) as NombreApellido, eq.Descripcion from reservas re natural join investigadores inv natural join equipos eq;
