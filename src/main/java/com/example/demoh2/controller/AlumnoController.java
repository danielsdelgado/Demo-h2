package com.example.demoh2.controller;

import com.example.demoh2.domain.Curso;
import com.example.demoh2.dto.AlumnoRequestDTO;
import com.example.demoh2.dto.AlumnoResponseDTO;
import com.example.demoh2.mapper.AlumnoMapper;
import com.example.demoh2.service.AlumnoService;
import com.example.demoh2.service.CursoService;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    private final AlumnoService alumnoService;
    private final CursoService cursoService;

    public AlumnoController(AlumnoService alumnoService, CursoService cursoService) {
        this.alumnoService = alumnoService;
        this.cursoService = cursoService;
    }

    @GetMapping("/hola")
    public ResponseEntity<String> hola() {
        return ResponseEntity.ok("Hola");
    }

    // GET: listar todos los alumnos
    @GetMapping
    public List<AlumnoResponseDTO> listar() {
        return alumnoService.listarTodos()
                .stream()
                .map(AlumnoMapper::toDTO)
                .collect(Collectors.toList());
    }

    // POST: crear un nuevo alumno
    @PostMapping
    public AlumnoResponseDTO crear(@RequestBody @Valid AlumnoRequestDTO alumnoDTO) {
        Curso curso = cursoService.obtenerCursoPorId(alumnoDTO.getCursoId())
                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado"));

        var alumno = AlumnoMapper.toEntity(alumnoDTO, curso);
        var creado = alumnoService.crearAlumno(alumno);
        return AlumnoMapper.toDTO(creado);
    }

    // GET: obtener alumno por ID
    @GetMapping("/{id}")
    public AlumnoResponseDTO obtenerPorId(@PathVariable Long id) {
        return alumnoService.obtenerPorId(id)
                .map(AlumnoMapper::toDTO)
                .orElse(null); // Puedes lanzar una excepción personalizada si prefieres
    }

    // PUT: actualizar alumno por ID
    @PutMapping("/{id}")
    public AlumnoResponseDTO actualizar(@PathVariable Long id, @RequestBody @Valid AlumnoRequestDTO alumnoDTO) {
        Curso curso = cursoService.obtenerCursoPorId(alumnoDTO.getCursoId())
                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado"));

        var alumnoActualizado = AlumnoMapper.toEntity(alumnoDTO, curso);

        var actualizado = alumnoService.actualizarAlumno(id, alumnoActualizado);
        return AlumnoMapper.toDTO(actualizado);
    }

    // DELETE: eliminar alumno por ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        alumnoService.eliminarAlumno(id);
    }
}
