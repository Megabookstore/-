package com.bookstore_member.megabookstore_member.service.membershipService;

import com.bookstore_member.megabookstore_member.domain.membership.Membership;
import com.bookstore_member.megabookstore_member.domain.membership.valid.MembershipGrade;
import com.bookstore_member.megabookstore_member.domain.membership.valid.MembershipStandardAmount;
import com.bookstore_member.megabookstore_member.dto.membershipDto.MembershipResponse;
import com.bookstore_member.megabookstore_member.exception.Membership.MembershipErrorResult;
import com.bookstore_member.megabookstore_member.exception.Membership.MembershipException;
import com.bookstore_member.megabookstore_member.repository.MembershipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MembershipService {
    private final MembershipRepository membershipRepository;
    public MembershipResponse addMembership(final Long membershipNo, final MembershipGrade membershipGrade, final Integer membershipPoint, final Integer membershipStandardAmount){

        final Membership result = membershipRepository.findByIdMembershipGrade(String.valueOf(membershipNo), membershipGrade);
        if(result != null){
            throw new MembershipException(MembershipErrorResult.DUPLICATED_MEMBERSHIP_REGISTER);
        }
        final Membership membership = Membership.builder()
                .membershipNo(membershipNo)
                .membershipGrade(membershipGrade)
                .membershipPoint(membershipPoint)
                .membershipStandardAmount(new MembershipStandardAmount())
                .build();
        final Membership savedMembership = membershipRepository.save(membership);

        return MembershipResponse.builder()
                .membershipNo(savedMembership.getMembershipNo())
                .membershipGrade(savedMembership.getMembershipGrade())
                .build();
    }
}
