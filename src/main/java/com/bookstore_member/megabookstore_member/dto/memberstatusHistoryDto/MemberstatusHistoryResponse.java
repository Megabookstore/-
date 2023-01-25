package com.bookstore_member.megabookstore_member.dto.memberstatusHistoryDto;

import com.bookstore_member.megabookstore_member.domain.member.Member;
import com.bookstore_member.megabookstore_member.domain.member_status_history.MemberstatusHistory;
import com.bookstore_member.megabookstore_member.domain.member_status_history.validation.StatusChangedReason;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberstatusHistoryResponse {
    private Long memberstatusHistoryNo;
    private Member member;
    private Long memberstatusNo;
    private LocalDateTime memberstatusHistoryCreatedAt;
    private StatusChangedReason statusChangedReason;

    public MemberstatusHistoryResponse(MemberstatusHistory memberstatusHistory){
        this.memberstatusHistoryNo = memberstatusHistory.getMemberstatusHistoryNo();
        this.member = memberstatusHistory.getMember();
        this.memberstatusNo = memberstatusHistory.getMemberstatusNo();
        this.memberstatusHistoryCreatedAt = memberstatusHistory.getMemberstatusHistoryCreatedAt();
        this.statusChangedReason = memberstatusHistory.getStatusChangedReason();
    }

    public StatusChangedReason statusChangedReason(MemberstatusHistory memberstatusHistory) {
        return memberstatusHistory.getStatusChangedReason();

    }
}
