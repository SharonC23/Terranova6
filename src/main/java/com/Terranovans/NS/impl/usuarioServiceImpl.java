package com.Terranovans.NS.impl;


import com.Terranovans.NS.dto.usuarioDTO;
import com.Terranovans.NS.entity.usuario;
import com.Terranovans.NS.exceptions.CustomException;
import com.Terranovans.NS.repository.usuarioRepository;
import com.Terranovans.NS.service.usuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class usuarioServiceImpl implements usuarioService {

    private final usuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public usuarioServiceImpl(com.Terranovans.NS.repository.usuarioRepository usuarioRepository, ModelMapper modelMapper) {
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<usuarioDTO> getAllUsers() {
        List<usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(usuario -> modelMapper.map(usuario, usuarioDTO.class))
                .toList();

    }

    @Override
    public usuarioDTO createUser(usuarioDTO usuarioDTO) {
        if(usuarioRepository.findByEmail(usuarioDTO.getEmail()) != null) {
            throw new CustomException("El email ya está en uso");
        } else {
            usuario usuario = modelMapper.map(usuarioDTO, usuario.class);
            usuario savedUsuario = usuarioRepository.save(usuario);
            return modelMapper.map(savedUsuario, usuarioDTO.class);
        }
    }

    @Override
    public usuarioDTO getUserById(String cedula) {
        usuario usuario = usuarioRepository.findById(cedula)
                .orElseThrow(() -> new CustomException("Usuario no encontrado con cédula: " + cedula));
        return modelMapper.map(usuario, usuarioDTO.class);
    }

    @Override
    public usuarioDTO updateUser(String cedula, usuarioDTO usuarioDTO) {
        usuario usuario = usuarioRepository.findById(cedula)
                .orElseThrow(()-> new CustomException("Usuario no encontrado con cédula: " + cedula));

        usuario.setNombres(usuarioDTO.getNombres());
        usuario.setEmail(usuarioDTO.getEmail());

        usuario updated = usuarioRepository.save(usuario);
        return modelMapper.map(updated, usuarioDTO.class);
    }

    @Override
    public boolean deleteUser(String cedula) {
        if(!usuarioRepository.existsById(cedula)) {
            throw new CustomException("Usuario no encontrado con cédula: " + cedula);
        }
        usuarioRepository.deleteById(cedula);
        return true;
    }

    @Override
    public usuarioDTO authenticateUser(String email, String password) {
        return null;
    }
}
