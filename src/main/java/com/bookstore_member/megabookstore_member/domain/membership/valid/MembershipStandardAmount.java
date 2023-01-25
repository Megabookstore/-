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
public class MembershipStandardAmount {

    private static final String MEMBERSHIP_STANDARD_AMOUNT_NOT_EMPTY = "맴버십 기준 금액는 0보다 작으면 안된다.";
    @Column(nullable = false)
    private String membershipStandardAmount;

    public MembershipStandardAmount(Long membershipStandardAmount){
        validate(Long.valueOf(membershipStandardAmount));
        this.membershipStandardAmount = String.valueOf(membershipStandardAmount);
    }
    private void validate(Long membershipStandardAmount){
        validateMembershipNotEmpty(membershipStandardAmount);
    }
    private void validateMembershipNotEmpty(Long membershipStandardAmount){
        if(Objects.isNull(membershipStandardAmount) || membershipStandardAmount < 0 ){
            throw new IllegalArgumentException(MEMBERSHIP_STANDARD_AMOUNT_NOT_EMPTY);
        }
    }
}
