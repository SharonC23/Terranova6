package com.Terranovans.NS.impl;

import com.Terranovans.NS.dto.favoritosDTO;
import com.Terranovans.NS.entity.favoritos;
import com.Terranovans.NS.entity.producto;
import com.Terranovans.NS.entity.Usuario;
import com.Terranovans.NS.repository.FavoritosRepository;
import com.Terranovans.NS.repository.ProductoRepository;
import com.Terranovans.NS.repository.UsuarioRepository;
import com.Terranovans.NS.service.FavoritosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FavoritosServiceImpl implements FavoritosService {

    private final FavoritosRepository favoritosRepository;
    private final UsuarioRepository usuarioRepository;
    private final ProductoRepository productoRepository;

    @Override
    public favoritosDTO crear(favoritosDTO favoritosDTO) {
        Usuario usuario = usuarioRepository.findById(favoritosDTO.getCedula())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        producto producto = productoRepository.findById(favoritosDTO.getIdProducto())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        favoritos fav = new favoritos();
        fav.setUsuario(usuario);
        fav.setProducto(producto);

        favoritos nuevo = favoritosRepository.save(fav);
        return mapearDTO(nuevo);
    }

    @Override
    public List<favoritosDTO> listar() {
        return favoritosRepository.findAll()
                .stream()
                .map(this::mapearDTO)
                .collect(Collectors.toList());
    }

    @Override
    public favoritosDTO obtenerPorId(Long id) {
        favoritos fav = favoritosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Favorito no encontrado"));
        return mapearDTO(fav);
    }

    @Override
    public favoritosDTO actualizar(Long id, favoritosDTO favoritosDTO) {
        favoritos fav = favoritosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Favorito no encontrado"));

        Usuario usuario = usuarioRepository.findById(favoritosDTO.getCedula())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        producto producto = productoRepository.findById(favoritosDTO.getIdProducto())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        fav.setUsuario(usuario);
        fav.setProducto(producto);

        favoritos actualizado = favoritosRepository.save(fav);
        return mapearDTO(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        favoritosRepository.deleteById(id);
    }

    private favoritosDTO mapearDTO(favoritos fav) {
        return new favoritosDTO(
                fav.getId_favorito(),
                fav.getUsuario() != null ? fav.getUsuario().getCedula() : null,
                fav.getProducto() != null ? fav.getProducto().getIdProducto() : null
        );
    }
}
