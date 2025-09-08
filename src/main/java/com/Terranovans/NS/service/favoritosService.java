package com.Terranovans.NS.service;


import com.Terranovans.NS.dto.favoritosDTO;
import java.util.List;

public interface favoritosService {
    favoritosDTO crear(favoritosDTO favoritosDTO);
    List<favoritosDTO> listar();
    favoritosDTO obtenerPorId(Long id);
    favoritosDTO actualizar(Long id, favoritosDTO favoritosDTO);
    void eliminar(Long id);
}
