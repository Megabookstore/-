package com.bookstore_member.megabookstore_member.service.memberstatusService;

import com.bookstore_member.megabookstore_member.domain.memberstatus.MemberStatus;
import com.bookstore_member.megabookstore_member.dto.memberstatusDto.MemberStatusRequest;
import com.bookstore_member.megabookstore_member.dto.memberstatusDto.MemberStatusResponse;
import com.bookstore_member.megabookstore_member.repository.MemberStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberStatusRegisterService {
    private final MemberStatusRepository memberStatusRepository;
    private final MemberStatusCheckDuplicateService memberStatusCheckDuplicateService;

    @Transactional
    public MemberStatusResponse registerMemberStatus(MemberStatusRequest memberStatusRequest){
        memberStatusCheckDuplicateService.validCheckMemberStatusDuplicate(memberStatusRequest);
        MemberStatus memberStatus = memberStatusRepository.save(memberStatusRequest.MemberStatusRequestToMemberStatus());
        return new MemberStatusResponse(memberStatus);
    }
}
