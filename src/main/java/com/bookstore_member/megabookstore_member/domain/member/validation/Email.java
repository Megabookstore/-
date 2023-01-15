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
public class Email {

    private static final String EMAIL_NOT_EMPTY = "닉네임은 빈값을 허용하지 않습니다";


    @Column(nullable = false, unique = true)
    private String email;

    public Email(String email) {
        validate(email);
        this.email = email;
    }

    private void validate(String email) {
        validateEmailNotEmpty(email);
    }

    private void validateEmailNotEmpty(String email) {
        if (Objects.isNull(email) || email.isEmpty()) {
            throw new IllegalArgumentException(EMAIL_NOT_EMPTY);
        }
    }

}
