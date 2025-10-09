package com.example.demoh2.repository;

import com.example.demoh2.domain.Alumno;
import com.example.demoh2.domain.Curso;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AlumnoRepositoryTest {

    @Autowired
    private CursoRepository cursoRepo;

    @Autowired
    private AlumnoRepository alumnoRepo;

    @Test
    void guardarCursoConAlumnos_cascadaFunciona() {
        // Arrange
        Curso curso = new Curso("Spring Java", "Antonio Resines");
        Alumno alumno = new Alumno("Ana", "ana@ex.com");

        curso.getAlumnos().add(alumno);
        alumno.setCurso(curso); // Importante establecer ambos lados de la relación

        // Act
        Curso guardado = cursoRepo.save(curso); // debería guardar también al alumno por cascada

        // Assert
        assertThat(guardado.getId()).isNotNull();
        List<Alumno> alumnos = alumnoRepo.findAll();
        assertThat(alumnos).hasSize(1);
        assertThat(alumnos.get(0).getNombre()).isEqualTo("Ana");
    }
}
