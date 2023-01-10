package com.bookstore_member.megabookstore_member.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class Point {
    private static final int ZERO = 0;
    private Long point;
    public Point(Long point){
        validate(point)
        this.point = point;
    }

    private void validate(Long point) {

    }
}
