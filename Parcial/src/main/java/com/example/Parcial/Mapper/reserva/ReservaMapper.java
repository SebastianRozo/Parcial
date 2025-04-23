package com.example.Parcial.Mapper.reserva;

import com.example.Parcial.DTO.reserva.ReservaDTO;
import com.example.Parcial.DTO.reserva.ReservaResponseDTO;
import com.example.Parcial.Model.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservaMapper {
    @Mapping(target = "cliente.id", source = "clienteId")
    @Mapping(target = "habitacion.id", source = "habitacionId")
    Reserva toEntity(ReservaDTO reservaDTO);
    ReservaResponseDTO toResponseDTO (Reserva reserva);
}
