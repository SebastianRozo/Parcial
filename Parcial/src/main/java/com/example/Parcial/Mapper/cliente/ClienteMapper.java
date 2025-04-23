package com.example.Parcial.Mapper.cliente;

import com.example.Parcial.DTO.cliente.ClienteDTO;
import com.example.Parcial.DTO.cliente.ClienteResponseDTO;
import com.example.Parcial.Model.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    Cliente toEntity(ClienteDTO dto);

    ClienteResponseDTO toResponseDTO(Cliente cliente);
}
