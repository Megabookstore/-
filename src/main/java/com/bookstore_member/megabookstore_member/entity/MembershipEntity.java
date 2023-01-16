package com.bookstore_member.megabookstore_member.entity;

import com.bookstore_member.megabookstore_member.entity.valid.MembershipGrade;
import com.bookstore_member.megabookstore_member.entity.valid.MembershipPoint;
import com.bookstore_member.megabookstore_member.entity.valid.MembershipStandardAmount;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class MembershipEntity {
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
