package com.example.BackendMarket.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Entity
@Data
@Table(name = "productos")
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;

    @Column(name = "categoria")
    private String categoria; // Almacenar como texto separado por comas

    @Column(name = "image_url")
    private String imageUrl; // Almacenar como texto separado por comas

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name = "precio_regular")
    private Double precioRegular;

    @Column(name = "created_at")
    private Instant createdAt;

    private String slug;
}