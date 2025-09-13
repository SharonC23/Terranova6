package com.Terranovans.NS.service;


import com.Terranovans.NS.dto.notificacionDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotificacionService {

    List<notificacionDTO> getAllNotificacion();

    notificacionDTO createNotificacion(notificacionDTO notificacionDTO);
    notificacionDTO updatedNotificacion(notificacionDTO notificacionDTO);
    notificacionDTO getNotificacionById(notificacionDTO notificacionDTO);
    boolean deleteNotificacion(notificacionDTO notificacionDTO);

}
