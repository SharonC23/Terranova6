package com.Terranovans.NS.repository;

import com.Terranovans.NS.entity.ganado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ganadoRepository extends JpaRepository<ganado, Long> {

    ganado findByIdGanado(Long idGanado);
}
