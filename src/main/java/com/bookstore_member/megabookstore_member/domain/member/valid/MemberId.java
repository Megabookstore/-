package com.bookstore_member.megabookstore_member.domain.member.valid;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Embeddable
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class MemberId {

    private static final String ID_NOT_EMPTY = "아이디는 빈값을 허용하지 않습니다";

    @Column(nullable = false, unique = true)
    private String memberId;
    public MemberId(String memberId){
        validate(memberId);
        this.memberId = memberId;
    }

    private void validate (String memberId){
        validateMemberIdNotEmpty(memberId);
    }

    private void validateMemberIdNotEmpty(String memberId){
        if(Objects.isNull(memberId) || memberId.isEmpty()){
            throw new IllegalArgumentException(ID_NOT_EMPTY);
        }
    }

}
