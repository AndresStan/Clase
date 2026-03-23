-- 1.	Agrega la dirección "Mayor, 10 Teruel" al cliente que tiene DNI "022222222R".
update cliente
set Direccion = "Mayor, 10 Teruel"
where DNI = "022222222R"


-- 2.	Cambia todos los nombres de los clientes para que todos los caracteres se almacenen con letras mayúsculas.
update cliente
set Nombre = UPPER(Nombre) 

-- 3.	Añade una película con código 6 con título 'Lo que el agua se
-- llevó' del género de 'Drama' que es la segunda parte de la película 'Lo que el viento se llevó'
-- (de la que conocemos el código: 4) y el actor principal es ' Eva '.

insert into pelicula 
(CodPeli, Titulo, CodGenero, SegundaParte, CodActor)
values 
(
	6,
	"Lo que el agua se llevo", 
	(SELECT CodGenero FROM genero WHERE Descripcion = 'Drama'), 
	(SELECT t.CodPeli FROM (SELECT CodPeli FROM pelicula WHERE Titulo = 'Lo que el viento se llevo') t),
	(select CodActor from actor where Nombre = "Eva")
)

-- 4.	Añadimos una copia con código de copia 1 de la película que tiene código 6.
insert into copia
(CodPeli, CodCopia)
values
(
	6,
	1
)



-- 5.	Creamos una nueva factura (con código de factura 4) para 'Pedro Martínez Martínez' para la fecha actual. El importe será 0, por el momento.
insert into factura
(CodFactura, Fecha, Importe, DNI)
values
(
	4,
	CURDATE(),
	0,
	(select DNI from cliente where Nombre = "PEDRO MARTINEZ ROY")
)

