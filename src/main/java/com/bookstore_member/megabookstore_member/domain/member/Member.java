package com.bookstore_member.megabookstore_member.domain.member;

import com.bookstore_member.megabookstore_member.domain.MemberInquiry;
import com.bookstore_member.megabookstore_member.domain.converter.BooleanToYNConverter;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long memberNo;

    @Column(nullable = false)
    private Long membershipNo;

    @Embedded
    private String memberId;

    @Embedded
    private String nickName;

    @Column(nullable = false)
    @Convert(converter = BooleanToYNConverter.class)
    private boolean isMan;

    @Column(nullable = false)
    private LocalDateTime birth;

    @Column(nullable = false)
    private String password;

    @Embedded
    private String phoneNumber;

    @Embedded
    private String email;

    @Column(nullable = false)
    private String memberCreatedAt;

    @OneToMany
    private List<MemberInquiry> inquiries = new ArrayList<>();

}
