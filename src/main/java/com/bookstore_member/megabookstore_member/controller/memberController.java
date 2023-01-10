package com.bookstore_member.megabookstore_member.controller;

import com.bookstore_member.megabookstore_member.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class memberController {

    private MemberService memberService;
}
