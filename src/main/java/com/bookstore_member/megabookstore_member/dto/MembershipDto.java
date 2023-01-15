package com.bookstore_member.megabookstore_member.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
public class MembershipDto {
    private Integer membership_no;
    private String membership_grade;
    private Long membership_standard_amount;
    private Long membership_point;

    public Integer getMembership_no(){
        return membership_no;
    }
    public void setMembership_no(Integer membership_no){
        this.membership_no = membership_no;
    }

    public String getMembership_grade() {
        return membership_grade;
    }

    public void setMembership_grade(String membership_grade) {
        this.membership_grade = membership_grade;
    }

    public Long getMembership_standard_amount() {
        return membership_standard_amount;
    }

    public void setMembership_standard_amount(Long membership_standard_amount) {
        this.membership_standard_amount = membership_standard_amount;
    }

    public Long getMembership_point() {
        return membership_point;
    }

    public void setMembership_point(Long membership_point) {
        this.membership_point = membership_point;
    }

    @Override
    public String toString() {
        return "MembershipDto{" +
                "membership_no=" + membership_no +
                ", membership_grade='" + membership_grade + '\'' +
                ", membership_standard_amount=" + membership_standard_amount +
                ", membership_point=" + membership_point +
                '}';
    }
}
