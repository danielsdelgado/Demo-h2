package com.example.demoh2.repository;

import com.example.demoh2.domain.Alumno;
import com.example.demoh2.domain.Curso; 
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CursoRepositoryTest {

    @Autowired
    private CursoRepository cursoRepo;

    @Autowired
    private AlumnoRepository alumnoRepo;

    @Test
    void guardarCursoConAlumnos_cascadaFunciona() {
        // Arrange
        Curso curso = new Curso("Spring Java", "Antonio Resines");
        Alumno alumno = new Alumno("Ana", "ana@ex.com");

        // Relación bidireccional
        alumno.setCurso(curso);
        curso.getAlumnos().add(alumno);

        // Act
        Curso guardado = cursoRepo.save(curso); // Cascada guarda alumno también

        // Assert
        assertThat(guardado.getId()).isNotNull();
        assertThat(alumnoRepo.findAll()).hasSize(1);
        assertThat(alumnoRepo.findAll().get(0).getNombre()).isEqualTo("Ana");
    }

    @Test
    void eliminarCursoConAlumnos_cascadaFunciona() {
        // Arrange
        Curso curso = new Curso("Matemáticas", "Profesor Einstein");
        Alumno a1 = new Alumno("Carlos", "carlos@correo.com");
        Alumno a2 = new Alumno("Lucía", "lucia@correo.com");

        // Establecer relaciones bidireccionales
        a1.setCurso(curso);
        a2.setCurso(curso);
        curso.getAlumnos().add(a1);
        curso.getAlumnos().add(a2);

        // Guardar curso (y alumnos por cascada)
        cursoRepo.save(curso);

        // Asegurar que se guardaron
        assertThat(cursoRepo.findAll()).hasSize(1);
        assertThat(alumnoRepo.findAll()).hasSize(2);

        // Act: eliminar curso
        cursoRepo.delete(curso);

        // Assert: alumnos deben eliminarse también por cascada
        assertThat(cursoRepo.findAll()).isEmpty();
        assertThat(alumnoRepo.findAll()).isEmpty();
    }
}
