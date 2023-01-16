package com.bookstore_member.megabookstore_member.repository;

import com.bookstore_member.megabookstore_member.entity.MembershipEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface MembershipRepository extends JpaRepository<MembershipEntity, Long> {


}
