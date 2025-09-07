package com.Terranovans.NS.service;

import com.Terranovans.NS.dto.ganadoDTO;
import com.Terranovans.NS.dto.usuarioDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ganadoService {

    List<ganadoDTO> getAllGanado ();

    ganadoDTO createGanado(ganadoDTO ganadoDTO);
    ganadoDTO getGanadoById(Long idGanado);
    ganadoDTO updateGanado(Long idGanado, ganadoDTO ganadoDTO);
    boolean deleteGanado(Long idGanado);

}
