package com.Terranovans.NS.service;


import com.Terranovans.NS.dto.productoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductoService {

    List<productoDTO> getAllProducts();

    productoDTO createProduct(productoDTO productoDTO);
    productoDTO getProductById(Long idProducto);
    productoDTO updateProduct(Long idProducto, productoDTO productoDTO);
    boolean deleteProduct(Long idProducto);

}
