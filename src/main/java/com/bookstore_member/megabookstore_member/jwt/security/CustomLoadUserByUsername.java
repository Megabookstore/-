package com.bookstore_member.megabookstore_member.jwt.security;

import com.bookstore_member.megabookstore_member.dto.memberDto.MemberDTO;
import com.bookstore_member.megabookstore_member.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomLoadUserByUsername implements UserDetailsService {
    @Autowired
    MemberRepository memberRepository;


    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        MemberDTO user = memberRepository.getOne(loginId);
        if(user == null)     throw new UsernameNotFoundException("유저를 찾을 수 없습니다.");
        return user;
    }
}
