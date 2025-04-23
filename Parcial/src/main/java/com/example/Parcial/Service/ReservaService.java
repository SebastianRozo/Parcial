package com.example.Parcial.Service;

import com.example.Parcial.DTO.reserva.ReservaDTO;
import com.example.Parcial.DTO.reserva.ReservaResponseDTO;
import com.example.Parcial.Mapper.reserva.ReservaMapper;
import com.example.Parcial.Model.Reserva;
import com.example.Parcial.Repository.ReservaRepository;
import com.example.Parcial.Repository.ClienteRepository;
import com.example.Parcial.Repository.HabitacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;
    private final ReservaMapper reservaMapper;
    private final ClienteRepository clienteRepository;
    private final HabitacionRepository habitacionRepository;

    public ReservaService(ReservaMapper reservaMapper, ReservaRepository reservaRepository,
                          ClienteRepository clienteRepository, HabitacionRepository habitacionRepository) {
        this.reservaRepository = reservaRepository;
        this.reservaMapper = reservaMapper;
        this.clienteRepository = clienteRepository;
        this.habitacionRepository = habitacionRepository;
    }

    public List<ReservaResponseDTO> getAllReservas() {
        return reservaRepository.findAll().stream()
                .map(reservaMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public ReservaResponseDTO getReservaById(long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La reserva no existe"));

        return reservaMapper.toResponseDTO(reserva);
    }

    public ReservaResponseDTO createReserva(ReservaDTO reservaDTO) {
        // Verificar que el cliente existe
        clienteRepository.findById(reservaDTO.getClienteId())
                .orElseThrow(() -> new RuntimeException("El cliente no existe"));

        // Verificar que la habitación existe
        habitacionRepository.findById(reservaDTO.getHabitacionId())
                .orElseThrow(() -> new RuntimeException("La habitación no existe"));

        Reserva reserva = reservaMapper.toEntity(reservaDTO);
        Reserva reservaGuardada = reservaRepository.save(reserva);
        return reservaMapper.toResponseDTO(reservaGuardada);
    }

    public ReservaResponseDTO modifyReserva(long id, ReservaDTO reservaDTO) {
        // Verificar que el cliente existe
        clienteRepository.findById(reservaDTO.getClienteId())
                .orElseThrow(() -> new RuntimeException("El cliente no existe"));

        // Verificar que la habitación existe
        habitacionRepository.findById(reservaDTO.getHabitacionId())
                .orElseThrow(() -> new RuntimeException("La habitación no existe"));

        // Buscar la reserva por ID
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La reserva no existe"));


        reserva.setFechaIngreso(reservaDTO.getFechaIngreso());
        reserva.setFechaSalida(reservaDTO.getFechaSalida());
        reserva.setEstado(reservaDTO.getEstado());
        reserva.setMontoTotal(reservaDTO.getMontoTotal());

        // Actualizar relaciones
        reserva.setCliente(clienteRepository.findById(reservaDTO.getClienteId()).orElseThrow());
        reserva.setHabitacion(habitacionRepository.findById(reservaDTO.getHabitacionId()).orElseThrow());

        // Guardar la reserva actualizada
        reservaRepository.save(reserva);

        return reservaMapper.toResponseDTO(reserva);
    }

    public void deleteReserva(long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La reserva no existe"));
        reservaRepository.deleteById(id);
    }
}
