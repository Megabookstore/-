package com.bookstore_member.megabookstore_member.domain;
//회원등급 기준 금액
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class Amount {
    private Long amount;
    public Amount(Long amount){
        validate(amount);
        this.amount = amount;
    }

    private void validate(Long amount) {
    }

}
