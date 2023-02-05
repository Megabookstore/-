package com.bookstore_member.megabookstore_member.service.memberService;

import com.bookstore_member.megabookstore_member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberCheckAuthorityService {

    private final MemberRepository memberRepository;



}
