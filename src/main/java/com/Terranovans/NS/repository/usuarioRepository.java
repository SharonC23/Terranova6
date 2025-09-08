package com.Terranovans.NS.repository;

import com.Terranovans.NS.entity.usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface usuarioRepository extends JpaRepository<usuario,String> { // ← String, no Long
    Optional<usuario> findByEmail(String email);
    Optional<usuario> findByEmailAndPassword(String email, String password);
}

