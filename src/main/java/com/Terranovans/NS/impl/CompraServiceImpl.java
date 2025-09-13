package com.Terranovans.NS.impl;


import com.Terranovans.NS.entity.Compra;
import com.Terranovans.NS.repository.CompraRepository;
import com.Terranovans.NS.service.CompraService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CompraServiceImpl extends CompraService {

    private final CompraRepository compraRepository;

    public CompraServiceImpl(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    @Override
    public Compra guardarCompra(Compra compra) {
        if (compra.getProducto() != null && compra.getProducto().getPrecioProducto() != null) {
            BigDecimal cantidad = BigDecimal.valueOf(compra.getCantidad());
            BigDecimal precio = compra.getProducto().getPrecioProducto();
            BigDecimal total = cantidad.multiply(precio);
            compra.setTotal(total); // si `total` es BigDecimal en Compra
        } else {
            throw new IllegalArgumentException("El producto o su precio no pueden ser nulos");
        }
        return compraRepository.save(compra);
    }

    @Override
    public List<Compra> listarCompras() {
        return compraRepository.findAll();
    }

    @Override
    public Optional<Compra> obtenerCompraPorId(Long id) {
        return compraRepository.findById(id);
    }

    @Override
    public void eliminarCompra(Long id) {
        compraRepository.deleteById(id);
    }
}
