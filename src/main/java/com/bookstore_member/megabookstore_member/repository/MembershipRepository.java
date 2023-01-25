package com.bookstore_member.megabookstore_member.repository;

import com.bookstore_member.megabookstore_member.domain.membership.Membership;
import com.bookstore_member.megabookstore_member.domain.membership.valid.MembershipGrade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipRepository extends JpaRepository<Membership, Long> {


//    public static Membership findByIdAndMembershipGrade(final String membershipNo, final MembershipGrade membershipGrade) {
//        return null;
//    }

    Membership findByIdMembershipGrade(String membershipNo, MembershipGrade membershipGrade);
}
