package com.bookstore_member.megabookstore_member.service.MembershipHistoryService;

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
import com.bookstore_member.megabookstore_member.domain.membership_history.MembershipHistory;
import com.bookstore_member.megabookstore_member.dto.membershipDto.MembershipRequest;
import com.bookstore_member.megabookstore_member.repository.MemberRepository;
import com.bookstore_member.megabookstore_member.repository.MembershipHistoryRepository;
import com.bookstore_member.megabookstore_member.repository.MembershipRepository;
import com.bookstore_member.megabookstore_member.service.membershipHistoryService.MembershipHistoryUpdateService;
import com.bookstore_member.megabookstore_member.service.membershipService.MembershipService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
public class MembershipHistoryServiceTest {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MembershipService membershipService;
    @Autowired
    MembershipRepository membershipRepository;
    @Autowired
    MembershipHistoryRepository membershipHistoryRepository;
    @Autowired
    MembershipHistoryUpdateService membershipHistoryUpdateService;

    private Member member;
    private BooleanToYNConverter booleanToYNConverter;

    @BeforeEach
    void setUp() {
        booleanToYNConverter = new BooleanToYNConverter();
        member = new Member(1L, null, new MemberId("twww"), new NickName("ddd"), booleanToYNConverter.convertToEntityAttribute("y"), LocalDateTime.now(), "tttt", new PhoneNumber("011111"), new Email("sadas@asd"), LocalDateTime.now());
        memberRepository.save(member);
    }

    @Test
    @DisplayName("멤버십 히스토리 등록 테스트")
    void RegisterMembershipHistory() {

        Membership membership =  new Membership(1L, new MembershipGrade("White"), new MembershipStandardAmount(1000L), new MembershipPoint(1000L));
        MembershipHistory membershipHistory = new MembershipHistory(1L, member, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        membershipHistory.registerMembershipHistory(membershipHistory);
    }

    @DisplayName("멤버십 히스토리 수정 테스트")
    @Test
    void updateMembershipHistory(){
        Member member1 = memberRepository.findById(1L).get();

        MembershipRequest membershipRequest = new MembershipRequest(1L, "White", 10000L, 1000L);

        membershipHistoryUpdateService.updateMembershipHistory(1L, membershipRequest);

        Membership find = membershipRepository.findById(1L).get();

        Assertions.assertThat(find.getMembershipGrade().equals(new MembershipGrade("Gold"));

    }
}



