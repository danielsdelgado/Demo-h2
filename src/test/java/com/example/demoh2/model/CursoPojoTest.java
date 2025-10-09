package com.example.demoh2.model;

import com.example.demoh2.domain.Curso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CursoPojoTest {

    @Test
    public void testConstructorConParametros() {
        // Arrange
        String nombre = "Matemáticas";
        String profesor = "Juan Pérez";

        // Act
        Curso curso = new Curso(nombre, profesor);

        // Assert
        assertEquals(nombre, curso.getNombre());
        assertEquals(profesor, curso.getProfesor());
        assertNull(curso.getId()); // El ID se genera automáticamente
        assertNotNull(curso.getAlumnos()); // Lista debe estar inicializada
        assertTrue(curso.getAlumnos().isEmpty());
    }

    @Test
    public void testSettersYGetters() {
        // Arrange
        Curso curso = new Curso();

        // Act
        curso.setNombre("Historia");
        curso.setProfesor("Ana García");

        // Assert
        assertEquals("Historia", curso.getNombre());
        assertEquals("Ana García", curso.getProfesor());
    }

    @Test
    public void testDefaultConstructor() {
        Curso curso = new Curso();

        assertNotNull(curso); // Verificar que se crea la instancia
        assertNull(curso.getNombre());
        assertNull(curso.getProfesor());
        assertNotNull(curso.getAlumnos()); // Asegurar que la lista se inicializa
        assertTrue(curso.getAlumnos().isEmpty());
    }
}
