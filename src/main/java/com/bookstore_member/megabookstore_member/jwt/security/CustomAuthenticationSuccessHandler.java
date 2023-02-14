package com.bookstore_member.megabookstore_member.jwt.security;

import io.jsonwebtoken.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 인증 성공 핸들링
@Slf4j
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException, java.io.IOException {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(60);
        response.sendRedirect("http://localhost:0208/api/login/success");
    }
}
