package com.bookstore_member.megabookstore_member.jwt.security;

import com.bookstore_member.megabookstore_member.dto.memberDto.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

// 로그인 인증 검증
@Slf4j
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private CustomLoadUserByUsername customLoadUserByUsername;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        MemberDTO memberDTO = (MemberDTO) customLoadUserByUsername.loadUserByUsername(authentication.getName().toString());

        String reqPassword = authentication.getCredentials().toString();
        if (!passwordEncoder.matches(reqPassword, memberDTO.getPassword()))
            throw new BadCredentialsException("Not Found User");

        return new UsernamePasswordAuthenticationToken(memberDTO, null, memberDTO.getAuthorities());
    }
    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}