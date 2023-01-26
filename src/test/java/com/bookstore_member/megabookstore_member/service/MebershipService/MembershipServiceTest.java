package com.bookstore_member.megabookstore_member.service.MebershipService;

import com.bookstore_member.megabookstore_member.domain.converter.BooleanToYNConverter;
import com.bookstore_member.megabookstore_member.domain.member.Member;
import com.bookstore_member.megabookstore_member.domain.member.validation.Email;
import com.bookstore_member.megabookstore_member.domain.member.validation.MemberId;
import com.bookstore_member.megabookstore_member.domain.member.validation.NickName;
import com.bookstore_member.megabookstore_member.domain.member.validation.PhoneNumber;
import com.bookstore_member.megabookstore_member.domain.membership.Membership;
import com.bookstore_member.megabookstore_member.domain.membership.valid.MembershipGrade;
import com.bookstore_member.megabookstore_member.domain.membership.valid.MembershipPoint;
import com.bookstore_member.megabookstore_member.domain.membership.valid.MembershipStandardAmount;
import com.bookstore_member.megabookstore_member.dto.memberDto.MemberRequest;
import com.bookstore_member.megabookstore_member.dto.membershipDto.MembershipRequest;
import com.bookstore_member.megabookstore_member.repository.MemberRepository;
import com.bookstore_member.megabookstore_member.service.membershipService.MembershipService;
import com.bookstore_member.megabookstore_member.service.membershipService.MembershipUpdateService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
public class MembershipServiceTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MembershipService membershipService;
    @Autowired
    MembershipUpdateService membershipUpdateService;

   private Member member;
    private BooleanToYNConverter booleanToYNConverter;

    @BeforeEach
    void setUp() {
        booleanToYNConverter = new BooleanToYNConverter();

        member = new Member(1L, null, new MemberId("twww"), new NickName("ddd"), booleanToYNConverter.convertToEntityAttribute("Y"), LocalDateTime.now(), "tttt", new PhoneNumber("011111"), new Email("sadas@asd"), LocalDateTime.now());

        memberRepository.save(member);

    }

    @Test
    @DisplayName("멤버십 등록 테스트")
    void registerMembership() {

        Member member1 = memberRepository.findById(1L).get();
        Membership white = new Membership(1L, new MembershipGrade("White"), new MembershipStandardAmount(10000L), new MembershipPoint(1000L));
//        MembershipRequest membershipRequest = new MembershipRequest();
        member1.updateMembership(white);

//        membershipService.addMembership(membershipRequest);
        //then
        Assertions.assertThat(member1.getMembership().getMembershipGrade()).isEqualTo(new MembershipGrade("White"));

    }

    @DisplayName("멤버십 수정 테스트")
    @Test
    void updateMembership(){

        Member member1 = memberRepository.findById(1L).get();

        MembershipRequest membershipRequest = new MembershipRequest(1L, "White", 10000L, 1000L);

        membershipUpdateService.updateMembership(1L, membershipRequest);

        Member find = memberRepository.findById(1L).get();

        Assertions.assertThat(find.getMembership().getMembershipGrade()).isEqualTo(new MembershipGrade("Gold"));
    }


}