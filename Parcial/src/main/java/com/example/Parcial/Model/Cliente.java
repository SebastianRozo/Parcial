package com.example.Parcial.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    @Column(nullable = false)
    private String documento;
    @Column(nullable = false)
    private String telefono;
    @Column(nullable = false)
    private String email;
    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reservaList;

}
