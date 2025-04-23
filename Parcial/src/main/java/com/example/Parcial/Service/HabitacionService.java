package com.example.Parcial.Service;

import com.example.Parcial.DTO.habitacion.HabitacionDTO;
import com.example.Parcial.DTO.habitacion.HabitacionResponseDTO;
import com.example.Parcial.Mapper.habitacion.HabitacionMapper;
import com.example.Parcial.Model.Cliente;
import com.example.Parcial.Model.Habitacion;
import com.example.Parcial.Repository.HabitacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HabitacionService {
    private final HabitacionRepository habitacionRepository;
    private final HabitacionMapper habitacionMapper;

    public  HabitacionService(HabitacionMapper habitacionMapper,HabitacionRepository habitacionRepository){
        this.habitacionRepository=habitacionRepository;
        this.habitacionMapper=habitacionMapper;
    }

    public List<HabitacionResponseDTO> getAllsRoms(){
        return habitacionRepository.findAll().stream()
                .map(habitacionMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public HabitacionResponseDTO getRoomById(long id){
        Habitacion habitacion=habitacionRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("El cliente no existe"));

        return habitacionMapper.toResponseDTO(habitacion);
    }

    public HabitacionResponseDTO createRoom(HabitacionDTO habitacionDTO){
        if(habitacionRepository.existsByCode(habitacionDTO.getCodigo())){
            throw new RuntimeException("Esa habitacion ya esta registrado");
        }
        Habitacion habitacion = habitacionMapper.toEntity(habitacionDTO);
        Habitacion habitacionGuardada= habitacionRepository.save(habitacion);
        return habitacionMapper.toResponseDTO(habitacionGuardada);
    }
    public HabitacionResponseDTO modifyRoom(long id, HabitacionDTO habitacionDTO) {
        if(habitacionRepository.existsByCode(habitacionDTO.getCodigo())){
            throw new RuntimeException("Esa habitacion ya esta registrado");
        }
        Habitacion habitacion = habitacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La habitación no existe"));


        habitacion.setCodigo(habitacionDTO.getCodigo());
        habitacion.setTipo(habitacionDTO.getTipo());
        habitacion.setCostoNoche(habitacionDTO.getCostoNoche());
        habitacion.setCapacidad(habitacionDTO.getCapacidad());
        habitacion.setEstado(habitacionDTO.getEstado());
        habitacion.setDescripcion(habitacionDTO.getDescripcion());


        habitacionRepository.save(habitacion);


        return habitacionMapper.toResponseDTO(habitacion);
    }

    public void deleteRoom(long id){
        Habitacion habitacion= habitacionRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("El cliente no existe"));
        habitacionRepository.deleteById(id);
    }
}
