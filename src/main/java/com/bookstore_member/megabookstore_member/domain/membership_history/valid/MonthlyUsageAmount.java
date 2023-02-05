package com.bookstore_member.megabookstore_member.domain.membership_history.valid;

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
public class MonthlyUsageAmount {

    private static final String MONTHLY_NOT_UNDER_ZERO = "한달 사용금액은 0보다 작으면 안된다.";
    @Column(nullable = false)
    @ColumnDefault("0")
    private Long monthlyUsageAmount;
    public MonthlyUsageAmount(Long monthlyUsageAmount){
        validate(monthlyUsageAmount);
    }
    private void validate(Long monthlyUsageAmount){
        validateMembershipPointNotEmpty(monthlyUsageAmount);
    }
    private void validateMembershipPointNotEmpty(Long monthlyUsageAmount){
        if(Objects.isNull(monthlyUsageAmount)||monthlyUsageAmount < 0){
            throw new IllegalArgumentException(MONTHLY_NOT_UNDER_ZERO);
        }
    }

}
