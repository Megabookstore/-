package com.bookstore_member.megabookstore_member.domain.memberstatus.validation;

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
public class MemberStatusNo {

    private static final String MEMBER_STATUS_NO_NOT_EMPTY = "회원 상태 번호는 빈 값을 허용하지 않는다 ";
    @Column(nullable = false)
    private String memberStatusNo;

    public MemberStatusNo(String memberStatusNo){
        validate(memberStatusNo);
        this.memberStatusNo = memberStatusNo;
    }
    private void validate(String memberStatusNo){
        validateMemberStatusNoNotEmpty(memberStatusNo);
    }
    private void validateMemberStatusNoNotEmpty(String memberStatusNo){
        if(Objects.isNull(memberStatusNo)||memberStatusNo.isEmpty()){
            throw new IllegalArgumentException(MEMBER_STATUS_NO_NOT_EMPTY);
        }
    }
}
