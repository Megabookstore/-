package com.bookstore_member.megabookstore_member.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

//회원등급_번호
@Embeddable
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class No {
    private Object no;
    private Long membership_no;

    public No(Long No){
        validate(No);
        this.no = no;
    }
    private void validate(Long no) {
    }


}
