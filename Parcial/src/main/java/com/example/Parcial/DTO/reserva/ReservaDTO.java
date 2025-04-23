package com.example.Parcial.DTO.reserva;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ReservaDTO {
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private String estado;
    private long montoTotal;
    private Long clienteId;
    private Long habitacionId;
}
