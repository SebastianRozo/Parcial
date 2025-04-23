package com.example.Parcial.Mapper.habitacion;

import com.example.Parcial.DTO.habitacion.HabitacionDTO;
import com.example.Parcial.DTO.habitacion.HabitacionResponseDTO;
import com.example.Parcial.Model.Habitacion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HabitacionMapper {
    Habitacion toEntity(HabitacionDTO habitacionDTO);
    HabitacionResponseDTO toResponseDTO(Habitacion habitacion);
}
