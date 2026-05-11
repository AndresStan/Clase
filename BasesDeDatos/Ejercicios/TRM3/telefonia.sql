-- Andres Alexandro Pescaru Stan 10/4/2026
-- DAM1

-- Muestra el nombre y apellidos de los clientes apadrinados por el cliente de mayor
-- edad, pero solo si esos ahijados tienen contratada la tarifa 'Barata'.
SELECT c.nombre, c.apellidos FROM clientes c
JOIN tarifas t ON c.tarifa = t.id_tarifa
WHERE c.padrino = (SELECT id_cliente FROM clientes WHERE edad = (SELECT MAX(edad) FROM clientes))
AND t.nombre = 'Barata';

-- Muestra el nombre y descuento de las promociones que están actualmente en vigor (fecha
-- actual entre fecha_inicio y fecha_fin) y tienen el mayor descuento entre todas las
-- promociones vigentes.
SELECT nombre, descuento
FROM promociones
WHERE CURDATE() BETWEEN fecha_inicio AND fecha_fin
AND descuento = 
(
    SELECT MAX(descuento)
    FROM promociones
    WHERE CURDATE() BETWEEN fecha_inicio AND fecha_fin
);

-- Muestra el nombre y apellidos del cliente, el nombre de su tarifa, el coste de
-- establecimiento y el número de llamadas realizadas, de aquellos clientes que tienen
-- contratada la tarifa con el mayor coste de establecimiento.
SELECT c.nombre, c.apellidos, t.nombre AS nombre_tarifa, t.establecimiento, COUNT(ll.id_llamada) AS num_llamadas
FROM clientes c JOIN tarifas t ON c.tarifa = t.id_tarifa
LEFT JOIN llamadas ll ON c.id_cliente = ll.id_cliente
WHERE t.establecimiento = (SELECT MAX(establecimiento) FROM tarifas)
GROUP BY c.id_cliente, c.nombre, c.apellidos, t.nombre, t.establecimiento;

-- Muestra los nombres de las tarifas cuyos clientes ÚNICAMENTE han realizado llamadas
-- nacionales (tipo='N'), es decir, que no tienen ninguna llamada de tipo internacional ('I') ni
-- de redirección ('R').
SELECT DISTINCT t.nombre FROM tarifas t
JOIN clientes c ON t.id_tarifa = c.tarifa
JOIN llamadas ll ON c.id_cliente = ll.id_cliente
WHERE ll.tipo = 'N' AND t.id_tarifa NOT IN 
(
    SELECT c2.tarifa
    FROM clientes c2 JOIN llamadas ll2 ON c2.id_cliente = ll2.id_cliente
    WHERE ll2.tipo IN ('I', 'R')
);

-- Muestra todos los datos de las llamadas sobre las que se debe aplicar alguna promoción
-- vigente (cualquiera, no solo Navidad). Para cada llamada muestra también el nombre de la
-- promoción aplicable.
SELECT ll.*, p.nombre AS nombre_promocion
FROM llamadas ll
JOIN clientes c ON ll.id_cliente = c.id_cliente
JOIN promociones p ON c.tarifa = p.id_tarifa
WHERE ll.fecha BETWEEN p.fecha_inicio AND p.fecha_fin;

-- Muestra el nombre y apellidos de los clientes cuya tarifa es 'Normal' o 'Buena' y que no han
-- realizado ninguna llamada de tipo nacional ('N').
select c.nombre, c.apellidos
from clientes c join tarifas t on c.tarifa = t.id_tarifa
where t.nombre in ('Normal', 'Buena')
and not exists (select * from llamadas ll where ll.id_cliente = c.id_cliente and ll.tipo = 'N');

-- Muestra los datos de los clientes que han realizado MÁS llamadas que la media de su tarifa.
-- Indica también cuántas llamadas han hecho y en cuánto superan dicha media.
SELECT c.nombre, c.apellidos, COUNT(ll.id_llamada) AS llamadas_hechas,
       COUNT(ll.id_llamada) - (SELECT COUNT(l2.id_llamada) / (SELECT COUNT(*) FROM clientes c3 WHERE c3.tarifa = c.tarifa) FROM clientes c2 LEFT JOIN llamadas l2 ON c2.id_cliente = l2.id_cliente WHERE c2.tarifa = c.tarifa) AS diferencia_media
FROM clientes c
JOIN llamadas ll ON c.id_cliente = ll.id_cliente
GROUP BY c.id_cliente, c.nombre, c.apellidos, c.tarifa
HAVING llamadas_hechas > 
(
    SELECT COUNT(l2.id_llamada) / (SELECT COUNT(*) FROM clientes c3 WHERE c3.tarifa = c.tarifa)
    FROM clientes c2
    LEFT JOIN llamadas l2 ON c2.id_cliente = l2.id_cliente
    WHERE c2.tarifa = c.tarifa
);

-- Muestra el nombre y apellidos de los clientes cuyo total de minutos en llamadas
-- internacionales (tipo='I') supera los 5 minutos. Muestra también el total de minutos
-- internacionales.
SELECT c.nombre, c.apellidos, SUM(ll.duracion) AS total_minutos
FROM clientes c JOIN llamadas ll ON c.id_cliente = ll.id_cliente
WHERE ll.tipo = 'I'
GROUP BY c.id_cliente, c.nombre, c.apellidos HAVING SUM(ll.duracion) > 5;

-- Muestra el cliente más joven y el más mayor de CADA tarifa.
-- Para cada uno indica su nombre, apellidos, edad y el nombre de la tarifa.
SELECT c.nombre, c.apellidos, c.edad, t.nombre AS tarifa
FROM clientes c JOIN tarifas t ON c.tarifa = t.id_tarifa
WHERE c.edad = (SELECT MIN(edad) FROM clientes c2 WHERE c2.tarifa = c.tarifa) OR c.edad = (SELECT MAX(edad) FROM clientes c2 WHERE c2.tarifa = c.tarifa);

-- Muestra el nombre y apellidos de los clientes que no han realizado ninguna llamada en el
-- año 2025. Incluye también a los clientes que nunca han llamado.
SELECT nombre, apellidos FROM clientes
WHERE id_cliente NOT IN 
(
    SELECT id_cliente FROM llamadas WHERE YEAR(fecha) = 2025
);

-- Para cada llamada muestra el nombre y apellidos del cliente, la duración, la fecha y la
-- duración media de todas las llamadas del mismo tipo (nacional, internacional o
-- redirección).
SELECT c.nombre, c.apellidos, ll.duracion, ll.fecha, AVG(ll.duracion) OVER (PARTITION BY ll.tipo) AS media_tipo
FROM llamadas ll
JOIN clientes c ON ll.id_cliente = c.id_cliente;

-- Usando una CTE, muestra el nombre y apellidos de los clientes junto con el total de
-- minutos hablados. De la consulta principal muestra solo los que superan los 5 minutos en total.
WITH MinutosTotales AS (
    SELECT c.id_cliente, c.nombre, c.apellidos, SUM(ll.duracion) AS total_minutos
    FROM clientes c JOIN llamadas ll ON c.id_cliente = ll.id_cliente
    GROUP BY c.id_cliente, c.nombre, c.apellidos
)
SELECT nombre, apellidos, total_minutos FROM MinutosTotales WHERE total_minutos > 5;