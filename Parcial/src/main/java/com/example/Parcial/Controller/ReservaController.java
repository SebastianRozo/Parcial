package com.example.Parcial.Controller;

import com.example.Parcial.DTO.cliente.ClienteDTO;
import com.example.Parcial.DTO.cliente.ClienteResponseDTO;
import com.example.Parcial.DTO.reserva.ReservaDTO;
import com.example.Parcial.DTO.reserva.ReservaResponseDTO;
import com.example.Parcial.Service.ClienteService;
import com.example.Parcial.Service.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reserva")
public class ReservaController {
    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService){
        this.reservaService=reservaService;
    }

    @GetMapping
    public ResponseEntity<List<ReservaResponseDTO>> getAlls(){
        return ResponseEntity.ok(reservaService.getAllReservas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> getOne(@PathVariable long id){
        return ResponseEntity.ok(reservaService.getReservaById(id));
    }

    @PostMapping
    public ResponseEntity<ReservaResponseDTO> create(@RequestBody ReservaDTO reservaDTO){
        return ResponseEntity.ok(reservaService.createReserva(reservaDTO));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> modifyCustomer(@PathVariable long id,@RequestBody ReservaDTO reservaDTO){
        return ResponseEntity.ok(reservaService.modifyReserva(id,reservaDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> DeleteCustomer(@PathVariable long id){
        reservaService.deleteReserva(id);
        return ResponseEntity.noContent().build();
    }
}
