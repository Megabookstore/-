package com.bookstore_member.megabookstore_member.domain.member.validation;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class NickName {

    private static final String NICKNAME_NOT_EMPTY = "닉네임은 빈값을 허용하지 않습니다";


    @Column(nullable = false, unique = true)
    private String nickName;

    public NickName(String nickName) {
        validate(nickName);
        this.nickName = nickName;
    }

    private void validate(String nickName) {
        validateNickNameNotEmpty(nickName);
    }

    private void validateNickNameNotEmpty(String nickName) {
        if (Objects.isNull(nickName) || nickName.isEmpty()) {
            throw new IllegalArgumentException(NICKNAME_NOT_EMPTY);
        }
    }


}
