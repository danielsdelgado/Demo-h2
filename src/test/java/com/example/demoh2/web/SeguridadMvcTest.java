package com.example.demoh2.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demoh2.controller.AlumnoController;
import com.example.demoh2.controller.CursoController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {AlumnoController.class, CursoController.class})
class SeguridadMvcTest {

    @Autowired
    MockMvc mvc;

    @Test
    void sinUsuario_devuelve401() throws Exception {
        mvc.perform(get("/api/hola"))
            .andExpect(status().isUnauthorized()); // 401
    }

    @Test
    @WithMockUser(username = "alumno", roles = {"USER"})
    void user_accede_a_hola_200() throws Exception {
        mvc.perform(get("/api/hola"))
            .andExpect(status().isOk()); // 200
    }

    @Test
    @WithMockUser(username = "alumno", roles = {"USER"})
    void user_no_puede_crear_alumno_403() throws Exception {
        mvc.perform(post("/api/alumnos")
                .contentType("application/json")
                .content("{\"nombre\":\"Ana\"}"))
            .andExpect(status().isForbidden()); // 403
    }

    @Test
    @WithMockUser(username = "profe", roles = {"ADMIN"})
    void admin_puede_crear_alumno_200o201() throws Exception {
        mvc.perform(post("/api/alumnos")
                .contentType("application/json")
                .content("{\"nombre\":\"Ana\"}"))
            .andExpect(result -> {
                int s = result.getResponse().getStatus();
                if (s != 200 && s != 201)
                    throw new AssertionError("Esperado 200/201 y fue " + s);
            });
    }
}
