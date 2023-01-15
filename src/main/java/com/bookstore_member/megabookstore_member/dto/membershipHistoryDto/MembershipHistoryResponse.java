package com.bookstore_member.megabookstore_member.dto.membershipHistoryDto;


import com.bookstore_member.megabookstore_member.domain.member.Member;
import com.bookstore_member.megabookstore_member.domain.membership_history.MembershipHistory;
import com.bookstore_member.megabookstore_member.domain.membership_history.validation.MonthlyUsageAmount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MembershipHistoryResponse {

    private Long membershipHistoryNo;

    private Member member;

    private MonthlyUsageAmount monthlyUsageAmount;

    private LocalDateTime membershipHistoryCreateAt;

    public MembershipHistoryResponse(MembershipHistory membershipHistory) {
        this.membershipHistoryNo = membershipHistory.getMembershipHistoryNo();
        this.member = membershipHistory.getMember();
        this.monthlyUsageAmount = monthlyUsageAmount(membershipHistory);
        this.membershipHistoryCreateAt = membershipHistory.getMembershipHistoryCreateAt();
    }

    public MonthlyUsageAmount monthlyUsageAmount(MembershipHistory membershipHistory) {
        return membershipHistory.getMonthlyUsageAmount();
    }
}
