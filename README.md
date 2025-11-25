# Proyecto Blog - EVALUACIÓN DE CAPACIDADES TÉCNICAS

El proyecto se implementó utilizando **Spring Boot** como framework principal para el desarrollo de servicios REST, aprovechando su robustez y facilidad de configuración para construir APIs modernas. La arquitectura se organizó **por features**, es decir, cada módulo funcional (Autor, Blog) se encapsula con sus propios controladores, servicios y DTOs, lo que facilita la separación de responsabilidades, escalabilidad y mantenibilidad del código.

---

## 📦 Requisitos del proyecto

Se debe tener JAVA 17 y maven 3.x.x instalados.

## ▶️ Ejecución del proyecto
Para ejecutar el proyecto se debe ejecutar el siguiente comando:

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
   - Crea un blog, considerando que se haya creado un autor previamente. `POST /api/blogs`
   - Actualiza un blog, registrando su historial correspondiente. `PUT /api/blogs/{id}`
   - Obtiene un blog. `GET /api/blogs/{id}`
   - Obtiene todos los blogs. `GET /api/blogs`
   - Obtiene el historial de blogs. `GET /api/blogs/historial`
   - **Comentarios**
     - Crea un comentario, considerando que se haya creado un blog previamente, actualizando los datos de minimo y maximo de puntuacion. `POST /api/comentarios`

## 🗂 Documentación
Se puede acceder a la documentación de la API a través de la siguiente URL:

```bash
http://localhost:8080/swagger-ui.html
```
