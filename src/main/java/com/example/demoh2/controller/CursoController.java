package com.example.demoh2.controller;

import com.example.demoh2.dto.CursoDTO;
import com.example.demoh2.dto.CursoResponseDTO;
import com.example.demoh2.mapper.CursoMapper;
import com.example.demoh2.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    // GET: listar todos los cursos
    @GetMapping
    public List<CursoResponseDTO> listar() {
        return cursoService.listarTodos()
                .stream()
                .map(CursoMapper::toDTO)
                .collect(Collectors.toList());
    }

    // POST: crear nuevo curso
    @PostMapping
    public CursoResponseDTO crear(@RequestBody @Valid CursoDTO cursoDTO) {
        var curso = CursoMapper.toEntity(cursoDTO);
        var creado = cursoService.crearCurso(curso);
        return CursoMapper.toDTO(creado);
    }

    // GET: obtener curso por ID
    @GetMapping("/{id}")
    public CursoResponseDTO obtenerPorId(@PathVariable Long id) {
        return cursoService.obtenerCursoPorId(id)
                .map(CursoMapper::toDTO)
                .orElse(null); // Puedes lanzar excepción si prefieres
    }

    // PUT: actualizar curso
    @PutMapping("/{id}")
    public CursoResponseDTO actualizar(@PathVariable Long id, @RequestBody @Valid CursoDTO cursoDTO) {
        var cursoActualizado = CursoMapper.toEntity(cursoDTO);
        var actualizado = cursoService.actualizarCurso(id, cursoActualizado);
        return CursoMapper.toDTO(actualizado);
    }

    // DELETE: eliminar curso
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        cursoService.eliminarCurso(id);
    }
}
