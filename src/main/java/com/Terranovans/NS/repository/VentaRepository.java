package com.Terranovans.NS.repository;

import com.Terranovans.NS.entity.venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<venta, Long> {

    venta findByIdVenta(Long idVenta);
}
