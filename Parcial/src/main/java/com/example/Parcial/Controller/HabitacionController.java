package com.example.Parcial.Controller;

import com.example.Parcial.DTO.habitacion.HabitacionDTO;
import com.example.Parcial.DTO.habitacion.HabitacionResponseDTO;
import com.example.Parcial.DTO.reserva.ReservaDTO;
import com.example.Parcial.DTO.reserva.ReservaResponseDTO;
import com.example.Parcial.Service.HabitacionService;
import com.example.Parcial.Service.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habitacion")
public class HabitacionController {
    private final HabitacionService habitacionService;

    public HabitacionController(HabitacionService habitacionService){
        this.habitacionService=habitacionService;
    }

    @GetMapping
    public ResponseEntity<List<HabitacionResponseDTO>> getAlls(){
        return ResponseEntity.ok(habitacionService.getAllsRoms());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HabitacionResponseDTO> getOne(@PathVariable long id){
        return ResponseEntity.ok(habitacionService.getRoomById(id));
    }

    @PostMapping
    public ResponseEntity<HabitacionResponseDTO> create(@RequestBody HabitacionDTO habitacionDTO){
        return ResponseEntity.ok(habitacionService.createRoom(habitacionDTO));
    }
    @PutMapping("/{id}")
    public ResponseEntity<HabitacionResponseDTO> modifyCustomer(@PathVariable long id,@RequestBody HabitacionDTO habitacionDTO){
        return ResponseEntity.ok(habitacionService.modifyRoom(id,habitacionDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HabitacionResponseDTO> DeleteCustomer(@PathVariable long id){
        habitacionService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }
}
