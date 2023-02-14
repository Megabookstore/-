package com.bookstore_member.megabookstore_member.jwt;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends OncePerRequestFilter {
    private final JwtProvider jwtProvider;
    public JwtFilter(JwtProvider jwtProvider){
        this.jwtProvider = jwtProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws SecurityException, IOException, ServletException {
        String token = jwtProvider.resolveToken(request);

        // 인증 후 최종 인증 결과(user 객체, 권한 정보) 를 담고 SecurityContext 에 저장되어 전역적으로 참조 가능
        // SecurityContextHolder = 인증 저장소
        if(jwtProvider.validateToken(token)){
            Authentication authentication = jwtProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }
}
