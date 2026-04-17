package com.Producto.Producto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 3, max = 50)
    private String nombre;

    @NotNull(message = "El precio es obligatorio")
    @Min(value = 1, message = "El precio debe ser mayor a 0")
    private Double precio;
}