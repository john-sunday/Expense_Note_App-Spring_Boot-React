package com.johnsunday.app.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(
            javax.servlet.http.HttpServletRequest request,
            javax.servlet.http.HttpServletResponse response,
            AuthenticationException authException)
            throws IOException, ServletException {

        response.sendError(
                javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED,
                "Unauthorized: Authentication is required");

        throw new UnsupportedOperationException("Unimplemented method 'commence'");
    }
}
