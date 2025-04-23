package com.example.Parcial.DTO.cliente;

import com.example.Parcial.DTO.reserva.ReservaDTO;
import lombok.Data;

import java.util.List;

@Data
public class ClienteResponseDTO {
    private Long id;
    private String nombre;
    private String documento;
    private String telefono;
    private String email;
    private List<ReservaDTO> reservaDTO;

}
