package com.bookstore_member.megabookstore_member.controller;

import com.bookstore_member.megabookstore_member.service.membershipService.MembershipUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class membershipController {

    private final MembershipUpdateService membershipService;
}
