package com.bookstore_member.megabookstore_member.domain.member.validation;


import com.bookstore_member.megabookstore_member.exception.err_code.ErrorCode;
import com.sun.istack.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class NickName {

    @Column(nullable = false, unique = true)
    @NotBlank
    @Size(min = 2, max = 15)
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
            throw new IllegalArgumentException(ErrorCode.NICKNAME_NOT_EMPTY.getErrCode());
        }
    }


}
