package com.bookstore_member.megabookstore_member.domain;

import com.bookstore_member.megabookstore_member.domain.converter.BooleanToYNConverter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_no")
    private Long memberNo;

    @Column(name = "membership_no")
    private Long membershipNo;

    private String id;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "is_man")
    @Convert(converter = BooleanToYNConverter.class)
    private boolean isMan;

    private LocalDateTime birth;

    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String email;

    @Column(name = "member_created_at")
    private String memberCreatedAt;

    @OneToMany
    private List<MemberInquiry> inquiries;

}
