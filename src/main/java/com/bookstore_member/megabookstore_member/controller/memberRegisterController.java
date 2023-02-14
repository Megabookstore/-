package com.bookstore_member.megabookstore_member.controller;

import com.bookstore_member.megabookstore_member.domain.member.Member;
import com.bookstore_member.megabookstore_member.domain.member.Role;
import com.bookstore_member.megabookstore_member.dto.memberDto.MemberRequest;
import com.bookstore_member.megabookstore_member.dto.memberDto.MemberResponse;
import com.bookstore_member.megabookstore_member.service.memberService.MemberRegisterService;
import io.swagger.models.Model;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
@Slf4j
@Controller
public class memberRegisterController {
    private final MemberRegisterService memberRegisterService;

    private final BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public MemberResponse registerMember(
            @RequestBody MemberRequest memberRequest) {
        log.info("please {}");
        return memberRegisterService.registerMember(memberRequest);

    }


    @ModelAttribute("roles")
    public Map<String, Role> roles(){
        Map<String, Role> map = new LinkedHashMap<>();
        map.put("관리자", Role.ROLE_ADMIN);
        map.put("일반 사용자",Role.ROLE_NORMAL);
        return map;
    }






}
