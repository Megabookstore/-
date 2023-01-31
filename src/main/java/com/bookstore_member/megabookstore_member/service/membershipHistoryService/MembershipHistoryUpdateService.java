package com.bookstore_member.megabookstore_member.service.membershipHistoryService;

import com.bookstore_member.megabookstore_member.domain.member.Member;
import com.bookstore_member.megabookstore_member.domain.membership.Membership;
import com.bookstore_member.megabookstore_member.domain.membership_history.MembershipHistory;
import com.bookstore_member.megabookstore_member.dto.membershipDto.MembershipRequest;
import com.bookstore_member.megabookstore_member.dto.membershipDto.MembershipResponse;
import com.bookstore_member.megabookstore_member.repository.MemberRepository;
import com.bookstore_member.megabookstore_member.repository.MembershipHistoryRepository;
import com.bookstore_member.megabookstore_member.repository.MembershipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class MembershipHistoryUpdateService {
    private final MembershipRepository membershipRepository;
    private final MemberRepository memberRepository;
    private final MembershipHistoryRepository membershipHistoryRepository;

    @Transactional
    public MembershipResponse updateMembershipHistory(Long memberId, MembershipRequest membershipRequest){

        Member member = memberRepository.findById(memberId).get();

        Membership membership = membershipRepository.findById(memberId).get();

        MembershipHistory membershipHistory = membershipHistoryRepository.findById(memberId).get();

        membershipHistory.updateMembershipHistory(membershipHistory.getMembershipHistoryNo(), membershipHistory.getMember());

        return new MembershipResponse(membership);
    }
}
