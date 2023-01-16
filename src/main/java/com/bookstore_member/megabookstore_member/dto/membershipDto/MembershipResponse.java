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
public class MembershipResponse{
    private Long membershipNo;
    private String membershipGrade;
    private Long membershipStandardAmount;
    private Long membershipPoint;

    public MembershipResponse(MembershipEntity membership){
        this.membershipNo = membership.getMembershipNo();
        this.membershipGrade = membershipGrade(membership).getMembershipGrade();
        this.membershipStandardAmount = membershipStandardAmount(membership).getMembershipStandardAmount();
        this.membershipPoint = membershipPoint(membership).getMembershipPoint();
    }

    public MembershipGrade membershipGrade(MembershipEntity membershipEntity){

        return membershipEntity.getMembershipGrade();
    }
    public MembershipPoint membershipPoint(MembershipEntity membershipEntity){

        return membershipEntity.getMembershipPoint();
    }
    public MembershipStandardAmount membershipStandardAmount(MembershipEntity membershipEntity){
        return membershipEntity.getMembershipStandardAmount();
    }
}
