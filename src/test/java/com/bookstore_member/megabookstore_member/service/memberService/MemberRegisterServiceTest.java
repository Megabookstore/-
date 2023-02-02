package com.bookstore_member.megabookstore_member.service.memberService;

import com.bookstore_member.megabookstore_member.domain.converter.BooleanToYNConverter;
import com.bookstore_member.megabookstore_member.domain.member.Member;
import com.bookstore_member.megabookstore_member.domain.member.Role;
import com.bookstore_member.megabookstore_member.domain.member.validation.Email;
import com.bookstore_member.megabookstore_member.domain.member.validation.MemberId;
import com.bookstore_member.megabookstore_member.domain.member.validation.NickName;
import com.bookstore_member.megabookstore_member.domain.member.validation.PhoneNumber;
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
import java.util.Set;


@SpringBootTest
class MemberRegisterServiceTest {

    @Autowired
    MemberRepository memberRepository;

    //권한 ->

    @Autowired
    MemberUpdateService memberUpdateService;

    private Member member;
    private BooleanToYNConverter booleanToYNConverter;

    @BeforeEach
    void setUp() {
        booleanToYNConverter = new BooleanToYNConverter();

        member = Member.builder()
                .memberNo(1L)
                .memberId(new MemberId("twwwasd8232"))
                .nickName(new NickName("sadas"))
                .isMan(booleanToYNConverter.convertToEntityAttribute("Y"))
                .birth(LocalDateTime.now())
                .password("asdasd")
                .phoneNumber(new PhoneNumber("010-2323-23232"))
                .email(new Email("asdas@asDasd"))
                .memberCreatedAt(LocalDateTime.now())
                .build();


        member.addMemberRole(Role.NORMAL);

        memberRepository.save(member);

    }

    @DisplayName("회원 등록 테스트")
    @Test
    void registerMember() {

        Member findMember = memberRepository.findById(1L).get();

        Assertions.assertThat(findMember.getNickName()).isEqualTo(new NickName("sadas"));

        Set<Role> roles = findMember.getRoles();

        for (Role role : roles) {
            Assertions.assertThat(role).isEqualTo(Role.NORMAL);

        }




    }

    @DisplayName("회원 조회 테스트")
    @Test
    void showMember() {

        Member find = memberRepository.findById(1L).get();

        Assertions.assertThat(find.getMemberId()).isEqualTo(new MemberId("twwwasd8232"));
    }

    @DisplayName("회원 수정 테스트")
    @Test
    void updateMember() {


        MemberRequest memberRequest = new MemberRequest(1L, "t", "ttt", false, LocalDateTime.now(), "123", "123213", "qw@asd", LocalDateTime.now());

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