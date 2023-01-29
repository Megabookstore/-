package com.bookstore_member.megabookstore_member.domain.membership;

import com.bookstore_member.megabookstore_member.domain.membership.valid.MembershipGrade;
import com.bookstore_member.megabookstore_member.domain.membership.valid.MembershipPoint;
import com.bookstore_member.megabookstore_member.domain.membership.valid.MembershipStandardAmount;
import com.bookstore_member.megabookstore_member.domain.membership_history.MembershipHistory;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long membershipNo;
    @Embedded
    private MembershipGrade membershipGrade;
    @Embedded
    private MembershipStandardAmount membershipStandardAmount;
    @Embedded
    private MembershipPoint membershipPoint;

    public void updateMembership(Long membershipNo, MembershipGrade membershipGrade,
                                 MembershipStandardAmount membershipStandardAmount,
                                 MembershipPoint membershipPoint){
        this.membershipNo = membershipNo;
        this.membershipGrade = membershipGrade;
        this.membershipStandardAmount = membershipStandardAmount;
        this.membershipPoint = membershipPoint;

    }


}
