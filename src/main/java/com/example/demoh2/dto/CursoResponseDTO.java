package com.example.demoh2.dto;

public class CursoResponseDTO {

    private Long id;
    private String nombre;
    private String profesor;

    public CursoResponseDTO() {
    }

    public CursoResponseDTO(Long id, String nombre, String profesor) {
        this.id = id;
        this.nombre = nombre;
        this.profesor = profesor;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }
}
