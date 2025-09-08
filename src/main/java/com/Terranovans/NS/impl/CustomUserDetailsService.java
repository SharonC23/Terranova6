package com.Terranovans.NS.impl;

import com.Terranovans.NS.entity.usuario;
import com.Terranovans.NS.repository.usuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private usuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<usuario> usuario = usuarioRepository.findByEmail(email);
        if (usuario.isEmpty()) {
            throw new UsernameNotFoundException("Usuario no encontrado con email: " + email);
        }
        return org.springframework.security.core.userdetails.User.builder()
                .username(usuario.get().getEmail())
                .password(usuario.get().getPassword())
                .build();
    }

}
