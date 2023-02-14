package com.bookstore_member.megabookstore_member.dto.memberDto;

import com.bookstore_member.megabookstore_member.domain.member.validation.MemberId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@ToString
public class MemberDTO implements UserDetails {

    String ROLE_PREFIX = "ROLE_";

    private String memberId;
    private String role;

    private String password;
    private String nickName;

    private String email;

    private LocalDateTime birth;

    private Boolean man;

    private LocalDateTime memberCreatedAt;

@Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + role));
    return authorities;
}

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    //계정 사용 가능 여부(true : 사용가능)
    @Override
    public boolean isEnabled() {
        return false;
    }

}
