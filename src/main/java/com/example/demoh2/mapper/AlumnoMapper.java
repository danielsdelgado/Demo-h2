package com.example.demoh2.mapper;

import com.example.demoh2.domain.Alumno;
import com.example.demoh2.domain.Curso;
import com.example.demoh2.dto.AlumnoDTO;
import com.example.demoh2.dto.AlumnoResponseDTO;

public class AlumnoMapper {

    public static Alumno toEntity(AlumnoDTO dto, Curso curso) {
        Alumno alumno = new Alumno();
        alumno.setNombre(dto.getNombre());
        alumno.setEmail(dto.getEmail());
        alumno.setCurso(curso);
        return alumno;
    }

    public static AlumnoResponseDTO toDTO(Alumno alumno) {
        return new AlumnoResponseDTO(
                alumno.getId(),
                alumno.getNombre(),
                alumno.getEmail(),
                alumno.getCurso().getId(),
                alumno.getCurso().getNombre()
        );
    }
}
