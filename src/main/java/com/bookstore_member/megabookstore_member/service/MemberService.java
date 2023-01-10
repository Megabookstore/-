package com.bookstore_member.megabookstore_member.service;

import com.bookstore_member.megabookstore_member.domain.Member;
import com.bookstore_member.megabookstore_member.dto.MemberRequest;
import com.bookstore_member.megabookstore_member.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class MemberService {

    private MemberRepository memberRepository;

    private Long registerMember(MemberRequest memberRequest) {
        Member member = Member.builder()
                .memberNo(memberRequest.getMemberNo())
                .membershipNo(memberRequest.getMembershipNo())
                .memberCreatedAt(memberRequest.getMemberCreatedAt())
                .birth(memberRequest.getBirth())
                .email(memberRequest.getEmail())
                .id(memberRequest.getId())
                .nickName(memberRequest.getNickName())
                .isMan(memberRequest.isMan())
                .password(memberRequest.getPassword())
                .build();

        return member.getMemberNo();
    }

}
