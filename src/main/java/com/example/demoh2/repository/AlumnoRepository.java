package com.example.demoh2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoh2.domain.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
