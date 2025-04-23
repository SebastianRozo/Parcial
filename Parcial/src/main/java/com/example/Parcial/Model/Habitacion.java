package com.example.Parcial.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String codigo;

    @Column(nullable = false)
    private String tipo;
    @Column(name = "costo_noche",nullable = false)
    private Integer CostoNoche;

    private Integer capacidad;

    @Column(nullable = false)
    private String estado;

    private String descripcion;


    @OneToMany(mappedBy = "habitacion")
    private List<Reserva> reservas;
}
