package com.Terranovans.NS.service;


import com.Terranovans.NS.dto.terrenoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TerrenoService {

    List<terrenoDTO> getAllTerreno();

    terrenoDTO createTerreno(terrenoDTO terrenoDTO);
    terrenoDTO getTerrenoById(Long idTerreno);
    terrenoDTO updateTerreno(Long idTerreno, terrenoDTO terrenoDTO);
    boolean deleteTerreno(Long idTerreno);
}
