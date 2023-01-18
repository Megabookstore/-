package com.bookstore_member.megabookstore_member.domain.member_status_history;

import com.bookstore_member.megabookstore_member.domain.member.Member;
import com.bookstore_member.megabookstore_member.domain.member_status_history.validation.StatusChangedReason;
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
public class MemberstatusHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberstatusHistoryNo;
    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;
    private Long memberNo;
    private Long memberstatusNo;
    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime memberstatusHistoryCreatedAt;
    @Embedded
    private StatusChangedReason statusChangedReason;

    }



