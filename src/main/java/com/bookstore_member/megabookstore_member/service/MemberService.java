package com.bookstore_member.megabookstore_member.service;

import com.bookstore_member.megabookstore_member.domain.member.Member;
import com.bookstore_member.megabookstore_member.dto.MemberRequest;
import com.bookstore_member.megabookstore_member.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.ldap.PagedResultsControl;


@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private MemberRepository memberRepository;

    @Transactional
    public Long registerMember(MemberRequest memberRequest) {
        Member member = Member.builder()
                .memberNo(memberRequest.getMemberNo())
                .membershipNo(memberRequest.getMembershipNo())
                .memberCreatedAt(memberRequest.getMemberCreatedAt())
                .birth(memberRequest.getBirth())
                .email(memberRequest.getEmail())
                .memberId(memberRequest.getId())
                .nickName(memberRequest.getNickName())
                .isMan(memberRequest.isMan())
                .password(memberRequest.getPassword())
                .build();

        return member.getMemberNo();
    }

    @Transactional
    public boolean validateMemberIdDuplicate(String memberId){
        return memberRepository.existsByMemberId(memberId);
    }

    @Transactional
    public boolean validateEmailDuplicate(String email){
        return memberRepository.existsByEmail(email);
    }

    @Transactional
    public boolean validatePhoneNumberDuplicate(String phoneNumber){
        return memberRepository.existsByPhoneNumber(phoneNumber);
    }


}
