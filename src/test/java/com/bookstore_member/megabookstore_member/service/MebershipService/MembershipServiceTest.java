package com.bookstore_member.megabookstore_member.service.MebershipService;

import com.bookstore_member.megabookstore_member.domain.membership.Membership;
import com.bookstore_member.megabookstore_member.domain.membership.valid.MembershipGrade;
import com.bookstore_member.megabookstore_member.dto.membershipDto.MembershipResponse;
import com.bookstore_member.megabookstore_member.repository.MembershipRepository;
import com.bookstore_member.megabookstore_member.service.membershipService.MembershipService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.xmlunit.util.Linqy.any;

@SpringBootTest
@ExtendWith(MockitoExtension.class) //JUnit5와 Mockito를 연동하기 위해 사용
public class MembershipServiceTest {
    @InjectMocks //가짜 객체 주입 어노테이션
    private MembershipService target;
    @Mock //가짜 mock 객체 생성 어노테이션
    private MembershipRepository membershipRepository;
    private final String membershipNo = "membershipNo";
    private final MembershipGrade membershipGrade = MembershipGrade.membershipGrade;
    private final Integer membershipPoint = 10000;
    private final Integer membershipStandardAmount = 1000;

    @Test
    @DisplayName("멤버십등록실패 : 이미 존재합니다.")
    void failRegister() {
        //given
        doReturn(null).when(membershipRepository).findByIdMembershipGrade(membershipNo, membershipGrade);
        doReturn(Membership.builder().build()).when(membershipRepository).findByIdMembershipGrade(membershipNo, membershipGrade);

        //when
        final Membership result = target.addMembership(membershipNo, membershipGrade, membershipPoint);

        //then
        assertThat(result.getMembershipNo()).isNotNull();
        assertThat(result.getMembershipGrade()).isEqualTo(MembershipGrade.membershipGrade);

        //verify
        verify(membershipRepository, times(1)).findByIdMembershipGrade(membershipNo, membershipGrade);
        verify(membershipRepository, times(1)).save(any(Membership.class));
    }

    private Membership membership() {
        return Membership.builder()
                .membershipNo(membershipNo)
                .membershipPoint(membershipPoint)
                .membershipGrade(membershipGrade)
                .membershipStandardAmount(membershipStandardAmount)
                .build();

        return membershipRepository.save(membership());
    }

    @Test
    @DisplayName("멤버십 등록 성공")
    public void successRegister() {
        //given
        doReturn(null).when(membershipRepository).findByIdMembershipGrade(membershipNo, membershipGrade);
        doReturn(membership()).when(membershipRepository).save(any(Membership.class));

        //when
        final MembershipResponse result = target.addMembership(membershipNo, membershipGrade, membershipPoint, membershipStandardAmount);

        //then
        assertThat(result.getMembershipNo()).isNotNull();
        assertThat(result.getMembershipGrade()).isEqualTo(MembershipGrade.membershipGrade);

        //verify
        verify(membershipRepository, times((1)).findByIdAndMembershipGrade(membershipNo, membershipGrade);
        verify(membershipRepository, times((1)).save(any(Membership.class));


    }
}