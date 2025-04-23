package com.example.Parcial.DTO.habitacion;

import lombok.Data;

@Data
public class HabitacionDTO {
    private String codigo;
    private String tipo;
    private Integer CostoNoche;
    private Integer capacidad;
    private String estado;
    private String descripcion;
}
