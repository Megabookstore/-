package com.bookstore_member.megabookstore_member.repository;

import com.bookstore_member.megabookstore_member.domain.membership.Membership;
import com.bookstore_member.megabookstore_member.domain.membership.valid.MembershipGrade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipRepository extends JpaRepository<Membership, Long> {

    boolean existsByMembershipGrade(String MembershipGrade);
    boolean existsByMembershipPoint(Long MembershipPoint);
    boolean existsByMembershipStandardAmount(Long MembershipStandardAmount);


}
