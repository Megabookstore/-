package com.bookstore_member.megabookstore_member.repository;

import com.bookstore_member.megabookstore_member.domain.member.Member;
import com.bookstore_member.megabookstore_member.domain.member.validation.MemberId;
import com.bookstore_member.megabookstore_member.dto.memberDto.MemberDTO;
import org.mapstruct.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
@Mapper

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByMemberId(String memberId);

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);

    boolean existsByNickName(String nickName);

    Optional<Member> findByUsername(String username);


    Optional<Member> loadUserByUsername(String username);

    public MemberDTO getOne(String loginId);
}



