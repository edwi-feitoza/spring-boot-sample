package br.com.edwi.sistema.security;

import br.com.edwi.sistema.exceptions.ApiError;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {

        ApiError apiError = new ApiError(HttpServletResponse.SC_FORBIDDEN, "Acesso negado!");
        httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN, new ObjectMapper().writeValueAsString(apiError));
    }
}
