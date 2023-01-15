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
public class PhoneNumber {

    private static final String PHONE_NUMBER_NOT_EMPTY = "휴대폰 번호는 빈값을 허용하지 않습니다";


    @Column(nullable = false, unique = true)
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
            throw new IllegalArgumentException(PHONE_NUMBER_NOT_EMPTY);
        }
    }

}
