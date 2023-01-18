package com.bookstore_member.megabookstore_member.dto.memberstatusDto;

import com.bookstore_member.megabookstore_member.domain.member.Member;
import com.bookstore_member.megabookstore_member.domain.memberstatus.MemberStatus;
import com.bookstore_member.megabookstore_member.domain.memberstatus.validation.MemberStatusName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberStatusResponse {
    private String memberStatusNo;
    private String memberStatusName;

    public MemberStatusResponse(MemberStatus memberStatus){
        this.memberStatusNo = memberStatus.getMemberStatusNo();
        this.memberStatusName = memberStatusName(memberStatus).getMemberStatusName();
    }
    public MemberStatusName memberStatusName(MemberStatus memberStatus){
        return memberStatus.getMemberStatusName();
    }
}
