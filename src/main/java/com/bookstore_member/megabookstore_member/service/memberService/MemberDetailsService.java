package com.bookstore_member.megabookstore_member.service.memberService;

import com.bookstore_member.megabookstore_member.domain.converter.BooleanToYNConverter;
import com.bookstore_member.megabookstore_member.domain.member.Member;
import com.bookstore_member.megabookstore_member.dto.memberDto.MemberDTO;
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

        Optional<Member> byMemberId = memberRepository.loadUserByUsername(username);

        if (Objects.isNull(byMemberId)) {
            log.info("Object is Null plz check");
        }

//        log.info("Check Email : "+ byMemberId.get().getEmail());


        Member member = byMemberId.get();


        log.info("-----------------");

        MemberDTO memberDTO = new MemberDTO();
            member.getMemberId();
                    member.getPassword();
                    member.getRoles().stream()
                            .map(role -> new SimpleGrantedAuthority(
                                    "ROLE_" + role.name())).collect(Collectors.toSet());

            memberDTO.setNickName(member.getNickName().getNickName());
            memberDTO.setEmail(member.getEmail().getEmail());
            memberDTO.setBirth(LocalDateTime.now());
            memberDTO.setMan(new BooleanToYNConverter().convertToEntityAttribute("Y"));
            memberDTO.setMemberCreatedAt(LocalDateTime.now());


            return memberDTO;
        }
    }
