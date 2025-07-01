# Proyecto Literatura - Gestión de Libros y Autores (ALURA)

## Descripción

Este proyecto es una aplicación en Java con Spring Boot para gestionar información de libros y autores. Consume datos desde la API pública [GutenDex](https://gutendex.com/) y almacena libros y autores en una base de datos local. Permite realizar búsquedas, listar libros filtrados por idioma, y mostrar estadísticas sobre los autores vivos en un año determinado.

---

## Funcionalidades principales

- Buscar libros por título a través de la API externa y guardar los datos en la base de datos.
- Mostrar listado de libros buscados localmente.
- Filtrar y mostrar libros por idioma.
- Listar autores almacenados.
- Mostrar autores que estuvieron vivos en un año dado (usando consultas derivadas y JPQL).
- Mostrar estadísticas de cantidad de libros por idioma.

---

## Tecnologías usadas

- Java 17+
- Spring Boot 3.x
- Spring Data JPA (Hibernate)
- Base de datos PostgreSQL
- Maven
- Consumo de API REST externa con RestTemplate o HttpClient
- Java Streams para procesamiento de colecciones

---

## Estructura del proyecto

- `controller`: Controladores para la lógica de negocio y comunicación con vistas.
- `service`: Servicios para la lógica de negocio y acceso a repositorios.
- `repository`: Interfaces JPA para acceso a datos.
- `model`: Entidades JPA que representan tablas en la base de datos.
- `dto`: Objetos para transferencia de datos.
- `view`: Clases que formatean y muestran información al usuario.

---

## Configuración

1. Configurar PostgreSQL y crear la base de datos.
2. Ajustar el archivo `application.properties` con la URL, usuario y contraseña de la base de datos.
3. Ejecutar la aplicación con Maven:

## Uso

En la consola se presenta un menú con opciones para buscar libros, listar libros, filtrar por idioma, listar autores y mostrar autores vivos en un año.

- Para buscar libros, se ingresa el título, que se consulta en la API externa y se guarda localmente.
- Para filtrar libros por idioma, se solicita un código de idioma (por ejemplo: `en`, `es`, `fr`) y se muestran los libros correspondientes usando Java Streams.
- Para listar autores vivos, se ingresa un año y el sistema muestra los autores que estaban vivos en esa fecha utilizando consultas derivadas (derived queries).

---

## Notas importantes

- La aplicación utiliza **consultas derivadas** (`derived queries`) y **JPQL** para optimizar las consultas a la base de datos.

---

## Autor

Luis Gonzalo Reyes Miranda
