package com.bookstore_member.megabookstore_member.domain.member.validation;

import com.bookstore_member.megabookstore_member.exception.err_code.ErrorCode;
import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class Email {

    @Column(nullable = false, unique = true)
    @NotBlank
    @javax.validation.constraints.Email
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
            throw new IllegalArgumentException(ErrorCode.EMAIL_NOT_EMPTY.getErrCode());
        }
    }

}
