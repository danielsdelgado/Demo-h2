package com.example.demoh2.controller;

import com.example.demoh2.domain.Curso;
import com.example.demoh2.dto.CursoDTO;
import com.example.demoh2.service.CursoService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public List<Curso> listar() {
        return cursoService.listarTodos();
    }

    @PostMapping
    public Curso crear(@RequestBody @Valid CursoDTO cursoDTO) {
        Curso curso = new Curso();
        curso.setNombre(cursoDTO.getNombre());
        curso.setProfesor(cursoDTO.getProfesor());
        return cursoService.crearCurso(curso);
    }

    @GetMapping("/{id}")
    public Curso obtenerPorId(@PathVariable Long id) {
        return cursoService.obtenerCursoPorId(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Curso actualizar(@PathVariable Long id, @RequestBody Curso cursoActualizado) {
        return cursoService.actualizarCurso(id, cursoActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        cursoService.eliminarCurso(id);
    }
}
