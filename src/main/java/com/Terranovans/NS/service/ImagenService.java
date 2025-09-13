package com.Terranovans.NS.service;


import com.Terranovans.NS.dto.imagenDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ImagenService {

    List<imagenDTO> getAllImagen();

    imagenDTO createImagen(imagenDTO imagenDTO);
    imagenDTO updatedImagen(Long idImagen, imagenDTO imagenDTO);
    imagenDTO getImagenById( imagenDTO imagenDTO);
    boolean deleteImagen(imagenDTO imagenDTO);


}
