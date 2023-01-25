package com.bookstore_member.megabookstore_member.domain.membership.valid;

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
public class MembershipGrade {
    private static final String MEMBERSHIPGRADE_NOT_EMPTY = "회원등급 이름은 빈 값을 허용하지 않습니다.";
    @Column(nullable = false, unique = true)
    private String membershipGrade;

    public MembershipGrade(String membershipGrade){
        validate(membershipGrade);
        this.membershipGrade = membershipGrade;
    }
    private void validate(String membershipGrade){
        validateMembershipGradeNotEmpty(membershipGrade);
    }
    private void validateMembershipGradeNotEmpty(String membershipGrade){
        if(Objects.isNull(membershipGrade)||membershipGrade.isEmpty()){
            throw new IllegalArgumentException(MEMBERSHIPGRADE_NOT_EMPTY);
        }
    }

}
