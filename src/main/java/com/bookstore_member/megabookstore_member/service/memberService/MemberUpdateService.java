package com.bookstore_member.megabookstore_member.service.memberService;

import com.bookstore_member.megabookstore_member.domain.member.Member;
import com.bookstore_member.megabookstore_member.domain.member.validation.Email;
import com.bookstore_member.megabookstore_member.domain.member.validation.MemberId;
import com.bookstore_member.megabookstore_member.domain.member.validation.NickName;
import com.bookstore_member.megabookstore_member.domain.member.validation.PhoneNumber;
import com.bookstore_member.megabookstore_member.dto.memberDto.MemberRequest;
import com.bookstore_member.megabookstore_member.dto.memberDto.MemberResponse;
import com.bookstore_member.megabookstore_member.exception.NotFoundException;
import com.bookstore_member.megabookstore_member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class MemberUpdateService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberResponse updateMember(String  id, MemberRequest memberRequest) {
        Member member = memberFindById(Long.valueOf(id));

        member.updateMember(String.valueOf(new MemberId(memberRequest.getMemberId())),
                new NickName(memberRequest.getNickName()),
                memberRequest.getPassword(),
                new PhoneNumber(memberRequest.getPhoneNumber()),
                new Email(memberRequest.getEmail())

        );

        memberRepository.save(member);

        return new MemberResponse(member);

    }

    private Member memberFindById(Long id) {
        return memberRepository.findById(id).orElseThrow(NotFoundException::new);
    }


}
