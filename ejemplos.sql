select*from profesor;
select*from modulo;
-- Selecciona alumnos que empiezen por J :)
select*from alumno where nombre like 'j%';
-- Mostrar profesores con numero de telefono
select nombre from profesor where Numero_Telefono is not null;
-- Mostrar alumnos que sean delegados
select*from alumno;
select*from alumno where Alumno_N_delegado is not null;
-- Mostrar nombre profesor que imparte modulo mates
select profesor.Nombre from profesor inner join modulo
 on profesor.codigo = modulo.Profesor_codigo 
 where modulo.Nombre='Matematicas';
-- Mostrar nombre y apellido de los alumnos en fisica
 select alumno.Nombre,alumno.Apellido from alumno inner join matricula 
 on alumno.N_Expendiente = matricula.Alumno_N_Expendiente
 inner join modulo on modulo.Codigo = matricula.Modulo_Codigo;