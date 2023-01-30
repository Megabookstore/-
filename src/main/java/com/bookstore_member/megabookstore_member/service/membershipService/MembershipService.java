package com.bookstore_member.megabookstore_member.service.membershipService;

import com.bookstore_member.megabookstore_member.domain.membership.Membership;
import com.bookstore_member.megabookstore_member.domain.membership.valid.MembershipGrade;
import com.bookstore_member.megabookstore_member.domain.membership.valid.MembershipPoint;
import com.bookstore_member.megabookstore_member.domain.membership.valid.MembershipStandardAmount;
import com.bookstore_member.megabookstore_member.dto.membershipDto.MembershipRequest;
import com.bookstore_member.megabookstore_member.dto.membershipDto.MembershipResponse;
import com.bookstore_member.megabookstore_member.exception.Membership.MembershipErrorResult;
import com.bookstore_member.megabookstore_member.exception.Membership.MembershipException;
import com.bookstore_member.megabookstore_member.repository.MemberRepository;
import com.bookstore_member.megabookstore_member.repository.MembershipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MembershipService {
    private final MembershipRepository membershipRepository;

    @Transactional
    public MembershipResponse addMembership(MembershipRequest membershipRequest){


        Membership save = membershipRepository.save(membershipRequest.MemberRequestToMember());
        return new MembershipResponse(save);
    }
}
