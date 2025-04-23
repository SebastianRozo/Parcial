package com.example.Parcial.Service;

import com.example.Parcial.DTO.cliente.ClienteDTO;
import com.example.Parcial.DTO.cliente.ClienteResponseDTO;
import com.example.Parcial.Mapper.cliente.ClienteMapper;
import com.example.Parcial.Model.Cliente;
import com.example.Parcial.Repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;
    public ClienteService( ClienteMapper clienteMapper,ClienteRepository clienteRepository){
        this.clienteRepository=clienteRepository;
        this.clienteMapper=clienteMapper;
    }

    public List<ClienteResponseDTO> getAllCostumers(){
        return clienteRepository.findAll().stream()
                .map(clienteMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public ClienteResponseDTO getCustomerByID(long id){
        Cliente cliente=clienteRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("El cliente no existe"));

        return clienteMapper.toResponseDTO(cliente);
    }

    public ClienteResponseDTO createCustomer(ClienteDTO clienteDTO){
        if(clienteRepository.existsByDocument(clienteDTO.getDocumento())){
            throw new RuntimeException("Esa documento ya esta registrado");
        }
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        Cliente clienteGuardado= clienteRepository.save(cliente);
        return clienteMapper.toResponseDTO(clienteGuardado);
    }
    public ClienteResponseDTO UpdateCustomer (long id, ClienteDTO clienteDTO){
        if(clienteRepository.existsByDocument(clienteDTO.getDocumento())){
            throw new RuntimeException("Esa documento ya esta registrado");
        }
        Cliente cliente=clienteRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("El cliente no existe"));

        cliente.setNombre(clienteDTO.getNombre());
        cliente.setApellido(clienteDTO.getApellido());
        cliente.setDocumento(clienteDTO.getDocumento());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setTelefono(clienteDTO.getTelefono());

        clienteRepository.save(cliente);
        return clienteMapper.toResponseDTO(cliente);
    }

    public void deleteCustomer(long id){
        Cliente cliente= clienteRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("El cliente no existe"));
        clienteRepository.deleteById(id);
    }
}
