package com.Terranovans.NS.service;

import com.Terranovans.NS.dto.calendarioDTO;
import java.util.List;

public interface CalendarioService {
    calendarioDTO createCalendario(calendarioDTO calendarioDTO);
    List<calendarioDTO> getAllCalendarios();
    calendarioDTO updateCalendario(Long id, calendarioDTO calendarioDTO);
    void deleteCalendario(Long id);
}



