package com.Terranovans.NS.service;


import com.Terranovans.NS.dto.fincaDTO;
import java.util.List;

public interface FincaService {
    fincaDTO crear(fincaDTO dto);
    List<fincaDTO> listar();
    fincaDTO obtenerPorId(Long id);
    fincaDTO actualizar(Long id, fincaDTO dto);
    void eliminar(Long id);
}


