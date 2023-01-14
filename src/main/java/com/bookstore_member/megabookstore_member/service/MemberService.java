package com.bookstore_member.megabookstore_member.service;

import com.bookstore_member.megabookstore_member.domain.member.Member;
import com.bookstore_member.megabookstore_member.domain.member.valid.Email;
import com.bookstore_member.megabookstore_member.domain.member.valid.MemberId;
import com.bookstore_member.megabookstore_member.domain.member.valid.NickName;
import com.bookstore_member.megabookstore_member.domain.member.valid.PhoneNumber;
import com.bookstore_member.megabookstore_member.dto.MemberRequest;
import com.bookstore_member.megabookstore_member.dto.MemberResponse;
import com.bookstore_member.megabookstore_member.exception.NotFoundException;
import com.bookstore_member.megabookstore_member.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberResponse registerMember(MemberRequest memberRequest) {
        Member member = memberRepository.save(memberRequest.MemberRequestToMember());

        return new MemberResponse(member);
    }

    public List<MemberResponse> memberList(Pageable pageable) {
        Page<Member> members = memberRepository.findAll(pageable);

        return members.get().map(member -> new MemberResponse(member)).collect(Collectors.toList());
    }

    @Transactional
    public MemberResponse updateMember(Long id, MemberRequest memberRequest) {
        Member member = memberFindById(id);

        member.updateMember(new MemberId(memberRequest.getMemberId()),
                new NickName(memberRequest.getNickName()),
                memberRequest.getPassword(),
                new PhoneNumber(memberRequest.getPhoneNumber()),
                new Email(memberRequest.getEmail())

        );

        return new MemberResponse(member);

    }

    private Member memberFindById(Long id) {
        return memberRepository.findById(id).orElseThrow(NotFoundException::new);
    }


    @Transactional
    public boolean validateMemberIdDuplicate(String memberId) {
        return memberRepository.existsByMemberId(memberId);
    }

    @Transactional
    public boolean validateEmailDuplicate(String email) {
        return memberRepository.existsByEmail(email);
    }

    @Transactional
    public boolean validatePhoneNumberDuplicate(String phoneNumber) {
        return memberRepository.existsByPhoneNumber(phoneNumber);
    }


}
