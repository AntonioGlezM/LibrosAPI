package com.damw.librosapp.service;

import org.springframework.stereotype.Service;
import com.damw.librosapp.model.Libro;
import com.damw.librosapp.repository.LibroRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public List<Libro> listarTodos() {
        return libroRepository.findAll();
    }

    public Optional<Libro> buscarPorId(Long id) {
        return libroRepository.findById(id);
    }

    public Libro guardar(Libro libro) {
        return libroRepository.save(libro);
    }

    public Optional<Libro> actualizar(Long id, Libro libroActualizado) {
        return libroRepository.findById(id).map(libro -> {
            // Aquí ya existen los getters de Lombok
            libro.setTitulo(libroActualizado.getTitulo());
            libro.setAutor(libroActualizado.getAutor());
            libro.setAnioPublicacion(libroActualizado.getAnioPublicacion());
            libro.setPrecio(libroActualizado.getPrecio());
            libro.setDisponible(libroActualizado.isDisponible());
            return libroRepository.save(libro);
        });
    }

    public boolean eliminar(Long id) {
        if (libroRepository.existsById(id)) {
            libroRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Libro> buscarPorTitulo(String titulo) {
        return libroRepository.findByTituloContainingIgnoreCase(titulo);
    }

    public List<Libro> buscarPorAutor(String autor) {
        return libroRepository.findByAutorContainingIgnoreCase(autor);
    }

    public List<Libro> filtrarPorDisponibilidad(boolean disponible) {
        return libroRepository.findByDisponible(disponible);
    }
}