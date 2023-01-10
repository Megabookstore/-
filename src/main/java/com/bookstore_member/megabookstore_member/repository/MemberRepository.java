package com.bookstore_member.megabookstore_member.repository;

import com.bookstore_member.megabookstore_member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
