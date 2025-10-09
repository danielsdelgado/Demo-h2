package com.example.demoh2.dto;

public class AlumnoResponseDTO {
    private Long id;
    private String nombre;
    private String email;
    private Long cursoId;
    private String cursoNombre;

    public AlumnoResponseDTO(Long id, String nombre, String email, Long cursoId, String cursoNombre) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.cursoId = cursoId;
        this.cursoNombre = cursoNombre;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public String getCursoNombre() {
        return cursoNombre;
    }
}
