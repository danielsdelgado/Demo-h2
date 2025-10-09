package com.example.demoh2.service;

import com.example.demoh2.domain.Curso;
import com.example.demoh2.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> listarTodos() {
        return cursoRepository.findAll();
    }

    public Curso crearCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Optional<Curso> obtenerCursoPorId(Long id) {
        return cursoRepository.findById(id);
    }

    public Curso actualizarCurso(Long id, Curso cursoActualizado) {
        return cursoRepository.findById(id)
                .map(curso -> {
                    curso.setNombre(cursoActualizado.getNombre());
                    curso.setProfesor(cursoActualizado.getProfesor());
                    return cursoRepository.save(curso);
                })
                .orElse(null);
    }

    public void eliminarCurso(Long id) {
        cursoRepository.deleteById(id);
    }
}
