package com.bookstore_member.megabookstore_member.domain.member.validation;

import com.bookstore_member.megabookstore_member.exception.err_code.ErrorCode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class PhoneNumber {


    @Column(nullable = false, unique = true)
    @NotBlank
    private String phoneNumber;

    public PhoneNumber(String phoneNumber) {
        validate(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    private void validate(String phoneNumber) {
        validateNickNameNotEmpty(phoneNumber);
    }

    private void validateNickNameNotEmpty(String phoneNumber) {
        if (Objects.isNull(phoneNumber) || phoneNumber.isEmpty()) {
            throw new IllegalArgumentException(ErrorCode.PHONE_NUMBER_NOT_EMPTY.getErrCode());
        }
    }

}
