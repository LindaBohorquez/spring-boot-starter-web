# Sistema de Gestión de Tareas — API REST

## 📌 Descripción del proyecto

Este proyecto corresponde al laboratorio de la Unidad 7: Patrones Arquitectónicos I.

Se implementa una API REST utilizando Spring Boot aplicando una **arquitectura en capas estricta**, separando responsabilidades entre presentación, lógica de negocio, dominio y persistencia.

El sistema permite gestionar tareas mediante operaciones CRUD y cambio de estado.

---

## 🧠 Arquitectura aplicada

Se implementa una arquitectura en capas con separación clara de responsabilidades:

- **Controller (Presentación)** → Manejo de solicitudes HTTP
- **Service (Aplicación)** → Lógica de negocio
- **Domain (Dominio)** → Entidades y reglas del negocio
- **Repository (Infraestructura)** → Acceso a datos

✔ No existen dependencias cruzadas entre capas  
✔ Se respeta el principio de responsabilidad única  
✔ El controlador no contiene lógica de negocio :contentReference[oaicite:0]{index=0}  

---

## 🏗️ Estructura del proyecto

com.universidad.tareas/
├── controller/
│ ├── TareaController.java
│ └── GlobalExceptionHandler.java
├── service/
│ └── TareaService.java
├── domain/
│ ├── TareaNotFoundException.java
│ └── model/
│ ├── Tarea.java
│ └── EstadoTarea.java
├── repository/
│ └── TareaRepository.java
└── TareasApplication.java



---

## 🧩 Tecnologías utilizadas

- Java 17+
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- H2 Database (base de datos en memoria)
- Jakarta Validation



## 📸 Evidencia de ejecución

A continuación se presentan las pruebas realizadas a los endpoints de la API REST utilizando Postman, verificando el correcto funcionamiento del sistema.

---

### 🟢 1. GET /api/tareas — Lista inicial

Se realiza una petición GET al iniciar el sistema, obteniendo una lista vacía.
 <img width="1176" height="736" alt="image" src="https://github.com/user-attachments/assets/0b1b0195-9f90-407f-861f-ad23b6204e1b" />


**Resultado esperado:**
- Código: 200 OK
- Respuesta: lista vacía

![GET inicial](img/get.png)

---

### 🟢 2. POST /api/tareas — Creación exitosa
<img width="1259" height="803" alt="image" src="https://github.com/user-attachments/assets/18e04f49-d322-4dd9-9b97-2dd3f00000c3" />  

Se crea una nueva tarea enviando un JSON válido.

**Body enviado:**
```json
{
  "titulo": "Estudiar Spring Boot",
  "descripcion": "Practicar arquitectura en capas"
}

---
----
## ⚙️ Ejecución del proyecto

### Requisitos:
- Java 17+
- Maven 3.8+

### Ejecutar:

```bash
mvn clean install
mvn spring-boot:run

