package com.bookstore_member.megabookstore_member.controller;

import com.bookstore_member.megabookstore_member.dto.memberDto.MemberRequest;
import com.bookstore_member.megabookstore_member.dto.memberDto.MemberResponse;
import com.bookstore_member.megabookstore_member.service.memberService.MemberRegisterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
@Slf4j
public class memberRegisterController {

    private final MemberRegisterService memberRegisterService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public MemberResponse registerMember(
            @RequestBody MemberRequest memberRequest) {
        log.info("please {}");
        return memberRegisterService.registerMember(memberRequest);

    }


}
