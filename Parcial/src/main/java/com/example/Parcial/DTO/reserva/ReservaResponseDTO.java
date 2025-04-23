package com.example.Parcial.DTO.reserva;

import com.example.Parcial.DTO.cliente.ClienteResponseDTO;
import com.example.Parcial.DTO.habitacion.HabitacionResponseDTO;
import lombok.Data;

import java.time.LocalDate;
@Data
public class ReservaResponseDTO {
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private String estado;
    private long montoTotal;
    private Long clienteId;
    private Long habitacionId;
    private ClienteResponseDTO cliente;
    private HabitacionResponseDTO habitacion;
}
