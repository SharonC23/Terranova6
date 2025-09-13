package com.Terranovans.NS.repository;



import com.Terranovans.NS.entity.favoritos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritosRepository extends JpaRepository<favoritos, Long> {
}

