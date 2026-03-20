package com.damw.librosapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.damw.librosapp.model.Libro;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByTituloContainingIgnoreCase(String titulo);
    List<Libro> findByAutorContainingIgnoreCase(String autor);
    List<Libro> findByDisponible(boolean disponible);
}