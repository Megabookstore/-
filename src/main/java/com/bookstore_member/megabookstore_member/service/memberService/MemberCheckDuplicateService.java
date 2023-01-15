package com.bookstore_member.megabookstore_member.service.memberService;

import com.bookstore_member.megabookstore_member.dto.memberDto.MemberRequest;
import com.bookstore_member.megabookstore_member.exception.AlreadyExistsMemberException;
import com.bookstore_member.megabookstore_member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCheckDuplicateService {

    private final MemberRepository memberRepository;

    public void validateCheckDuplicate(MemberRequest memberRequest) {
        validateEmailDuplicate(memberRequest.getEmail());
        validatePhoneNumberDuplicate(memberRequest.getPhoneNumber());
        validatePhoneNumberDuplicate(memberRequest.getPhoneNumber());
    }


    @Transactional
    public void validateMemberIdDuplicate(String memberId) {
        if (memberRepository.existsByMemberId(memberId)) {
            throw new AlreadyExistsMemberException();
        }
    }

    @Transactional
    public void validateEmailDuplicate(String email) {
        if (memberRepository.existsByEmail(email)) {
            throw new AlreadyExistsMemberException();
        }
    }

    @Transactional
    public void validatePhoneNumberDuplicate(String phoneNumber) {
        if (memberRepository.existsByPhoneNumber(phoneNumber)) {
            throw new AlreadyExistsMemberException();
        }
    }
}
