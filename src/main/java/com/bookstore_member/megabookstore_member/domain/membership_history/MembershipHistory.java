package com.bookstore_member.megabookstore_member.domain.membership_history;


import com.bookstore_member.megabookstore_member.domain.member.Member;
import com.bookstore_member.megabookstore_member.domain.membership.Membership;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MembershipHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long membershipHistoryNo;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Membership membership;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @CreatedDate
    private LocalDateTime membershipHistoryCreateAt;

    public void updateMonthlyUsageAmount(Long usageMoney) {
    }


    public void updateMembershipHistory(Long membershipHistoryNo, Member member) {
    }
}
