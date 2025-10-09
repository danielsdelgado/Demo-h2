package com.example.demoh2.service;

import com.example.demoh2.domain.Alumno;
import com.example.demoh2.repository.AlumnoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {

    private final AlumnoRepository alumnoRepository;

    public AlumnoService(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    public List<Alumno> listarTodos() {
        return alumnoRepository.findAll();
    }

    public Alumno crearAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public Optional<Alumno> obtenerPorId(Long id) {
        return alumnoRepository.findById(id);
    }

    public Alumno actualizarAlumno(Long id, Alumno alumnoActualizado) {
        return alumnoRepository.findById(id)
                .map(alumno -> {
                    alumno.setNombre(alumnoActualizado.getNombre());
                    alumno.setEmail(alumnoActualizado.getEmail());
                    alumno.setCurso(alumnoActualizado.getCurso());
                    return alumnoRepository.save(alumno);
                })
                .orElse(null);
    }

    public void eliminarAlumno(Long id) {
        alumnoRepository.deleteById(id);
    }
}
