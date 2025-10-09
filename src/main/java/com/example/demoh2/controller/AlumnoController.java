package com.example.demoh2.controller;

import com.example.demoh2.domain.Alumno;
import com.example.demoh2.domain.Curso;
import com.example.demoh2.dto.AlumnoDTO;
import com.example.demoh2.service.AlumnoService;
import com.example.demoh2.service.CursoService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    private final AlumnoService alumnoService;
    private final CursoService cursoService;

    public AlumnoController(AlumnoService alumnoService, CursoService cursoService) {
        this.alumnoService = alumnoService;
        this.cursoService = cursoService;
    }

    // GET: listar todos los alumnos
    @GetMapping
    public List<Alumno> listar() {
        return alumnoService.listarTodos();
    }

    // POST: crear un nuevo alumno
    @PostMapping
    public Alumno crear(@RequestBody @Valid AlumnoDTO alumnoDTO) {
        Curso curso = cursoService.obtenerCursoPorId(alumnoDTO.getCursoId())
                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado"));

        Alumno alumno = new Alumno();
        alumno.setNombre(alumnoDTO.getNombre());
        alumno.setEmail(alumnoDTO.getEmail());
        alumno.setCurso(curso);

        return alumnoService.crearAlumno(alumno);
    }

    // GET: obtener alumno por ID
    @GetMapping("/{id}")
    public Alumno obtenerPorId(@PathVariable Long id) {
        return alumnoService.obtenerPorId(id).orElse(null);
    }

    // PUT: actualizar alumno por ID
    @PutMapping("/{id}")
    public Alumno actualizar(@PathVariable Long id, @RequestBody Alumno alumnoActualizado) {
        return alumnoService.actualizarAlumno(id, alumnoActualizado);
    }

    // DELETE: eliminar alumno por ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        alumnoService.eliminarAlumno(id);
    }
}
