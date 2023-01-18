package com.bookstore_member.megabookstore_member.service.memberstatusService;

import com.bookstore_member.megabookstore_member.domain.member.Member;
import com.bookstore_member.megabookstore_member.domain.memberstatus.MemberStatus;
import com.bookstore_member.megabookstore_member.domain.memberstatus.validation.MemberStatusName;
import com.bookstore_member.megabookstore_member.dto.memberstatusDto.MemberStatusRequest;
import com.bookstore_member.megabookstore_member.dto.memberstatusDto.MemberStatusResponse;
import com.bookstore_member.megabookstore_member.repository.MemberStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class MemberStatusUpdateService {
    private final MemberStatusRepository memberStatusRepository;

    @Transactional
    public MemberStatusResponse updateMemberStatus(String id, MemberStatusRequest memberStatusRequest){
//        Member member = memberFindById(id);
        MemberStatus memberStatus = memberStatusRepository.findById(id).get();

        memberStatus.updateMemberStatus(id, new MemberStatusName(memberStatusRequest.getMemberStatusNo()));
        return new MemberStatusResponse(memberStatus);
    }
}
