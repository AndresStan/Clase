

-- Andres Stan
-- Consultas basicas

use ventas;


-- 1
SELECT CONCAT(nombre, ' ',apellidos) AS nombre_completo, ciudad  FROM empleados;

-- 2
select numero_producto , nombre, precio_venta  from productos where (stock >= 10 and stock <= 50);

-- 3
select nombre from productos where nombre like '%Trail%' or nombre like '%Mountain%' order by precio_venta desc;

-- 4
select nombre, provincia from clientes where nombre like "%a" and provincia not in ('Madrid', 'Toledo');

-- 5
select nombre, apellidos, CONCAT(codigo_area, telefono) as TELEFONO_COMPLETO from empleados where cod_postal like "28%";

-- 6
select precio_venta  * 0.85 as Precio_con_descuento, precio_venta  from productos;


-- Subconsultas

-- 7
select nombre, precio_venta  from productos where precio_venta > (select AVG(precio_venta) from productos p );

-- 8
SELECT empleados.id_empleado, COUNT(pedidos.id_empleado) AS pedidosHechos FROM empleados LEFT JOIN pedidos ON empleados.id_empleado = pedidos.id_empleado GROUP BY empleados.id_empleado;

-- 9

-- 10 

-- 11
select * from productos where precio_venta > (select precio_venta from productos where numero_producto = 15);

-- 12
select * from clientes where provincia = (select provincia from proveedores where nombre = "Shinoman, Incorporated");

-- 13
select * from clientes where provincia not in (select provincia from proveedores);