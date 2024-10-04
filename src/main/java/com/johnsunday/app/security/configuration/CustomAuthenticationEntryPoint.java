package com.johnsunday.app.security.configuration;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;

import java.io.IOException;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(
            jakarta.servlet.http.HttpServletRequest request,
            jakarta.servlet.http.HttpServletResponse response,
            AuthenticationException authException)
            throws IOException, ServletException {
        response.sendError(
                jakarta.servlet.http.HttpServletResponse.SC_UNAUTHORIZED,
                "Unauthorized: Authentication is required");
        throw new UnsupportedOperationException("Unimplemented method 'commence'");
    }
}
