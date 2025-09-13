package com.Terranovans.NS.controller;


import com.Terranovans.NS.dto.ProductoDTO;
import com.Terranovans.NS.repository.ProductoRepository;
import com.Terranovans.NS.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }


    @GetMapping ("/all")
    public ResponseEntity<List<ProductoDTO>> getAllProducts(){
        List<ProductoDTO> productos = productoService.getAllProducts();
        return ResponseEntity.ok(productos);
    }

    @PostMapping ("/create")
    public ResponseEntity<ProductoDTO> createProduct(@Validated @RequestBody ProductoDTO productoDTO){
        productoService.createProduct(productoDTO);
        return ResponseEntity.ok(productoDTO);
    }

    @PutMapping ("/update/{idProducto}")
    public ResponseEntity<ProductoDTO> updateProduct(@PathVariable Long productoId, @RequestBody ProductoDTO productoDTO ){
        ProductoDTO producto = productoService.updateProduct(productoId, productoDTO);
        return ResponseEntity.ok(productoDTO);
    }

    @DeleteMapping ("/delete/{idProducto}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long idProducto){
        productoService.deleteProduct(idProducto);
        return ResponseEntity.noContent().build();
    }


}
