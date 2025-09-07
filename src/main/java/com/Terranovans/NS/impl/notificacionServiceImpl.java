package com.Terranovans.NS.impl;

import com.Terranovans.NS.dto.notificacionDTO;
import com.Terranovans.NS.entity.notificacion;
import com.Terranovans.NS.entity.usuario;
import com.Terranovans.NS.exceptions.CustomException;
import com.Terranovans.NS.repository.notificacionRepository;
import com.Terranovans.NS.repository.usuarioRepository;
import com.Terranovans.NS.service.notificacionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class notificacionServiceImpl implements notificacionService {

    private final notificacionRepository notificacionRepository;
    private final usuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;

    public notificacionServiceImpl(com.Terranovans.NS.repository.notificacionRepository notificacionRepository, usuarioRepository usuarioRepository, ModelMapper modelMapper) {
        this.notificacionRepository = notificacionRepository;
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<notificacionDTO> getAllNotificacion() {
        return notificacionRepository.findAll()
                .stream()
                .map(n -> modelMapper.map(n, notificacionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public notificacionDTO createNotificacion(notificacionDTO notificacionDTO) {
        notificacion entity = modelMapper.map(notificacionDTO, notificacion.class);

        usuario usuario = usuarioRepository.findById(notificacionDTO.getCedula())
                .orElseThrow(() -> new CustomException("Usuario no encontrado con id " + notificacionDTO.getCedula()));
        entity.setCedula(usuario);

        notificacion saved = notificacionRepository.save(entity);
        return modelMapper.map(saved, notificacionDTO.class);
    }

    @Override
    public notificacionDTO updatedNotificacion(notificacionDTO notificacionDTO) {
        if (notificacionDTO.getIdNotification() == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo para actualizar");
        }

        notificacion notificacion = notificacionRepository.findById(notificacionDTO.getIdNotification())
                .orElseThrow(() -> new CustomException("No existe notificación con id " + notificacionDTO.getIdNotification()));

        // actualizar campos
        notificacion.setMensajeNotificacion(notificacionDTO.getMensajeNotificacion());
        notificacion.setFechaNotification(LocalDateTime.now());
        notificacion.setTipo(notificacionDTO.getTipo());
        notificacion.setLeida(notificacionDTO.getLeida());

        if (notificacionDTO.getCedula() != null) {
            usuario usuario = usuarioRepository.findById(notificacionDTO.getCedula())
                    .orElseThrow(() -> new CustomException("Usuario no encontrado con id " + notificacionDTO.getCedula()));
            notificacion.setCedula(usuario);
        }

        notificacion updated = notificacionRepository.save(notificacion);
        return modelMapper.map(updated, notificacionDTO.class);
    }

    @Override
    public notificacionDTO getNotificacionById(notificacionDTO notificacionDTO) {
        if (notificacionDTO.getIdNotification() == null) {
            throw new IllegalArgumentException("Se requiere el ID para consultar");
        }
        notificacion entity = notificacionRepository.findById(notificacionDTO.getIdNotification())
                .orElseThrow(() -> new RuntimeException("No existe notificación con id " + notificacionDTO.getIdNotification()));
        return modelMapper.map(entity, notificacionDTO.class);
    }

    @Override
    public boolean deleteNotificacion(notificacionDTO notificacionDTO) {
        if (notificacionDTO.getIdNotification() == null) {
            return false;
        }
        if (!notificacionRepository.existsById(notificacionDTO.getIdNotification())) {
            return false;
        }
        notificacionRepository.deleteById(notificacionDTO.getIdNotification());
        return true;
    }
}
