package com.bookstore_member.megabookstore_member.jwt;
// jwtProvider 가 검증을 끝낸 jwt 로부터 유저 정보를 조회해와서 UserPasswordAuthenticationFilter 로 전달하는 클래스
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends GenericFilterBean {

    private final JwtProvider jwtProvider;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException{
        //헤더에서 jwt 받아옴
        String token = jwtProvider.resolveToken((HttpServletRequest) request);
        //유효한 토큰인지 확인
        if (token != null && jwtProvider.validateToken(token)){
            //토큰이 유효하면 토큰으로부터 유저 정보 받아옴
            Authentication authentication = jwtProvider.getAuthentication(token);
            //securityContext 에 authentication 객체 저장
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request,response);

    }
}
