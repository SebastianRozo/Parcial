package com.example.Parcial.Controller;

import com.example.Parcial.DTO.cliente.ClienteDTO;
import com.example.Parcial.DTO.cliente.ClienteResponseDTO;
import com.example.Parcial.Model.Cliente;
import com.example.Parcial.Repository.ClienteRepository;
import com.example.Parcial.Service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService=clienteService;
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> getAlls(){
        return ResponseEntity.ok(clienteService.getAllCostumers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> getOne(@PathVariable long id){
        return ResponseEntity.ok(clienteService.getCustomerByID(id));
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> create(@RequestBody ClienteDTO clienteDTO){
        return ResponseEntity.ok(clienteService.createCustomer(clienteDTO));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> modifyCustomer(@PathVariable long id,@RequestBody ClienteDTO clienteDTO){
        return ResponseEntity.ok(clienteService.UpdateCustomer(id,clienteDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> DeleteCustomer(@PathVariable long id){
        clienteService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
