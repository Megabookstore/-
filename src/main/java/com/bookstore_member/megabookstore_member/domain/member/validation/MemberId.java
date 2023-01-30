package com.bookstore_member.megabookstore_member.domain.member.validation;

import com.bookstore_member.megabookstore_member.exception.err_code.ErrorCode;
import com.sun.istack.NotNull;
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
public class MemberId {


    @Column(nullable = false, unique = true)
    @NotNull
    private String memberId;


    public MemberId(String memberId) {
        validate(memberId);
        this.memberId = memberId;
    }

    private void validate(String memberId) {
        validateMemberIdNotEmpty(memberId);
    }

    private void validateMemberIdNotEmpty(String memberId) {
        if (Objects.isNull(memberId) || memberId.isEmpty()) {
            throw new IllegalArgumentException(ErrorCode.ID_NOT_EMPTY.getErrCode());
        }
    }

}
