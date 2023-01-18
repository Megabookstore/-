package com.bookstore_member.megabookstore_member.service.memberstatusService;

import com.bookstore_member.megabookstore_member.dto.memberstatusDto.MemberStatusRequest;
import com.bookstore_member.megabookstore_member.exception.AlreadyExistsMemberException;
import com.bookstore_member.megabookstore_member.repository.MemberStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberStatusCheckDuplicateService {
    private MemberStatusRepository memberStatusRepository;

    public void validCheckMemberStatusDuplicate(MemberStatusRequest memberStatusRequest){
        validCheckMemberStatusNoDuplicate(memberStatusRequest.getMemberStatusNo());
        validCheckMemberStatusNameDuplicate(memberStatusRequest.getMemberStatusName());

    }
    @Transactional
    public void validCheckMemberStatusNoDuplicate(String MemberStatusNo){
        if(memberStatusRepository.existsByMemberStatusNo(MemberStatusNo)){
            throw new AlreadyExistsMemberException();
        }
    }
    @Transactional
    public void validCheckMemberStatusNameDuplicate(String MemberStatusName){
        if(memberStatusRepository.existsByMemberStatusName(MemberStatusName)){
            throw new AlreadyExistsMemberException();
        }
    }
}
