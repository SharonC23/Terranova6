package com.Terranovans.NS.config;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        String redirectURL = "/index"; // Página predeterminada

        // Recorremos todos los roles para decidir la redirección
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            String role = authority.getAuthority();

            if ("ROLE_USER".equals(role)) {
                redirectURL = "/user/dashboard"; // Ruta para usuario autenticado
                break;
            }
        }

        // Redirige al usuario según su rol o a la página por defecto
        response.sendRedirect(request.getContextPath() + redirectURL);
    }
}
