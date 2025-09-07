package com.Terranovans.NS.repository;


import com.Terranovans.NS.entity.terreno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface terrenoRepository  extends JpaRepository<terreno, Long>{

    terreno findByIdTerreno(Long idTerreno);
}
