package com.Terranovans.NS.impl;

import com.Terranovans.NS.dto.calendarioDTO;
import com.Terranovans.NS.entity.calendario;
import com.Terranovans.NS.entity.Usuario;
import com.Terranovans.NS.repository.CalendarioRepository;
import com.Terranovans.NS.repository.UsuarioRepository;
import com.Terranovans.NS.service.CalendarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalendarioServiceImpl implements CalendarioService {

    @Autowired
    private CalendarioRepository calendarioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public calendarioDTO createCalendario(calendarioDTO calendarioDTO) {
        Usuario user = usuarioRepository.findById(calendarioDTO.getCedula())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        calendario cal = new calendario();
        cal.setUsuario(user);

        calendario saved = calendarioRepository.save(cal);

        return new calendarioDTO(saved.getIdCalendario(), saved.getUsuario().getCedula());
    }

    @Override
    public List<calendarioDTO> getAllCalendarios() {
        return calendarioRepository.findAll()
                .stream()
                .map(c -> new calendarioDTO(c.getIdCalendario(), c.getUsuario().getCedula()))
                .collect(Collectors.toList());
    }

    @Override
    public calendarioDTO updateCalendario(Long id, calendarioDTO calendarioDTO) {
        calendario cal = calendarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Calendario no encontrado"));

        Usuario user = usuarioRepository.findById(calendarioDTO.getCedula())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        cal.setUsuario(user);
        calendario updated = calendarioRepository.save(cal);

        return new calendarioDTO(updated.getIdCalendario(), updated.getUsuario().getCedula());
    }

    @Override
    public void deleteCalendario(Long id) {
        calendarioRepository.deleteById(id);
    }
}
