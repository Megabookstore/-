package com.bookstore_member.megabookstore_member.dto.memberDto;

import com.bookstore_member.megabookstore_member.domain.member.Member;
import com.bookstore_member.megabookstore_member.domain.member.validation.Email;
import com.bookstore_member.megabookstore_member.domain.member.validation.NickName;
import com.bookstore_member.megabookstore_member.domain.member.validation.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberResponse {

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

    private Set<GrantedAuthority> roles = new HashSet<>();

    public MemberResponse(Member member) {
        this.memberId = member.getMemberId();
        this.nickName = nickName(member).getNickName();
        this.isMan = member.isMan();
        this.birth = member.getBirth();
        this.password = member.getPassword();
        this.phoneNumber = phoneNumber(member).getPhoneNumber();
        this.email = email(member).getEmail();
        this.memberCreatedAt = member.getMemberCreatedAt();
        this.roles = member.getRoles().stream().
                map(role -> new SimpleGrantedAuthority("ROLE_" + role.getDescription())).
                collect(Collectors.toSet());
    }


    public String memberId(Member member) {
        return member.getMemberId();
    }

    public NickName nickName(Member member) {
        return member.getNickName();
    }

    public PhoneNumber phoneNumber(Member member) {
        return member.getPhoneNumber();
    }

    public Email email(Member member) {
        return member.getEmail();
    }

}
