package com.bookstore_member.megabookstore_member.dto.memberstatusDto;

import com.bookstore_member.megabookstore_member.domain.memberstatus.MemberStatus;
import com.bookstore_member.megabookstore_member.domain.memberstatus.validation.MemberStatusName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberStatusRequest {

    private String memberStatusNo;
    private String memberStatusName;

    public MemberStatus MemberStatusRequestToMemberStatus(){
        return MemberStatus.builder()
                .memberStatusNo(memberStatusNo)
                .memberStatusName(new MemberStatusName(memberStatusName))
                .build();
    }
}
