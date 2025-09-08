package com.Terranovans.NS.service;


import com.Terranovans.NS.dto.usuarioDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface usuarioService {

    List<usuarioDTO> getAllUsers();

    //UserDTO authenticateUser(String email, String password);

    usuarioDTO createUser(usuarioDTO usuarioDTO);
    usuarioDTO getUserById(String cedula);
    usuarioDTO updateUser(String cedula, usuarioDTO usuarioDTO);
    boolean deleteUser(String cedula);
    usuarioDTO authenticateUser(String email, String password);


    boolean usuarioExiste(String cedula);
}
