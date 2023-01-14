package com.bookstore_member.megabookstore_member.domain.member;

import com.bookstore_member.megabookstore_member.domain.converter.BooleanToYNConverter;
import com.bookstore_member.megabookstore_member.domain.member.valid.Email;
import com.bookstore_member.megabookstore_member.domain.member.valid.MemberId;
import com.bookstore_member.megabookstore_member.domain.member.valid.NickName;
import com.bookstore_member.megabookstore_member.domain.member.valid.PhoneNumber;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long memberNo;

    @Column(nullable = false)
    private Long membershipNo;

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
    @CreatedDate
    private LocalDateTime memberCreatedAt;


    public void updateMember(MemberId memberId, NickName nickName, String password , PhoneNumber phoneNumber, Email email){
        this.memberId = memberId;
        this.nickName = nickName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

}
