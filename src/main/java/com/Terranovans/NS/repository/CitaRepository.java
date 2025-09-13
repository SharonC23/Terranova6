package com.Terranovans.NS.repository;



import com.Terranovans.NS.entity.cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends JpaRepository<cita, Long> {
}


