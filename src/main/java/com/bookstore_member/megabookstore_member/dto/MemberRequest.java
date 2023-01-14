package com.bookstore_member.megabookstore_member.dto;

import com.bookstore_member.megabookstore_member.domain.member.Member;
import com.bookstore_member.megabookstore_member.domain.member.valid.Email;
import com.bookstore_member.megabookstore_member.domain.member.valid.MemberId;
import com.bookstore_member.megabookstore_member.domain.member.valid.NickName;
import com.bookstore_member.megabookstore_member.domain.member.valid.PhoneNumber;
import lombok.*;
//import org.springframework.security.core.parameters.P;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberRequest {

    private Long memberNo;

    private Long membershipNo;

    private String memberId;

    private String nickName;

    private boolean isMan;

    private LocalDateTime birth;

    private String password;

    private String phoneNumber;

    private String email;

    private LocalDateTime memberCreatedAt;

    public Member MemberRequestToMember(){
        return Member.builder()
                .memberNo(memberNo)
                .membershipNo(membershipNo)
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
