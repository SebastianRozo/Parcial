package com.example.Parcial.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate fechaIngreso;
    @Column(nullable = false)
    private LocalDate fechaSalida;
    @Column(nullable = false)
    private String estado;
    @Column(nullable = false)
    private long montoTotal;
    @Column(nullable = false)
    private String codigoReserva;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "habitacion_id")
    private Habitacion habitacion;
}
