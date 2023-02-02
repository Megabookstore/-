package com.bookstore_member.megabookstore_member.dto.membershipDto;

//import com.bookstore_member.megabookstore_member.domain.membership.Membership;
import com.bookstore_member.megabookstore_member.domain.membership.valid.MembershipGrade;
import com.bookstore_member.megabookstore_member.domain.membership.valid.MembershipPoint;
import com.bookstore_member.megabookstore_member.domain.membership.valid.MembershipStandardAmount;
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

//    public MembershipResponse(Membership membership){
//        this.membershipNo = membership.getMembershipNo();
//        this.membershipGrade = membershipGrade(membership).getMembershipGrade();
//        this.membershipStandardAmount = membershipStandardAmount(membership).getMembershipStandardAmount();
//        this.membershipPoint = membershipPoint(membership).getMembershipPoint();
//    }

//    public MembershipGrade membershipGrade(Membership membershipEntity){
//
//        return membershipEntity.getMembershipGrade();
//    }
//    public MembershipPoint membershipPoint(Membership membershipEntity){
//
//        return membershipEntity.getMembershipPoint();
//    }
//    public MembershipStandardAmount membershipStandardAmount(Membership membershipEntity){
//        return membershipEntity.getMembershipStandardAmount();
//    }
}
