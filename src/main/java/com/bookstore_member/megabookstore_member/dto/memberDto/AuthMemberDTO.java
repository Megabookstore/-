package com.bookstore_member.megabookstore_member.dto.memberDto;

import com.bookstore_member.megabookstore_member.domain.member.validation.MemberId;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@Setter
public class AuthMemberDTO extends User {

    private MemberId memberId;

    private String nickName;

    private String email;

    private LocalDateTime birth;

    private Boolean man;

    private LocalDateTime memberCreatedAt;


    public AuthMemberDTO(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.memberId = new MemberId(username);
    }

}
