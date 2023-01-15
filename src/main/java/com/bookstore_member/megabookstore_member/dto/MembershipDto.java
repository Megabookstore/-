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






}
