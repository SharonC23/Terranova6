package com.Terranovans.NS.service;


import com.Terranovans.NS.dto.usuarioDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface usuarioService {

    List<usuarioDTO> getAllUsers();

    //UserDTO authenticateUser(String email, String password);

    usuarioDTO createUser(usuarioDTO usuarioDTO);
    usuarioDTO getUserById(Long cedula);
    usuarioDTO updateUser(Long cedula, usuarioDTO usuarioDTO);
    boolean deleteUser(Long cedula);
    usuarioDTO authenticateUser(String email, String password);




}
