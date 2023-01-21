package com.bookstore_member.megabookstore_member.dto.memberDto;

import com.bookstore_member.megabookstore_member.domain.member.Member;
import com.bookstore_member.megabookstore_member.domain.member.validation.Email;
import com.bookstore_member.megabookstore_member.domain.member.validation.MemberId;
import com.bookstore_member.megabookstore_member.domain.member.validation.NickName;
import com.bookstore_member.megabookstore_member.domain.member.validation.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberRequest {

    private Long memberNo;

    private String memberId;

    private String nickName;

    private boolean isMan;

    private LocalDateTime birth;

    private String password;

    private String phoneNumber;

    private String email;

    private LocalDateTime memberCreatedAt;

    public Member MemberRequestToMember() {
        return Member.builder()
                .memberNo(memberNo)
                .memberId(new MemberId(memberId))
                .nickName(new NickName(nickName))
                .isMan(isMan)
                .birth(birth)
                .password(password)
                .phoneNumber(new PhoneNumber(phoneNumber))
                .email(new Email(email))
                .memberCreatedAt(memberCreatedAt)
                .build();

    }


}
