package com.damw.librosapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "libro")
@Data // Genera getters, setters, toString, equals y hashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título no puede estar vacío")
    private String titulo;

    @NotBlank(message = "El autor no puede estar vacío")
    private String autor;

    @Positive(message = "El año de publicación debe ser positivo")
    private int anioPublicacion;

    @PositiveOrZero(message = "El precio debe ser cero o positivo")
    private double precio;

    private boolean disponible;
}