package com.bookstore_member.megabookstore_member.domain.member.validation;

import com.bookstore_member.megabookstore_member.exception.err_code.ErrorCode;
import com.sun.istack.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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

    public static final String ID_PATTERN = "^[a-zA-Z0-9]*$";

    @Column(nullable = false, unique = true)
    @NotBlank
    @Size(min = 8)
    @Pattern(regexp = ID_PATTERN)
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
