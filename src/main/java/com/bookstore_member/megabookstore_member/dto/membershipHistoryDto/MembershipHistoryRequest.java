package com.bookstore_member.megabookstore_member.dto.membershipHistoryDto;

import com.bookstore_member.megabookstore_member.domain.member.Member;
import com.bookstore_member.megabookstore_member.domain.membership_history.MembershipHistory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MembershipHistoryRequest {

    private Long membershipHistoryNo;

    private Member member;

    private Long monthlyUsageAmount;

    private String membershipHistoryCreateAt;

    public MembershipHistory toMembershipHistory() {
        return MembershipHistory.builder()
                .membershipHistoryNo(membershipHistoryNo)
                .member(member)
                .monthlyUsageAmount(monthlyUsageAmount)
                .membershipHistoryCreateAt(LocalDateTime.parse(membershipHistoryCreateAt))
                .build();

    }


}
