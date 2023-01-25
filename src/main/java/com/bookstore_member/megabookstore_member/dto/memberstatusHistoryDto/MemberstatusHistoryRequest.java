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
public class MemberstatusHistoryRequest {
    private Long memberstatusHistoryNo;
    private Member member;
    private Long memberstatusNo;
    private Long statusChangedReason;
    private LocalDateTime memberstatusHistoryCreatedAt;
    public MemberstatusHistory MemberstatusHistoryRequesttomemberstatusHistory(){
        return MemberstatusHistory.builder()
                .memberstatusHistoryNo(memberstatusHistoryNo)
                .member(member)
                .memberstatusHistoryCreatedAt(memberstatusHistoryCreatedAt)
                .statusChangedReason(new StatusChangedReason(statusChangedReason))
                .build();
    }


}
