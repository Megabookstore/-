package com.bookstore_member.megabookstore_member.service.memberstatusService;

import com.bookstore_member.megabookstore_member.domain.memberstatus.MemberStatus;
import com.bookstore_member.megabookstore_member.dto.memberstatusDto.MemberStatusResponse;
import com.bookstore_member.megabookstore_member.repository.MemberStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberStatusListService {
    private final MemberStatusRepository memberStatusRepository;
    public List<MemberStatusResponse> memberStatusList(Pageable pageable){
        Page<MemberStatus> memberStatus1 = memberStatusRepository.findAll(pageable);

        return memberStatus1.get().map(memberStatus -> new MemberStatusResponse(memberStatus)).
                collect(Collectors.toList());
    }
}
