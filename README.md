# API RESTFUL - Gestión de tareas

### Deescripción:
API RESTful desarrollada con Spring Boot para la gestión de tareas. Permite crear, consultar, actualizar, eliminar y filtrar tareas según distintos criterios como estado, categoría, prioridad, etiquetas o título.

Este proyecto forma parte de la actividad del módulo Acceso a Datos.

---

### Requisitos previos:
- JDK 21
- Extensión Lombok (IntelliJ)

---

## Tecnologías utilizadas
- Java 17
- Spring Boot
- Spring Data MongoDB
- MongoDB
- Maven
- Postman / Thunder Client

---

## Estructura del proyecto
- controller: Controladores REST
- service: Lógica de negocio
- repository: Acceso a datos con MongoDB
- model: Entidad Task y enumerados
- exception: Gestión de excepciones personalizadas

---

### Modelo de datos (Task)

```json
{
  "id": "string",
  "title": "string",
  "description": "string",
  "completed": false,
  "priority": "ALTA | MEDIA | BAJA",
  "category": "string",
  "tags": ["string"],
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime",
  "dueDate": "LocalDateTime"
}

```
---

### Endpoints de la API

#### Crear nueva tarea

POST /api/tasks

#### Obtener todas las tareas

GET /api/tasks

#### Obtener tarea por ID

GET /api/tasks/{id}

#### Actualizar tarea completa

PUT /api/tasks/{id}

#### Marcar tarea como completada

PATCH /api/tasks/{id}/complete

#### Marcar tarea como no completada

PATCH /api/tasks/{id}/incomplete

#### Eliminar tarea

DELETE /api/tasks/{id}

#### Obtener tareas completadas

GET /api/tasks/completed

#### Obtener tareas pendientes

GET /api/tasks/pending

#### Buscar tareas por categoría

GET /api/tasks/category/{category}

#### Buscar tareas por etiqueta

GET /api/tasks/tag/{tag}

#### Buscar tareas por prioridad

GET /api/tasks/priority/{priority}

#### Buscar tareas por título

GET /api/tasks/search?title={title}

---

### Ejemplo de petición:

#### Crear nueva tarea

POST http://localhost:8080/api/tasks

Cuerpo:
```json
{
  "title": "Corregir prácticas pendientes",
  "description": "Revisar prácticas entregadas con errores",
  "completed": true,
  "priority": "BAJA",
  "category": "Estudios",
  "tags": ["Prácticas"],
  "dueDate": "2025-12-17T14:00:00"
}
```

---

### Ejecución del proyecto

1. Clonar el repositorio.

```bash
git clone https://github.com/Larian-DAM/API_GestionDeTareas_Larian.git
```

2. Configurar la conexión a MongoDB en el archivo `application.properties`.

```bash
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=taskmanager
```
