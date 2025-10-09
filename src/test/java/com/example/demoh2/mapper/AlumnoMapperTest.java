package com.example.demoh2.mapper;

import com.example.demoh2.domain.Alumno;
import com.example.demoh2.domain.Curso;
import com.example.demoh2.dto.AlumnoDTO;
import com.example.demoh2.dto.AlumnoResponseDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlumnoMapperTest {

    @Test
    void testToEntity() {
        AlumnoDTO dto = new AlumnoDTO();
        dto.setNombre("Juan");
        dto.setEmail("juan@correo.com");
        dto.setCursoId(1L);

        Curso curso = new Curso("Historia", "Profe García");
        curso.setId(1L);

        Alumno alumno = AlumnoMapper.toEntity(dto, curso);

        assertEquals("Juan", alumno.getNombre());
        assertEquals("juan@correo.com", alumno.getEmail());
        assertEquals(curso, alumno.getCurso());
    }

   @Test
void testToDTO() {
    Curso curso = new Curso("Matemáticas", "Einstein");
    curso.setId(2L);

    Alumno alumno = new Alumno("Lucía", "lucia@correo.com");
    alumno.setId(10L); // ✅ Aquí estaba el error
    alumno.setCurso(curso);

    AlumnoResponseDTO dto = AlumnoMapper.toDTO(alumno);

    assertEquals(10L, dto.getId());
    assertEquals("Lucía", dto.getNombre());
    assertEquals("lucia@correo.com", dto.getEmail());
    assertEquals(2L, dto.getCursoId());
    assertEquals("Matemáticas", dto.getCursoNombre());
}

}
