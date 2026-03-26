-- 1. Borrar de la tabla ALUM los ANTIGUOS alumnos. Ayuda: Mirar el punto 5 de la teoría, ya
-- que tendréis que eliminarlos con una subconsulta
delete from alum where edad > (select edad from (select avg(edad) as edad from alum) as z)

-- 2. EMPLE y DEPART. Insertar un empleado de apellido 'saavedra' con número 200, la fecha de
-- alta será la actual, el SALARIO será el mismo salario de el empleado de apellido 'sala' más el
-- 20 por 100 y el resto de datos serán los mismos que los datos de 'sala'. Ayuda: Hay que
-- hacer un INSERT utilizando un SELECT
insert into emple ()
values
(
	200,
	"saavedra",
	(select oficio from (select * from emple) as z where apellido = "sala"),
	(select dir from (select * from emple) as z where apellido = "sala"),
	CURDATE(),
	(select salario *1.2 from (select * from emple) as z where apellido = "sala"),
	(select comision from (select * from emple) as z  where apellido = "sala"),
	(select DEPT_NO from (select * from emple) as z where apellido = "sala")
)


-- 3. Modificar el número de departamento de 'saavedra'. El nuevo departamento será el
-- Departamento que está en BILBAO. Ayuda: Utilizar una subconsulta
update emple
set dept_no = (select dept_no from depart where loc = "Bilbao")
where apellido = "saavedra"


-- 4. Borrar todos los departamentos de la tabla DEPART para los cuales no existan empleados
-- en emple. Ayuda: Utilizar un SELECT
delete from depart 
where dept_no not in (select dept_no from emple)

-- 5. Eliminar los centros que no tengan personal.
delete from centro
where cod_centro not in (select cod_centro from personal)


-- 6. Borrar el personal que está en centros de menos de 300 plazas y con menos de dos
-- profesores. Ayuda: Hay que utilizar agrupación (GROUP BY)
delete from personal
where cod_centro in (select cod_centro form centro where num_plazas < 300 and ) 
-- sin hacer


-- 7. Borrar a los profesores que están en la tabla PROFESORES y que no están en la tabla
-- PERSONAL.
-- 8. Dar de alta un nuevo artículo con código 'PI201' llamadado 'Pipas' de 'Primera' categoría y
-- peso '1' para el fabricante PRESIDENT y abastecer con cinco unidades de ese artículo a
-- todas las tiendas y en la fecha de hoy.
-- 9. Dar de alta una tienda en la provincia de Madrid y abastecerla con 20 unidades de cada
-- -- uno de los artículos existentes.
-- 10. Dar de alta dos tiendas en la provincia de Sevilla y abastecerlas con 30 unidades de
-- artículos de la marca de fabricante gallo.
-- 11. Cambiar todos los artículos de 'primera' categoría a 'quinta' del país ITALIA.
-- 12. Eliminar los artículos que no hayan tenido ni compras ni ventas.
-- 13. Restar uno a las unidades de los últimos pedidos de la tienda con nif 5555-B. 