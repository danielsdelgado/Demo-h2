const API_BASE = 'http://localhost:8081/api';
const authProfe = 'Basic ' + btoa('profe:admin');
const authAlumno = 'Basic ' + btoa('alumno:1234');

async function cargarCursos() {
    const res = await fetch(`${API_BASE}/cursos`, {
        headers: { 'Authorization': authProfe }
    });
    const cursos = await res.json();
    const tbody = document.getElementById('tablaCursos').querySelector('tbody');
    tbody.innerHTML = '';
    cursos.forEach(curso => {
        tbody.innerHTML += `<tr>
            <td>${curso.id}</td>
            <td>${curso.nombre}</td>
            <td>${curso.profesor}</td>
        </tr>`;
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
        tbody.innerHTML += `<tr>
            <td>${alumno.id}</td>
            <td>${alumno.nombre}</td>
            <td>${alumno.email}</td>
            <td>${alumno.cursoNombre || '—'}</td>
        </tr>`;
    });
}

window.onload = () => {
    cargarCursos();
    cargarAlumnos();
};

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
    alert('Curso creado');
    cargarCursos();
});

document.getElementById('actualizarCursoForm').addEventListener('submit', async (e) => {
    e.preventDefault();
    const id = document.getElementById('cursoIdActualizar').value;
    const nombre = document.getElementById('nuevoNombreCurso').value;
    const profesor = document.getElementById('nuevoProfesorCurso').value;
    await fetch(`${API_BASE}/cursos/${id}`, {
        method: 'PUT',
        headers: {
            'Authorization': authProfe,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ nombre, profesor })
    });
    alert('Curso actualizado');
    cargarCursos();
});

document.getElementById('eliminarCursoForm').addEventListener('submit', async (e) => {
    e.preventDefault();
    const id = document.getElementById('cursoIdEliminar').value;
    await fetch(`${API_BASE}/cursos/${id}`, {
        method: 'DELETE',
        headers: { 'Authorization': authProfe }
    });
    alert('Curso eliminado');
    cargarCursos();
});

document.getElementById('crearAlumnoForm').addEventListener('submit', async (e) => {
    e.preventDefault();
    const nombre = document.getElementById('nombreAlumno').value;
    const email = document.getElementById('emailAlumno').value;
    const cursoId = document.getElementById('cursoIdAlumno').value;
    await fetch(`${API_BASE}/alumnos`, {
        method: 'POST',
        headers: {
            'Authorization': authProfe,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ nombre, email, cursoId })
    });
    alert('Alumno creado');
    cargarAlumnos();
});

document.getElementById('actualizarAlumnoForm').addEventListener('submit', async (e) => {
    e.preventDefault();
    const id = document.getElementById('alumnoIdActualizar').value;
    const nombre = document.getElementById('nuevoNombreAlumno').value;
    const email = document.getElementById('nuevoEmailAlumno').value;
    const cursoId = document.getElementById('nuevoCursoIdAlumno').value;
    await fetch(`${API_BASE}/alumnos/${id}`, {
        method: 'PUT',
        headers: {
            'Authorization': authProfe,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ nombre, email, cursoId })
    });
    alert('Alumno actualizado');
    cargarAlumnos();
});

document.getElementById('eliminarAlumnoForm').addEventListener('submit', async (e) => {
    e.preventDefault();
    const id = document.getElementById('alumnoIdEliminar').value;
    await fetch(`${API_BASE}/alumnos/${id}`, {
        method: 'DELETE',
        headers: { 'Authorization': authProfe }
    });
    alert('Alumno eliminado');
    cargarAlumnos();
});

// Pruebas
async function accesoAdmin() {
    const res = await fetch('http://localhost:8080/api/admin/secret', {
        headers: { 'Authorization': authProfe }
    });
    alert(`Status: ${res.status}\nRespuesta: ${await res.text()}`);
}

async function accesoAlumno() {
    const res = await fetch('http://localhost:8080/api/hola', {
        headers: { 'Authorization': authAlumno }
    });
    alert(`Status: ${res.status}\nRespuesta: ${await res.text()}`);
}

async function leerAlumnosComoAlumno() {
    const res = await fetch('http://localhost:8080/api/alumnos', {
        headers: { 'Authorization': authAlumno }
    });
    const data = await res.json();
    alert(JSON.stringify(data));
}

async function crearAlumnoComoAlumno() {
    const res = await fetch('http://localhost:8080/api/alumnos', {
        method: 'POST',
        headers: {
            'Authorization': authAlumno,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ nombre: 'Ana' })
    });
    alert(`Status: ${res.status}\nRespuesta: ${await res.text()}`);
}

async function sinCredenciales() {
    const res = await fetch('http://localhost:8081/api/hola');
    alert(`Status: ${res.status}\nRespuesta: ${await res.text()}`);
}
