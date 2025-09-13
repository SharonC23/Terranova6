package com.Terranovans.NS.service;


import com.Terranovans.NS.dto.ProductoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductoService {

    static List<ProductoDTO> findAllDTO() {
        return null;
    }

    List<ProductoDTO> getAllProducts();

    ProductoDTO createProduct(ProductoDTO productoDTO);
    ProductoDTO getProductById(Long idProducto);
    ProductoDTO updateProduct(Long idProducto, ProductoDTO productoDTO);
    boolean deleteProduct(Long idProducto);

}
