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
import com.bookstore_member.megabookstore_member.dto.membershipDto.MembershipRequest;
import com.bookstore_member.megabookstore_member.repository.MemberRepository;
import com.bookstore_member.megabookstore_member.service.memberService.MemberUpdateService;
import com.bookstore_member.megabookstore_member.service.membershipService.MembershipService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
//@ExtendWith(MockitoExtension.class) //JUnit5와 Mockito를 연동하기 위해 사용
public class MembershipServiceTest {
    //    @InjectMocks //가짜 객체 주입 어노테이션
//    private MembershipService membershipService;
//    @Mock //가짜 mock 객체 생성 어노테이션
//    private MemberRepository memberRepository;
//    private final Long membershipNo = 1L;
//    private final String membershipGrade = "White";
//    private final Integer membershipPoint = 10000;
//    private final Integer membershipStandardAmount = 1000;
//
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MembershipService membershipService;

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
    void failRegister() {
//        //given
//        doReturn(null).when(membershipRepository).findByIdMembershipGrade(membershipNo, membershipGrade);
//        doReturn(Membership.builder().build()).when(membershipRepository).findByIdMembershipGrade(membershipNo, membershipGrade);
//
//        //when
//        final Membership result = membershipService.addMembership(membershipNo, membershipGrade, membershipPoint);

        Member member1 = memberRepository.findById(1L).get();
        Membership white = new Membership(1L, new MembershipGrade("White"), new MembershipStandardAmount(10000L), new MembershipPoint(1000L));
        MembershipRequest membershipRequest = new MembershipRequest();
        member1.updateMembership(white);

        membershipService.addMembership(membershipRequest);
        //then
        Assertions.assertThat(member1.getMembership().getMembershipGrade()).isEqualTo(new MembershipGrade("White"));


//        //verify
//        verify(membershipRepository, times(1)).findByIdMembershipGrade(membershipNo, membershipGrade);
//        verify(membershipRepository, times(1)).save(any(Membership.class));
    }




}