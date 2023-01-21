package com.bookstore_member.megabookstore_member.service.memberService;

import com.bookstore_member.megabookstore_member.domain.member.Member;
import com.bookstore_member.megabookstore_member.dto.memberDto.MemberRequest;
import com.bookstore_member.megabookstore_member.dto.memberDto.MemberResponse;
import com.bookstore_member.megabookstore_member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberRegisterService {

    private final MemberRepository memberRepository;


    @Transactional
    public MemberResponse registerMember(MemberRequest memberRequest) {

        Member member = memberRepository.save(memberRequest.MemberRequestToMember());

        return new MemberResponse(member);
    }


}
