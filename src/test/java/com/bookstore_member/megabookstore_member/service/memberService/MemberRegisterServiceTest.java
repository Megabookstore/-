package com.bookstore_member.megabookstore_member.service.memberService;

import com.bookstore_member.megabookstore_member.domain.converter.BooleanToYNConverter;
import com.bookstore_member.megabookstore_member.domain.member.Member;
import com.bookstore_member.megabookstore_member.domain.member.validation.Email;
import com.bookstore_member.megabookstore_member.domain.member.validation.MemberId;
import com.bookstore_member.megabookstore_member.domain.member.validation.NickName;
import com.bookstore_member.megabookstore_member.domain.member.validation.PhoneNumber;
import com.bookstore_member.megabookstore_member.domain.membership.Membership;
import com.bookstore_member.megabookstore_member.dto.memberDto.MemberRequest;
import com.bookstore_member.megabookstore_member.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;


@SpringBootTest
class MemberRegisterServiceTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberUpdateService memberUpdateService;

    private Member member;
    private BooleanToYNConverter booleanToYNConverter;

    @BeforeEach
    void setUp() {
        booleanToYNConverter = new BooleanToYNConverter();


        member = new Member(1L,new Membership(), new MemberId("twww"), new NickName("ddd"), booleanToYNConverter.convertToEntityAttribute("Y"), LocalDateTime.now(), "tttt", new PhoneNumber("011111"), new Email("sadas@asd"), LocalDateTime.now());

        memberRepository.save(member);

    }

    @DisplayName("회원 등록 테스트")
    @Test
    void registerMember() {

        Member findMember = memberRepository.findById(1L).get();

        Assertions.assertThat(findMember.getNickName()).isEqualTo(new NickName("ddd"));

    }

    @DisplayName("회원 조회 테스트")
    @Test
    void showMember() {

        Member find = memberRepository.findById(1L).get();

        Assertions.assertThat(find.getMemberId()).isEqualTo(new MemberId("twww"));
    }

    @DisplayName("회원 수정 테스트")
    @Test
    void updateMember() {


        MemberRequest memberRequest = new MemberRequest(1L,"t", "ttt", false, LocalDateTime.now(), "123", "123213", "qw@asd", LocalDateTime.now());

        memberUpdateService.updateMember(1L, memberRequest);

        Member findMember = memberRepository.findById(1L).get();

        Assertions.assertThat(findMember.getMemberId()).isEqualTo(new MemberId("t"));

    }

    @DisplayName("회원 삭제 테스트")
    @Test
    void deleteMember() {

        Optional<Member> member1 = memberRepository.findById(1L);

        memberRepository.delete(member1.get());

        Optional<Member> byId = memberRepository.findById(1L);

        org.junit.jupiter.api.Assertions.assertFalse(byId.isPresent());


    }

}