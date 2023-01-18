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
public class MemberStatusName {

    private static final String MEMBER_STATUS_NAME_NOT_EMPTY = "회원 상태명은 빈값을 허용하지 않습니다";


    @Column(nullable = false, unique = true)
    private String memberStatusName;

    public MemberStatusName(String memberStatusName){
        validate(memberStatusName);
        this.memberStatusName = memberStatusName;
    }

    private void validate (String memberStatusName){

        validatememberStatusNameNotEmpty(memberStatusName);
    }

    private void validatememberStatusNameNotEmpty(String memberStatusName){
        if(Objects.isNull(memberStatusName) || memberStatusName.isEmpty()){
            throw new IllegalArgumentException(MEMBER_STATUS_NAME_NOT_EMPTY);
        }
    }


}

