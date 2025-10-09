package com.example.demoh2.dto;

import jakarta.validation.constraints.*;

public class CursoRequestDTO {

    @NotBlank(message = "El nombre del curso es obligatorio")
    private String nombre;

    @NotBlank(message = "El nombre del profesor es obligatorio")
    private String profesor;

    public CursoRequestDTO() {}

    public CursoRequestDTO(String nombre, String profesor) {
        this.nombre = nombre;
        this.profesor = profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }
}
