package com.bookstore_member.megabookstore_member.Grade.dto;

import com.bookstore_member.megabookstore_member.domain.Grade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Membership {
    private Integer membership_no;
    private String membership_grade;
    private Long membership_standard_amount;
    private Long membership_point;

    public Grade toGrade(){
        return Grade.builder()
                .membership_no(new Membership_no(membership_no))
                .membership_grade(new Membership_Grade(membership_grade))
                .membership_standard_amount(new Membership_standard_amount(membership_standard_amount))
                .membership_point(new Membership_point(membership_point))
                .build();
    }

    private class Membership_no {
        public Membership_no(Integer membershipNo) {
        }
    }

    private class Membership_Grade {
        public Membership_Grade(String membershipGrade) {
        }
    }

    private class Membership_standard_amount {
        public Membership_standard_amount(Long membershipStandardAmount) {
        }
    }

    private class Membership_point {
        public Membership_point(Long membershipPoint) {
        }
    }
}
