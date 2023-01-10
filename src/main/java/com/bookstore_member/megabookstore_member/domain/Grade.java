package com.bookstore_member.megabookstore_member.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class Grade {
    private String grade;
    private String membership_grade;
    public Grade(String grade){
        validate(grade);
        this.grade = grade;
    }
    private void validate(String grade) {
    }

}
