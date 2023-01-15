package com.bookstore_member.megabookstore_member.entity;

import com.bookstore_member.megabookstore_member.dto.MembershipDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "membership") //db에 table 자동 생성
public class MembershipEntity {
    @Id
    Integer membership_no;
    String membership_Grade;
    Long membership_standard_amount;
    Long membership_point;

    public MembershipDto toDto(){
        return MembershipDto.builder()
                .membership_no(membership_no)
                .membership_grade(membership_Grade)
                .membership_standard_amount(membership_standard_amount)
                .membership_point(membership_point)
                .build();
    }


}
