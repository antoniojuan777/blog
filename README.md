# Proyecto Blog – Evaluación de Capacidades Técnicas

Este proyecto implementa un sistema básico de gestión de **Autores**, **Blogs** y **Comentarios**, desarrollado con **Spring Boot** y siguiendo una arquitectura **orientada por features**.  
El objetivo es demostrar buenas prácticas en diseño estructurado, separación de responsabilidades y uso de herramientas modernas para construcción de APIs REST.

La organización por *features* permite que cada módulo funcional (Autor, Blog, Comentario) contenga sus propios controladores, servicios, entidades, repositorios y DTOs. Esto facilita la escalabilidad, mantenibilidad y comprensión del código a medida que la solución crece.

---

## 🛠️ Tecnologías y Estrategia de Implementación

- **Spring Boot 3.x**: framework principal para la creación de APIs REST.
- **Maven**: herramienta de construcción y gestión de dependencias.
- **Java 17**: versión mínima requerida.
- **OpenAPI/Swagger**: para documentación interactiva.
- Arquitectura **by feature**, favoreciendo bajo acoplamiento y alta cohesión.
- Manejo de excepciones con `@ControllerAdvice`, para centralizar las excepciones y tratarlas con una Clase `ApiError`. Con las excepciones personlizadas `BusinessException`, `NotFoundException`.

---

## 📦 Requisitos Previos

Asegúrate de tener instalados:

- **Java 17**
- **Maven 3.x.x** (o utilizar los wrappers incluidos)

---

## ▶️ Cómo Ejecutar el Proyecto

Desde la raíz del proyecto, ejecutar:

```bash
./mvnw spring-boot:run
```

Se levantara el servidor en el puerto 8080.

## 🚀 Prueba del proyecto

Debe seguir las siguientes reglas para poder probar el proyecto:

1. **Autor**
   - Crea un autor, lo cual genera un id de autor en formato uuid. `POST /api/autores`
   - Obtiene todos los autores. `GET /api/autores`

2. **Blog**
   - Crea un blog, considerando que se se pedira el ID del autor previamente creado. `POST /api/blogs`
   - Actualiza un blog, registrando su historial correspondiente. `PUT /api/blogs/{id}`
   - Obtiene un blog. `GET /api/blogs/{id}`
   - Obtiene todos los blogs. `GET /api/blogs`
   - Obtiene el historial de blogs. `GET /api/blogs/historial`
   - **Comentarios**
     - Crea un comentario, considerando que se pedira el ID del blog previamente creado, actualizando los datos de minimo y maximo de puntuacion. `POST /api/comentarios`

## 🗂 Documentación
Se puede acceder a la documentación de la API a través de la siguiente URL:

```bash
http://localhost:8080/swagger-ui.html
```
