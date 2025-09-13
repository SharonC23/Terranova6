package com.Terranovans.NS.impl;


import com.Terranovans.NS.dto.terrenoDTO;
import com.Terranovans.NS.entity.producto;
import com.Terranovans.NS.entity.terreno;
import com.Terranovans.NS.exceptions.CustomException;
import com.Terranovans.NS.repository.ProductoRepository;
import com.Terranovans.NS.repository.TerrenoRepository;
import com.Terranovans.NS.service.TerrenoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TerrenoServiceImpl implements TerrenoService {

    private final ProductoRepository productoRepository;
    private final TerrenoRepository terrenoRepository;
    private final ModelMapper modelMapper;

    public TerrenoServiceImpl(ProductoRepository productoRepository, TerrenoRepository terrenoRepository, ModelMapper modelMapper) {
        this.productoRepository = productoRepository;
        this.terrenoRepository = terrenoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<terrenoDTO> getAllTerreno() {
        List<terreno> terrenos = terrenoRepository.findAll();
        return terrenos.stream().map(terreno -> modelMapper.map(terreno, terrenoDTO.class)).collect(Collectors.toList());

    }

    @Override
    public terrenoDTO createTerreno(terrenoDTO terrenoDTO) {
        terreno terreno = new terreno();

        terreno.setTamanoTerreno(terrenoDTO.getTamanoTerreno());
        terreno.setTipoTerreno(terrenoDTO.getTipoTerreno());
        terreno.setTopografiaTerreno(terrenoDTO.getTopografiaTerreno());
        terreno.setAcceso(terrenoDTO.getAcceso());
        terreno.setServicios(terrenoDTO.getServicios());
        terreno.setUsoActual(terrenoDTO.getUsoActual());
        terreno.setCercado(terrenoDTO.getCercado());

        // Buscar producto y asignarlo
        if (terrenoDTO.getIdproducto() != null) {
            producto producto = productoRepository.findById(terrenoDTO.getIdproducto())
                    .orElseThrow(() -> new CustomException("Producto no encontrado"));
            terreno.setIdProducto(producto);
        } else {
            throw new CustomException("El idProducto es obligatorio");
        }

        terreno = terrenoRepository.save(terreno);
        return modelMapper.map(terreno, terrenoDTO.class);

    }

    @Override
    public terrenoDTO getTerrenoById(Long idTerreno) {
        terreno terreno = terrenoRepository.findById(idTerreno)
                .orElseThrow(()-> new CustomException("Terreno no encontrado con id:" + idTerreno));
        return modelMapper.map(terreno, terrenoDTO.class);
    }

    @Override
    public terrenoDTO updateTerreno(Long idTerreno, terrenoDTO terrenoDTO) {
        if(!terrenoRepository.existsById(idTerreno)){
            throw new CustomException(("Ganado no encontrado con id:" + idTerreno));
        }
        terreno terreno = modelMapper.map(terrenoDTO, com.Terranovans.NS.entity.terreno.class);
        terreno.setIdTerreno(idTerreno);

        if (terrenoDTO.getIdproducto()!=null){
            producto producto = productoRepository.findById(terrenoDTO.getIdproducto())
                    .orElseThrow(()-> new CustomException("Producto no encontrado con id:" + terrenoDTO.getIdTerreno()));
            terreno.setIdProducto(producto);
        }
        terreno = terrenoRepository.save(terreno);
        return modelMapper.map(terreno, com.Terranovans.NS.dto.terrenoDTO.class);
    }

    @Override
    public boolean deleteTerreno(Long idTerreno) {
        if (!terrenoRepository.existsById(idTerreno)){
            throw new CustomException(("Terreno no encontrado con id:" + idTerreno));
        }
        terrenoRepository.deleteById(idTerreno);
        return true;
    }
}
