package com.example.Parcial.Repository;

import com.example.Parcial.Model.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitacionRepository extends JpaRepository<Habitacion,Long> {
    boolean existsByCode(String codigo);
}
