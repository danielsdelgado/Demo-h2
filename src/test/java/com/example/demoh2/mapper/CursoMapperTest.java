package com.example.demoh2.mapper;

import com.example.demoh2.domain.Curso;
import com.example.demoh2.dto.CursoRequestDTO;
import com.example.demoh2.dto.CursoResponseDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CursoMapperTest {

    @Test
    void testToEntity() {
        CursoRequestDTO dto = new CursoRequestDTO("Física", "Newton");

        Curso curso = CursoMapper.toEntity(dto);

        assertEquals("Física", curso.getNombre());
        assertEquals("Newton", curso.getProfesor());
    }

    @Test
    void testToDTO() {
        Curso curso = new Curso("Programación", "Alan Turing");
        curso.setId(5L);

        CursoResponseDTO dto = CursoMapper.toDTO(curso);

        assertEquals(5L, dto.getId());
        assertEquals("Programación", dto.getNombre());
        assertEquals("Alan Turing", dto.getProfesor()); 
    }

}
