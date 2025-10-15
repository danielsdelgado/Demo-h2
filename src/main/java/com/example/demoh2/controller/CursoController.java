Aquí tienes el archivo `index.html` completo, con **todos los cambios integrados**:

* Tablas para **listar cursos** y **alumnos**.
* Estilo coherente con el resto de la página.
* Funciones JS para cargar los datos al inicio y tras operaciones.
* Llamadas a `cargarCursos()` y `cargarAlumnos()` luego de crear/actualizar/eliminar.

---

### ✅ Archivo `index.html` completo:

```html
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Gestión de Cursos y Alumnos</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
            background-color: #f4f4f4;
        }

        h1, h2 {
            color: #333;
        }

        form {
            background-color: #fff;
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            max-width: 500px;
        }

        input, button {
            display: block;
            margin: 10px 0;
            padding: 8px;
            width: 100%;
            box-sizing: border-box;
        }

        button {
            background-color: #0066cc;
            color: white;
            border: none;
            cursor: pointer;
        }

        button:hover {
            background-color: #004999;
        }

        .test-buttons button {
            width: auto;
            margin-right: 10px;
            margin-bottom: 10px;
        }

        .test-buttons {
            margin-top: 30px;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            background-color: #fff;
            margin-bottom: 40px;
            max-width: 800px;
        }

        th, td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #f0f0f0;
        }
    </style>
</head>
<body>
    <h1>Gestión de Cursos y Alumnos</h1>

    <h2>Crear Curso</h2>
    <form id="crearCursoForm">
        <input type="text" id="nombreCurso" placeholder="Nombre del curso" required>
        <input type="text" id="profesorCurso" placeholder="Nombre del profesor" required>
        <button type="submit">Crear Curso</button>
    </form>

    <h2>Actualizar Curso</h2>
    <form id="actualizarCursoForm">
        <input type="number" id="cursoIdActualizar" placeholder="ID del curso" required>
        <input type="text" id="nuevoNombreCurso" placeholder="Nuevo nombre" required>
        <input type="text" id="nuevoProfesorCurso" placeholder="Nuevo profesor" required>
        <button type="submit">Actualizar Curso</button>
    </form>

    <h2>Eliminar Curso</h2>
    <form id="eliminarCursoForm">
        <input type="number" id="cursoIdEliminar" placeholder="ID del curso a eliminar" required>
        <button type="submit">Eliminar Curso</button>
    </form>

    <h2>Crear Alumno</h2>
    <form id="crearAlumnoForm">
        <input type="text" id="nombreAlumno" placeholder="Nombre del alumno" required>
        <input type="email" id="emailAlumno" placeholder="Email del alumno" required>
        <input type="number" id="cursoIdAlumno" placeholder="ID del curso" required>
        <button type="submit">Crear Alumno</button>
    </form>

    <h2>Actualizar Alumno</h2>
    <form id="actualizarAlumnoForm">
        <input type="number" id="alumnoIdActualizar" placeholder="ID del alumno" required>
        <input type="text" id="nuevoNombreAlumno" placeholder="Nuevo nombre" required>
        <input type="email" id="nuevoEmailAlumno" placeholder="Nuevo email" required>
        <input type="number" id="nuevoCursoIdAlumno" placeholder="Nuevo ID curso" required>
        <button type="submit">Actualizar Alumno</button>
    </form>

    <h2>Eliminar Alumno</h2>
    <form id="eliminarAlumnoForm">
        <input type="number" id="alumnoIdEliminar" placeholder="ID del alumno a eliminar" required>
        <button type="submit">Eliminar Alumno</button>
    </form>

    <h2>Lista de Cursos</h2>
    <table id="tablaCursos">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Profesor</th>
            </tr>
        </thead>
        <tbody></tbody>
    </table>

    <h2>Lista de Alumnos</h2>
    <table id="tablaAlumnos">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Email</th>
                <th>Curso</th>
            </tr>
        </thead>
        <tbody></tbody>
    </table>

    <div class="test-buttons">
        <h2>Pruebas de Seguridad y Autorización</h2>
        <button onclick="accesoAdmin()">🔐 Acceso solo ADMIN (/admin/secret)</button>
        <button onclick="accesoAlumno()">👩‍🎓 Acceso alumno (/hola)</button>
        <button onclick="leerAlumnosComoAlumno()">📚 Leer alumnos como alumno</button>
        <button onclick="crearAlumnoComoAlumno()">🚫 Crear alumno como alumno (prohibido)</button>
        <button onclick="sinCredenciales()">❌ Acceso sin credenciales (/hola)</button>
    </div>

    <script>
        const API_BASE = 'http://localhost:8081/api';
        const authProfe = 'Basic ' + btoa('profe:admin');
        const authAlumno = 'Basic ' + btoa('alumno:1234');

        // Funciones para cargar las tablas
        async function cargarCursos() {
            const res = await fetch(`${API_BASE}/cursos`, {
                headers: { 'Authorization': authProfe }
            });
            const cursos = await res.json();
            const tbody = document.getElementById('tablaCursos').querySelector('tbody');
            tbody.innerHTML = '';
            cursos.forEach(curso => {
                const row = `<tr>
                    <td>${curso.id}</td>
                    <td>${curso.nombre}</td>
                    <td>${curso.profesor}</td>
                </tr>`;
                tbody.innerHTML += row;
            });
        }

        async function cargarAlumnos() {
            const res = await fetch(`${API_BASE}/alumnos`, {
                headers: { 'Authorization': authProfe }
            });
            const alumnos = await res.json();
            const tbody = document.getElementById('tablaAlumnos').querySelector('tbody');
            tbody.innerHTML = '';
            alumnos.forEach(alumno => {
                const row = `<tr>
                    <td>${alumno.id}</td>
                    <td>${alumno.nombre}</td>
                    <td>${alumno.email}</td>
                    <td>${alumno.cursoNombre || '—'}</td>
                </tr>`;
                tbody.innerHTML += row;
            });
        }

        // Al cargar la página
        window.onload = () => {
            cargarCursos();
            cargarAlumnos();
        };

        // Crear curso
        document.getElementById('crearCursoForm').addEventListener('submit', async (e) => {
            e.preventDefault();
            const nombre = document.getElementById('nombreCurso').value;
            const profesor = document.getElementById('profesorCurso').value;
            const res = await fetch(`${API_BASE}/cursos`, {
                method: 'POST',
                headers: {
                    'Authorization': authProfe,
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ nombre, profesor })
            });
            const data = await res.json();
            alert('Curso creado: ' + JSON.stringify(data));
            cargarCursos();
        });

        // Actualizar curso
        document.getElementById('actualizarCursoForm').addEventListener('submit', async (e) => {
            e.preventDefault();
            const id = document.getElementById('cursoIdActualizar').value;
            const nombre = document.getElementById('nuevoNombreCurso').value;
            const profesor = document.getElementById('nuevoProfesorCurso').value;
            const res = await fetch(`${API_BASE}/cursos/${id}`, {
                method: 'PUT',
                headers: {
                    'Authorization': authProfe,
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ nombre, profesor })
            });
            const data = await res.json();
            alert('Curso actualizado: ' + JSON.stringify(data));
            cargarCursos();
        });

        // Eliminar curso
        document.getElementById('eliminarCursoForm').addEventListener('submit', async (e) => {
            e.preventDefault();
            const id = document.getElementById('cursoIdEliminar').value;
            const res = await fetch(`${API_BASE}/cursos/${id}`, {
                method: 'DELETE',
                headers: { 'Authorization': authProfe }
            });
            alert('Curso eliminado (status ' + res.status +
```
