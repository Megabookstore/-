package com.bookstore_member.megabookstore_member.dto.membershipDto;

import com.bookstore_member.megabookstore_member.entity.MembershipEntity;
import com.bookstore_member.megabookstore_member.entity.valid.MembershipGrade;
import com.bookstore_member.megabookstore_member.entity.valid.MembershipPoint;
import com.bookstore_member.megabookstore_member.entity.valid.MembershipStandardAmount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MembershipRequest {

    private Long membershipNo;
    private String membershipGrade;
    private Long membershipStandardAmount;
    private Long membershipPoint;

    public MembershipEntity MemberRequestToMember(){
        return MembershipEntity.builder()
                .membershipNo(membershipNo)
                .membershipGrade(new MembershipGrade(membershipGrade))
                .membershipStandardAmount(new MembershipStandardAmount(membershipStandardAmount))
                .membershipPoint(new MembershipPoint(membershipPoint))
                .build();
    }

}
