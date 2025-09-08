package com.Terranovans.NS.repository;


import com.Terranovans.NS.entity.finca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface fincaRepository extends JpaRepository<finca, Long> {
}


