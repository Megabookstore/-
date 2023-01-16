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

    private MemberRepository memberRepository;

    public void validCheckMemberDuplicate(MemberRequest memberRequest) {
        validCheckMemberEmailDuplicate(memberRequest.getEmail());
        validCheckMemberIdDuplicate(memberRequest.getMemberId());
        validCheckMemberNickNameDuplicate(memberRequest.getNickName());
        validCheckMemberPhoneNumberDuplicate(memberRequest.getPhoneNumber());

    }

    @Transactional
    public void validCheckMemberIdDuplicate(String id){
        if(memberRepository.existsByMemberId(id)){
            throw new AlreadyExistsMemberException();
        }
    }

    @Transactional
    public void validCheckMemberEmailDuplicate(String email){
        if(memberRepository.existsByEmail(email)){
            throw new AlreadyExistsMemberException();
        }
    }

    @Transactional
    public void validCheckMemberNickNameDuplicate(String nickName){
        if(memberRepository.existsByNickName(nickName)){
            throw new AlreadyExistsMemberException();
        }
    }

    @Transactional
    public void validCheckMemberPhoneNumberDuplicate(String phoneNumber){
        if(memberRepository.existsByPhoneNumber(phoneNumber)){
            throw new AlreadyExistsMemberException();
        }
    }



}
