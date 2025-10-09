package com.example.demoh2.model;

import com.example.demoh2.domain.Alumno;
import com.example.demoh2.domain.Curso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlumnoPojoTest {

    @Test
    public void testConstructorConParametros() {
        String nombre = "Juan";
        String email = "juan@example.com";

        Alumno alumno = new Alumno(nombre, email);

        assertEquals(nombre, alumno.getNombre());
        assertEquals(email, alumno.getEmail());
        assertNull(alumno.getId());
        assertNull(alumno.getCurso());
    }

    @Test
    public void testSettersYGetters() {
        Alumno alumno = new Alumno();
        alumno.setNombre("Ana");
        alumno.setEmail("ana@example.com");

        Curso curso = new Curso("Historia", "Profesor García");
        alumno.setCurso(curso);

        assertEquals("Ana", alumno.getNombre());
        assertEquals("ana@example.com", alumno.getEmail());
        assertNotNull(alumno.getCurso());
        assertEquals("Historia", alumno.getCurso().getNombre());
        assertEquals("Profesor García", alumno.getCurso().getProfesor());
    }

    @Test
    public void testDefaultConstructor() {
        Alumno alumno = new Alumno();
        assertNotNull(alumno);
        assertNull(alumno.getNombre());
        assertNull(alumno.getEmail());
        assertNull(alumno.getCurso());
    }
}
