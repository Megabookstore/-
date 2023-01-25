package com.bookstore_member.megabookstore_member.service.MebershipService;

import com.bookstore_member.megabookstore_member.domain.membership.Membership;
import com.bookstore_member.megabookstore_member.domain.membership.valid.MembershipGrade;
import com.bookstore_member.megabookstore_member.domain.membership.valid.MembershipPoint;
import com.bookstore_member.megabookstore_member.domain.membership.valid.MembershipStandardAmount;
import com.bookstore_member.megabookstore_member.repository.MembershipRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
@DisplayName("membershipRepository는 NULL이 아니다.")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//replace값이 none일 경우 EmbeddedDatabase를 찾아 설정하지 않고 기존 애플리케이션에서 사용한 DataSource(MySQL)가 등록되게 됨
public class MembershipRepositoryTest {

    @Autowired //test 코드기 때문에 필드 주입 @Autowired 사용
    private MembershipRepository membershipRepository;
    private boolean findResult;

    @Test
    @DisplayName("멤버십 등록")
    public void registerMembership(){
        //given

        final Membership membership = Membership.builder()
                .membershipNo(Long.valueOf("membershipNo"))
                .membershipGrade(new MembershipGrade())
                .membershipPoint(new MembershipPoint())
                .membershipStandardAmount(new MembershipStandardAmount())
                .build();

        //when
        final Membership result = membershipRepository.save(membership);


        //then
        assertThat(result.getMembershipNo()).isEqualTo("membershipNo");
        assertThat(result.getMembershipGrade()).isEqualTo(MembershipGrade.);
        assertThat(result.getMembershipPoint()).isEqualTo(10000);
        assertThat(result.getMembershipStandardAmount()).isEqualTo(1000);
        }
        @Test
    @DisplayName("멤버십이 존재하는지")
    void alreadyMembership(){
            //given
            final Membership membership = Membership.builder()
                    .membershipNo(Long.valueOf("membershipNo"))
                    .membershipGrade(MembershipGrade.membershipGrade)
                    .membershipPoint(10000)
                    .membershipStandardAmount(1000)
                    .build();

            //when
            membershipRepository.save(membership);
            membershipRepository.findByIdMembershipGrade("membershipNo",MembershipGrade.membershipGrade);

            //then
            assertThat(findResult).isNotNull();
            assertThat(findResult.getMembershipNo()).isNotNull();
            assertThat(findResult.getMembershipGrade()).isEqualTo(MembershipGrade.membershipGrade);
            assertThat(findResult.getMembershipPoint()).isEqualTo(10000);
            assertThat(findResult.getMembershipStandardAmount()).isEqualTo(1000);

        }

}
