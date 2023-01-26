package com.bookstore_member.megabookstore_member.service.membershipService;

import com.bookstore_member.megabookstore_member.domain.member.Member;
import com.bookstore_member.megabookstore_member.domain.member.validation.MemberId;
import com.bookstore_member.megabookstore_member.dto.membershipDto.MembershipRequest;
import com.bookstore_member.megabookstore_member.dto.membershipDto.MembershipResponse;
import com.bookstore_member.megabookstore_member.domain.membership.Membership;
import com.bookstore_member.megabookstore_member.domain.membership.valid.MembershipGrade;
import com.bookstore_member.megabookstore_member.domain.membership.valid.MembershipPoint;
import com.bookstore_member.megabookstore_member.domain.membership.valid.MembershipStandardAmount;
import com.bookstore_member.megabookstore_member.repository.MemberRepository;
import com.bookstore_member.megabookstore_member.repository.MembershipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class MembershipUpdateService {

    private final MemberRepository memberRepository;

    private final MembershipRepository membershipRepository;

    @Transactional
    public MembershipResponse updateMembership(Long memberId, MembershipRequest membershipRequest){

        Member member =  memberRepository.findById(memberId).get();

        Membership membership= membershipRepository.findById(membershipRequest.getMembershipNo()).get();

        membership.updateMembership(membership.getMembershipNo(), new MembershipGrade(membershipRequest.getMembershipGrade()),
                new MembershipStandardAmount(membershipRequest.getMembershipStandardAmount()),new MembershipPoint(membershipRequest.getMembershipPoint()));

        member.updateMembership(membership);

        return new MembershipResponse(membership);

    }
}
