package com.bookstore_member.megabookstore_member.controller;

import com.bookstore_member.megabookstore_member.dto.memberstatusDto.MemberStatusRequest;
import com.bookstore_member.megabookstore_member.dto.memberstatusDto.MemberStatusResponse;
import com.bookstore_member.megabookstore_member.service.memberstatusService.MemberStatusRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("memberStatus")
public class memberStatusController {
    private final MemberStatusRegisterService memberStatusRegisterService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public MemberStatusResponse registerMemberStatus(
            @RequestBody MemberStatusRequest memberStatusRequest){
        return memberStatusRegisterService.registerMemberStatus(memberStatusRequest);
    }

}
