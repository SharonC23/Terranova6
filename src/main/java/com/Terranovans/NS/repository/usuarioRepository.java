package com.Terranovans.NS.repository;

import com.Terranovans.NS.entity.usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usuarioRepository extends JpaRepository<usuario, Long> {

    usuario findByEmail(String email);

}
