package com.bookstore_member.megabookstore_member.domain.membership_history;


import com.bookstore_member.megabookstore_member.domain.member.Member;
import com.bookstore_member.megabookstore_member.domain.membership.Membership;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
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

    @Embedded
    private MonthlyUsageAmount monthlyUsageAmount;

    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime membershipHistoryCreateAt;

    public void updateMembershipHistory(Long membershipHistoryNo, Member member,
                                        Membership membership, LocalDateTime membershipHistoryCreateAt){
        this.membershipHistoryNo = membershipHistoryNo;
        this.member = member;
        this.membership = membership;
        this.membershipHistoryCreateAt = membershipHistoryCreateAt;
    }

    public void updateMembershipHistory(MembershipHistory membershipHistory) {
    }

    public void registerMembershipHistory(MembershipHistory membershipHistory) {

    }
}

