package com.Terranovans.NS.repository;


import com.Terranovans.NS.entity.producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productoRepository extends JpaRepository<producto , Long> {

    producto findByIdProducto(Long idProducto);



}
