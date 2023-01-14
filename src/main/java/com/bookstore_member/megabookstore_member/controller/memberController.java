package com.bookstore_member.megabookstore_member.controller;

import com.bookstore_member.megabookstore_member.dto.MemberRequest;
import com.bookstore_member.megabookstore_member.dto.MemberResponse;
import com.bookstore_member.megabookstore_member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class memberController {

    private final MemberService memberService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public MemberResponse registerMember(
            @RequestBody MemberRequest memberRequest) {
        return memberService.registerMember(memberRequest);

    }


}
