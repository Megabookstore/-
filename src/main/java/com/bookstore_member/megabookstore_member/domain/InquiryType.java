package com.bookstore_member.megabookstore_member.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class InquiryType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inquiryTypeNo;

    @Column(unique = true, nullable = false)
    private String inquiryTypeName;

    @OneToMany
    private List<MemberInquiry> memberInquiries = new ArrayList<>();
}
