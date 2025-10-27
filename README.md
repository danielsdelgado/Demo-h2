# 📘 Proyecto / Project: Gestión de Cursos y Alumnos / Courses & Students Management (Spring Boot + H2 + JavaScript)

---

<details>
<summary>ESPAÑOL 🇪🇸</summary>

## 🧩 Descripción

Este proyecto implementa una **aplicación web completa** desarrollada con **Spring Boot**, **H2 en memoria** y **JavaScript nativo (sin frameworks)**.
Permite gestionar **cursos** y **alumnos**, realizar operaciones **CRUD completas**, y probar **autenticación y roles** (profesor vs alumno) desde una interfaz web.

---

## ⚙️ Tecnologías utilizadas

### 🔹 Backend

* **Java 17+**
* **Spring Boot 3.3.x**

  * *Spring Web* → Exposición de endpoints REST.
  * *Spring Data JPA* → Persistencia con Hibernate.
  * *Spring Validation (Jakarta)* → Validación de datos.
  * *Spring Security* → Autenticación básica (`profe:admin`, `alumno:1234`).
  * *H2 Database* → Base de datos en memoria para pruebas.
* **Hibernate** → ORM para mapear entidades a tablas.
* **Maven** → Gestión de dependencias y compilación.

### 🔹 Frontend

* **HTML5 + CSS3 + JavaScript ES6**
* **Fetch API** para comunicación con el backend.
* **Basic Auth** para autenticar roles.
* **DOM dinámico** para mostrar cursos y alumnos.
* **Formularios HTML** para crear, actualizar y eliminar registros.

---

## 🧠 Conceptos Java aplicados

* Programación Orientada a Objetos (clases, entidades, encapsulación).
* Anotaciones JPA (`@Entity`, `@ManyToOne`, `@JoinColumn`).
* Validación con anotaciones (`@NotBlank`, `@Email`, `@NotNull`).
* Patrón **DTO + Mapper** para separar capas.
* Uso de `Optional` y `ResponseEntity` para manejar respuestas.
* Arquitectura MVC (Controller → Service → Repository).

---

## 🧩 Estructura del proyecto

```
src/
 └── main/
     ├── java/com/example/demoh2/
     │   ├── controller/
     │   ├── service/
     │   ├── repository/
     │   ├── domain/
     │   ├── dto/
     │   └── mapper/
     └── resources/
         ├── static/
         │   ├── index.html
         │   └── scripts/script.js
         ├── application.properties
         └── templates/
```

---

## 🌐 Endpoints principales

**Base URL:** `http://localhost:8081/api`

### 👩‍🏫 Cursos

| Método | Endpoint       | Descripción            |
| ------ | -------------- | ---------------------- |
| GET    | `/cursos`      | Lista todos los cursos |
| POST   | `/cursos`      | Crea un curso          |
| PUT    | `/cursos/{id}` | Actualiza un curso     |
| DELETE | `/cursos/{id}` | Elimina un curso       |

### 👨‍🎓 Alumnos

| Método | Endpoint        | Descripción             |
| ------ | --------------- | ----------------------- |
| GET    | `/alumnos`      | Lista todos los alumnos |
| POST   | `/alumnos`      | Crea un alumno          |
| PUT    | `/alumnos/{id}` | Actualiza un alumno     |
| DELETE | `/alumnos/{id}` | Elimina un alumno       |

---

## 🖥️ Interfaz HTML

* Formularios para crear, actualizar y eliminar cursos y alumnos.
* Tablas dinámicas que se rellenan automáticamente con datos de la API.
* Botones para pruebas de roles y seguridad.

**Ejemplo visual:**

```
Gestión de Cursos y Alumnos
 ├─ Crear / Actualizar / Eliminar Curso
 ├─ Crear / Actualizar / Eliminar Alumno
 ├─ Tablas de cursos y alumnos
 └─ Botones de prueba de roles y seguridad
```

---

## 🔒 Pruebas de seguridad

| Botón                       | Acción                               | Usuario       |
| --------------------------- | ------------------------------------ | ------------- |
| 🔐 Acceso solo ADMIN        | Accede a `/api/admin/secret`         | `profe:admin` |
| 👩‍🎓 Acceso alumno         | Accede a `/api/hola`                 | `alumno:1234` |
| 📚 Leer alumnos como alumno | GET `/api/alumnos` con rol de alumno | `alumno:1234` |
| 🚫 Crear alumno como alumno | POST `/api/alumnos` prohibido        | `alumno:1234` |
| ❌ Sin credenciales          | Acceso público                       | —             |

---

## 🧰 Configuración (`application.properties`)

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
server.port=8081
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.jpa.show-sql=true
```

**Consola H2:** [http://localhost:8081/h2-console](http://localhost:8081/h2-console)
Usuario: `sa`
URL: `jdbc:h2:mem:testdb`

---

## ▶️ Ejecución

```bash
git clone https://github.com/tuusuario/proyectomavenpersistentdatabase.git
cd proyectomavenpersistentdatabase
mvn clean install
mvn spring-boot:run
```

Abrir en el navegador: [http://localhost:8081](http://localhost:8081)

</details>

<details>
<summary>ENGLISH 🇬🇧</summary>

## 🧩 Description

This project is a **full-stack web application** built with **Spring Boot**, **in-memory H2**, and **vanilla JavaScript (no frameworks)**.
It allows managing **courses** and **students**, performing **full CRUD operations**, and testing **authentication and roles** (teacher vs student) via a web interface.

---

## ⚙️ Technologies Used

### 🔹 Backend

* **Java 17+**
* **Spring Boot 3.3.x**

  * *Spring Web* → Exposes REST endpoints.
  * *Spring Data JPA* → Persistence with Hibernate.
  * *Spring Validation (Jakarta)* → Data validation.
  * *Spring Security* → Basic authentication (`profe:admin`, `alumno:1234`).
  * *H2 Database* → In-memory database for testing.
* **Hibernate** → ORM to map entities to tables.
* **Maven** → Dependency management and build.

### 🔹 Frontend

* **HTML5 + CSS3 + JavaScript ES6**
* **Fetch API** to communicate with the backend.
* **Basic Auth** to authenticate roles.
* **Dynamic DOM** to display courses and students.
* **HTML forms** to create, update, and delete records.

---

## 🧠 Applied Java Concepts

* Object-Oriented Programming (classes, entities, encapsulation).
* JPA annotations (`@Entity`, `@ManyToOne`, `@JoinColumn`).
* Validation annotations (`@NotBlank`, `@Email`, `@NotNull`).
* **DTO + Mapper** pattern to separate layers.
* Usage of `Optional` and `ResponseEntity` for responses.
* MVC architecture (Controller → Service → Repository).

---

## 🧩 Project Structure

```
src/
 └── main/
     ├── java/com/example/demoh2/
     │   ├── controller/
     │   ├── service/
     │   ├── repository/
     │   ├── domain/
     │   ├── dto/
     │   └── mapper/
     └── resources/
         ├── static/
         │   ├── index.html
         │   └── scripts/script.js
         ├── application.properties
         └── templates/
```

---

## 🌐 Main Endpoints

**Base URL:** `http://localhost:8081/api`

### 👩‍🏫 Courses

| Method | Endpoint       | Description      |
| ------ | -------------- | ---------------- |
| GET    | `/cursos`      | List all courses |
| POST   | `/cursos`      | Create a course  |
| PUT    | `/cursos/{id}` | Update a course  |
| DELETE | `/cursos/{id}` | Delete a course  |

### 👨‍🎓 Students

| Method | Endpoint        | Description       |
| ------ | --------------- | ----------------- |
| GET    | `/alumnos`      | List all students |
| POST   | `/alumnos`      | Create a student  |
| PUT    | `/alumnos/{id}` | Update a student  |
| DELETE | `/alumnos/{id}` | Delete a student  |

---

## 🖥️ HTML Interface

* Forms to create, update, and delete courses and students.
* Dynamic tables automatically filled with API data.
* Buttons to test roles and security.

**Example view:**

```
Courses & Students Management
 ├─ Create / Update / Delete Course
 ├─ Create / Update / Delete Student
 ├─ Courses & students tables
 └─ Role & security test buttons
```

---

## 🔒 Security Tests

| Button                       | Action                        | User          |
| ---------------------------- | ----------------------------- | ------------- |
| 🔐 Admin only                | Access `/api/admin/secret`    | `profe:admin` |
| 👩‍🎓 Student access         | Access `/api/hola`            | `alumno:1234` |
| 📚 List students as student  | GET `/api/alumnos` as student | `alumno:1234` |
| 🚫 Create student as student | POST `/api/alumnos` forbidden | `alumno:1234` |
| ❌ Public access              | Access without credentials    | —             |

---

## 🧰 Configuration (`application.properties`)

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
server.port=8081
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.jpa.show-sql=true
```

**H2 Console:** [http://localhost:8081/h2-console](http://localhost:8081/h2-console)
User: `sa`
URL: `jdbc:h2:mem:testdb`

---

## ▶️ Running

```bash
git clone https://github.com/tuusuario/proyectomavenpersistentdatabase.git
cd proyectomavenpersistentdatabase
mvn clean install
mvn spring-boot:run
```

Open in browser: [http://localhost:8081](http://localhost:8081)

</details> 
