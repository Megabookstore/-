package com.bookstore_member.megabookstore_member.repository;

import com.bookstore_member.megabookstore_member.domain.memberstatus.MemberStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberStatusRepository extends JpaRepository<MemberStatus, String> {

    boolean existsByMemberStatusNo(String memberStatusNo);
    boolean existsByMemberStatusName(String memberStatusName);
}
