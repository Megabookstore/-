package com.bookstore_member.megabookstore_member.domain.member;

import com.bookstore_member.megabookstore_member.domain.converter.BooleanToYNConverter;
import com.bookstore_member.megabookstore_member.domain.member.validation.Email;
import com.bookstore_member.megabookstore_member.domain.member.validation.MemberId;
import com.bookstore_member.megabookstore_member.domain.member.validation.NickName;
import com.bookstore_member.megabookstore_member.domain.member.validation.PhoneNumber;
import com.bookstore_member.megabookstore_member.domain.membership.Membership;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long memberNo;

    @OneToOne
    private Membership membership;

    @Embedded
    private MemberId memberId;

    @Embedded
    private NickName nickName;

    @Column(nullable = false)
    @Convert(converter = BooleanToYNConverter.class)
    private boolean isMan;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime birth;

    @Column(nullable = false)
    private String password;

    @Embedded
    private PhoneNumber phoneNumber;

    @Embedded
    private Email email;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @CreatedDate
    private LocalDateTime memberCreatedAt;

    public void updateMembership(Membership membership) {

        this.membership = membership;
    }


    public void updateMember(MemberId memberId, NickName nickName, String password, PhoneNumber phoneNumber, Email email) {
        if (Objects.nonNull(memberId)) {
            this.memberId = memberId;
        }

        if (Objects.nonNull(nickName)) {
            this.nickName = nickName;
        }

        if (Objects.nonNull(password)) {
            this.password = password;
        }

        if (Objects.nonNull(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        }

        if (Objects.nonNull(email)) {
            this.email = email;
        }

    }

}
