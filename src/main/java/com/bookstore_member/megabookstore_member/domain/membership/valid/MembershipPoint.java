package com.bookstore_member.megabookstore_member.domain.membership.valid;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class MembershipPoint {
    private static final String MEMBERSHIPPOINT_NOT_EMPTY = "지급포인트는 빈값을 허용하지 않습니다.";
    @Column(nullable = false)
    @ColumnDefault("0")
    private Integer membershipPoint;
    public MembershipPoint(Long membershipPoint){
        validate(membershipPoint);
    }
    private void validate(Long membershipPoint){
        validateMembershipPointNotEmpty(membershipPoint);
    }
    private void validateMembershipPointNotEmpty(Long membershipPoint){
        if(Objects.isNull(membershipPoint)||membershipPoint < 0){
            throw new IllegalArgumentException(MEMBERSHIPPOINT_NOT_EMPTY);
        }
    }
}
