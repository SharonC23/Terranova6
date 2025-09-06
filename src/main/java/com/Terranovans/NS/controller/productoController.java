package com.Terranovans.NS.controller;


import com.Terranovans.NS.dto.productoDTO;
import com.Terranovans.NS.repository.productoRepository;
import com.Terranovans.NS.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/productos")
public class productoController {

    @Autowired
    private productoRepository productoRepository;

    private final ProductoService productoService;

    public productoController(ProductoService productoService) {
        this.productoService = productoService;
    }


    @GetMapping ("/all")
    public ResponseEntity<List<productoDTO>> getAllProducts(){
        List<productoDTO> productos = productoService.getAllProducts();
        return ResponseEntity.ok(productos);
    }

    @PostMapping ("/create")
    public ResponseEntity<productoDTO> createProduct(@Validated @RequestBody productoDTO productoDTO){
        productoService.createProduct(productoDTO);
        return ResponseEntity.ok(productoDTO);
    }

    @PutMapping ("/update/{idProducto}")
    public ResponseEntity<productoDTO> updateProduct(@PathVariable Long productoId, @RequestBody productoDTO productoDTO ){
        productoDTO producto = productoService.updateProduct(productoId, productoDTO);
        return ResponseEntity.ok(productoDTO);
    }

    @DeleteMapping ("/delete/{idProducto}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long idProducto){
        productoService.deleteProduct(idProducto);
        return ResponseEntity.noContent().build();
    }


}
