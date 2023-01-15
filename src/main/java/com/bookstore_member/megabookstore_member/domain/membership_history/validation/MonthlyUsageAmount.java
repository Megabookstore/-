package com.bookstore_member.megabookstore_member.domain.membership_history.validation;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
@NoArgsConstructor
@Getter
public class MonthlyUsageAmount {

    private static final int ZERO = 0;

    private static final String USAGE_AMOUNT_LESS_THAN_ZERO = "총액은 0원보다 작을 수 없습니다";

    @Column(nullable = false)
    private BigDecimal monthlyUsageAmount;

    public MonthlyUsageAmount(Long monthlyUsageAmount) {

        validate(monthlyUsageAmount);
        this.monthlyUsageAmount = BigDecimal.valueOf(monthlyUsageAmount);
    }

    private void validate(Long price) {
        validateUsageAmountLessThanZero(price);
    }

    private void validateUsageAmountLessThanZero(Long amount) {
        if (amount < ZERO) {
            throw new IllegalArgumentException(USAGE_AMOUNT_LESS_THAN_ZERO);
        }
    }

}
