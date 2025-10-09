package com.example.demoh2.mapper;

import com.example.demoh2.domain.Curso;
import com.example.demoh2.dto.CursoDTO;
import com.example.demoh2.dto.CursoResponseDTO;

public class CursoMapper {

    public static Curso toEntity(CursoDTO dto) {
        Curso curso = new Curso();
        curso.setNombre(dto.getNombre());
        curso.setProfesor(dto.getProfesor());
        return curso;
    }

    public static CursoResponseDTO toDTO(Curso curso) {
        return new CursoResponseDTO(
                curso.getId(),
                curso.getNombre(),
                curso.getProfesor()
        );
    }
}
