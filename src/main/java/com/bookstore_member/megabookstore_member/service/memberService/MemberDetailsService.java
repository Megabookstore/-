package com.bookstore_member.megabookstore_member.service.memberService;

import com.bookstore_member.megabookstore_member.domain.converter.BooleanToYNConverter;
import com.bookstore_member.megabookstore_member.domain.member.Member;
import com.bookstore_member.megabookstore_member.domain.member.validation.MemberId;
import com.bookstore_member.megabookstore_member.dto.memberDto.AuthMemberDTO;
import com.bookstore_member.megabookstore_member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("MemberDetailsService : " + username);

        Optional<Member> byMemberId = memberRepository.findByMemberId(new MemberId(username));

        if (Objects.isNull(byMemberId)){
                log.info("Object is Null plz check");
        }

//        log.info("Check Email : "+ byMemberId.get().getEmail());



        Member member = byMemberId.get();



        log.info("-----------------");

        AuthMemberDTO authMemberDTO = new AuthMemberDTO(
                member.getMemberId().getMemberId(),
                member.getPassword(),
                member.getRoles().stream()
                        .map(role -> new SimpleGrantedAuthority(
                                "ROLE_" + role.name())).collect(Collectors.toSet()));

        authMemberDTO.setNickName(member.getNickName().getNickName());
        authMemberDTO.setEmail(member.getEmail().getEmail());
        authMemberDTO.setBirth(LocalDateTime.now());
        authMemberDTO.setMan(new BooleanToYNConverter().convertToEntityAttribute("Y"));
        authMemberDTO.setMemberCreatedAt(LocalDateTime.now());


        return authMemberDTO;
    }
}
