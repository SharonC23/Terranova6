package com.Terranovans.NS.repository;


import com.Terranovans.NS.entity.notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface notificacionRepository  extends JpaRepository<notificacion, Long> {

    Optional<notificacion> findByIdNotification(Long idNotification);
}
