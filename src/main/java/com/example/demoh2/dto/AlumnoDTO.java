package com.example.demoh2.dto;
 
import jakarta.validation.constraints.*;

public class AlumnoDTO {

    @NotBlank(message = "El nombre del alumno es obligatorio")
    private String nombre;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email no es válido")
    private String email;

    @NotNull(message = "Debe especificar el ID del curso")
    private Long cursoId;

    public AlumnoDTO() {}

    public AlumnoDTO(String nombre, String email, Long cursoId) {
        this.nombre = nombre;
        this.email = email;
        this.cursoId = cursoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }
}
