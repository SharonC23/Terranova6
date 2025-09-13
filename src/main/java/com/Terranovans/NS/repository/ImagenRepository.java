package com.Terranovans.NS.repository;

import com.Terranovans.NS.entity.imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenRepository extends JpaRepository<imagen , Long> {

    boolean findByIdImagen(Long idImagen);
}
