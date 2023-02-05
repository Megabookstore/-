//package com.bookstore_member.megabookstore_member.service.memberService;
//
//import com.bookstore_member.megabookstore_member.domain.member.Member;
//import com.bookstore_member.megabookstore_member.domain.membership.Membership;
//import com.bookstore_member.megabookstore_member.domain.membership.valid.MembershipGrade;
//import com.bookstore_member.megabookstore_member.dto.memberDto.MemberResponse;
//import com.bookstore_member.megabookstore_member.repository.MemberRepository;
//import com.bookstore_member.megabookstore_member.repository.MembershipRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//@Transactional(readOnly = true)
//public class MembershipAddMemberService {
//
//    private final MembershipRepository membershipRepository;
//
//    private final MemberRepository memberRepository;
//
//    @Transactional
//    public MemberResponse registerMembership(Long memberId, Long membershipNo){
//
//        Member member = memberRepository.findById(memberId).get();
//
//        Optional<Membership> membership = membershipRepository.findById(membershipNo);
//
//        member.updateMembership(membership.get());
//
//        return new MemberResponse(member);
//    }
//
//}
