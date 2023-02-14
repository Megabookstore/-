package com.bookstore_member.megabookstore_member.jwt.security;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenValidTestController {
    @PostMapping("/test")
    public String test(){
        return "test 통과";
    }
}
