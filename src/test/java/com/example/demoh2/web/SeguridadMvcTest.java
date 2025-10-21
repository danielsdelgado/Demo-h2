package com.example.demoh2.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import com.example.demoh2.controller.AlumnoController;
import com.example.demoh2.controller.CursoController; 
import com.example.demoh2.service.AlumnoService;
import com.example.demoh2.service.CursoService; 
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 
@WebMvcTest(controllers = { AlumnoController.class, CursoController.class })
class SeguridadMvcTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    private AlumnoService alumnoService;

    @MockBean
    private CursoService cursoService;
 
    @Test
    @WithMockUser(username = "alumno", roles = { "USER" })
    void user_no_puede_crear_alumno_403() throws Exception {
        mvc.perform(post("/api/alumnos")
                .contentType("application/json")
                .content("{\"nombre\":\"Ana\"}"))
                .andExpect(status().isForbidden());
    }
 
}
