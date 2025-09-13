package com.Terranovans.NS.impl;


import com.Terranovans.NS.dto.usuarioDTO;
import com.Terranovans.NS.entity.Usuario;
import com.Terranovans.NS.exceptions.CustomException;
import com.Terranovans.NS.repository.UsuarioRepository;
import com.Terranovans.NS.service.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, ModelMapper modelMapper) {
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<usuarioDTO> getAllUsers() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(usuario -> modelMapper.map(usuario, usuarioDTO.class))
                .toList();

    }

    @Override
    public usuarioDTO createUser(usuarioDTO usuarioDTO) {
        if (usuarioRepository.findByEmail(usuarioDTO.getEmail()) != null) {
            throw new CustomException("El email ya está en uso");
        } else {
            Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
            Usuario savedUsuario = usuarioRepository.save(usuario);
            return modelMapper.map(savedUsuario, usuarioDTO.class);
        }
    }

    @Override
    public usuarioDTO getUserById(String cedula) {
        Usuario usuario = usuarioRepository.findById(cedula)
                .orElseThrow(() -> new CustomException("Usuario no encontrado con cédula: " + cedula));
        return modelMapper.map(usuario, usuarioDTO.class);
    }

    @Override
    public usuarioDTO updateUser(String cedula, usuarioDTO usuarioDTO) {
        Usuario usuario = usuarioRepository.findById(cedula)
                .orElseThrow(() -> new CustomException("Usuario no encontrado con cédula: " + cedula));

        usuario.setNombres(usuarioDTO.getNombres());
        usuario.setEmail(usuarioDTO.getEmail());

        Usuario updated = usuarioRepository.save(usuario);
        return modelMapper.map(updated, usuarioDTO.class);
    }

    @Override
    public boolean deleteUser(String cedula) {
        if (!usuarioRepository.existsById(cedula)) {
            throw new CustomException("Usuario no encontrado con cédula: " + cedula);
        }
        usuarioRepository.deleteById(cedula);
        return true;
    }

    @Override
    public usuarioDTO authenticateUser(String email, String password) {
        return null;
    }

    @Override
    public boolean usuarioExiste(String cedula) {
        return false;
    }

    @Override
    public usuarioDTO getUserByEmail(String email) {
        return usuarioRepository.findByEmail(email)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Override
    public Usuario findByEmail(String email) {
        return null;
    }

    private usuarioDTO convertToDTO(Usuario usuario) {
        return new usuarioDTO(
                usuario.getCedula(),
                usuario.getNombres(),
                usuario.getApellidos(),
                usuario.getEmail(),
                usuario.getPassword()
        );
    }

}
