package com.bookstore_member.megabookstore_member.repository;

import com.bookstore_member.megabookstore_member.domain.membership_history.MembershipHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipHistoryRepository extends JpaRepository<MembershipHistory, Long> {

    boolean existsByMembershipNo(Long MembershipNo);

}
