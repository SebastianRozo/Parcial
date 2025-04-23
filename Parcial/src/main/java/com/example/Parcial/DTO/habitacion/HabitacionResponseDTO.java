package com.example.Parcial.DTO.habitacion;

import lombok.Data;

import java.util.List;
@Data
public class HabitacionResponseDTO {
    private long Id;
    private String codigo;
    private String tipo;
    private Integer CostoNoche;
    private Integer capacidad;
    private String estado;
    private String descripcion;
    private List<HabitacionResponseDTO> habitacion;
}
